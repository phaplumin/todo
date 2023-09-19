package com.jhost.template.Template.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table
public class User {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */

    @Id
    @SequenceGenerator(name = "task_sequence", sequenceName = "task_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence")
    private long userid;
    private String name;
    private String email;
    private String password;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createddate;
    @UpdateTimestamp
    private LocalDate updateddate;

    @OneToMany
    @JoinColumn(name="userid") // join column is in table for Order
    private List<Task> tasks = new ArrayList<>();
}
