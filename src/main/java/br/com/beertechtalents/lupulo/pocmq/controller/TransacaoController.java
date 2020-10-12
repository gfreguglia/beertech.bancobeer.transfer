package br.com.beertechtalents.lupulo.pocmq.controller;


import br.com.beertechtalents.lupulo.pocmq.model.TipoTransacao;
import br.com.beertechtalents.lupulo.pocmq.model.Transacao;
import br.com.beertechtalents.lupulo.pocmq.service.TransacaoService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transacao")
@Api(value = "Endpoints para transações")
@RequiredArgsConstructor
@Slf4j
public class TransacaoController {

    final TransacaoService transacaoService;

    @ApiOperation(value = "Busca saldo total", nickname = "GET", notes = "Busca o saldo total", response = BigDecimal.class, tags = {"buscasaldo",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = BigDecimal.class),
            @ApiResponse(code = 400, message = "Invalid status value")})
    @GetMapping
    public ResponseEntity<BigDecimal> getSaldo(String hashconta) {
        return new ResponseEntity<>(transacaoService.buscarSaldo(hashconta), HttpStatus.OK);
    }

    @ApiOperation(value = "Adiciona uma nova transacao", nickname = "POST", notes = "", tags = {"transacao",})
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input")})
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void novaOperacao(@ApiParam(value = "Transacao de saque ou deposito", required = true) @RequestBody Transacao body) {

        // Normalizar entrada
        if(body.getTipo().equals(TipoTransacao.SAQUE)) {
            body.setValor(body.getValor().abs().negate());
        } else {
            body.setValor(body.getValor().abs());
        }
        transacaoService.salvarTransacao(body);
    }
}
