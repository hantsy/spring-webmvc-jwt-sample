package com.example.demo;

import com.example.demo.web.AuthenticationRequest;
import com.example.demo.web.VehicleForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureTestDatabase
@Slf4j
public class IntegrationTests {
    
    @LocalServerPort
    private int port;
    
    @Autowired
    ObjectMapper objectMapper;
    
    private String token;
    
    @BeforeEach
    public void setup() {
        RestAssured.port = this.port;
        token = given()
                .contentType(ContentType.JSON)
                .body(new AuthenticationRequest("user","password"))
                .when().post("/auth/signin")
                .andReturn().jsonPath().getString("token");
        log.debug("Got token:" + token);
    }
    
    @Test
    public void getAllVehicles() throws Exception {
        //@formatter:off
         given()

            .accept(ContentType.JSON)

        .when()
            .get("/v1/vehicles")

        .then()
            .assertThat()
            .statusCode(HttpStatus.SC_OK);
         //@formatter:on
    }
    
    @Test
    public void testSave() throws Exception {
        //@formatter:off
        given()

            .contentType(ContentType.JSON)
            .body(new VehicleForm("test"))

        .when()
            .post("/v1/vehicles")

        .then()
            .statusCode(401);

        //@formatter:on
    }
    
    @Test
    public void testSaveWithAuth() throws Exception {
        
        //@formatter:off
        given()
            .header("Authorization", "Bearer "+token)
            .contentType(ContentType.JSON)
                .body(new VehicleForm("test"))

        .when()
            .post("/v1/vehicles")

        .then()
            .statusCode(201);
        //@formatter:on
    }
    
    @Test
    public void testSaveWithInvalidAuth() throws Exception {
        
        //@formatter:off
        given()
            .header("Authorization", "Bearer "+"invalidtoken")
            .contentType(ContentType.JSON)
                .body(new VehicleForm("test"))

        .when()
            .post("/v1/vehicles")
            
        .then()
            .statusCode(401);
        //@formatter:on
    }
    
}
