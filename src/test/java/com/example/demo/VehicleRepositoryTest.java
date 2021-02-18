package com.example.demo;

import com.example.demo.domain.Vehicle;
import com.example.demo.repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class VehicleRepositoryTest {
    
    @Autowired
    private VehicleRepository vehicles;
    
    @Test
    public void mapping() {
        Vehicle saved = this.vehicles.save(Vehicle.builder().name("test").build());
        Vehicle v = this.vehicles.getOne(saved.getId());
        assertThat(v.getName()).isEqualTo("test");
        assertThat(v.getId()).isNotNull();
        assertThat(v.getId()).isGreaterThan(0);
    }
}
