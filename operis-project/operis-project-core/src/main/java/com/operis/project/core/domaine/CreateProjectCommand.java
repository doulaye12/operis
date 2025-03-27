package com.operis.project.core.domaine;

public record CreateProjectCommand(String name, String description, String owner) {
}
