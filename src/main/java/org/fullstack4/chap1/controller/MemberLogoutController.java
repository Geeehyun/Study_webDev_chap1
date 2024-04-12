package org.fullstack4.chap1.controller;

import org.fullstack4.chap1.util.CookieUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/")
public class MemberLogoutController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        CookieUtil.deleteCookie(resp, "autoLogin");
        resp.sendRedirect("/member/login");
    }
}
