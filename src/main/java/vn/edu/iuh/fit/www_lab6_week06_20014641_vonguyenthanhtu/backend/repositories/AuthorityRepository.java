package vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
