package projeto.api.rest.controller;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.api.rest.DTO.PessoaDTO;
import projeto.api.rest.model.PessoaModel;
import projeto.api.rest.repository.PessoaRepository;
import projeto.api.rest.service.PessoaService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/all")
    public List<PessoaModel> get() {
        return service.get();
    }

    @PostMapping("/new")
    public String save(@RequestBody @Valid PessoaDTO pessoa) {
        PessoaModel pessoaSalvar = pessoa.salvar();
        pessoaRepository.save(pessoaSalvar);
        return "salvando";}

    @GetMapping("/{id}")
    public Optional<PessoaModel> getById(@PathVariable Long codigoId) {
        return service.getById(codigoId);
    }

}
