package org.faeriefit.microentity.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "role_data",schema = "messenger_users",catalog = "postgres")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;


    public Role(Long id,String role){
        this.role =role;
        this.id = id;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    public List<User> users;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Role role1)) return false;
        return Objects.equals(getRole(), role1.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRole());
    }
}


