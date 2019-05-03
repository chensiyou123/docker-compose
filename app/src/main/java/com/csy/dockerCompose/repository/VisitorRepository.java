package com.csy.dockerCompose.repository;

import com.csy.dockerCompose.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor,Long> {
    Visitor findByIp(String id);
}
