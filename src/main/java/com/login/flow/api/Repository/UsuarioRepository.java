package com.login.flow.api.Repository;
public class UsuarioRepository {
    

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

   
    Usuario save(Long idUsuario);

    Usuario findByEmail(String email);
    
    }
    
    
    
}