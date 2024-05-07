package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long f_no;

    @Column(name="f_user_id")
    String f_id;
    @Column(name="f_user_name")
    String f_name;
    @Column(name="f_user_pwd")
    String f_pwd;
}
