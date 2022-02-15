package com.projectmanagementservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="project")
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {

    private static final long serialVersionUID = -8970309899692057634L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @ManyToMany(fetch=FetchType.LAZY, mappedBy = "leaderAssign")
    @JsonBackReference
        private List<Employee> leaders= new ArrayList<>();

    @ManyToMany(fetch=FetchType.LAZY, mappedBy = "memberAssign")
    @JsonBackReference
    private List<Employee> memberAssign = new ArrayList<>();
}
