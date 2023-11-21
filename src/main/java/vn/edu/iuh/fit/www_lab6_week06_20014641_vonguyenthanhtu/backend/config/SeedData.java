package vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.Authority;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.Post;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.PostComment;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.User;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.repositories.AuthorityRepository;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.repositories.PostCommentRepository;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.repositories.PostRepository;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.services.PostCommentService;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.services.PostService;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.services.UserService;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private PostCommentService postCommentService ;
    @Autowired
    private AuthorityRepository authorityRepository;


    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAllPost();
        if (posts.size() == 0){
            //Create Authority
            Authority authority = new Authority();
            authority.setName("ROLE_USER");
            authorityRepository.save(authority);

            Authority authority1 = new Authority();
            authority1.setName("ROLE_ADMIN");
            authorityRepository.save(authority1);


            // Create Users
            User user1 = new User("John", null, "Doe", "123456789", "john@example.com", "hashedPassword", LocalDateTime.now(), null, "Intro about John", "Profile of John", null, null, null);
            Set<Authority>  authorities1 = new HashSet<>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities1::add);
            user1.setAuthorities(authorities1);
            User user2 = new User("Jane", "A.", "Doe", "987654321", "jane@example.com", "hashedPassword", LocalDateTime.now(), null, "Intro about Jane", "Profile of Jane", null, null, null);
            Set<Authority>  authorities2 = new HashSet<>();
            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities2::add);
            user1.setAuthorities(authorities2);
            userService.insert(user1);
            userService.insert(user2);

            // Create Posts
            Post post1 = new Post(user1, null, "Post 1 Title", "Meta Title 1", "Summary of Post 1", true, LocalDateTime.now(), null, null, "Content of Post 1", null, null);
            Post post2 = new Post(user2, null, "Post 2 Title", "Meta Title 2", "Summary of Post 2", true, LocalDateTime.now(), null, null, "Content of Post 2", null, null);

            postService.insert(post1);
            postService.insert(post2);

            // Create Post Comments
            PostComment comment1 = new PostComment(post1, null, user2, "Comment 1 Title", true, LocalDateTime.now(), null, "Content of Comment 1", null);
            PostComment comment2 = new PostComment(post2, null, user1, "Comment 2 Title", true, LocalDateTime.now(), null, "Content of Comment 2", null);

            postCommentService.insert(comment1);
            postCommentService.insert(comment2);
        }
    }
}
