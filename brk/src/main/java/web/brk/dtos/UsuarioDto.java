package web.brk.dtos;

//import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
//(Dto = campo para validação)feito com spring boot validation
public class UsuarioDto {
    
    //não aceita campo nulo.
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    //@Email
    private String email;
    @NotBlank
    private String dataDeNascimento;
    @NotBlank
    private String login;
    @NotBlank
    @Size(min = 8)
    private String senha;
    @NotBlank
    private String telefone;
    //private String listaCarros;
}
