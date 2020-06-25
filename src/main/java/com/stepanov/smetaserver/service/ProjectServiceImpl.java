package com.stepanov.smetaserver.service;

import com.stepanov.smetaserver.model.Project;
import com.stepanov.smetaserver.repository.ProjectRepository;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Page<Project> findAll(Pageable pageable, String searchText) {
        return projectRepository.findAllProjects(pageable, searchText);
    }

    @Override
    public List<Project> findAll() { return (List<Project>) projectRepository.findAll(); }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public Project saveOrUpdate(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            projectRepository.deleteById(id);
            jsonObject.put("message", "Book deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

}
