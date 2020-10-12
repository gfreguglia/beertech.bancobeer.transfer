package br.com.beertechtalents.lupulo.pocmq.service;

import br.com.beertechtalents.lupulo.pocmq.model.Transferencia;
import br.com.beertechtalents.lupulo.pocmq.repository.TransacaoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class TransferenciaServiceTest {

    @InjectMocks
    private TransferenciaService transferenciaService;

    @Mock
    TransacaoRepository transacaoRepository;

    @Test
    public void realizarTransferenciaTest() {
        Transferencia transferencia = new Transferencia();
        transferencia.setHashcontadestino(UUID.randomUUID().toString());
        transferencia.setHashcontaorigem(UUID.randomUUID().toString());
        transferencia.setValor(BigDecimal.TEN);

        transferenciaService.realizarTransferencia(transferencia);
    }
}
