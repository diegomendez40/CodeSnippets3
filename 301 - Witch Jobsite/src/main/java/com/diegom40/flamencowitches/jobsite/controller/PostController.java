package com.diegom40.flamencowitches.jobsite.controller;

import com.diegom40.flamencowitches.jobsite.repository.PostRepository;
import com.diegom40.flamencowitches.jobsite.model.Post;
import com.diegom40.flamencowitches.jobsite.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(value = "/allPosts")
    public List<Post> getAllPosts(){
        return repo.findAll();
    }

    @GetMapping(value = "/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }

    @PostMapping(value = "/addWitchJob")
    public Post addWitchJob(@RequestBody Post witchJob){
        return repo.save(witchJob);
    }

}
