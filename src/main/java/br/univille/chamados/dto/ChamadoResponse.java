package br.univille.chamados.dto;

import br.univille.chamados.model.StatusChamado;

import java.time.LocalDateTime;

public record ChamadoResponse(

    Long id,
    String titulo,
    String descricao,
    StatusChamado status,
    LocalDateTime criadoEm

    )
{}
