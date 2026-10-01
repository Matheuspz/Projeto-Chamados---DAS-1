package br.univille.chamados.service;

import br.univille.chamados.model.Chamado;
import br.univille.chamados.model.StatusChamado;
import br.univille.chamados.repository.ChamadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;

    public ChamadoService(ChamadoRepository chamadoRepository, ChamadoRepository chamadoRepository1) {
        this.chamadoRepository = chamadoRepository1;
    }

    public Chamado abrirChamado(Chamado chamado) {
        chamado.setStatus(StatusChamado.ABERTO);
        return chamadoRepository.save(chamado);
    }

    public List<Chamado> listarChamados() {
        return chamadoRepository.findAll();
    }

    public Chamado buscarChamadoPorId(Long id) {
        return chamadoRepository.findById(id)
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
        return chamadoRepository.save(chamado);
    }
}
