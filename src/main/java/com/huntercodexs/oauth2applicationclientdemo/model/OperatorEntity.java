package com.huntercodexs.oauth2applicationclientdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "oauth2_application_client_operator")
public class OperatorEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;

    @Column
    public String accessCode;

    @Column
    public String authority;

    @Column
    public String authorization;

    @Column
    public String username;

    @Column
    public String password;

    @Column
    public String grantType;

    @Column
    public String client;

    @Column
    public String secret;

    @Column
    public String role;

    @Column
    public String email;

    @Column
    public int status;

    @Column
    public String token;

    @Column
    public String urlGetToken;

    @Column
    public String urlCheckToken;
}
