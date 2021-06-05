package com.example.sso_test.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TokenRequest {

    @NotBlank
    private String accessToken;

    @NotBlank
    private String refreshToken;

}
