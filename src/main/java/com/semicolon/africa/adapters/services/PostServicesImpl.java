package com.semicolon.africa.adapters.services;

import com.semicolon.africa.domain.Post;
import com.semicolon.africa.ports.in.PostService;
import com.semicolon.africa.ports.in.dtos.request.post.CreatePostRequest;
import com.semicolon.africa.ports.in.dtos.request.post.DeletePostRequest;
import com.semicolon.africa.ports.in.dtos.request.post.UpdatePostRequest;
import com.semicolon.africa.ports.out.PostRepository;
import com.semicolon.africa.ports.out.dtos.response.post.CreatePostResponse;
import com.semicolon.africa.ports.out.dtos.response.post.DeletePostResponse;
import com.semicolon.africa.ports.out.dtos.response.post.UpdatePostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PostServicesImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public CreatePostResponse createPost(CreatePostRequest request) {
       Post post = new Post();
       post.setDate(LocalDate.now());
       post.setTitle(request.getTitle());
       post.setContent(request.getContent());
       post.setCustomer(request.getCustomer());
       post.setCustomerId(request.getCustomerId());
       postRepository.save(post);
       CreatePostResponse response = new CreatePostResponse();
       response.setMessage("Post Created Successfully !!!");
       return response;
    }


    @Override
    public UpdatePostResponse updatePost(UpdatePostRequest request) {
        Post foundPost = postRepository.findPostById(request.getId());
        foundPost.setId(request.getId());
        foundPost.setDate(LocalDate.now());
        foundPost.setTitle(request.getTitle());
        foundPost.setContent(request.getContent());
        postRepository.save(foundPost);
        UpdatePostResponse response = new UpdatePostResponse();
        response.setMessage("Post Updated Successfully !!!");
        return response;
    }


    @Override
    public DeletePostResponse deletePost(DeletePostRequest request) {
        Post foundPost = postRepository.findPostById(request.getPostId());
        postRepository.delete(foundPost);
        DeletePostResponse response = new DeletePostResponse();
        response.setMessage("Deleted Post Successfully !!!");
        return response;
    }

}
