package com.soltelec.consola.configurations;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

import static com.soltelec.consola.DemoApplication.MODEL_PACKAGE;

/**
 * @author Jay Ehsaniara, Dec 30 2019
 */
@Configuration
@ConfigurationProperties("spring.datasource-mysql")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryWrite",
        transactionManagerRef = "transactionManagerWrite"
        //,basePackages = {"com.soltelec.consola.repository.writeRepository"}
)
public class DataSourceConfigMysql extends HikariConfigWrite {

    public DataSourceConfigMysql(HikariMysqlProperties hikariWriteProperties) {
        super(hikariWriteProperties);
    }

    @Bean
    public HikariDataSource dataSourceWrite() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryWrite(
            final HikariDataSource dataSourceWrite) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSourceWrite);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_WRITE_PROPERTIES);
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerWrite(EntityManagerFactory entityManagerFactoryWrite) {
        return new JpaTransactionManager(entityManagerFactoryWrite);
    }
}
