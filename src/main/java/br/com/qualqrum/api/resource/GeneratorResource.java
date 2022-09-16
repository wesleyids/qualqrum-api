package br.com.qualqrum.api.resource;

import br.com.qualqrum.Generator;
import br.com.qualqrum.api.annotation.Info;
import br.com.qualqrum.data.ContatoTelefonico;
import br.com.qualqrum.data.Endereco;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generator")
public class GeneratorResource {

    @Info(description = "Gerar um número de cpf válido", path = "/cpf")
    @GetMapping("/cpf")
    public ResponseEntity<?> cpf() {
        String response = Generator.cpf();
        return ResponseEntity.ok().body(response);
    }

    @Info(description = "Gerar um número de cnpj válido", path = "/cnpj")
    @GetMapping("/cnpj")
    public ResponseEntity<?> cnpj() {
        String response = Generator.cnpj();
        return ResponseEntity.ok().body(response);
    }

    @Info(description = "Gerar um email válido", path = "/email")
    @GetMapping("/email")
    public ResponseEntity<?> email() {
        String response = Generator.email();
        return ResponseEntity.ok().body(response);
    }

    @Info(description = "Gerar uma senha aleatória", path = "/senha", params = { "tamanho" })
    @GetMapping("/senha")
    public ResponseEntity<?> senha(@RequestParam int tamanho) {
        String response = Generator.senha(tamanho);
        return ResponseEntity.ok().body(response);
    }

    @Info(description = "Gerar um estado aleatório", path = "/estado")
    @GetMapping("/estado")
    public ResponseEntity<?> estado() {
        String response = Generator.estado();
        return ResponseEntity.ok().body(response);
    }

    @Info(description = "Gerar uf", path = "/uf")
    @GetMapping("/uf")
    public ResponseEntity<?> uf() {
        String response = Generator.uf();
        return ResponseEntity.ok().body(response);
    }

    @Info(description = "Gerar uma cidade aleatória", path = "/cidade", params = { "uf" })
    @GetMapping("/cidade")
    public ResponseEntity<?> cidade(@RequestParam String uf) {
        String response;

        if (uf != null && !"".equals(uf)) {
            response = Generator.cidade(uf);
        } else {
            response = Generator.cidade();
        }

        return ResponseEntity.ok().body(response);
    }

    @Info(description = "Gerar um endereço aleatório", path = "/endereco")
    @GetMapping("/endereco")
    public ResponseEntity<?> endereco() {
        Endereco response = Generator.endereco();
        return ResponseEntity.ok().body(response);
    }

    @Info(description = "Gerar um contato telefônico", path = "/contato")
    @GetMapping("/contato")
    public ResponseEntity<?> contato() {
        ContatoTelefonico response = Generator.contatoTelefonico();
        return ResponseEntity.ok().body(response);
    }
}
