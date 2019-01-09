package com.zixiaww.ppmtool.services;

import com.zixiaww.ppmtool.domain.Project;
import com.zixiaww.ppmtool.repositories.ProjectRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepositories projectRepositories;


    public Project saveOrUpdateProject(Project project){

        //Logic

        return projectRepositories.save(project);
    }
}
