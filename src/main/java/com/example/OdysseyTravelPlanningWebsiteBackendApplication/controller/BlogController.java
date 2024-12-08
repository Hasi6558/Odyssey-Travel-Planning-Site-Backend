package com.example.OdysseyTravelPlanningWebsiteBackendApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Blog;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.BlogService;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins = "*")
public class BlogController {

    @Autowired
    public BlogService blogService;

    @PostMapping("/addBlog")
    public ResponseEntity<Blog> postBlog(@RequestBody Blog blog) {
        return new ResponseEntity<Blog>(blogService.saveBlog(blog), HttpStatus.CREATED);
    }

    @GetMapping("/getAllBlog")
    public ResponseEntity<List<Blog>> getallBlog() {
        List<Blog> blog = blogService.getAllBlog();
        if (blog.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }

    }

    @GetMapping("/getBlogById/{id}")
    public ResponseEntity<Blog> getBlogBuId(@PathVariable String id) {
        Optional<Blog> blog = blogService.getBlogById(id);
        if (blog.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blog.get(), HttpStatus.OK);
        }
    }

    @PutMapping("/updateBlog/{id}")
    public ResponseEntity<Blog> updteBlog(@RequestBody Blog newBlog, @PathVariable String id) {

        Blog blog = blogService.updateBlog(newBlog, id);
        if (blog != null) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteBlog/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable String id) {
        boolean isBlogDeleted = blogService.deleteBlog(id);
        if (isBlogDeleted) {
            return new ResponseEntity<>("Deleted the blog : id " + id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot delete.Something wrong !", HttpStatus.NOT_FOUND);
        }
    }

}
