package com.project.demo.DO;

import java.util.Date;

public class CommentDO {
    private Long id;

    private Long authorId;

    private Long preUserId;

    private String text;

    private Date postDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getPreUserId() {
        return preUserId;
    }

    public void setPreUserId(Long preUserId) {
        this.preUserId = preUserId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}