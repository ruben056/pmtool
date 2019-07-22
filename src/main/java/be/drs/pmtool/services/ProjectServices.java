package be.drs.pmtool.services;

import be.drs.pmtool.domain.Project;
import be.drs.pmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServices {

    private final ProjectRepository repository;

    @Autowired
    public ProjectServices(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project saveOrUpdate(Project project){
        //todo business validation etc...
        return this.repository.save(project);
    }

}
