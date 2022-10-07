package com.likelionswu.backend_1hw.post.dto;

import com.likelionswu.backend_1hw.post.domain.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDto {
    private Long id;

    private String email;
    private String password;

    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .email(email)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
