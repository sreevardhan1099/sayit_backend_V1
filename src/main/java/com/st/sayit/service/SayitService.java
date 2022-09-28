package com.st.sayit.service;


import Customexceptions.IdnotfoundException;
import com.st.sayit.models.Post;
import com.st.sayit.models.Comment;
import com.st.sayit.repository.CommentRepository;
import com.st.sayit.repository.PostRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service //Enables dependency injection and also enables auto mapping
public class SayitService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;

    public List<Post> getPosts() {

        return postRepository.findAll();
    }

    public Post createPost(Post post) {
        post.setTimestamp(String.valueOf(new Timestamp(System.currentTimeMillis())));
        return postRepository.save(post);
    }


    public Post editPost(Post post) throws IdnotfoundException {
        if (post.getPostid() != null) {
            return postRepository.save(post);
        } else {
            throw new IdnotfoundException("Id doesnot exist");
        }
    }

    public void deletePost(String postid){
        postRepository.deleteById(postid);
    }

    public List<Comment> getComments(String postid) {
        if(StringUtils.isBlank(postid)){
            throw new IdnotfoundException("ID Should not be blank");
        }
        Optional<Comment> comments=commentRepository.findById(postid);
        if(comments.isPresent())
        {
            return (List<Comment>) comments.get();
        }
        return Collections.emptyList();
    }

    public Comment createComment(String postid, Comment comment)
    {
//        Optional<Comment> comments=commentRepository.findById(postid);
//        if(comments.isPresent())
//        {
//            return (List<Comment>) comments.get();
//        }"
//        else{
//            throw new IdnotfoundException();
//        }
//      comment.setTimestamp(String.valueOf(new Timestamp(System.currentTimeMillis())));
        comment.setCreatedTime(String.valueOf(new Timestamp(System.currentTimeMillis())));
        return commentRepository.save(comment);
    }

    public Comment editComment(Comment comment){
        if (comment.getCommentid()==null) {
            throw new IdnotfoundException("Commentid is not present");
        }
            return commentRepository.save(comment);
    }

    public void deleteComment(String comment) {
        commentRepository.deleteById(comment);
    }
}
