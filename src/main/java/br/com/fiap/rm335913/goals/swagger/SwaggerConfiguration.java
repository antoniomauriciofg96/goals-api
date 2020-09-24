package br.com.fiap.rm335913.goals.swagger;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	 @Bean
	  public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).select()
	        .apis(RequestHandlerSelectors.basePackage("br.com.fiap.rm335913.goals")).paths(paths()).build()
	        .apiInfo(apiInfo());
	  }

	  private Predicate<String> paths() {
	    return Predicates.not(PathSelectors.regex("/basic-error-controller.*"));
	  }

	  private ApiInfo apiInfo() {
	    return new ApiInfoBuilder().title("Goals API Documentation").version("Versão 1.0")
	        .build();
	  }

}
