package config;

import javax.servlet.Filter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// Load database and spring security configuration
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("getRootConfigClasses");
		String encoded = new BCryptPasswordEncoder().encode("1234");
		System.out.println("pass is" + encoded + "until here");
		return new Class[] { AppConfig.class, SecurityConfiguration.class };
	}

	@Override
	protected Filter[] getServletFilters() {
		DelegatingFilterProxy delegateFilterProxy = new DelegatingFilterProxy();
	    delegateFilterProxy.setTargetBeanName("springSecurityFilterChain");
	    return new Filter[]{delegateFilterProxy};
	}
	
	// Load spring web configuration
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfigClasses");
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("getServletMappings");
		return new String[] { "/" };
	}

}