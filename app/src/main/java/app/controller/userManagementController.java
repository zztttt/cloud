package app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class userManagementController {
    @GetMapping("/getUser")
    public String getUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username == null){
            username = "testSessionRedis|" + System.currentTimeMillis();
            session.setAttribute("username", username);
        }
        System.out.println("port:" + request.getServerPort());
        return username;
    }
}
