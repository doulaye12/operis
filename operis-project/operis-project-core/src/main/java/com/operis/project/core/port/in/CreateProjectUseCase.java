package com.operis.project.core.port.in;

import com.operis.project.core.domaine.CreateProjectCommand;
import com.operis.project.core.domaine.Project;

public interface CreateProjectUseCase {
    Project createProject(CreateProjectCommand command);
}
