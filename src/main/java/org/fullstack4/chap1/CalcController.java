package org.fullstack4.chap1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/calc"})
public class CalcController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // webapp > WEB-INF 폴더 하위는 웹에서 직접적으로 접근할 수 없으며, 시스템 내 에서 로직으로만 접근 가능함. => 보완성 강화
        // 그래서 webapp > WEB-INF 폴더 밑으로 메뉴 별로 폴더로 구성하여 프로젝트 진행 함.
        // 매번 로직에서 "/WEB-INF/input.jsp" 이런식으로 작성하는게 번거로울 수 있으니 공통 모듈로 빼서 URL 패턴 작성하는 식으로 구성함.
        req.getRequestDispatcher("/WEB-INF/input.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        System.out.println(String.format("num1 : %s, num2 : %s", num1, num2));

        if (num1.equals("") || num2.equals("") || num1.equals("null") || num2.equals("null")) {
            req.setAttribute("errCode", "1|2");
            req.getRequestDispatcher("/WEB-INF/input.jsp").forward(req,resp);
        } else {
            String result = num1 + "+" + num2;
            req.setAttribute("result", result);
            req.getRequestDispatcher("/WEB-INF/input.jsp").forward(req,resp);
        }

    }
}
