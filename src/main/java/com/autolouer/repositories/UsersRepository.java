package com.autolouer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autolouer.entities.defaultapp.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

}
