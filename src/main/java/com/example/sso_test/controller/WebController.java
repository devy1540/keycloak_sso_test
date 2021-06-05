package com.example.sso_test.controller;

import com.example.sso_test.dto.TokenRequest;
import com.example.sso_test.service.WebService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "WebController", description = "Test API")
public class WebController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    private final WebService webService;

    @Autowired
    public WebController(WebService webService) {
        this.webService = webService;
    }

    @Operation(summary = "아이디 조회", description = "token을 통해 사용자 아이디 조회")
    @GetMapping("token")
    public Object getAccessToken(@Valid TokenRequest tokenRequest) throws Exception {
        return webService.getUserIdByAccessToken(tokenRequest.getAccessToken());
    }

    @Operation(summary = "테스트 조회", description = "테스트 조회")
    @GetMapping("test")
    public String getAccessToken(String value) throws Exception {
        return "response: " + value;
    }
}
