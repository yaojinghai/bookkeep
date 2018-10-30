package com.spring.bookkeep.config.dao;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@MapperScan("com.spring.bookkeep.dao")
public class DataSourceConfiguration {

    @Value("${jdbc.driver}")
    private String jdbcDriverClass;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.user}")
    private String jdbcUser;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(name="dataSource")
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUser);
        dataSource.setPassword(jdbcPassword);
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
