package org.sagun.opinion.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name="thought")
public class Thought {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ThoughtsCategory thoughtsCategory;

    @Column(nullable = false, length = 280)
    private String content;

    @Column(nullable = false,columnDefinition = " BOOLEAN DEFAULT FALSE")
    private Boolean isAnonymous=false;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isDebateMode=true;

    @OneToMany(mappedBy = "thought",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Opinions> opinions = new ArrayList<>();

    @OneToMany(mappedBy = "thought",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Reactions> reactions = new ArrayList<>();


    @Column(nullable = false)
    @Min(0)
    private Integer agreeCount=0;

    @Column(nullable = false)
    @Min(0)
    private Integer disagreeCount=0;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
}
