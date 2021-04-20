package projeto.api.rest.DTO;

import projeto.api.rest.model.PessoaModel;

import javax.xml.crypto.Data;
import java.util.Date;

public class PessoaDTO {

    private String nome;
    private String email;
    private String cpf;
    private Date dataNascimento;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }


    public PessoaModel salvar() {
        PessoaModel pessoa = new PessoaModel(nome, cpf,email, dataNascimento);
        return pessoa;
    }
}
