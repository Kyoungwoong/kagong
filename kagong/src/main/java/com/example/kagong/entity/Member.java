package com.example.kagong.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import javax.persistence.Convert;
import java.io.IOException;
import java.util.List;
@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue
    private Long memberId;

    private String name;

    private String email;
    private String password;
    private String nickName;

    @Embedded
    private Address address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private University university;
    private Grade grade;



    @Convert(converter = StringListConverter.class)
    private List<String> historyList;

    @Convert(converter = StringListConverter.class)
    private List<String> favoriteList;

    public Member(){

    }

    public Member(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

