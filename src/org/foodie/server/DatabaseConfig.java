package org.foodie.server;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Contains database configurations.
 * 
 * @author Danyang Li
 */
@Configuration
@PropertySource("classpath:org/foodie/server/application.properties")
@EnableTransactionManagement
public class DatabaseConfig { 
	@Autowired
	private Environment env;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private LocalContainerEntityManagerFactoryBean entityManagerFactory;

  /**
   * DataSource definition for database connection. Settings are read from the application.properties file (using the env object).
   */
  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  //DruidDataSource dataSource = new DruidDataSource();
	  
    dataSource.setDriverClassName(env.getProperty("db.driver"));
    dataSource.setUrl(env.getProperty("db.url"));
    dataSource.setUsername(env.getProperty("db.username"));
    dataSource.setPassword(env.getProperty("db.password"));
    
    //Druid data connection pool configuration
   /* dataSource.setInitialSize(Integer.parseInt(env.getProperty("Druid.initialSize")));
    dataSource.setMinIdle(Integer.parseInt(env.getProperty("Druid.minIdle")));
    dataSource.setMaxActive(Integer.parseInt(env.getProperty("Druid.maxActive")));
    dataSource.setPoolPreparedStatements(Boolean.parseBoolean(env.getProperty("Druid.poolPreparedStatements")));*/
    
    return dataSource;
  }
  
  @Bean
  public LocalSessionFactoryBean sessionFactory(){
	  //AnnotationSessionFactoryBean sessionFactory=new AnnotationSessionFactoryBean();
	  LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
	  sessionFactory.setDataSource(dataSource);
	  sessionFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));
	  //sessionFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));
	  Properties additionalProperties = new Properties();
	  additionalProperties.put( "hibernate.dialect", env.getProperty("hibernate.dialect"));
	  additionalProperties.put( "hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	  additionalProperties.put( "hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	  sessionFactory.setHibernateProperties(additionalProperties);  
	  return sessionFactory;
  }

  /**
   * Declare the JPA entity manager factory.
   */
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
    
    entityManagerFactory.setDataSource(dataSource);
    
    // Classpath scanning of @Component, @Service, etc annotated class
    entityManagerFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));
    
    // Vendor adapter
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(true);
    entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
    
    // Hibernate properties
    Properties additionalProperties = new Properties();
    additionalProperties.put( "hibernate.dialect", env.getProperty("hibernate.dialect"));
    additionalProperties.put( "hibernate.show_sql", env.getProperty("hibernate.show_sql"));
    additionalProperties.put( "hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
    entityManagerFactory.setJpaProperties(additionalProperties);    
    return entityManagerFactory;
  }

  /**
   * Declare the transaction manager.
   */
  @Bean
  public JpaTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
    return transactionManager;
  }
  
  /**
   * PersistenceExceptionTranslationPostProcessor is a bean post processor
   * which adds an advisor to any bean annotated with Repository so that any
   * platform-specific exceptions are caught and then rethrown as one
   * Spring's unchecked data access exceptions (i.e. a subclass of 
   * DataAccessException).
   */
  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

}
