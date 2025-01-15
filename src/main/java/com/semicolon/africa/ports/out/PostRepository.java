package com.semicolon.africa.ports.out;

import com.semicolon.africa.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{
    Post findPostById(long id);

}
