package org.sagun.opinion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.sagun.opinion.enums.CategoriesTypeEnum;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="thoughtsCategories")
public class ThoughtsCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private CategoriesTypeEnum categoryType;
    @CreationTimestamp
    private Instant createdAt;

}
