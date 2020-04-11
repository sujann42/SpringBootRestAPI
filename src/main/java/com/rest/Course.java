package com.rest;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
/*@JsonIgnoreProperties will ignore lazy loading*/
public class Course {
    @Id
    private int courseid;
    private String authorname;
    private String coursename;

    public Course() {
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseId) {
        this.courseid = courseId;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorName) {
        this.authorname = authorName;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String courseName) {
        this.coursename = courseName;
    }
}
