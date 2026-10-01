package br.univille.chamados.repository;

import br.univille.chamados.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado,Long> {
    List<Chamado> findByStatus(String status);
}
