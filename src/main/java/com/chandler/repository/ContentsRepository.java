package com.chandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandler.domain.Contents;

@Repository
public interface ContentsRepository extends JpaRepository<Contents, Long> {

}