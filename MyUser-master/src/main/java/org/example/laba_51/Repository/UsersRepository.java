package org.example.laba_51.Repository;

import org.example.laba_51.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
