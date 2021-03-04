package cn.laochou.diagnose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
// 扫描Servlet相关组件
@ServletComponentScan
public class CloudDiagnoseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDiagnoseApplication.class, args);
    }

}