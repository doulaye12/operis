package com.operis.project.core.domaine;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Project {
    private String id;
    private String name;
    private String description;
    private String owner;
    private List<String> members;

    public Project(String name, String description, String owner) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if(owner == null || owner.isBlank()) {
            throw new IllegalArgumentException("Owner cannot be null or empty");
        }

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.members = Arrays.asList(owner);
    }
}
