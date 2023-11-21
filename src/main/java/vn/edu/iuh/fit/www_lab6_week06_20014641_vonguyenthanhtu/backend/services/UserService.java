package vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.Post;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.User;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void insert(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }


    public Optional<User> findByEmail(String mail) {
        return userRepository.findByEmail(mail);
    }
}
