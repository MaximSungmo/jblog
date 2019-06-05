package com.cafe24.jblog.initializer;

import javax.servlet.Filter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.cafe24.jblog.config.AppConfig;
import com.cafe24.jblog.config.WebConfig;

public class JblogWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {AppConfig.class};
	}
//	<!-- ContextLoader에서 다음의 Appconfig 위치를 참조하여 미리 DAO와 같은 웹과 관련되지 않은 객체 생성 -->
//	<!-- AppConfig, applicationContext와 대응 -->
//	<context-param>
//		<param-name>contextClass</param-name>
//		<param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
//	</context-param>
//	<context-param>
//		<param-name>contextConfigLocation</param-name>
//		<param-value>com.cafe24.jblog.config.AppConfig</param-value>
//	</context-param>
//	<!-- Context Loader Listener -->
//	<listener>
//		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
//	</listener>

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}
	
	@Override
	protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
		DispatcherServlet dispatcherServlet = (DispatcherServlet)(super.createDispatcherServlet(servletAppContext));
		
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(false);
		return dispatcherServlet;
	}
//	<!-- Dispatcher Server(Front Controller) -->
//	<!-- WebConfig, spring-servlet의 내용과 대응 -->	
//	<servlet>
//		<servlet-name>spring</servlet-name>
//		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//		<init-param>
//			<param-name>contextClass</param-name>
//			<param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
//		</init-param>
//		<init-param>
//			<param-name>contextConfigLocation</param-name>
//			<param-value>com.cafe24.jblog.config.WebConfig</param-value>
//		</init-param>
//		<load-on-startup>1</load-on-startup>	
//	</servlet>

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
//	<servlet-mapping>
//	<servlet-name>spring</servlet-name>
//	<url-pattern>/</url-pattern>
//</servlet-mapping>

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] {new CharacterEncodingFilter("UTF-8", true) };		
	}
//	<!-- Encodng Filter -->
//	<filter>
//		<filter-name>encodingFilter</filter-name>
//		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
//		<init-param>
//			<param-name>encoding</param-name>
//			<param-value>UTF-8</param-value>
//		</init-param>
//		<init-param>
//			<param-name>forceEncoding</param-name>
//			<param-value>true</param-value>
//		</init-param>
//	</filter>
//	<filter-mapping>
//		<filter-name>encodingFilter</filter-name>
//		<url-pattern>/*</url-pattern>
//	</filter-mapping>
	

}
