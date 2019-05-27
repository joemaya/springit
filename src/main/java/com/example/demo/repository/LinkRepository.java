package com.example.demo.repository;

import com.example.demo.domain.lombok.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long> {

    Link findByTitle(String title);

    List<Link> findAllByTitleLikeOrderByCreationDateDesc(String title);
}
