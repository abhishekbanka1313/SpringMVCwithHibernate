package com.stackroute.configuration;


import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import com.stackroute.domain.User;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class ApplicationContextConfig {
    @Bean
    @Autowired
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db1");
        dataSource.setUsername("abhishek");
        dataSource.setPassword("root123");
//	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//	    dataSource.setUrl("jdbc:mysql://localhost:3306/Test1");
//	    dataSource.setUsername("root");
//	    dataSource.setPassword("Root@123");

        return dataSource;
    }

    /*
     * Define the bean for SessionFactory. Hibernate SessionFactory is the factory
     * class through which we get sessions and perform database operations.
     */

    @Bean
    @Autowired
    public LocalSessionFactoryBean getSessionFactory() throws IOException {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties properties=new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.hbm2ddl.auto", "update");

        factoryBean.setHibernateProperties(properties);
        factoryBean.setAnnotatedClasses(User.class);
        factoryBean.afterPropertiesSet();
        return factoryBean;
    }

    /*
     * Define the bean for Transaction Manager. HibernateTransactionManager handles
     * transaction in Spring. The application that uses single hibernate session
     * factory for database transaction has good choice to use
     * HibernateTransactionManager. HibernateTransactionManager can work with plain
     * JDBC too. HibernateTransactionManager allows bulk update and bulk insert and
     * ensures data integrity.
     */

    @Bean
    @Autowired
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

}
