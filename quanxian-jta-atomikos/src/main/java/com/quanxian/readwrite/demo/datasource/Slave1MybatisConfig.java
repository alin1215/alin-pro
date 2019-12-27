package com.quanxian.readwrite.demo.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @program: alin-pro
 * @description: aaa
 * @author: Alin
 * @create: 2019-12-25 17:19
 **/
@Configuration
@MapperScan(basePackages = "com.quanxian.demo.mapper.slave1", sqlSessionTemplateRef = "slave1SqlSessionTemplate")
public class Slave1MybatisConfig {

    @Value("${spring.datasource.slave1.url}")
    private String url;
    @Value("${spring.datasource.slave1.username}")
    private String username;
    @Value("${spring.datasource.slave1.password}")
    private String password;
    @Value("${spring.datasource.slave1.driverClassName}")
    private String driverClassName;
    @Bean(name = "slave1MybatisDS")
    public DataSource DataSource() throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(url);
        mysqlXaDataSource.setPassword(password);
        mysqlXaDataSource.setUser(username);

//        DruidXADataSource druidXADataSource=new DruidXADataSource();
//        druidXADataSource.setUrl(url);
//        druidXADataSource.setPassword(password);
//        druidXADataSource.setUsername(username);

        AtomikosDataSourceBean ds2 = new AtomikosDataSourceBean();
        ds2.setXaDataSource(mysqlXaDataSource);
        return ds2;
    }
    @Bean(name = "slave1SqlSessionFactory")
    public SqlSessionFactory SqlSessionFactory(@Qualifier("slave1MybatisDS") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/slave1/*.xml");
        bean.setMapperLocations(resources);
        return bean.getObject();
    }

    @Bean(name = "slave1SqlSessionTemplate")
    public SqlSessionTemplate SqlSessionTemplate(@Qualifier("slave1SqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}