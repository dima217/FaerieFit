package org.faeriefit.microentity.entity.user;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "social_accounts")
public class SocialAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "social_network", nullable = false)
    private String socialNetwork; // Например, "Facebook", "Google", "Twitter"

    @Column(name = "social_id", nullable = false, unique = true)
    private String socialId; // Уникальный идентификатор пользователя в социальной сети

    @Column(name = "access_token", nullable = false)
    private String accessToken; // Токен доступа для взаимодействия с API социальной сети

    @Column(name = "refresh_token")
    private String refreshToken; // Токен для обновления accessToken

    @Column(name = "expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate; // Срок действия accessToken

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Ссылка на сущность User
}
