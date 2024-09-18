package com.examen.Session1.domain;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserMaster {

    String username;
    String password;


}