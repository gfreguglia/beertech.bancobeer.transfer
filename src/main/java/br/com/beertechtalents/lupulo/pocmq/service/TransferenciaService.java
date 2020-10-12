package br.com.beertechtalents.lupulo.pocmq.service;

import br.com.beertechtalents.lupulo.pocmq.model.TipoTransacao;
import br.com.beertechtalents.lupulo.pocmq.model.Transacao;
import br.com.beertechtalents.lupulo.pocmq.model.Transferencia;
import br.com.beertechtalents.lupulo.pocmq.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferenciaService {

    final TransacaoRepository transacaoRepository;

    public void realizarTransferencia(Transferencia transferencia){
        Transacao transacaoOrigem = new Transacao();
        transacaoOrigem.setTipo(TipoTransacao.SAQUE);
        transacaoOrigem.setHashconta(transferencia.getHashcontaorigem());
        transacaoOrigem.setValor(transferencia.getValor().abs().negate());

        Transacao transacaoDestino = new Transacao();
        transacaoDestino.setTipo(TipoTransacao.DEPOSITO);
        transacaoDestino.setHashconta(transferencia.getHashcontadestino());
        transacaoDestino.setValor(transferencia.getValor().abs());

        transacaoRepository.save(transacaoOrigem);
        transacaoRepository.save(transacaoDestino);
    }
}
