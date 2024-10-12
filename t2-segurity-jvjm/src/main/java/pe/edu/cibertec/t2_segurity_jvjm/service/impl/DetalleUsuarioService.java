package pe.edu.cibertec.t2_segurity_jvjm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.t2_segurity_jvjm.model.Rol;
import pe.edu.cibertec.t2_segurity_jvjm.model.Usuario;
import pe.edu.cibertec.t2_segurity_jvjm.service.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {

    private final IUsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.obtenerUsuarioXemail(username); // Ajustamos a buscar por email
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return crearUserDetail(usuario, obtenerRolesUsuario(usuario.getRoles()));

    }

    public List<GrantedAuthority> obtenerRolesUsuario(Set<Rol> rolesList) {
        List<GrantedAuthority> rolesAuth = new ArrayList<>();
        for (Rol rol : rolesList) {
            rolesAuth.add(new SimpleGrantedAuthority("ROLE_" + rol.getNomrol()));
        }
        return rolesAuth;
    }

    private UserDetails crearUserDetail(Usuario usuario, List<GrantedAuthority> authorityList) {
        return new User(
                usuario.getEmail(), // Cambiamos a usar el email
                usuario.getPassword(),
                usuario.getActivo(),
                true,
                true,
                true,
                authorityList);
    }
}