package web.brk.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;
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
    @OneToMany
    @JsonBackReference
    private List<AutomoveisModel> automoveis;

    
}
