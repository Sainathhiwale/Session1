package com.examen.Session1.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse {
    String jwtToken;
    String username;
}
