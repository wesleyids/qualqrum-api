package br.com.qualqrum.api.resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.qualqrum.math.Divide;
import br.com.qualqrum.math.Multiply;
import br.com.qualqrum.math.Subtract;
import br.com.qualqrum.math.Sum;

@RestController
@RequestMapping("/math")
public class MathResource {

    // @Info(description = "Gerar uma pessoa física", path = "/")
    @GetMapping(value = "/soma", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sum(@RequestParam("valores") double[] values) {
        return ResponseEntity.ok().body(new Sum().calculate(values));
    }

    // @GetMapping(value = "/subtrair", produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<?> subtract(@RequestParam("valores") double[] values) {
    // return ResponseEntity.ok().body(new Subtract().calculate(values));
    // }

    @GetMapping(value = "/dividir", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> divide(@RequestParam("numero") double number, @RequestParam("divisor") double divider) {
        return ResponseEntity.ok().body(new Divide().calculate(number, divider));
    }

    @GetMapping(value = "/multiplicar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> divide(@RequestParam("valores") double[] values) {
        return ResponseEntity.ok().body(new Multiply().calculate(values));
    }
}
