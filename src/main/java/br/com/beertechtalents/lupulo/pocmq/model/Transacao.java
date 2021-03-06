package br.com.beertechtalents.lupulo.pocmq.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;


    @Column(nullable = false)
    private String hashconta;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal valor;

    @CreatedDate
    @JsonIgnore
    private Timestamp datahora;

}

