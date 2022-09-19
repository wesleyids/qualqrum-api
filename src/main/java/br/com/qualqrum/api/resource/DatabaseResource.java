package br.com.qualqrum.api.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.qualqrum.sql.DatabaseGenerator;

import static java.util.stream.Collectors.joining;

@RestController
@RequestMapping("/sql")
public class DatabaseResource {

    @GetMapping
    public String init(
            @RequestParam(value = "fields", required = false) List<String> fields,
            @RequestParam(value = "table", required = false) String tableName,
            @RequestParam(value = "limit", required = true) int limit) {
        if (limit <= 0) {
            limit = 2;
        }
        List<String> response = new DatabaseGenerator().init(fields, tableName, limit);
        return response.stream().collect(joining("\n"));
    }
}
