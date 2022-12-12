package com.example.demo.web;

import com.example.demo.domain.Brand;
import com.example.demo.domain.Vehicle;
import com.example.demo.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    
    private final VehicleRepository vehicles;
    
    @GetMapping("")
    public ResponseEntity<List<Vehicle>> all(@RequestParam(name = "brand", required = false) String[] brands) {
        if (brands == null || brands.length == 0) {
            return ok(this.vehicles.findAll());
        } else {
            List<Brand> brandList = Arrays.stream(brands)
                    .map(brand -> Brand.valueOf(brand.toUpperCase()))
                    .collect(Collectors.toList());
            return ok(this.vehicles.findByBrandIn(brandList));
        }
        
    }
    
    @SuppressWarnings("rawtypes")
    @PostMapping("")
    public ResponseEntity save(@RequestBody VehicleForm form, HttpServletRequest request) {
        Vehicle saved = this.vehicles.save(Vehicle.builder().name(form.getName()).build());
        return created(
                ServletUriComponentsBuilder
                        .fromContextPath(request)
                        .path("/v1/vehicles/{id}")
                        .buildAndExpand(saved.getId())
                        .toUri())
                .build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> get(@PathVariable("id") Long id) {
        return ok(this.vehicles.findById(id).orElseThrow(() -> new VehicleNotFoundException()));
    }
    
    @SuppressWarnings("rawtypes")
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody VehicleForm form) {
        Vehicle existed = this.vehicles.findById(id).orElseThrow(() -> new VehicleNotFoundException());
        existed.setName(form.getName());
        
        this.vehicles.save(existed);
        return noContent().build();
    }
    
    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Vehicle existed = this.vehicles.findById(id).orElseThrow(() -> new VehicleNotFoundException());
        this.vehicles.delete(existed);
        return noContent().build();
    }
}
