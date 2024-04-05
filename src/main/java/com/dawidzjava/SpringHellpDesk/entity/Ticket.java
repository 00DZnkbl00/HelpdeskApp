package com.dawidzjava.SpringHellpDesk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;

@Entity
public class Ticket {
    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private int priority;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date openDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date closeDate;


//    private User client;
//
//    private Collection<Employee> workers;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
