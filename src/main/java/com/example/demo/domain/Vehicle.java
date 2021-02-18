package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicles")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle extends AbstractAuditableEntity<Long> implements Serializable {
    
    @Column
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Brand brand = Brand.FORD;
    
}
