package com.handehdy.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Document

public class Post {
    @Id
    String postId;
    String title;
    String text;
    @CreatedDate
    Date createdDate;
}
