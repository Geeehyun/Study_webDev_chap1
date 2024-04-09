package org.fullstack4.chap1.controller;

import org.fullstack4.chap1.util.CommonUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/bbs/delete")
public class BbsDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("여기는 GET 돌아가세요.");
        resp.sendRedirect("/bbs/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idx = CommonUtil.parseInt(req.getParameter("idx"));
        boolean flag = true;
        if (idx == 0) {
            System.out.println("올바르지 않은 idx 값 입니다.");
            flag = false;
        }
        
        if(flag) {
            System.out.println("삭제 성공");
            resp.sendRedirect("/bbs/list");
        } else {
            System.out.println("삭제 실패");
            resp.sendRedirect("/bbs/list");
        }
    }
}
