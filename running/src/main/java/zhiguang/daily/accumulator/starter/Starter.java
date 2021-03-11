package zhiguang.daily.accumulator.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Map;


/**
 * 程序启动入口
 */
@Slf4j
@EnableAsync
@EnableCaching
@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "zhiguang.daily.accumulator")
public class Starter {

    public static void main(String[] args) {
        Map<String, String> environmentMap = System.getenv();
        environmentMap.forEach((key, value) -> log.info("{}=:{}", key,value));
        SpringApplication.run(Starter.class, args);
    }

}
