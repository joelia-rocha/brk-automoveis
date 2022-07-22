package web.brk.services;

import web.brk.models.UsuarioModel;
import web.brk.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    
    //Injeção dependência de repositories aqui dentro de service.
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

    public List<UsuarioModel> findAll() {
        return usuarioRepository.findAll();
    }


    public Optional<UsuarioModel> findById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }
    
}
