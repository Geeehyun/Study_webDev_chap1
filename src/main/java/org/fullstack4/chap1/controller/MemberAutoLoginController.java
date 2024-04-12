package org.fullstack4.chap1.controller;

import org.fullstack4.chap1.dto.MemberDTO;
import org.fullstack4.chap1.service.MemberService;
import org.fullstack4.chap1.util.CommonUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/member/autoLogin")
public class MemberAutoLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String user_id = CommonUtil.parseString(req.getParameter("user_id"));
        MemberDTO dto = null;
        try {
            dto = MemberService.INSTANCE.selectMemberInfo(user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (dto != null) {
            session.setAttribute("user_id",dto.getUser_id());
            session.setAttribute("name", dto.getName());
            resp.sendRedirect("/bbs/list");
        } else {
            System.out.println("로그인 실패 : 없는 회원정보");
            resp.sendRedirect("/member/login?loginYN=fail");
        }

    }
}
