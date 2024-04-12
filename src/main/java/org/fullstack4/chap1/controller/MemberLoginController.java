package org.fullstack4.chap1.controller;

import org.fullstack4.chap1.dto.MemberDTO;
import org.fullstack4.chap1.service.MemberService;
import org.fullstack4.chap1.util.CommonUtil;
import org.fullstack4.chap1.util.CookieUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String user_id = CommonUtil.parseString(req.getParameter("user_id"));
        String pwd = CommonUtil.parseString(req.getParameter("pwd"));
        String saved_id = CommonUtil.parseString(req.getParameter("saved_id"));
        String auto_login = CommonUtil.parseString(req.getParameter("auto_login"));

        if (!saved_id.equals("")) {
            CookieUtil.setCookie(resp,"savedId", user_id, 9999999);
        } else {
            CookieUtil.deleteCookie(resp,"savedId");
        }

        MemberDTO dto = null;
        try {
            dto = MemberService.INSTANCE.selectMemberInfo(user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (dto != null) {
            if(dto.getUser_id().equals(user_id) && dto.getPwd().equals(pwd)) {
                System.out.println("로그인 성공");
                session.setAttribute("user_id",dto.getUser_id());
                session.setAttribute("name", dto.getName());
                if (!auto_login.equals("")) {
                    CookieUtil.setCookie(resp,"autoLogin", user_id, 9999999);
                }
                resp.sendRedirect("/bbs/list");
            } else {
                System.out.println("로그인 실패 : 비밀번호 미일치");
                resp.sendRedirect("/member/login?loginYN=fail");
            }
        } else {
            System.out.println("로그인 실패 : 없는 회원정보");
            resp.sendRedirect("/member/login?loginYN=fail");
        }

    }
}
