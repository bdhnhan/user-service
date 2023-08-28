package com.zalopay.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String phoneNumber;
    private String cccd;
    private Timestamp createdTime;
    private Timestamp updatedTime;
}
