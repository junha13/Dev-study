package lx.edu.springmvc.config;

import org.springframework.context.ApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class AddrBookWebInitalizer implements WebApplicationInitializer{
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));	
		
		AnnotationConfigWebApplicationContext web = new AnnotationConfigWebApplicationContext();
		web.register(WebMvcConfig.class);
		
		ServletRegistration.Dynamic sd = servletContext.addServlet("dispatcher", new DispatcherServlet(web));
		sd.setLoadOnStartup(1);
		sd.addMapping("/");
	}
}
