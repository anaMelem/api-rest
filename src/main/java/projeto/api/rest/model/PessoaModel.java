package projeto.api.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity(name = "pessoa")

public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoId;

    @Column(name = "nome", nullable = false,length = 50)
    @NotNull(message = "Nome é obrigatório")
    private String nome;

    @Column(name = "cpf", length = 11 , nullable = false, unique = true)
    @NotNull(message = "Cpf é obrigatório")
    @CPF(message = "Somente números")
    private String cpf;

    @Column(name = "email",nullable = false,length = 255,unique = true)
    @Size(min=5, max = 255, message = "E-mail deve conter entre 5 a 255 caracteres")
    @NotNull(message = "E-mail é obrigatório")
    private String email;

    @Column(nullable = false,length = 10)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date dataNascimento;

    public Long getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(Long codigoId) {
        this.codigoId = codigoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public PessoaModel(@NotNull(message = "Nome é obrigatório") String nome,
                       @NotNull(message = "Cpf é obrigatório") @CPF(message = "Somente números") String cpf,
                       @Size(min = 5, max = 255, message = "E-mail deve conter entre 5 a 255 caracteres")
                       @NotNull(message = "E-mail é obrigatório") String email, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }
}
