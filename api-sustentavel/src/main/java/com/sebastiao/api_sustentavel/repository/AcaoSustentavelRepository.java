package com.sebastiao.api_sustentavel.repository;

import com.sebastiao.api_sustentavel.model.AcaoSustentavel;
import com.sebastiao.api_sustentavel.model.CategoriaAcao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AcaoSustentavelRepository
        extends JpaRepository<AcaoSustentavel, Long> {

    List<AcaoSustentavel> findByCategoria(CategoriaAcao categoria);


}
