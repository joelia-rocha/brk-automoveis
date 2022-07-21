package web.brk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import web.brk.models.UsuarioModel;
//pode substituir String por UUID
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, String> {
    /*@Query(value = "select * from usuario where login = :login and senha = :senha", nativeQuery = true)
    public UsuarioModel Login(String login, String senha);*/
    boolean existsByEmail(String email);
    boolean existsByLogin(String login);
    //boolean existsByLoginAndSenha(String login, String senha);
    
}
