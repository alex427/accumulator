package zhiguang.daily.accumulator.checkpoint;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FileDownload {
    public static void main(String[] args) throws IOException {
        String remote_img_url="http://img.baidu.com/img/iknow/sula201506/baiduzhidaowenkugaokao.png?t=1433819530";
        URL url=null;
        URLConnection urlconn=null;
        HttpURLConnection httpconn=null;
        BufferedInputStream bis=null;
        try {
            url = new URL(remote_img_url);
            urlconn = url.openConnection();
            //1.5以后URLConnection设置连接超时，从主机读取数据超时 单位：毫秒
            /*urlconn.setConnectTimeout(10000);
            urlconn.setReadTimeout(20000);*/
            httpconn = (HttpURLConnection) urlconn;
            int httpResult = httpconn.getResponseCode();
            System.out.println("httpResult::"+httpResult);
            if(httpResult==HttpURLConnection.HTTP_OK){
                int filesize = urlconn.getContentLength(); // 取数据长度
                byte[] b=new byte[filesize];
                bis=new BufferedInputStream(httpconn.getInputStream());
                int r=0;
                while((r=bis.read(b))>0);
                System.out.println("length::"+filesize);
                System.out.println("string:"+new String(b,"UTF-8"));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(httpconn!=null)
                httpconn.disconnect();
            if(bis!=null){
                bis.close();
            }
        }
    }
}
