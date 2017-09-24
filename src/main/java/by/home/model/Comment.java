package by.home.model;

import java.util.Date;

public class Comment {
    private long id;
    private String comment;
    private Date created;
    private String Author;

    public Comment() {
    }

    public Comment(long id, String comment, String author) {
        this.id = id;
        this.comment = comment;
        this.created = new Date();
        Author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", created=" + created +
                ", Author='" + Author + '\'' +
                '}';
    }
}
