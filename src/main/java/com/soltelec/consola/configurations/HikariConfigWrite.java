package com.soltelec.consola.configurations;

import com.zaxxer.hikari.HikariConfig;

import java.util.Properties;

public class HikariConfigWrite extends HikariConfig {

    protected final HikariMysqlProperties hikariWriteProperties;

    protected final String PERSISTENCE_UNIT_NAME = "persistence.mysql";

    protected final Properties JPA_WRITE_PROPERTIES = new Properties() {{
        put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        put("hibernate.hbm2ddl.auto", "update");
        put("hibernate.ddl-auto", "update");
        put("show-sql", "true");
    }};

    protected HikariConfigWrite(HikariMysqlProperties hikariWriteProperties) {
        this.hikariWriteProperties = hikariWriteProperties;
        setPoolName(this.hikariWriteProperties.getPoolName());
        setMinimumIdle(this.hikariWriteProperties.getMinimumIdle());
        setMaximumPoolSize(this.hikariWriteProperties.getMaximumPoolSize());
        setIdleTimeout(this.hikariWriteProperties.getIdleTimeout());
    }
}
