package com.likelionswu.backend_1hw.post.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
        import lombok.NoArgsConstructor;
        import org.hibernate.annotations.CreationTimestamp;
        import org.hibernate.annotations.UpdateTimestamp;

        import javax.persistence.*;
        import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Info extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length= 10, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(length= 30, nullable = false)
    private String major;

    @Column(length= 100, nullable = false)
    private String intro;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @Builder
    public Info(Long id, String name, Integer age, String major, String intro){
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
        this.intro = intro;
    }
}