package org.sagun.opinion.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.sagun.opinion.enums.ProfileVisibilityEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 15)
    private String username;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false)
    private String password;

    private String bio;
    private Integer reputationScore=0;

    @CreationTimestamp
    private Instant createdAt;

    private String badges;

    private boolean isActive = true;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'PUBLIC'")
    private ProfileVisibilityEnum profileVisibilty= ProfileVisibilityEnum.PUBLIC;

    @OneToMany(mappedBy = "senderId", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ChatRequests> sentRequests = new ArrayList<>();

    @OneToMany(mappedBy = "receiverId",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ChatRequests> receivedRequests = new ArrayList<>();

    @OneToMany(mappedBy = "userFirst",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Chats> chatAsFirstUser = new ArrayList<>();

    @OneToMany(mappedBy = "userSecond",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Chats> chatAsSecondUser = new ArrayList<>();

    @OneToMany(mappedBy = "follower",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Follow> follower = new ArrayList<>();

    @OneToMany(mappedBy = "following",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Follow> following = new ArrayList<>() ;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Notifications> notifications= new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Opinions> opinions= new ArrayList<>();



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
