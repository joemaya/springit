package com.example.demo.repository;

import com.example.demo.domain.lombok.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {

    Link findByTitle(String title);
}
