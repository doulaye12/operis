package com.operis.project.infrastructure.jwt;

import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JWTConnectedUserResolver {
    private final JWTParser jwtParser;

    public String extractConnectedUserEmail(String bearerToken) {
        JWTClaimsSet jwtClaimsSet = jwtParser.parseToken(bearerToken.substring(7));
        return jwtClaimsSet.getSubject();
    }
}
