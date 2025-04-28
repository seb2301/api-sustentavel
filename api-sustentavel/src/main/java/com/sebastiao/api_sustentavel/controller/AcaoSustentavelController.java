package com.sebastiao.api_sustentavel.controller;

import com.sebastiao.api_sustentavel.response.AcaoSustentavelResponse;
import com.sebastiao.api_sustentavel.service.AcaoSustentavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acoes-sustentaveis")
public class AcaoSustentavelController {

    private final AcaoSustentavelService service;

    @Autowired
    public AcaoSustentavelController(AcaoSustentavelService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping
    public List<AcaoSustentavelResponse> listar() {
        return service.listar();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public AcaoSustentavelResponse buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public AcaoSustentavelResponse cadastrar(@RequestBody AcaoSustentavelResponse request) {
        return service.cadastrar(request);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public AcaoSustentavelResponse atualizar(@PathVariable Long id, @RequestBody AcaoSustentavelResponse request) {
        return service.atualizar(id, request);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
