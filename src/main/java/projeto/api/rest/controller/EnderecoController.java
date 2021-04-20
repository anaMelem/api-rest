package projeto.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.api.rest.model.EnderecoModel;
import projeto.api.rest.service.EnderecoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping("/all")
    public List<EnderecoModel> get() {
        return service.get();
    }

    @PostMapping("/new")
    public EnderecoModel save(@RequestBody EnderecoModel endereco) {
        return service.save(endereco);
    }

    @GetMapping("/{id}")
    public Optional<EnderecoModel> getById(@PathVariable Long id) {
        return service.getById(id);
    }

//    public class CepRestService {
//
//        @Autowired
//        private EnderecoService.CepService cepService;
//
//        @GetMapping("/{cep}")
//        public ResponseEntity<EnderecoModel> getCep(@PathVariable String cep) {
//
//            EnderecoModel endereco = cepService.buscaEnderecoPorCep(cep);
//
//            return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
//        }
//
//    }

}
