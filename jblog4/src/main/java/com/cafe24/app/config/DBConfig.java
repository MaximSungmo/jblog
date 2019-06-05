package com.cafe24.app.config;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:com/cafe24/config/app/properties/jdbc.properties")
public class DBConfig {

	
	@Autowired
	private Environment env;
	//추 후 연결 변경 시 classpath:com/cafe24/config/app/properties/jdbc.properties 파일 내용 변경 
	@Bean
	public DataSource basicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		basicDataSource.setUrl(env.getProperty("jdbc.url"));
		basicDataSource.setUsername(env.getProperty("jdbc.username"));
		basicDataSource.setPassword(env.getProperty("jdbc.password"));
		// InitailSize와 MaxActive 로 datasource tuning을 하게 됨 
		basicDataSource.setInitialSize(env.getProperty("jdbc.initialSize", Integer.class));
		basicDataSource.setMaxActive(env.getProperty("jdbc.maxActive", Integer.class));
		return basicDataSource;
	}
//	*applicationContext.xml*에 존재하던 DB연결 설정을 위의 함수로 @Bean설정함
//	<!-- Connection Pool DataSource-->
//	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
//		<property name="driverClassName" value="org.mariadb.jdbc.Driver" />
//		<property name="url" value="jdbc:mariadb://192.168.1.45:3307/jblog" />
//		<property name="username" value="jblog" />
//		<property name="password" value="jblog" />
//	</bean>
	
	// service에서 @Transactional 로 트랜잭션을 관리함 
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
