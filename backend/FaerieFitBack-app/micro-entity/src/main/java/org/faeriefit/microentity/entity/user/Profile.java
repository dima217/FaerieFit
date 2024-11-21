package org.faeriefit.microentity.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Table(name = "profile_settings",schema = "messenger_users",catalog = "postgres")
@Builder
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid;

    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Genger gender;

    private Double weight;

    private Double height;

    private Double hip_circumference;

    private Double chest_girth;

    private Double waist_circumference;

    @JsonIgnore
    @OneToOne(optional = false)
    @JoinColumn(name = "user_id",updatable = false,nullable = false)
    private User user;

    @OneToMany(mappedBy = "profile",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ProfileImage> profileImages;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Profile profile)) return false;
        return Objects.equals(getUuid(), profile.getUuid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid());
    }
}
