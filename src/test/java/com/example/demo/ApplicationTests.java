package com.example.demo;

import com.example.demo.web.VehicleForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext applicationContext;

    @Autowired
    ObjectMapper objectMapper;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.applicationContext)
            .apply(springSecurity())
            .build();
    }

    @Test
    public void getAllVehicles() throws Exception {
        this.mockMvc
            .perform(
                get("/v1/vehicles")
                    .accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk());
    }

    @Test
    public void testSave() throws Exception {

        this.mockMvc
            .perform(
                post("/v1/vehicles")
                    .content(this.objectMapper.writeValueAsBytes(VehicleForm.builder().name("test").build()))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().is4xxClientError());

    }

    @Test
    @WithMockUser
    public void testSaveWithMock() throws Exception {

        this.mockMvc
            .perform(
                post("/v1/vehicles")
                    .content(this.objectMapper.writeValueAsBytes(VehicleForm.builder().name("test").build()))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isCreated());
    }

}
