package com.zixiaww.ppmtool.services;

import com.zixiaww.ppmtool.domain.Project;
import com.zixiaww.ppmtool.exceptions.ProjectIdException;
import com.zixiaww.ppmtool.repositories.ProjectRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepositories projectRepositories;


    public Project saveOrUpdateProject(Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepositories.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }
    }


    public Project findProjectByIdentifier(String projectId){

        Project project = projectRepositories.findByProjectIdentifier(projectId.toUpperCase());//Upper case to avoid ambiguity

        if (project == null){
            throw new ProjectIdException("Project ID '"+projectId+"' doesn't exists");
        }

        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepositories.findAll();
    }
}
