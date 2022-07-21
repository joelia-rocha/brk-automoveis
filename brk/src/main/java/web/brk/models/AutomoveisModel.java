package web.brk.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

import javax.persistence.ManyToOne;

@Data
@Entity
@Table(name = "TB_AUTOMOVEIS")
public class AutomoveisModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long automoveisId;
    @Column(nullable = false, unique = true)
    private int anoFabricacao;
    @Column(nullable = false, unique = true, length = 8)
    private String placaCarro;
    @Column(nullable = false, unique = true, length = 50)
    private String modeloCarro;
    @Column(nullable = false, unique = true, length = 50)
    private String corCarro;
    @ManyToOne
    @JsonBackReference
    private UsuarioModel usuario;

}