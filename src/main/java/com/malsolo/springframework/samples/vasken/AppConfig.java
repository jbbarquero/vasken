package com.malsolo.springframework.samples.vasken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/com/${my.placeholder:default/path}/app.properties")
@ComponentScan
public class AppConfig {
    @Autowired
    Environment env;
    
    @Autowired
    ApplicationContext ctx;
    
    @Bean
    public TestBean testBean() {
        TestBean testBean = new TestBean();
        testBean.setName(env.getProperty("testbean.name"));
        testBean.setMensaje(ctx.getBean("perfilado", String.class));
        return testBean;
    }
    
    @Profile("lalala")
    @Bean(name = "perfilado")
    public String damePerfilLa() {
    	return "perfil";
    }
    
    @Profile("lololo")
    @Bean(name = "perfilado")
    public String damePerfilLo() {
    	return "de lado";
    }
    
    public static void main(String[] args) {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	TestBean testBean = context.getBean(TestBean.class);
    	
    	System.out.println(testBean);
    	
    	System.err.println(context.getBean("perfilado"));
    	
    	context.close();
	}
    
    
}