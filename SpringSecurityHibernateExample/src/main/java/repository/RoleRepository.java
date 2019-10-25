package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Authorities;

public interface RoleRepository extends JpaRepository<Authorities, Long>{
}