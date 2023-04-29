package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.flow.api.Repository.UsuarioRepository;
import com.login.flow.api.model.Usuario;

@RestController
//@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
   

    //cadastrar usuario OK
    @PostMapping(value = "usuarios/cadastrar") 
    public Usuario criarNovoUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
        }
        
    //listar usuario OK
    @GetMapping(value = "usuarios/lista")
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
        } 

    //listar por id OK
    
    @GetMapping(value = "usuarios/{id}")
    public Optional<Usuario> obterUsuarioPeloId (@PathVariable String id) {
       return usuarioRepository.findById(id);
    }
   
   
    //listar por email  

    @GetMapping(value = "email/{email}")
   public Optional<Usuario> obterUsuarioPeloEmail (@PathVariable String email) {
    return usuarioRepository.findById(email);
   }
           
    
    

    //Atualizar usuario  OK
    @PutMapping(value = "usuarios/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario) {
    return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
    }

    //Deletar usuario OK
    @DeleteMapping(value = "usuarios/{id}")
    public String deletarUsuarioPeloId(@PathVariable(value = "id") Long id) {
        usuarioRepository.deleteById(id);
        return "Usuario deletado com suscesso";

    }
    
}
