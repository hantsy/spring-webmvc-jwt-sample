package com.example.demo.web;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(Long vehicleId ) {
        super("Vehicle: " +vehicleId +" not found.");
    }
}
