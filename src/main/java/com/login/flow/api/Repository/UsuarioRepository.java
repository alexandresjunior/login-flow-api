package com.login.flow.api.Repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.login.flow.api.model.Usuario;

  
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

   
    //Usuario save(Long id);

    Optional<Usuario> findByEmail(String email);
    
}    