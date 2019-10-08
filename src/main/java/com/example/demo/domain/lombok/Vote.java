package com.example.demo.domain.lombok;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Vote {

    @Id
    @GeneratedValue
    private Long id;
    private int vote;

    // user
    // link

}
