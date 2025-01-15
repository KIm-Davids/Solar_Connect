package com.semicolon.africa.ports.in;

import com.semicolon.africa.ports.in.dtos.request.post.CreatePostRequest;
import com.semicolon.africa.ports.in.dtos.request.post.DeletePostRequest;
import com.semicolon.africa.ports.in.dtos.request.post.UpdatePostRequest;
import com.semicolon.africa.ports.out.dtos.response.post.CreatePostResponse;
import com.semicolon.africa.ports.out.dtos.response.post.DeletePostResponse;
import com.semicolon.africa.ports.out.dtos.response.post.UpdatePostResponse;

public interface PostService {

    CreatePostResponse createPost(CreatePostRequest request);
    UpdatePostResponse updatePost(UpdatePostRequest request);
    DeletePostResponse deletePost(DeletePostRequest request);
}
