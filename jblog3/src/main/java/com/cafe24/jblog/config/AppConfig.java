package com.cafe24.jblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.app.config.DBConfig;
import com.cafe24.app.config.MyBatisConfig;


/*
 * AppConfig는 톰캣 실행 시에는 ContextLoadListener가 호출되어 
 * ContextLoader가 생성되며 ContextLoader에 의해서 생성되는 Root Application Context는 웹과 관련이 없는
 * DAO같은 것을 톰캣 실행 시 생성할 수 있도록 한다.
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.jblog.service", "com.cafe24.jblog.repository", "com.cafe24.jblog.aspect"})
@Import({DBConfig.class, MyBatisConfig.class})
public class AppConfig {

//	*web.xml*의 참조를 현재 @Configuration으로 작성하여 본 파일을 읽도록 변경 
//	*applicationContext.xml*를 읽어서 contextLoader로 미리 객체 생성할 예정이나 path를 appconfig로 변경시켜줌
//	<context-param>
//		<param-name>contextConfigLocation</param-name>
//		<param-value>classpath:applicationContext.xml  --> appConfig</param-value>
//	</context-param>
	
//	*applicationContext.xml*의 내용을 @componentScan으로 변경 
//	<aop:aspectj-autoproxy />
//	<context:annotation-config />
//	<context:component-scan
//		base-package="com.cafe24.jblog.dao, com.cafe24.jblog.service, com.cafe24.jblog.repository, com.cafe24.jblog.aspect">
//		<context:include-filter type="annotation" expression="org.springframework.stereotype.Repository" />
//		<context:include-filter type="annotation" expression="org.springframework.stereotype.Service" />
//		<context:include-filter type="annotation" expression="org.springframework.stereotype.Component" />
//	</context:component-scan>
		
	
//	위의 내용이 삭제되며 web.xml에서는 하기의 코드가 사라진다.
//	<!-- 빈설정을 annotation으로 하겠다.(@Controller에 auto scanning) -->
//	<!-- Controller Scanning 하는 base package 지정 -->
//	<context:annotation-config />
//	<context:component-scan
//		base-package="com.cafe24.jblog.controller, com.cafe24.jblog.controller.api, com.cafe24.jblog.exception" />
	
//	applicationContext.xml에 있던 <!-- auto proxy --> 은 @EnableAspectJAutoProxy 변경
//	<aop:aspectj-autoproxy />
	
//	applicationContext.xml에 있던 내용은 @import 된 DB관련 내용은 각각 Java 파일 내에 설명 추가하였음. 
	
	
}
