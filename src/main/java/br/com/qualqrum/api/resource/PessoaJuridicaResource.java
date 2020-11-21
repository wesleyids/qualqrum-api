package br.com.qualqrum.api.resource;

import br.com.qualqrum.api.annotation.Info;
import br.com.qualqrum.Generator;
import br.com.qualqrum.PessoaFisica;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa/juridica")
public class PessoaJuridicaResource {

    @Info(description = "Gerar uma pessoa jurídica", path = "/")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPessoaJuridica() {
        PessoaFisica response = new Generator.GeneratorBuilder()
                .create()
                .pessoaFisica();
        return ResponseEntity.ok().body(response);
    }

    @Info(description = "Gerar uma pessoa jurídica por uf", path = "/uf", params = {"value"})
    @GetMapping(value = "/uf", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPessoaJuridicaPorEstado(@RequestParam("value") String uf) {
        PessoaFisica response = new Generator.GeneratorBuilder()
                .setEstado(uf)
                .create()
                .pessoaFisica();
        return ResponseEntity.ok().body(response);
    }
}
