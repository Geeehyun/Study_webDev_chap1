package org.fullstack4.chap1.controller;

import org.fullstack4.chap1.dto.BbsDTO;
import org.fullstack4.chap1.service.BbsService;
import org.fullstack4.chap1.util.CommonUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/bbs/view")
public class BbsViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===================================");
        System.out.println("/bbs/view");
        System.out.println("===================================");
        try {
            int idx = CommonUtil.parseInt(req.getParameter("idx"));
            BbsDTO dto = BbsService.INSTANCE.bbsView(idx);
            req.setAttribute("dto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/views/bbs/view.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
