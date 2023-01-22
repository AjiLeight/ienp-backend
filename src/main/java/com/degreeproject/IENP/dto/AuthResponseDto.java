package com.degreeproject.IENP.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    public String accessToken;
    public String tokenType = "Bearer ";
    public String username;

    public AuthResponseDto(String accessToken, String username) {
        this.accessToken = accessToken;
        this.username = username;
    }
}
