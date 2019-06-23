package com.example.demo.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {

	private String secretKey = "secret";

	private long validityInMilliseconds = 3600000; // 1h
}
