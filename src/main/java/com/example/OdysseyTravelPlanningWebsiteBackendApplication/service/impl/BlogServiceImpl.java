package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Blog;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Hotel;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo.BlogRepository;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAllBlog() {
       return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> getBlogById(String id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog updateBlog(Blog blog, String id) {
        Optional<Blog> existingBlog = blogRepository.findById(id);
        if (existingBlog.isEmpty()) {
            throw new RuntimeException("cannot find any blog entity for this id :" + id);

        } else {

            Blog blog1 = existingBlog.get();
            
            blog.setTitle(blog1.getTitle());
            blog.setImg_url(blog1.getImg_url());
            blog.setContent_html(blog1.getContent_html());

            return blogRepository.save(blog);
        }
    }

    @Override
    public boolean deleteBlog(String id) {
        Optional<Blog> blog = blogRepository.findById(id);
        if (blog.isEmpty()) {
            throw new RuntimeException("cannot find any blog entity for this id :" + id);
        } else {
            blogRepository.deleteById(id);
            return true;
        }
    }

}
