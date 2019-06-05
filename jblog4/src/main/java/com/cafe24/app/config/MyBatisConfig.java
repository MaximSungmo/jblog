package com.cafe24.app.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource, ApplicationContext applicationContext) throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:com/cafe24/config/app/mybatis/configuration.xml"));
		return sqlSessionFactoryBean.getObject();
	}
//	*applicationContext.xml*에 존재하던 mybatis를 위의 함수로 @Bean설정함
//	<!-- MyBatis SqlSessionFactoryBean --> 
//	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean"> 
//		<property name="dataSource" ref="dataSource"/> 
//		<property name="configLocation" value="classpath:mybatis/configuration.xml" /> 
//	</bean>
	
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
//	*applicationContext.xml*에 존재하던 mybatis를 위의 함수로 @Bean설정함
//	<!-- MyBatis SqlSessionTemplate --> 
//	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
//		<constructor-arg index="0" ref="sqlSessionFactory" />
//	</bean>
	
}
