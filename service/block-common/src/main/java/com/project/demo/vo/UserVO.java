package com.project.demo.vo;

import java.util.Date;

/**
 * @description:
 * @author: YZL
 * @time: 2020/3/20 21:42
 */
public class UserVO {
    private String name;

    private Integer blockCnt;

    private Integer likeCnt;

    private String email;

    private Date createDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBlockCnt() {
        return blockCnt;
    }

    public void setBlockCnt(Integer blockCnt) {
        this.blockCnt = blockCnt;
    }

    public Integer getLikeCnt() {
        return likeCnt;
    }

    public void setLikeCnt(Integer likeCnt) {
        this.likeCnt = likeCnt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}