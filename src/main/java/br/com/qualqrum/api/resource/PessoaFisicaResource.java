package br.com.qualqrum.api.resource;

import br.com.qualqrum.api.annotation.Info;
import br.com.qualqrum.Generator;
import br.com.qualqrum.PessoaFisica;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pessoa/fisica")
public class PessoaFisicaResource {

    @Info(description = "Gerar uma pessoa física", path = "/")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPessoaFisica() {
        PessoaFisica response = new Generator.GeneratorBuilder()
                .create()
                .pessoaFisica();
        return ResponseEntity.ok().body(response);
    }

    @Info(description = "Gerar uma lista de pessoas física", path = "/list", params = {"value=QTDE"})
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPessoasFisica(@RequestParam("value") int count) {
        if (count == 0) {
            count = 1;
        }
        List<PessoaFisica> response = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            PessoaFisica pf = new Generator.GeneratorBuilder()
                    .create()
                    .pessoaFisica();
            response.add(pf);
        }
        return ResponseEntity.ok().body(response);
    }

    @Info(description = "Gerar uma pessoa física por uf", path = "/uf", params = {"value=SIGLA_UF"})
    @GetMapping(value = "/uf", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPessoaFisicaPorEstado(@RequestParam("value") String uf) {
        PessoaFisica response = new Generator.GeneratorBuilder()
                .setEstado(uf)
                .create()
                .pessoaFisica();
        return ResponseEntity.ok().body(response);
    }

    @Info(description = "Gerar uma pessoa física do sexo masculino", path = "/masculino")
    @GetMapping(value = "/masculino", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPessoaFisicaMasculino() {
        PessoaFisica response = new Generator.GeneratorBuilder()
                .sexoMasculino()
                .create()
                .pessoaFisica();
        return ResponseEntity.ok().body(response);
    }

    @Info(description = "Gerar uma pessoa física do sexo feminino", path = "/feminino")
    @GetMapping(value = "/feminino", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPessoaFisicaFeminino() {
        PessoaFisica response = new Generator.GeneratorBuilder()
                .sexoFeminino()
                .create()
                .pessoaFisica();
        return ResponseEntity.ok().body(response);
    }
}
