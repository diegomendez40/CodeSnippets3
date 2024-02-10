package com.diegom40.flamencowitches.jobsite.repository;

import com.diegom40.flamencowitches.jobsite.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

public interface SearchRepository {
    public List<Post> findByText(String text);
}
