package programs.examples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "programs.examples")
public class AppConfig
{
	@Bean
	public ViewResolver jspViewResolver() {
		UrlBasedViewResolver resolver = new ChainableUrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(0);
		return resolver;
	}

	@Bean
	public ViewResolver jspViewResolver2() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view2/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);
		return resolver;
	}

}
