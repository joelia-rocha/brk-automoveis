package web.brk.models;

import java.io.Serializable;
//import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Identificadores únicos gerados automaticamente.
    private UUID Id;
    //campo não pode ser vazio e o valor não pode ser duplicado
    @Column(nullable = false, unique = true) 
    private String nome;
    @Column(nullable = false, unique = true)
    private String sobrenome;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @Column(nullable = false, unique = true, length = 10)
    private String dataDeNascimento;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false, unique = true)
    private String senha;
    @Column(nullable = false, unique = true)
    private String telefone;
    //private String listaCarros;
    //private LocalDateTime registrationDate;
    
}
