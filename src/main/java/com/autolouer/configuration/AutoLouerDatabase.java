package com.autolouer.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = {
        "com.autolouer.repositories" }, transactionManagerRef = "transactionManager"

)
public class AutoLouerDatabase {
    @Primary
    @Bean(name = "autoLouerDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.autolouer")
    public DataSource autoLouerDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean autoLouerEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("autoLouerDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.autolouer.entities.defaultapp")
               
                .build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager autoLouerTransactionManager(
            EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}