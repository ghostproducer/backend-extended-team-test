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
    private String optionOne;

    @Column(name = "optionTwo")
    private String optionTwo;

    public Poll() {

    }

    public Poll(String title, String description, boolean published, String optionOne, String OptionTwo) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
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

    public String getOptionTwo() { return  optionTwo; }

    public void setOptionTwo(String optionTwo) {this.optionTwo = optionTwo; }

    @Override
    public String toString() {
        return "Poll [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + ", optionOne=" + optionOne + ", optionTwo=" + optionTwo + "]";
    }
}
