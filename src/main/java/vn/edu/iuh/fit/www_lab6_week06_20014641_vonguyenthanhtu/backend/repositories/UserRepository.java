package vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String mail);
}
