package web.brk.controllers.usuario;

//import java.time.LocalDateTime;
//import java.time.ZoneId;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping
    public ResponseEntity<Object> saveUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        
        if(usuarioService.existsByEmail(usuarioDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O e-mail já existe.");
        }
        if(usuarioService.existsByLogin(usuarioDto.getLogin())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Login já existe.");
        }
        /*if(usuarioService.existsByLoginAndSenha(usuarioDto.getLogin(), usuarioDto.getSenha())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Login ou senha inválidos.");
        }*/

        var UsuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDto, UsuarioModel);
        //UsuarioModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(UsuarioModel));
    }


}

