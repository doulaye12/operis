package com.operis.project.infrastructure.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class JWTParser {

    @Value("${code.secret}")
    private String codeSecret;

    public JWTClaimsSet parseToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier jwsVerifier = new MACVerifier(codeSecret);

            // Verify the Signature
            if (!signedJWT.verify(jwsVerifier)) {
                throw new RuntimeException("Invalid JWT Signature");
            }

            // Retrieve JWT claims
            return signedJWT.getJWTClaimsSet();
        } catch (JOSEException | ParseException e) {
            throw new RuntimeException("Error while parsing JWT token", e);
        }
    }
}
