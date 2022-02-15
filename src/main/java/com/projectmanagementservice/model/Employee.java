package com.projectmanagementservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Builder
@Data
@Entity
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = -8970309065692057634L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    @JoinTable(
            name = "member_assigment",
            joinColumns = @JoinColumn(
                    name = "employee_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "project_id",
                    referencedColumnName = "id"
            )
    )
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonManagedReference
    private Set<Project> memberAssign;

    @JoinTable(
            name = "leader_assigment",
            joinColumns = @JoinColumn(
                    name = "employee_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "project_id",
                    referencedColumnName = "id"
            )
    )
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonManagedReference
    private Set<Project> leaderAssign;





}
