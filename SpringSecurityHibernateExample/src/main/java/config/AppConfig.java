package config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import model.Authorities;
import model.User;

import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("dao"),
    @ComponentScan("service"),
    @ComponentScan("model")})
public class AppConfig {

  @Autowired
  private Environment env;

  @Bean
  public LocalSessionFactoryBean getSessionFactory() {
    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
    
    Properties props = new Properties();
    
    // Setting JDBC properties
    props.put(DRIVER, env.getProperty("mysql.driver"));
    props.put(URL, env.getProperty("mysql.jdbcUrl"));
    props.put(USER, env.getProperty("mysql.username"));
    props.put(PASS, env.getProperty("mysql.password"));
    props.put(DIALECT, env.getProperty("mysql.dialect"));

    // Setting Hibernate properties
    props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
    props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
    props.put(CURRENT_SESSION_CONTEXT_CLASS, env.getProperty("hibernate.current_session_context_class"));
    props.put(HBM2DDL_CHARSET_NAME, env.getProperty("hibernate.charset_name"));
    props.put(USE_NATIONALIZED_CHARACTER_DATA, env.getProperty("hibernate.character_data"));

    // Setting C3P0 properties
    props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
    props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
    props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
    props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
    props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));

    factoryBean.setHibernateProperties(props);
    factoryBean.setAnnotatedClasses(User.class, Authorities.class);
    
    return factoryBean;
  }

  @Bean
  public HibernateTransactionManager getTransactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(getSessionFactory().getObject());
    return transactionManager;
  }
}