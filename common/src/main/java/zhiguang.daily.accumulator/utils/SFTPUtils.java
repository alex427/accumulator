package zhiguang.daily.accumulator.utils;


import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * SFTP工具类
 **/
@Slf4j
public class SFTPUtils {

    /**
     * 查看当前目录下所有文件夹以及文件
     */
    public static List<String> getFileList(String host,int port,String user,String passwd,
                                           Integer timeout, String path) throws Exception{
        Session session = null;
        ChannelSftp sftpChannel = null;
        List fs = new ArrayList();
        try {
            //建立session
            session = getSession(host, port,user,passwd,timeout);
            // 打开SFTP通道
            Channel channel=session.openChannel("sftp");
            // 建立SFTP通道的连接
            channel.connect();
            sftpChannel=(ChannelSftp)channel;
            //注意os差异
            //sftpChannel.cd(path);
            Vector fileList = sftpChannel.ls(path);
            fs= parseList(fileList);
        } catch (Exception e) {
            throw e;
        }finally{
            if(sftpChannel!=null)sftpChannel.disconnect();
            if(session!=null) session.disconnect();
        }
        return fs;
    }


    /**
     * 连接ftp
     */
    public static Session getSession(String host, int port, String user, String passwd, Integer timeout){
        JSch jsch=new JSch();
        Session session = null;
        try {
            session=jsch.getSession(user, host, port);
            session.setPassword(passwd);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setTimeout(timeout==null?6000:timeout);
            session.connect();
            return session;
        } catch (JSchException e) {
            log.error(e.getMessage());
            if(session!=null && session.isConnected()){
                session.disconnect();
            }
            return null;
        }
    }


    /**
     * vector--->list
     */
    public static List<String> parseList(Vector fileList){
        List<String> list= new ArrayList<String>();
        Iterator it = fileList.iterator();
        while (it.hasNext())
        {
            String fileName = ((ChannelSftp.LsEntry)it.next()).getFilename();
            if ((".".equals(fileName)) || ("..".equals(fileName))) {
                continue;
            }
            list.add(fileName);
        }
        return list;
    }





}
