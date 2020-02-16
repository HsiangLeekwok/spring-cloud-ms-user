package com.leekwok.msuser.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/15 13:47<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
@Table(name = "user_account_event_log")
@Entity
public class UserAccountEventLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer userId;
    @Column
    private BigDecimal money;
    @Column
    private String event;
    @Column
    private String description;
    @Column
    private Date createTime;

    public UserAccountEventLog() {
    }

    public UserAccountEventLog(Integer userId, BigDecimal money, String event, String description, Date createTime) {
        this.userId = userId;
        this.money = money;
        this.event = event;
        this.description = description;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
