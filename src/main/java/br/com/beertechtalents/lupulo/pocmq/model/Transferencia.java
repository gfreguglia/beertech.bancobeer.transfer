package br.com.beertechtalents.lupulo.pocmq.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.math.BigDecimal;

@EntityListeners(AuditingEntityListener.class)
@Data
public class Transferencia {
    private String hashcontaorigem;
    private String hashcontadestino;
    private BigDecimal valor;

}
