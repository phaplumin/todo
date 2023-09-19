package com.jhost.template.Template.model;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "task")
public class Task {
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
    private long taskid;
    @Column(name = "userid")
    private long userid;
    private String taskname;
    private String note;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createddate;
    @UpdateTimestamp
    private LocalDate updateddate;
    private LocalDate completedate;
}
