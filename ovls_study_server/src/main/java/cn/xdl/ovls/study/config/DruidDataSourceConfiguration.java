package cn.xdl.ovls.study.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidDataSourceConfiguration {
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource druid(){
		
		//DruidDataSource ds = new DruidDataSource();
		
		DataSource ds = 
				DataSourceBuilder.create().type(DruidDataSource.class).build();
		return ds;
	}

}
