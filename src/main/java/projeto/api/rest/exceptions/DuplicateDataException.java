package projeto.api.rest.exceptions;

public class DuplicateDataException extends RuntimeException {
    public DuplicateDataException(String email, String cpf) {
        super("E-mail e/ ou cpf já cadastrados: \n"
                + email + " " + cpf);
    }

}
