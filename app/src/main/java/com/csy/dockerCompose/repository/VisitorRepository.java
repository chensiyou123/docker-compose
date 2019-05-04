package com.csy.dockerCompose.repository;

import com.csy.dockerCompose.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor,Long> {
    List<Visitor> findByIp(String id);
}
