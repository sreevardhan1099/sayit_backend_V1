package com.st.sayit.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "posts")
public class Post {
    @Id
    String postid;
    String likes;
    List<String> commentid;
    String timestamp;
    String title;
    String content;

}
