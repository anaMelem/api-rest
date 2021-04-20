package projeto.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.api.rest.model.PessoaModel;

@Repository
public interface PessoaRepository extends JpaRepository <PessoaModel,Long> {
    PessoaModel findByEmail(String email);
    PessoaModel findByCpf(String cpf);
}
