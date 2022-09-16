package br.com.qualqrum.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.qualqrum.data.CPF;

@RestController
@RequestMapping("/test/generator")
public class TesteResource {

    @Autowired
    private CPF cpf;

    @GetMapping("/cpf")
    public ResponseEntity<?> cpf() {
        return ResponseEntity.ok().body(cpf.getValue());
    }
}
