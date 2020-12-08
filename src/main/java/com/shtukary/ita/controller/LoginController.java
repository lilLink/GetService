package com.shtukary.ita.controller;

import com.shtukary.ita.exception.UserNotFoundException;
import com.shtukary.ita.model.UserPrincipal;
import com.shtukary.ita.utility.LoggedUserUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @PostMapping("/login")
    public UserPrincipal userLoginPost() {
        if (LoggedUserUtil.getLoggedUser().isPresent()) {
            return LoggedUserUtil.getLoggedUser().get();
        } else {
            throw new UserNotFoundException("No such user");
        }
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (request.isRequestedSessionIdValid() && session != null) {
            session.invalidate();
        }
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setValue(null);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

}
