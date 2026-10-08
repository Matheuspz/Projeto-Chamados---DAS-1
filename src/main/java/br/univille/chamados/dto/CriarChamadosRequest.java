package br.univille.chamados.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CriarChamadosRequest(

    @NotBlank(message = "Titulo é obrigatório")
    @Size(max = 120, message = "Titulo deve ter no máximo 120 caracteres")
    String titulo,

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 1000, message = "Descrição deve ter no máximo 1000 caracteres")
    String descricao

) {}
