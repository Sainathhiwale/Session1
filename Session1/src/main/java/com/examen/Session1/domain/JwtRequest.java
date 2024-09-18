package com.examen.Session1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class JwtRequest {
    private String username;
    private String password;
}
