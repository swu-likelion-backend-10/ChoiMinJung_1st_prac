package com.likelionswu.backend_1hw.post.dto;

import com.likelionswu.backend_1hw.post.domain.Info;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class InfoDto {

    private Long id;
    private String name;
    private Integer age;
    private String major;
    private String intro;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    public Info toEntity(){
        Info build = Info.builder()
                .id(id)
                .name(name)
                .age(age)
                .major(major)
                .intro(intro)
                .build();
        return build;
    }

    @Builder
    public InfoDto(Long id, String name, Integer age, String major, String intro, LocalDateTime createdTime, LocalDateTime modifiedTime){

        this.id = id;
        this.name = name;
        this.age = age;
        this.major=major;
        this.intro=intro;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }
}
