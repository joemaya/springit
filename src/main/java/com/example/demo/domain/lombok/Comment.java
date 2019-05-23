package com.example.demo.domain.lombok;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Data
public class Comment extends Auditable {

    @Id
    @GeneratedValue
    private Long id;
    private String body;

    // tie to Link
    @ManyToOne
    private Link link;

}
