package cn.laochou.diagnose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CloudDiagnoseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDiagnoseApplication.class, args);
    }

}