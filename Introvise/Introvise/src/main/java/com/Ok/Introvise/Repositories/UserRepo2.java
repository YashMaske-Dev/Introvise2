package com.Ok.Introvise.Repositories;



import com.Ok.Introvise.Models.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo2 extends JpaRepository<User2, Long> {
    Optional<User2> findByEmail(String email);
}
