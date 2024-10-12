package pe.edu.cibertec.t2_segurity_jvjm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.t2_segurity_jvjm.model.Usuario;
import pe.edu.cibertec.t2_segurity_jvjm.repository.UsuarioRepository;
import pe.edu.cibertec.t2_segurity_jvjm.service.IUsuarioService;

@RequiredArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario obtenerUsuarioXemail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(String email, Usuario usuario) {
        Usuario usuarioExistente = obtenerUsuarioXemail(email);
        if (usuarioExistente != null) {
            usuarioExistente.setCodigo(usuario.getCodigo());
            usuarioExistente.setPassword(usuario.getPassword());
            usuarioExistente.setRoles(usuario.getRoles());
            return usuarioRepository.save(usuarioExistente);
        }
        return null;
    }
}
