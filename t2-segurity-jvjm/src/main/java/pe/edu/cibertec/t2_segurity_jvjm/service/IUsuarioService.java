package pe.edu.cibertec.t2_segurity_jvjm.service;

import pe.edu.cibertec.t2_segurity_jvjm.model.Usuario;

public interface IUsuarioService {
    Usuario obtenerUsuarioXemail(String email);
    Usuario crearUsuario(Usuario usuario);
    Usuario actualizarUsuario(String email, Usuario usuario);
}
