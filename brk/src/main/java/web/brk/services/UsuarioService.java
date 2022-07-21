package web.brk.services;

import web.brk.models.UsuarioModel;
import web.brk.repositories.UsuarioRepository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    //injeção dependencia de repository dentro aqui de service
    final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public UsuarioModel save(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public boolean existsByLogin(String login) {
        return usuarioRepository.existsByLogin(login);
    }

    /*public boolean existsByLoginAndSenha(String login, String senha) {
        return usuarioRepository.existsByLoginAndSenha(login, senha);
    }*/
}
