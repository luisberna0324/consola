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
@ConfigurationProperties("spring.datasource-postgres")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryRead",
        transactionManagerRef = "transactionManagerRead"
        //,basePackages = {"com.soltelec.consola.repository.readRepository"}
)
public class DataSourceConfigPostgres extends HikariConfigRead {

    public DataSourceConfigPostgres(HikariReadProperties hikariReadProperties) {
        super(hikariReadProperties);
    }

    @Bean
    public HikariDataSource dataSourceRead() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryRead(
            final HikariDataSource dataSourceRead) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSourceRead);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_READ_PROPERTIES);
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerRead(EntityManagerFactory entityManagerFactoryRead) {
        return new JpaTransactionManager(entityManagerFactoryRead);
    }
}
