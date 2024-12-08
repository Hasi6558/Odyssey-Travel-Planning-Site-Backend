package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service;

import java.util.List;
import java.util.Optional;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Blog;

public interface BlogService {
    public Blog saveBlog(Blog blog);

    public List<Blog> getAllBlog();

    public Optional<Blog> getBlogById(String id);

    public Blog updateBlog(Blog blog, String id);

    public boolean deleteBlog(String id);
}
