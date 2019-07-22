package be.drs.pmtool.web;


import be.drs.pmtool.domain.Project;
import be.drs.pmtool.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        if(result.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid Project object");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.projectServices.saveOrUpdate(project));
    }
}
