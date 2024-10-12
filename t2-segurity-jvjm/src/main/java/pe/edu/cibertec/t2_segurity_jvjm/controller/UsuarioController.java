package pe.edu.cibertec.t2_segurity_jvjm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.t2_segurity_jvjm.model.Usuario;
import pe.edu.cibertec.t2_segurity_jvjm.service.IUsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final IUsuarioService usuarioService;

    @PostMapping
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }


    @GetMapping("/{email}")
    @PreAuthorize("hasRole('COORDINADOR')")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String email) {
        Usuario usuario = usuarioService.obtenerUsuarioXemail(email);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("/{email}")
    @PreAuthorize("hasRole('GESTOR') or hasRole('COORDINADOR')") // Restringe el acceso
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable String email, @RequestBody Usuario usuario) {
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(email, usuario);
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
    }
}
