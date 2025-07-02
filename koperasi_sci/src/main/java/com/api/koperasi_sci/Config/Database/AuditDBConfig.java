//package com.api.koperasi_sci.Config.Database;
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages = "com.cim.sky.Repository.Remote",
//        entityManagerFactoryRef = "auditEntityManagerFactory",
//        transactionManagerRef = "auditTransactionManager"
//)
//public class AuditDBConfig {
//
//    @Primary
//    @Bean(name = "auditDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.audit")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Primary
//    @Bean(name = "auditEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean auditEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("auditDataSource") DataSource dataSource) {
//        return builder.dataSource(dataSource).packages("com.cim.sky.Model.Remote").persistenceUnit("audit").build();
//    }
//
//    @Primary
//    @Bean(name = "auditTransactionManager")
//    public PlatformTransactionManager productTransactionManager(
//            @Qualifier("auditEntityManagerFactory") EntityManagerFactory auditEntityManagerFactory ) {
//        return new JpaTransactionManager(auditEntityManagerFactory);
//    }
//}
