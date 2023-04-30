package com.login.flow.api.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @NotNull(message = "O nome deverá ser informado")
    @NotBlank(message = "O nome não poderá ser vazio")
    @Size(min = 3, max = 45, message = "O nome deverá ter entre 3 e 45 caracteres")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Informar apenas letras para o nome")
    private String nome;

    @NotNull(message = "O sobrenome deverá ser informado")
    @NotBlank(message = "O sobrenome não poderá ser vazio")
    @Size(min = 2, max = 45, message = "O sobrenome deverá ter entre 5 e 45 caracteres")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Informar apenas letras para o sobrenome")
    private String sobrenome;

    @Column(unique = true)
    private String email;

    @Past
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    // TODO: Incluir regex
    @NotNull(message = "O campo senha deverá ser informado")
    @NotBlank(message = "O campo senha não poderá ser vazio")
    @Size(min = 6, max = 6, message = "O campo senha deverá ter 6 caracteres")
    private String senha;

    @OneToOne
    @JoinColumn(name = "idTipoUsuario")
    private TipoUsuario tipoUsuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (tipoUsuario.getNome().equalsIgnoreCase("administrador")) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else if (tipoUsuario.getNome().equalsIgnoreCase("colaborador")) {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }

        return List.of(new SimpleGrantedAuthority("ROLE_GUEST"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return Boolean.TRUE;
    }

    @Override
    public boolean isAccountNonLocked() {
        return Boolean.TRUE;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return Boolean.TRUE;
    }

    @Override
    public boolean isEnabled() {
        return Boolean.TRUE;
    }

}