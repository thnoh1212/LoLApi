package com.practice.web.dto;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Data
@Entity
public class User {
    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String puuid;

    @Column(nullable = false)
    private String accountId;

    @Column
    private Integer profileIconId;

    @Column(nullable = false)
    private String revisionDate;

    @Column(nullable = false)
    private int summonerLevel;
}
