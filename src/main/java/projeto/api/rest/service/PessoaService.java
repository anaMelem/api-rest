package projeto.api.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.api.rest.exceptions.DuplicateDataException;
import projeto.api.rest.model.PessoaModel;
import projeto.api.rest.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {


    @Autowired
    private PessoaRepository repository;
    public PessoaModel save(PessoaModel pessoa) {

        boolean exist = this.findExistedPerson(pessoa.getEmail(), pessoa.getCpf());

        if(!exist) {
            return repository.save(pessoa);
        } else {
            throw new DuplicateDataException(pessoa.getEmail(), pessoa.getCpf());
        }

    }

    public List<PessoaModel> get() {
        return repository.findAll();
    }

    public Optional<PessoaModel> getById(Long codigoId) {
        return repository.findById(codigoId);
    }

    private Boolean findExistedPerson(String email, String cpf) {
        PessoaModel findByEmail = repository.findByEmail(email);
        PessoaModel findByCpf = repository.findByCpf(cpf);

        if(findByEmail != null || findByCpf != null) {
            return true;
        } else {
            return false;
        }
    }

}
