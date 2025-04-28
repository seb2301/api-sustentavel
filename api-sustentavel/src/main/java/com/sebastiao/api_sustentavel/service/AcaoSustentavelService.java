package com.sebastiao.api_sustentavel.service;

import com.sebastiao.api_sustentavel.dto.AcaoSustentavelRequest;
import com.sebastiao.api_sustentavel.dto.AcaoSustentavelResponse;
import com.sebastiao.api_sustentavel.exception.RecursoNaoEncontradoException;
import com.sebastiao.api_sustentavel.model.AcaoSustentavel;
import com.sebastiao.api_sustentavel.model.CategoriaAcao;
import com.sebastiao.api_sustentavel.repository.AcaoSustentavelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AcaoSustentavelService {

    private final AcaoSustentavelRepository repository;

    public AcaoSustentavelService(AcaoSustentavelRepository repository) {
        this.repository = repository;
    }

    public List<AcaoSustentavelResponse> listar() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public AcaoSustentavelResponse buscarPorId(Long id) {
        AcaoSustentavel acao = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ação com ID " + id + " não encontrada."));
        return toResponse(acao);
    }

    public List<AcaoSustentavelResponse> buscarPorCategoria(CategoriaAcao categoria) {
        return repository.findByCategoria(categoria)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public AcaoSustentavelResponse criar(AcaoSustentavelRequest request) {
        AcaoSustentavel acao = toEntity(request);
        AcaoSustentavel salvo = repository.save(acao);
        return toResponse(salvo);
    }

    public AcaoSustentavelResponse atualizar(Long id, AcaoSustentavelRequest request) {
        AcaoSustentavel existente = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ação com ID " + id + " não encontrada."));

        existente.setTitulo(request.getTitulo());
        existente.setDescricao(request.getDescricao());
        existente.setCategoria(request.getCategoria());
        existente.setDataRealizacao(request.getDataRealizacao());
        existente.setResponsavel(request.getResponsavel());

        AcaoSustentavel atualizado = repository.save(existente);
        return toResponse(atualizado);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Ação com ID " + id + " não encontrada.");
        }
        repository.deleteById(id);
    }



    private AcaoSustentavel toEntity(AcaoSustentavelRequest request) {
        AcaoSustentavel acao = new AcaoSustentavel();
        acao.setTitulo(request.getTitulo());
        acao.setDescricao(request.getDescricao());
        acao.setCategoria(request.getCategoria());
        acao.setDataRealizacao(request.getDataRealizacao());
        acao.setResponsavel(request.getResponsavel());
        return acao;
    }

    private AcaoSustentavelResponse toResponse(AcaoSustentavel acao) {
        AcaoSustentavelResponse response = new AcaoSustentavelResponse();
        response.setId(acao.getId());
        response.setTitulo(acao.getTitulo());
        response.setDescricao(acao.getDescricao());
        response.setCategoria(acao.getCategoria());
        response.setDataRealizacao(acao.getDataRealizacao());
        response.setResponsavel(acao.getResponsavel());
        return response;
    }
}
