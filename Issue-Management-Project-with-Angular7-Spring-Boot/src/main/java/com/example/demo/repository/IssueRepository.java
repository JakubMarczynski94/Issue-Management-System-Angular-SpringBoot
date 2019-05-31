package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {

}
