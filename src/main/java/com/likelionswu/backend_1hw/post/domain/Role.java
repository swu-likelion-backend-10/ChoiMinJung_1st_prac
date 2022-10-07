package com.likelionswu.backend_1hw.post.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN("ROLE_ADMIN"),

    MEMBER("ROLE_MEMBER");

    private String value;
}
