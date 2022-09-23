package com.likelionswu.backend_1hw.post.repository;

import com.likelionswu.backend_1hw.post.domain.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Long> {
}
