package br.com.qualqrum.api.resource;

import br.com.qualqrum.api.service.LoaderService;
import br.com.qualqrum.api.dto.PathResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/")
public class IndexResource {

    @GetMapping
    public ResponseEntity<?> getPaths() {
        List<PathResponseDTO> response = LoaderService.getPaths();
        return ResponseEntity.ok().body(response);
    }


}
