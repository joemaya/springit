package com.example.demo.domain.lombok;

import lombok.*;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Vote extends Auditable {

    @Id
    @GeneratedValue
    private Long id;


    @NonNull
    private short direction;

    // user
    // link

    @NonNull
    @ManyToOne
    private Link link;

}
