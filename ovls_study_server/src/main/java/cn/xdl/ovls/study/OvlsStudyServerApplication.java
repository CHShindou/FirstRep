package cn.xdl.ovls.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient   //注册eureka客户端
@MapperScan("cn.xdl.ovls.study.*.dao")
@SpringBootApplication
@ServletComponentScan
public class OvlsStudyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OvlsStudyServerApplication.class, args);

	}

}
