package br.com.delivery.pidao.repositories;

import br.com.delivery.pidao.entities.Manager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository {

    Optional<Manager> findByEmailAndPassword(String email, String password);

}