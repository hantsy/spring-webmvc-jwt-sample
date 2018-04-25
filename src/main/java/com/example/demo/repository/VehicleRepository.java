package com.example.demo.repository;

import com.example.demo.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
