package com.login.flow.api.Repository;

import java.util.List;
import java.util.Optional;

import com.login.flow.api.model.Usuario;

public class UsuarioRepository {
    

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

   
    Usuario save(Long idUsuario);

    Usuario findByEmail(String email);
    
    }

public Usuario save(Usuario usuario) {
    return null;
}

public List<Usuario> findAll() {
    return null;
}

public Optional<Usuario> findById(String email) {
    return null;
}

public void deleteById(Long id) {
}
    
    
    
}