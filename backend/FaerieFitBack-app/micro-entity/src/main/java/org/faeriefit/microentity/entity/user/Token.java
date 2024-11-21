package org.faeriefit.microentity.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Token implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String token;

    @Column(unique = true)
    private String username;

    private String password;

    private Instant issuerDate;

    private Instant expiryDate;


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Token token1)) return false;
        return Objects.equals(getId(), token1.getId()) && Objects.equals(getToken(), token1.getToken())
                && Objects.equals(getIssuerDate(), token1.getIssuerDate())
                && Objects.equals(getExpiryDate(), token1.getExpiryDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getToken(), getIssuerDate(), getExpiryDate());
    }
}

