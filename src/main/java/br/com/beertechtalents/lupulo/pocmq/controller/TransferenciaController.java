package br.com.beertechtalents.lupulo.pocmq.controller;

import br.com.beertechtalents.lupulo.pocmq.model.Transferencia;
import br.com.beertechtalents.lupulo.pocmq.service.TransferenciaService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transferencia")
@Api(value="Endpoint para transferencia")
@RequiredArgsConstructor
@Slf4j
public class TransferenciaController {

    final TransferenciaService transferenciaService;

    @ApiOperation(value = "Realiza uma transferencia", nickname = "POST", notes = "", tags = {"transferencia",})
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input")})
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void novaOperacao(@ApiParam(value = "Transferencia de saldo", required = true) @RequestBody Transferencia body) {

        transferenciaService.realizarTransferencia(body);
    }
}
