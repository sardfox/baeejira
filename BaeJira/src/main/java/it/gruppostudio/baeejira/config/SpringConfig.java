package it.gruppostudio.baeejira.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import it.gruppostudio.baeejira.dao.RoleDAO;
import it.gruppostudio.baeejira.dao.RoleDAOImpl;
import it.gruppostudio.baeejira.dao.UserDAO;
import it.gruppostudio.baeejira.dao.UserDAOImpl;
import it.gruppostudio.baeejira.service.RoleService;
import it.gruppostudio.baeejira.service.RoleServiceImpl;
import it.gruppostudio.baeejira.service.UserService;
import it.gruppostudio.baeejira.service.UserServiceImpl;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@PropertySource({ "classpath:mysql.properties" })
@ComponentScan(basePackages = "it.gruppostudio.baeejira")
public class SpringConfig extends WebMvcConfigurerAdapter{
	
	
	@Value("${db.driver}")
    private String DB_DRIVER;
 
    @Value("${db.password}")
    private String DB_PASSWORD;
 
    @Value("${db.jdbcurl}")
    private String DB_URL;
 
    @Value("${db.user}")
    private String DB_USERNAME;
	
	@Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;

    }
	
	@Bean(name = "dataSource")
    public ComboPooledDataSource dataSource() {
        // a named datasource is best practice for later jmx monitoring
        ComboPooledDataSource dataSource = new ComboPooledDataSource("jupiter");
 
        try {
            dataSource.setDriverClass(DB_DRIVER);
        } catch (PropertyVetoException pve){
            System.out.println("Cannot load datasource driver (com.mysql.jdbc.Driver) : " + pve.getMessage());
            return null;
        }
        dataSource.setJdbcUrl(DB_URL);
        dataSource.setUser(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setMinPoolSize(5);
        dataSource.setMaxPoolSize(20);
        dataSource.setMaxIdleTime(3000);
 
        return dataSource;
    }
	
	@Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("it.gruppostudio.baeejira.model");
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.put("hibernate.show_sql", true);
        sessionFactoryBean.setHibernateProperties(hibernateProperties);
 
        return sessionFactoryBean;
    }
	
	@Bean(name = "transactionManager")
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }	
	
	// define bean for our sad fortune service
	@Bean(name = "roleDAO")
	public RoleDAO getRoleDAO() {
		return new RoleDAOImpl();
	}
	
	// define bean for our sad fortune service
	@Bean(name = "roleService")
	public RoleService getRoleService() {
		return new RoleServiceImpl();
	}
	
	// define bean for our userDAO
	@Bean(name = "userDAO")
	public UserDAO getUserDAO() {
		return new UserDAOImpl();
	}
	
	// define bean for user service
	@Bean(name = "userService")
	public UserService getUserService() {
		return new UserServiceImpl();
	}
	
}
