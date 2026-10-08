package br.univille.chamados.controllers;

import br.univille.chamados.dto.ChamadoResponse;
import br.univille.chamados.dto.CriarChamadosRequest;
import br.univille.chamados.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chamados")
class ChamadoRestController {

    private final ChamadoService chamadoService;

    public ChamadoRestController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChamadoResponse criar(@Valid @RequestBody CriarChamadosRequest request) {
        return chamadoService.abrir(request);
    }

    @GetMapping
    public List<ChamadoResponse> listar() {
        return chamadoService.listarRespostas();
    }
}
