package com.example.sso_test.dto;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.keycloak.representations.AccessToken;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TokenParsingResult {
    private String userId;
    private String email;
    private String subject;
    private String codeHash;
    private String type;
    private String client;

    Set<String> realmRole;
    Set<String> clientRole;

    public TokenParsingResult(AccessToken accessToken) {
        this.userId = accessToken.getPreferredUsername();
        this.email = accessToken.getEmail();
        this.subject = accessToken.getSubject();
        this.codeHash = accessToken.getCodeHash();
        this.type = accessToken.getType();

        this.realmRole = accessToken.getRealmAccess().getRoles();
        this.clientRole = accessToken.getResourceAccess().get("testClient01").getRoles();
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
