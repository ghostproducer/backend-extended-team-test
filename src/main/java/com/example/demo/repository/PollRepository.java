package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Poll;

public interface PollRepository extends JpaRepository<Poll, Long> {

    List<Poll> findByPublished(boolean published);
    List<Poll> findByTitleContaining(String title);
}
