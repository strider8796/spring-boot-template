package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.desc}")
    private String desc;

    @Value("${swagger.version}")
    private String version;

    @Value("${swagger.license}")
    private String license;

    @Value("${swagger.license-url}")
    private String licenseUrl;

    @Value("${swagger.contact.name}")
    private String contactName;

    @Value("${swagger.contact.url}")
    private String contactUrl;

    @Value("${swagger.contact.email}")
    private String contactMail;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(regex("/*"))
                .build()
                .apiInfo(metaData());
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private Contact contact() {
        return new Contact(contactName, contactUrl, contactMail);
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title(title)
                .description(desc)
                .version(version)
                .license(license)
                .licenseUrl(licenseUrl)
                .contact(contact())
                .build();
    }
}
