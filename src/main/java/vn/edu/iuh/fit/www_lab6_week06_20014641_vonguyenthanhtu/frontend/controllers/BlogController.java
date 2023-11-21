package vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.frontend.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.Post;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.User;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.repositories.UserRepository;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.services.PostService;
import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.services.UserService;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private PostService postService;

    @GetMapping( "/")
    public  String index(Model model){
        List<Post> posts = postService.getAllPost();
        model.addAttribute("posts", posts);
        return "index";
    }

//    @GetMapping(value = "/posts")
//    public List<Post> posts(){
//        return postService.getAllPost();
//    }
//
//    @PostMapping(value = "/post")
//    public void publishPost(@RequestBody Post post){
//        postService.insert(post);
//    }

}
