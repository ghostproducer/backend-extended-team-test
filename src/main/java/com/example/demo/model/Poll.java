package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "polls")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;

    @Column(name = "optionOne")
    public String optionOne;

    @Column(name = "totalVotesOne")
    private int totalVotesOne;

    @Column(name = "optionTwo")
    public String optionTwo;

    @Column(name = "totalVotesTwo")
    private int totalVotesTwo;

    public Poll() {

    }

    public Poll(String title, String description, boolean published, String optionOne, int totalVotesOne, String optionTwo, int totalVotesTwo) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.optionOne = optionOne;
        this.totalVotesOne = totalVotesOne;
        this.optionTwo = optionTwo;
        this.totalVotesTwo = totalVotesTwo;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    public String getOptionOne() { return  optionOne; }

    public void setOptionOne(String optionOne) {this.optionOne = optionOne; }

    public int getTotalVotesOne() { return totalVotesOne; }

    public void setTotalVotesOne() { this.totalVotesOne++; }

    public String getOptionTwo() { return  optionTwo; }

    public void setOptionTwo(String optionTwo) {this.optionTwo = optionTwo; }

    public int getTotalVotesTwo() { return totalVotesTwo; }

    public void setTotalVotesTwo() { this.totalVotesTwo++; }

    @Override
    public String toString() {
        return "Poll [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + ", optionOne=" + optionOne + ", optionTwo=" + optionTwo + "]";
    }
}
