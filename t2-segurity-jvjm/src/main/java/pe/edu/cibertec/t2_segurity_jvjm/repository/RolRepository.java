package pe.edu.cibertec.t2_segurity_jvjm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.t2_segurity_jvjm.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}
