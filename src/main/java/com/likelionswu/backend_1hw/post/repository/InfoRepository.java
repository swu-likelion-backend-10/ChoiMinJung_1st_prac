package com.likelionswu.backend_1hw.post.repository;

import com.likelionswu.backend_1hw.post.domain.Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoRepository extends JpaRepository<Info, Long> {
    List<Info> findByNameContaining(String keyword);
}

