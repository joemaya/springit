//package com.example.demo.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import java.util.Objects;
//
//@Entity
//public class Comment {
//
//    public Comment() {}
//
//    @Id
//    @GeneratedValue
//    private Long id;
//    private String body;
//
//    // tie to Link
//
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public Long getId() {
//
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Override
//    public String toString() {
//        return "Comment{" +
//                "id=" + id +
//                ", body='" + body + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Comment comment = (Comment) o;
//        return Objects.equals(id, comment.id) &&
//                Objects.equals(body, comment.body);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, body);
//    }
//}
