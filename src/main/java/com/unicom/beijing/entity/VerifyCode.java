package com.unicom.beijing.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class VerifyCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "v_code")
    private String vCode;

    @Column(name = "state")
    private String state;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date udpateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUdpateTime() {
        return udpateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setUdpateTime(Date udpateTime) {
        this.udpateTime = udpateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }
}
