package com.diegom40.flamencowitches.jobsite.repository;

import com.diegom40.flamencowitches.jobsite.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
