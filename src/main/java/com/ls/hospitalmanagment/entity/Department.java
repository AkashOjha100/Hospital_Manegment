package com.ls.hospitalmanagment.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Service
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100,unique = true)
    private String name;

    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @OneToOne
    private Doctor headDoctor;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn,inverseJoinColumns = @JoinColumn(name="doctor_id"))
    private Set<Doctor> doctors=new HashSet<>();
}
