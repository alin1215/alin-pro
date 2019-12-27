package com.quanxian.readwrite.demo.datasource;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import javax.sql.XADataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(value = {"com.quanxian.demo.mapper.master"}, sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class MasterMybatisConfig {
    @Value("${spring.datasource.master.url}")
    private String url;
    @Value("${spring.datasource.master.username}")
    private String username;
    @Value("${spring.datasource.master.password}")
    private String password;
    @Value("${spring.datasource.master.driverClassName}")
    private String driverClassName;

    @Bean(name = "masterMybatisDS")
    public DataSource DataSource() throws SQLException {
        DruidXADataSource druidXADataSource=new DruidXADataSource();
//        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        druidXADataSource.setUrl(url);
        druidXADataSource.setPassword(password);
        druidXADataSource.setUsername(username);
//        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(druidXADataSource);
        xaDataSource.setUniqueResourceName("datasourMaster");
        return xaDataSource;
    }

    @Bean(name = "masterSqlSessionFactory")
    public SqlSessionFactory SqlSessionFactory(@Qualifier("masterMybatisDS") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/master/*.xml");
        bean.setMapperLocations(resources);
        return bean.getObject();
    }

    @Bean(name = "masterSqlSessionTemplate")
    public SqlSessionTemplate SqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}