package com.examen.Session1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtRequest {
    String username;
    String password;

}