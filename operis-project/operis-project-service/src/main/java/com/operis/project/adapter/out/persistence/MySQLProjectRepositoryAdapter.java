package com.operis.project.adapter.out.persistence;

import com.operis.project.core.domaine.Project;
import com.operis.project.core.port.out.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MySQLProjectRepositoryAdapter implements ProjectRepository {

    private final JPAProjectRepository jpaProjectRepository;

    @Override
    public void create(Project project) {
        ProjectEntity projectEntity = new ProjectEntity();
        jpaProjectRepository.save(projectEntity);
    }

}
