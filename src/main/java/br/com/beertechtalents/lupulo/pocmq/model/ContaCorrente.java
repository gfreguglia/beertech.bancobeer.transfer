package br.com.beertechtalents.lupulo.pocmq.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class ContaCorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(updatable = false, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="uuid-char")
    @JsonIgnore
    private UUID hashid;

    @PrePersist
    public void autofill(){
        this.setHashid(UUID.randomUUID());
    }

}
