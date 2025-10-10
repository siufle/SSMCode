package com.xq.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource("classpath:db.properties") //加载类路径下的properties配置文件
public class DataSourceConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**
     * @Bean 相当于bean标签 修饰方法 方法的返回值就是需要管理的bean
     *       默认情况下方法的名称就是bean的名称 可以通过name或value指定bean的名称
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Qualifier 修饰方法形参 意味着可以从IOC容器中获取指定的bean
     * @return
     */
    @Bean(name = "runner")
    public QueryRunner getQueryRunner(@Qualifier("dataSource") DataSource dataSource) {
        QueryRunner runner = new QueryRunner(dataSource);
        return runner;
    }
}
