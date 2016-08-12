package com.test.me;



import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import javax.sql.DataSource;

/**
 * Created by jingbo.lin on 2016/7/25.
 */
@Configuration
@ComponentScan(basePackageClasses = {CacheConfiger.class,WebConfig.class}, excludeFilters = {@ComponentScan.Filter(value = Controller.class)})
//@Import(CacheConfiger.class)
public class AppConfig {
	private static final Logger logger = Logger.getLogger(WebConfig.class);

	private String driverClassName ="com.mysql.jdbc.Driver";

	private String url = "jdbc:mysql://localhost:3306/mytest";

	private String username = "root";

	private String password = "batawar";

	@Bean(name="dataSource")
	public DataSource dataSource(){
		logger.info("dataSource");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		return dataSource;
	}


	@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}

	//    事务管理
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
/*
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(getDataSource());
		return sqlSessionFactory.getObject();
	}
	*/
}