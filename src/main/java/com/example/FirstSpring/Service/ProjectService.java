package com.example.FirstSpring.Service;

import com.example.FirstSpring.Entity.Project;
import com.example.FirstSpring.Repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(int id) throws Exception {
        if (!projectRepository.existsById(id)) {
            throw new Exception("getProject(): Incorrect ID!");
        }
        return projectRepository.findById(id).get();
    }

    public void createProject(Project project) {
        projectRepository.save(project);
    }

    public void updateProject(int id, Project project) throws Exception {
        if (!projectRepository.existsById(id)) {
            throw new Exception("updateProject(): Incorrect ID!");
        }
        Project projectToUpdate = projectRepository.getOne(id);
        projectToUpdate.setClientName(project.getClientName());
        projectToUpdate.setDeadline(project.getDeadline());
        // projectToUpdate.setEmployees(project.getEmployees());
        //projectToUpdate.setEmployees(project.getEmployees());
        projectToUpdate.setName(project.getName());
        projectToUpdate.setLanguage(project.getLanguage());
        projectRepository.save(projectToUpdate);
    }

    public void deleteProject(int id) throws Exception {
        if (!projectRepository.existsById(id)) {
            throw new Exception("deleteProject(): Incorrect ID!");
        }
        projectRepository.delete(projectRepository.getById(id));
    }
}
