package com.digitel;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.digitel.common.ConcatString;
import com.digitel.common.Interceptor;
import com.google.common.base.Predicates;
//import com.digitel.common.ConcatString; Revisar
//import com.digitel.common.Interceptor;  Revisar

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@PropertySources({
//	@PropertySource("file:/opt/tomcat/apache-tomcat-8.5.37/webapps/intercorp/properties/name_project.properties"),
//	@PropertySource("file:/opt/tomcat/apache-tomcat-8.5.37/webapps/intercorp/properties/intercorpError.properties")
//			})
@PropertySources({
@PropertySource("classpath:findMaterial.properties"), //cambiar nombre de los properties
@PropertySource("classpath:findMaterialError.properties") //cambiar nombre de los properties
})
public class ConfigAdapter extends WebMvcConfigurationSupport {
	
	private static final Logger logger = LogManager.getLogger(ConfigAdapter.class);
	public static HashMap<String,String> mapErrorIc ;
	public static HashMap<String,String> mapConfAuthenticator;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("Config Interceptor");
		registry.addInterceptor(new Interceptor())
		.excludePathPatterns(
				new String[] { 
						"/v2/**", "/swagger-ui.html","/v2/api-docs?group=public-api", 
						"/swagger-resources", "/webjars/**", "/configuration/**",
						"/pruebas*"
				});
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		System.out.println("Config Cors");
		registry.addMapping("*/**")
		.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
		.allowedOrigins("*")
		.allowedHeaders("*")
		.exposedHeaders("Authorization","lookup_type","lookup_data")
		.allowCredentials(false);
	}
	
	@Bean
    public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error.*")))
				.build();                      
    }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("InterCorp Backend")
				.description("InterCorp Backend Web Services")
				.license("JavaInUse License")
				.version("1.0")
				.build();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Autowired
	Environment env;
	@Bean
	public boolean readProrperties() throws Exception {
		
		StringBuilder sms = new StringBuilder();
		sms.append("Inicio Despliegue de ic-getSalesRepresentative"); ///Cambiar por nombre de servicio
		logger.info(sms);	
		
		logger.info(ConcatString.generateSms("Cargando Bean de errores ...", "read findMaterialError.properties"));/// cambiar nombre propertie
		mapErrorIc = new HashMap<String, String>();
		mapConfAuthenticator = new HashMap<String,String>();
		
		mapErrorIc.put("error.cod_000", env.getProperty("error.cod_000").toString()); //Cambiar mapa de error
		mapErrorIc.put("error.cod_007", env.getProperty("error.cod_007").toString()); //Cambiar mapa de error
		mapErrorIc.put("error.cod_013", env.getProperty("error.cod_013").toString()); //Cambiar mapa de error
		mapErrorIc.put("error.cod_014", env.getProperty("error.cod_014").toString()); //Cambiar mapa de error
		
		logger.info(ConcatString.generateSms("Cargando Bean de Configuración ...", " read findMaterial.propertie"));/// cambiar nombre propertie
		
		mapConfAuthenticator.put("pnnprod",env.getProperty("pnnprod").toString()); //Cambiar mapa de error
		mapConfAuthenticator.put("kenan",env.getProperty("kenan").toString()); //Cambiar mapa de error
		mapConfAuthenticator.put("expiryTime",env.getProperty("expiryTime").toString()); //Cambiar mapa de error
		mapConfAuthenticator.put("tokenSignature",env.getProperty("tokenSignature").toString()); //Cambiar mapa de error
		mapConfAuthenticator.put("sp_loockup_msisdn_type",env.getProperty("sp_loockup_msisdn_type").toString()); //Cambiar mapa de error
		mapConfAuthenticator.put("featc_validate_type_sim",env.getProperty("featc_validate_type_sim").toString()); //Cambiar mapa de error
		
		
		return true;

	}
	
}
