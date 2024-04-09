package org.fullstack4.chap1.controller;

import org.fullstack4.chap1.dto.BbsDTO;
import org.fullstack4.chap1.service.BbsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/bbs/list")
public class BbsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===================================");
        System.out.println("/bbs/list");
        System.out.println("===================================");
        List<BbsDTO> dtoList = BbsService.INSTANCE.bbsList();
        req.setAttribute("list", dtoList);
        req.getRequestDispatcher("/WEB-INF/views/bbs/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
