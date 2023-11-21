package vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.PostComment;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.User;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.repositories.PostCommentRepository;

@Service
public class PostCommentService {
    @Autowired
    private PostCommentRepository postCommentRepository;
    public void insert(PostComment postComment) {
        postCommentRepository.save(postComment);
    }
}
