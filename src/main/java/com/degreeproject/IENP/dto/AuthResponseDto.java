package com.degreeproject.IENP.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    public String accessToken;
    public String tokenType = "Bearer ";

    public AuthResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
