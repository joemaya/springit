package com.example.demo.repository;

import com.example.demo.domain.lombok.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
