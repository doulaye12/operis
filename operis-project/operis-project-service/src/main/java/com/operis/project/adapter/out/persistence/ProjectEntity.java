package com.operis.project.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private String ownerEmail;

    @ElementCollection
    @CollectionTable(
            name = "project_members_emails",
            joinColumns = @JoinColumn(name = "project_id")
    )
    private List<String> membes;
}
