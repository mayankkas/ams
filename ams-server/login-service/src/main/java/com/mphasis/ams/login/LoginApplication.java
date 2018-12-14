package com.mphasis.ams.login;


import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.util.StringUtils;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDynamoDBRepositories(basePackages = "com.mphasis.ams.login.repository")
@SpringBootApplication
@Configuration
@EnableSwagger2
public class LoginApplication {

	@Value("${amazon.dynamodb.endpoint}")
	private String dBEndpoint;
 
	@Value("${amazon.aws.accesskey}")
	private String accessKey;
 
	@Value("${amazon.aws.secretkey}")
	private String secretKey;
 
	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
		
		
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		AmazonDynamoDB dynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
 
		if (!StringUtils.isNullOrEmpty(dBEndpoint)) {
			dynamoDB.setEndpoint(dBEndpoint);
		}
 
		return dynamoDB;
	}
 
	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(accessKey, secretKey);
	}
}
