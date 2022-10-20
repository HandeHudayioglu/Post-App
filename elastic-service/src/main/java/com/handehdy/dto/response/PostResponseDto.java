package com.handehdy.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor

public class PostResponseDto implements Serializable {



    Long postId;
    String title;
    String text;
    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;
}
