package com.st.sayit.controller;


import Customexceptions.IdnotfoundException;
import com.st.sayit.models.Comment;
import com.st.sayit.models.Post;
import com.st.sayit.service.SayitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;



import com.st.sayit.models.Comment;
import com.st.sayit.models.Post;
import com.st.sayit.service.SayitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class SayitController {

    Logger l=  LoggerFactory.getLogger(SayitController.class);


    @Autowired
    private SayitService sayitservice;

    @GetMapping("/list")
    public ResponseEntity<List<Post>> start(){

        List<Post> posts=sayitservice.getPosts();
        ResponseEntity<List<Post>> resp=new ResponseEntity<>(posts,HttpStatus.OK);
        return resp;
    }
    @PostMapping("/post")
    public ResponseEntity<Post> createPost(@RequestBody Post post)
    {
        Post pst=sayitservice.createPost(post);
        return new ResponseEntity<Post>(pst,HttpStatus.CREATED);

    }

    @PutMapping("/post")
    public ResponseEntity<Post> editPost(@RequestBody Post post){
        Post pst=sayitservice.editPost(post);
        return new ResponseEntity<Post>(pst,HttpStatus.OK);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id){
        sayitservice.deletePost(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("list/{postid}/comment")

    public ResponseEntity<List<Comment>> showcomments(@PathVariable String postid){
        List<Comment> comments=sayitservice.getComments(postid);
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }



    @PostMapping("/{postid}/comment/new")
    public ResponseEntity<Comment> newComment(@RequestBody Comment comment, @PathVariable String postid){

        Comment cmnt=sayitservice.createComment(postid,comment);
        return new ResponseEntity<Comment>(cmnt,HttpStatus.OK);
    }

    @PutMapping("/{postid}/comment/edit")
    public ResponseEntity<Comment> editPost(@RequestBody Comment comment){
        Comment cmnt=sayitservice.editComment(comment);
        return new ResponseEntity<Comment>(cmnt,HttpStatus.OK);
    }

    @DeleteMapping("{postid}/comment/{cmntid}/delete")
    public ResponseEntity<String> deleteComment(@PathVariable String cmntid){
        sayitservice.deleteComment(cmntid);
        return ResponseEntity.ok(cmntid);
    }


}

