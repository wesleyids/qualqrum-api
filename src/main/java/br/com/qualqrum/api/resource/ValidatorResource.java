package br.com.qualqrum.api.resource;

import br.com.qualqrum.api.annotation.Info;
import br.com.qualqrum.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validator")
public class ValidatorResource {

    @Info(description = "Valida se o cpf é valido", path = "/cpf", params = {"value"})
    @GetMapping(value = "/cpf")
    public ResponseEntity<?> cpf(@RequestParam("value") String cpf) {
        boolean valid = Validator.cpfValid(cpf);
        return ResponseEntity.ok().body(valid);
    }

    @Info(description = "Valida se o cnpj é valido", path = "/cnpj", params = {"value"})
    @GetMapping(value = "/cnpj")
    public ResponseEntity<?> cnpj(@RequestParam("value") String cnpj) {
        boolean valid = Validator.cnpjValid(cnpj);
        return ResponseEntity.ok().body(valid);
    }

    @Info(description = "Valida se o email é valido", path = "/email", params = {"value"})
    @GetMapping(value = "/email")
    public ResponseEntity<?> email(@RequestParam("value") String email) {
        boolean valid = Validator.emailValid(email);
        return ResponseEntity.ok().body(valid);
    }
}
