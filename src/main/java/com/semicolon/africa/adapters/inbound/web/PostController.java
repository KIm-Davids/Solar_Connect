package com.semicolon.africa.adapters.inbound.web;

import com.semicolon.africa.adapters.services.PostServicesImpl;
import com.semicolon.africa.ports.in.dtos.request.post.CreatePostRequest;
import com.semicolon.africa.ports.in.dtos.request.post.DeletePostRequest;
import com.semicolon.africa.ports.in.dtos.request.post.UpdatePostRequest;
import com.semicolon.africa.ports.out.dtos.response.ApiResponse;
import com.semicolon.africa.ports.out.dtos.response.post.CreatePostResponse;
import com.semicolon.africa.ports.out.dtos.response.post.DeletePostResponse;
import com.semicolon.africa.ports.out.dtos.response.post.UpdatePostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private PostServicesImpl services;

    @PostMapping()
    public ResponseEntity<?> createPost(@RequestBody CreatePostRequest request){
        try {
            CreatePostResponse response = services.createPost(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping
    public ResponseEntity<?> updatePost(@RequestBody UpdatePostRequest request){
        try{
            UpdatePostResponse response = services.updatePost(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deletePost(@RequestBody DeletePostRequest request){
        try{
            DeletePostResponse response = services.deletePost(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }



}
