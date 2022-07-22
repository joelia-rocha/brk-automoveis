package web.brk.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

//Campo para validação. Feito com spring boot validation
@Data
public class UsuarioDto {
       
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @Email
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
}
