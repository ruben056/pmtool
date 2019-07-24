package be.drs.pmtool.web;


import be.drs.pmtool.domain.Project;
import be.drs.pmtool.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectCtrl {

    private final ProjectServices projectServices;

    @Autowired
    public ProjectCtrl(ProjectServices projectServices) {
        this.projectServices = projectServices;
    }

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project,
                                                    BindingResult result){
        return ControllerResponseUtil.createResponseForInvalidInput(result)
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(this.projectServices.saveOrUpdate(project)));
    }
}
