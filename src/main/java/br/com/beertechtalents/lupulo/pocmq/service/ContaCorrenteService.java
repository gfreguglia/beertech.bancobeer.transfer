package br.com.beertechtalents.lupulo.pocmq.service;

import br.com.beertechtalents.lupulo.pocmq.model.ContaCorrente;
import br.com.beertechtalents.lupulo.pocmq.repository.ContaCorrenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContaCorrenteService {

    final ContaCorrenteRepository contaCorrenteRepository;

    public void salvarContaCorrente(ContaCorrente contaCorrente){
        contaCorrenteRepository.save(contaCorrente);
    }
}
