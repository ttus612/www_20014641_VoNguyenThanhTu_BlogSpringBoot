package vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.Post;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.repositories.PostRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(long id){
        return postRepository.findById(id);
    }

    public void insert(Post post) {
        if (post.getId() == null){
            post.setCreatedAt(LocalDateTime.now());
        }
        postRepository.save(post);
    }
}
