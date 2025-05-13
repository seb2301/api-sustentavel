package com.sebastiao.api_sustentavel.service;

import com.sebastiao.api_sustentavel.model.AcaoSustentavel;
import com.sebastiao.api_sustentavel.repository.AcaoSustentavelRepository;
import com.sebastiao.api_sustentavel.response.AcaoSustentavelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcaoSustentavelService {

    public AcaoSustentavelResponse buscarPorId(Long id) {
        Optional<AcaoSustentavel> optionalAcao = repository.findById(id);

        AcaoSustentavel acao = optionalAcao.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Ação sustentável não encontrada com ID: " + id)
        );

        return toResponse(acao);
    }


    private final AcaoSustentavelRepository repository;

    @Autowired
    public AcaoSustentavelService(AcaoSustentavelRepository repository) {
        this.repository = repository;
    }

    public List<AcaoSustentavelResponse> listar() {
        List<AcaoSustentavel> acoes = repository.findAll();
        return acoes.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private AcaoSustentavelResponse toResponse(AcaoSustentavel acao) {
        return new AcaoSustentavelResponse(
                acao.getId(),
                acao.getTitulo(),
                acao.getDescricao(),
                acao.getCategoria().name(), // Aqui estou assumindo que Categoria é um Enum
                acao.getLocal()
        );
    }

    public AcaoSustentavelResponse cadastrar(AcaoSustentavelResponse request) {
        return request;
    }

    public AcaoSustentavelResponse atualizar(Long id, AcaoSustentavelResponse request) {
        return request;
    }

    public void deletar(Long id) {
    }
}
