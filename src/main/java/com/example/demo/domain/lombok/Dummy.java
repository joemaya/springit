package com.example.demo.domain.lombok;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Dummy extends Auditable {

    @Id
    @GeneratedValue
    private Long id;

    private String dummyValue;
}
