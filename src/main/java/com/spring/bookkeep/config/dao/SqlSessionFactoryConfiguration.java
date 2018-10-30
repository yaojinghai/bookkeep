package com.spring.bookkeep.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SqlSessionFactoryConfiguration {

    @Value("${mybatis_config_file}")
    private String mybatisConfigPath;

    @Value("${mapper_path}")
    private String mapperPath;

    @Value("${entity_package}")
    private String entityPackage;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;


    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean getSqlSessFacBean() throws IOException {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigPath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_URL_PREFIX;
        sessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath+mapperPath));
        sessionFactoryBean.setTypeAliasesPackage(entityPackage);
        sessionFactoryBean.setDataSource(dataSource);
        return sessionFactoryBean;
    }
}
