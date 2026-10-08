package br.univille.chamados.service;

import br.univille.chamados.dto.ChamadoResponse;
import br.univille.chamados.dto.CriarChamadosRequest;
import br.univille.chamados.model.Chamado;
import br.univille.chamados.model.StatusChamado;
import br.univille.chamados.repository.ChamadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {

    private final ChamadoRepository repository;

    public ChamadoService(ChamadoRepository repository, ChamadoRepository chamadoRepository1) {
        this.repository = chamadoRepository1;
    }

    public Chamado abrirChamado(Chamado chamado) {
        chamado.setStatus(StatusChamado.ABERTO);
        return repository.save(chamado);
    }

    public List<Chamado> listarChamados() {
        return repository.findAll();
    }

    public Chamado buscarChamadoPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Chamado não encontrado")
                );
    }

    public Chamado concluirChamado(Long id) {
        Chamado chamado = buscarChamadoPorId(id);

        if (chamado.getStatus() == StatusChamado.CONCLUIDO) {
            throw new IllegalArgumentException("Chamado já está concluido");
        }

        chamado.setStatus(StatusChamado.CONCLUIDO);
        return repository.save(chamado);
    }

    public ChamadoResponse abrir(CriarChamadosRequest request) {
        Chamado chamado = new Chamado();
        chamado.setTitulo(request.titulo());
        chamado.setDescricao(request.descricao());
        chamado.setStatus(StatusChamado.ABERTO);

        Chamado salvo = repository.save(chamado);
        return paraResponse(salvo);
    }

    public List<ChamadoResponse> listarRespostas() {
        return repository.findAll()
                .stream()
                .map(this::paraResponse)
                .toList();
    }
    public ChamadoResponse paraResponse(Chamado chamado) {
        return new ChamadoResponse(
                chamado.getIdChamado(),
                chamado.getTitulo(),
                chamado.getDescricao(),
                chamado.getStatus(),
                chamado.getCriadoEm()
        );
    }

}
