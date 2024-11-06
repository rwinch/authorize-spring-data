package com.noscendo.authorize.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.stereotype.Component;

@Component("authz")
@Slf4j
public class AuthorizationLogic {

    public boolean decide(MethodSecurityExpressionOperations operations) {
        log.warn("authorization logic");
        return false;
    }
}
