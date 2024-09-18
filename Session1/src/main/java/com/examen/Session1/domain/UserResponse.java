package com.examen.Session1.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    String jwtToken;
    String username;

}
