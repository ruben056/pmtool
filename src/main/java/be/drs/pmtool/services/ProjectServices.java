package be.drs.pmtool.services;

import be.drs.pmtool.domain.Project;
import be.drs.pmtool.domain.exceptions.ProjectIdentifierException;
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

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return this.repository.save(project);
        } catch (Exception e) {
            /**
             * lesson 15:
             * This whole thing doesn't make any sense:
             * - we assume there will only have this exception...
             * - the problem being a not so clear errmsg, is subjective
             * - the solution contains objective flaws
             * - also very heavyweight, with the projectIdentifierExceptionResponse...
             * really don't see the use
             * - als exception is annotated as responseStatus BadRequest,
             * but we manually set the responseStatus in the controllerAdvice...
             */
            throw new ProjectIdentifierException(project.getProjectIdentifier() + " Already exists");
        }
    }

    public Project findProjectById(String projectIdentifier){
        Project project = repository.findByProjectIdentifier(projectIdentifier);
        if(project == null){
            throw new ProjectIdentifierException("No project with identifier " + projectIdentifier + "' exists.");
        }
        return project;
    }

}
