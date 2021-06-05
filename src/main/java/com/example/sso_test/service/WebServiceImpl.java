package com.example.sso_test.service;

import com.example.sso_test.controller.WebController;
import com.example.sso_test.dto.TokenParsingResult;
import org.keycloak.common.VerificationException;
import org.keycloak.representations.AccessToken;
import org.keycloak.TokenVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WebServiceImpl implements WebService{
    private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceImpl.class);

    @Override
    public Object getUserIdByAccessToken(String token) {
        TokenParsingResult tokenParsingResult;
        LOGGER.info("parameter token: [{}]", token);
        try {
            AccessToken accessToken = TokenVerifier.create(token, AccessToken.class).getToken();

            /*String userId = accessToken.getPreferredUsername();
            String email = accessToken.getEmail();
            String subject = accessToken.getSubject();
            String codeHash = accessToken.getCodeHash();
            String type = accessToken.getType();
            Set<String> realmRole = accessToken.getRealmAccess().getRoles();
            Set<String> clientRole = accessToken.getResourceAccess().get("testClient").getRoles();*/

            tokenParsingResult = new TokenParsingResult(accessToken);

            /*LOGGER.info("userId: [{}], email: [{}]", userId, email);
            LOGGER.info("subject: [{}], codeHash: [{}], type: [{}]", subject, codeHash, type);
            LOGGER.info("realmRole: [{}]", realmRole);
            LOGGER.info("clientRole: [{}]", clientRole);*/
            LOGGER.info("{}", tokenParsingResult);


        } catch (VerificationException e) {
            LOGGER.error("keycloak access token parsing error: {}", e.getLocalizedMessage());
            return "error";
        }

        return tokenParsingResult;
    }
}
