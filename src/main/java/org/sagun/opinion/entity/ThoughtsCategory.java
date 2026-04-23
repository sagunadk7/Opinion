package org.sagun.opinion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.sagun.opinion.enums.CategoriesTypeEnum;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="thoughtsCategories")
public class ThoughtsCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CategoriesTypeEnum categoryType;

    @OneToMany(mappedBy = "thoughtsCategory") // NO cascade, NO orphanRemoval
    private List<Thought> thoughts = new ArrayList<>();

    @CreationTimestamp
    private Instant createdAt;

}
