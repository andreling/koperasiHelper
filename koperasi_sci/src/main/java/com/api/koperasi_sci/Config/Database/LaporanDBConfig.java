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
//        entityManagerFactoryRef = "laporanEntityManagerFactory",
//        transactionManagerRef = "laporanTransactionManager"
//)
//public class LaporanDBConfig {
//
//    @Primary
//    @Bean(name = "laporanDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.laporan")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Primary
//    @Bean(name = "laporanEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean laporanEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("laporanDataSource") DataSource dataSource) {
//        return builder.dataSource(dataSource).packages("com.cim.sky.Model.Remote").persistenceUnit("laporan").build();
//    }
//
//    @Primary
//    @Bean(name = "laporanTransactionManager")
//    public PlatformTransactionManager productTransactionManager(
//            @Qualifier("laporanEntityManagerFactory") EntityManagerFactory laporanEntityManagerFactory ) {
//        return new JpaTransactionManager(laporanEntityManagerFactory);
//    }
//}
