package mx.utng.practice.repository;

import mx.utng.practice.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long > {

}//
