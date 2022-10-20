package com.handehdy.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "post")
public class Post implements Serializable {


    @Id
    String id;
    Long postId;
    String title;
    String text;
    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;
}
