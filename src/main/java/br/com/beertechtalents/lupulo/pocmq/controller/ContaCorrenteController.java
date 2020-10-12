package br.com.beertechtalents.lupulo.pocmq.controller;

import br.com.beertechtalents.lupulo.pocmq.model.ContaCorrente;
import br.com.beertechtalents.lupulo.pocmq.service.ContaCorrenteService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacorrente")
@Api(value = "Endpoint para conta corrente")
@RequiredArgsConstructor
@Slf4j
public class ContaCorrenteController {

    final ContaCorrenteService contaCorrenteService;

    @ApiOperation(value = "Adiciona uma nova conta corrente", nickname = "POST", notes = "", tags = {"contacorrente",})
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input")})
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void novaConta(@ApiParam(value = "Nova Conta Corrente", required = true) @RequestBody ContaCorrente body) {

        contaCorrenteService.salvarContaCorrente(body);
    }

}
