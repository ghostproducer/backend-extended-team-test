package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Poll;
import com.example.demo.repository.PollRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PollController {

    @Autowired
    PollRepository pollRepository;

    @GetMapping("/poll")
    public ResponseEntity<List<Poll>> getAllPolls(@RequestParam(required = false) String title) {
        try {
            List<Poll> polls = new ArrayList<Poll>();

            if (title == null)
                pollRepository.findAll().forEach(polls::add);
            else
                pollRepository.findByTitleContaining(title).forEach(polls::add);

            if (polls.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(polls, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/poll/{id}")
    public ResponseEntity<Poll> getPollById(@PathVariable("id") long id) {
        Optional<Poll> pollData = pollRepository.findById(id);

        if (pollData.isPresent()) {
            return new ResponseEntity<>(pollData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/poll")
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {
        try {
            Poll _poll = pollRepository
                    .save(new Poll(poll.getTitle(), poll.getDescription(), false));
            return new ResponseEntity<>(_poll, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/poll/{id}")
    public ResponseEntity<Poll> updatePoll(@PathVariable("id") long id, @RequestBody Poll poll) {
        Optional<Poll> pollData = pollRepository.findById(id);

        if (pollData.isPresent()) {
            Poll _poll = pollData.get();
            _poll.setTitle(poll.getTitle());
            _poll.setDescription(poll.getDescription());
            _poll.setPublished(poll.isPublished());
            return new ResponseEntity<>(pollRepository.save(_poll), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/poll/{id}")
    public ResponseEntity<HttpStatus> deletePoll(@PathVariable("id") long id) {
        try {
            pollRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/poll")
    public ResponseEntity<HttpStatus> deleteAllPolls() {
        try {
            pollRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping("/poll/published")
    public ResponseEntity<List<Poll>> findByPublished() {
        try {
            List<Poll> poll = pollRepository.findByPublished(true);

            if (poll.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(poll, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
