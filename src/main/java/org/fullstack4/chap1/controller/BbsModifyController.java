package org.fullstack4.chap1.controller;

import org.fullstack4.chap1.util.CommonUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/bbs/modify")
public class BbsModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/bbs/modify.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        boolean check_flag = true;
        String title = CommonUtil.parseString(req.getParameter("title"));
        String reg_date = CommonUtil.parseString(req.getParameter("reg_date"));
        String content = CommonUtil.parseString(req.getParameter("content"));
        String[] hobbies = req.getParameterValues("hobbies");
        String gender = CommonUtil.parseString(req.getParameter("gender"));

        if (!CommonUtil.nullCheck(title)) {
            req.setAttribute("titleNull","null");
            check_flag = false;
        }
        if (!CommonUtil.nullCheck(reg_date)) {
            req.setAttribute("reg_dateNull","null");
            check_flag = false;
        }
        if (!CommonUtil.nullCheck(content)) {
            req.setAttribute("contentNull","null");
            check_flag = false;
        }
        if (!CommonUtil.nullCheck(hobbies)) {
            req.setAttribute("hobbiesNull","null");
            check_flag = false;
        }
        if (!CommonUtil.nullCheck(gender)) {
            req.setAttribute("genderNull","null");
            check_flag = false;
        }

        if(check_flag) {
            System.out.println("수정완료");
            resp.sendRedirect("/bbs/list");
        } else {
            System.out.println("수정실패");
            req.setAttribute("title", title);
            req.setAttribute("reg_date", reg_date);
            req.setAttribute("content", content);
            req.setAttribute("hobbies", Arrays.toString(hobbies));
            req.setAttribute("gender", gender);
            req.getRequestDispatcher("/WEB-INF/bbs/modify.jsp").forward(req, resp);
        }
    }
}
