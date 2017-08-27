package cn.g_open.game.common.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
/**
 * 数据库连接池&Mybatis配置类
 * @author Administrator
 **/
@Configuration
public class DruidConfiguation
{
    /**
     * druid 监控配置
     * @return
     * http://127.0.0.1:8080/druid/index.html
     */
    @Bean
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ServletRegistrationBean statViewServle(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //白名单：
        servletRegistrationBean.addInitParameter("allow","192.168.1.218,127.0.0.1");
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的即提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny","192.168.1.100");
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername","druid");
        servletRegistrationBean.addInitParameter("loginPassword","12345678");
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    /**
     * druid 监控过滤配置
     * @return
     */
    @Bean
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
    
    /**
     * druid连接池配置
     * @return
     */
    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
    //配置数据库的基本链接信息
     @Primary
     @Bean(name = "dataSource")
     @ConfigurationProperties(prefix = "spring.datasource")    //可以在application.properties中直接导入
     public DataSource dataSource(){
         return DataSourceBuilder.create().type(DruidDataSource.class).build();
     }
     
    @Bean(name = "sqlSessionFactory")
     public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws IOException {
         SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
         bean.setDataSource(dataSource);
         ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
         bean.setMapperLocations(resolver.getResources("classpath:mapper/**/*Mapper.xml"));
         return bean;
     }

}
