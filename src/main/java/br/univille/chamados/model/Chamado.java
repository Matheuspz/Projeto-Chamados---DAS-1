package br.univille.chamados.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chamados")
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chamado")
    private Long idChamado;

    @Column(name = "titulo", nullable = false, length = 120)
    private String titulo;

    @Column(name = "descricao", nullable = false, length = 1000 )
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusChamado status = StatusChamado.ABERTO;

    @Column(name = "criado_em",nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    public Chamado() {
    }

    public Long getIdChamado() {
        return idChamado;
    }
    public void setIdChamado(Long idChamado) {
        this.idChamado = idChamado;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public StatusChamado getStatus() {
        return status;
    }
    public void setStatus(StatusChamado status) {
        this.status = status;
    }
    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
}
