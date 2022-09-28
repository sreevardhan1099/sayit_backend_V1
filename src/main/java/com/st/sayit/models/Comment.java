package com.st.sayit.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document(collection = "comments")
public class Comment {
    @Id
    String commentid;
    String comment;
    String createdTime;
    String reply;
    String likes;
}
