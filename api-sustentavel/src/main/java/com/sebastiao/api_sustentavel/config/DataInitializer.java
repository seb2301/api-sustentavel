package com.sebastiao.api_sustentavel.config;

import com.sebastiao.api_sustentavel.model.AcaoSustentavel;
import com.sebastiao.api_sustentavel.model.CategoriaAcao;
import com.sebastiao.api_sustentavel.repository.AcaoSustentavelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner carregarDadosIniciais(AcaoSustentavelRepository repository) {
        return args -> {
            repository.saveAll(List.of(
                    new AcaoSustentavel(
                            "Plantio de árvores na praça central",
                            "Plantio de 30 mudas de árvores nativas.",
                            CategoriaAcao.PLANTIO,
                            LocalDate.of(2024, 3, 15),
                            "João Silva"
                    ),
                    new AcaoSustentavel(
                            "Campanha de reciclagem em escolas",
                            "Coleta seletiva e conscientização nas escolas municipais.",
                            CategoriaAcao.RECICLAGEM,
                            LocalDate.of(2024, 4, 5),
                            "Maria Oliveira"
                    ),
                    new AcaoSustentavel(
                            "Doação de roupas para famílias carentes",
                            "Arrecadação e entrega de roupas para comunidades carentes.",
                            CategoriaAcao.DOACAO,
                            LocalDate.of(2024, 2, 10),
                            "ONG Solidariedade"
                    ),
                    new AcaoSustentavel(
                            "Palestra sobre meio ambiente",
                            "Palestra sobre sustentabilidade em universidades.",
                            CategoriaAcao.EDUCACAO_AMBIENTAL,
                            LocalDate.of(2024, 1, 25),
                            "Prof. Ana Costa"
                    ),
                    new AcaoSustentavel(
                            "Mutirão de limpeza no rio",
                            "Limpeza das margens e fundo do Rio Cachoeira.",
                            CategoriaAcao.OUTROS,
                            LocalDate.of(2024, 5, 2),
                            "Grupo EcoAtitude"
                    ),
                    new AcaoSustentavel(
                            "Oficina de compostagem doméstica",
                            "Oficina sobre como transformar lixo orgânico em adubo.",
                            CategoriaAcao.EDUCACAO_AMBIENTAL,
                            LocalDate.of(2024, 3, 8),
                            "Lucas Martins"
                    ),
                    new AcaoSustentavel(
                            "Coleta de eletrônicos",
                            "Campanha para reciclagem de eletrônicos velhos.",
                            CategoriaAcao.RECICLAGEM,
                            LocalDate.of(2024, 4, 12),
                            "Tech Verde"
                    ),
                    new AcaoSustentavel(
                            "Feira de produtos orgânicos",
                            "Feira com produtores locais e produtos orgânicos.",
                            CategoriaAcao.OUTROS,
                            LocalDate.of(2024, 2, 20),
                            "Associação Rural"
                    ),
                    new AcaoSustentavel(
                            "Plantio de flores em canteiros públicos",
                            "Embelezamento urbano com flores em praças.",
                            CategoriaAcao.PLANTIO,
                            LocalDate.of(2024, 4, 30),
                            "Prefeitura Municipal"
                    ),
                    new AcaoSustentavel(
                            "Distribuição de mudas de plantas",
                            "Distribuição gratuita de mudas para a população.",
                            CategoriaAcao.PLANTIO,
                            LocalDate.of(2024, 3, 22),
                            "ONG VerdeJá"
                    ),
                    new AcaoSustentavel(
                            "Curso sobre reciclagem criativa",
                            "Curso de reaproveitamento de materiais recicláveis.",
                            CategoriaAcao.EDUCACAO_AMBIENTAL,
                            LocalDate.of(2024, 1, 15),
                            "Ateliê Recicle"
                    ),
                    new AcaoSustentavel(
                            "Campanha de doação de alimentos",
                            "Arrecadação e entrega de cestas básicas.",
                            CategoriaAcao.DOACAO,
                            LocalDate.of(2024, 2, 5),
                            "Voluntários Unidos"
                    ),
                    new AcaoSustentavel(
                            "Aula aberta sobre sustentabilidade",
                            "Aula sobre práticas sustentáveis no dia a dia.",
                            CategoriaAcao.EDUCACAO_AMBIENTAL,
                            LocalDate.of(2024, 3, 1),
                            "Univille"
                    ),
                    new AcaoSustentavel(
                            "Troca de óleo usado por sabão",
                            "Iniciativa para evitar descarte de óleo no meio ambiente.",
                            CategoriaAcao.RECICLAGEM,
                            LocalDate.of(2024, 3, 18),
                            "Eco Troca"
                    ),
                    new AcaoSustentavel(
                            "Arrecadação de brinquedos usados",
                            "Distribuição de brinquedos reciclados.",
                            CategoriaAcao.DOACAO,
                            LocalDate.of(2024, 4, 10),
                            "Projeto Criança Feliz"
                    )
            ));
        };
    }
}
