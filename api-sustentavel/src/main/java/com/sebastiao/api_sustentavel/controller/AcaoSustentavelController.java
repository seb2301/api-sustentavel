package com.sebastiao.api_sustentavel.controller;

import com.sebastiao.api_sustentavel.dto.AcaoSustentavelRequest;
import com.sebastiao.api_sustentavel.dto.AcaoSustentavelResponse;
import com.sebastiao.api_sustentavel.model.CategoriaAcao;
import com.sebastiao.api_sustentavel.service.AcaoSustentavelService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acoes")
public class AcaoSustentavelController {

    private final AcaoSustentavelService service;

    public AcaoSustentavelController(AcaoSustentavelService service) {
        this.service = service;
    }

    @GetMapping
    public List<AcaoSustentavelResponse> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public AcaoSustentavelResponse buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/categoria")
    public List<AcaoSustentavelResponse> filtrarPorCategoria(@RequestParam CategoriaAcao tipo) {
        return service.buscarPorCategoria(tipo);
    }

    @PostMapping
    public AcaoSustentavelResponse criar(@RequestBody @Valid AcaoSustentavelRequest request) {
        return service.criar(request);
    }

    @PutMapping("/{id}")
    public AcaoSustentavelResponse atualizar(@PathVariable Long id, @RequestBody @Valid AcaoSustentavelRequest request) {
        return service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
