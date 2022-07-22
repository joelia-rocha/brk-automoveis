package web.brk.controllers.usuario;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.brk.dtos.UsuarioDto;
import web.brk.models.UsuarioModel;
import web.brk.services.UsuarioService;

@Controller
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuario")
public class ControllerUsuario {

    final UsuarioService usuarioService;

    public ControllerUsuario(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Salvar informações do usuário com validação.
    @PostMapping
    public ResponseEntity<Object> saveUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        
        if(usuarioService.existsByEmail(usuarioDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O e-mail já existe.");
        }
        if(usuarioService.existsByLogin(usuarioDto.getLogin())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Login já existe.");
        }

        var UsuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDto, UsuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(UsuarioModel));
    }

    //Receber lista de usuários cadastrados.
    @GetMapping("/cadastrados")
    public ResponseEntity<List<UsuarioModel>> getAllUsuario(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    //Pesquisar e validar usuário pelo id.
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUsuario(@PathVariable(value = "id") Long idUsuario){
        Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(idUsuario);
        if(!usuarioModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Login ou senha inválidos.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioModelOptional.get());
    }

}

