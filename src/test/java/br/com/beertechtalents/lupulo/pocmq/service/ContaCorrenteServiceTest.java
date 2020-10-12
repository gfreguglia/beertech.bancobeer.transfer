package br.com.beertechtalents.lupulo.pocmq.service;

import br.com.beertechtalents.lupulo.pocmq.model.ContaCorrente;
import br.com.beertechtalents.lupulo.pocmq.repository.ContaCorrenteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContaCorrenteServiceTest {

    @InjectMocks
    private ContaCorrenteService contaCorrenteService;

    @Mock
    ContaCorrenteRepository contaCorrenteRepository;

    @Test
    public void saveTest() {
        ContaCorrente contaCorrente = new ContaCorrente();

        Mockito.when(contaCorrenteRepository.save(Mockito.any(ContaCorrente.class))).then(i -> {
            ContaCorrente cc = (ContaCorrente) i.getArguments()[0];
            return cc;
        });

        contaCorrenteService.salvarContaCorrente(contaCorrente);

    }

}
