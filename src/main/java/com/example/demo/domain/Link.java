//package com.example.demo.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import java.util.Objects;
//
//@Entity
//public class Link {
//
//    public Link() {}
//
//    @Id
//    @GeneratedValue
//    private Long id;
//    private String url;
//    private String title;
//
//    // comments
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    @Override
//    public String toString() {
//        return "Link{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Link link = (Link) o;
//        return Objects.equals(id, link.id) &&
//                Objects.equals(title, link.title);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, title);
//    }
//}
