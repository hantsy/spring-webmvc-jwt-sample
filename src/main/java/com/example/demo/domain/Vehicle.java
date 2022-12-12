package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "vehicles")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Vehicle extends AbstractAuditableEntity<Long> implements Serializable {
    
    @Column
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Brand brand = Brand.FORD;
    
}
