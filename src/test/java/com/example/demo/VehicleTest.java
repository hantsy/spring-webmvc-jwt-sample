package com.example.demo;

import com.example.demo.domain.Vehicle;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VehicleTest {
    
    @Test
    public void testVehicle() {
        Vehicle v = Vehicle.builder().name("test").build();
        v.setId(1L);
        assertThat(v.getId()).isEqualTo(1L);
        assertThat(v.getName()).isEqualTo("test");
        
        Vehicle v2 = Vehicle.builder().name("test2").build();
        v2.setId(2L);
        assertThat(v2.getId()).isEqualTo(2L);
        assertThat(v2.getName()).isEqualTo("test2");
    }
}
