    package vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.frontend.controllers;

    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import jakarta.servlet.http.HttpSession;
    import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model.User;
    import vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.services.UserService;

    import java.util.Optional;

    @Controller
    public class LoginController {

        @Autowired
        UserService userService = new UserService();



        @GetMapping("/login")
        public String login(){
            return "login";
        }

        @PostMapping("/login")
        public String login(@RequestParam String email, @RequestParam String password, HttpSession session){
            //ĐÚNG THÌ ZO TRANG HOME SAI THÌ Ở LẠI
            System.out.println(password);
            System.out.println(email);
            boolean check = userService.login(email, password);
            if(check){
                Optional<User> user = userService.findByEmail(email);
                session.setAttribute("user", user);
                return "redirect:/";
            }
            return "redirect:/login";
        }

        @GetMapping("/logout")
        public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
            session.invalidate();
            return "redirect:/";
        }

    }
