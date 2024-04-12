package org.fullstack4.chap1.controller;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.chap1.dto.BbsDTO;
import org.fullstack4.chap1.service.BbsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet("/bbs/list")
public class BbsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===================================");
        System.out.println("/bbs/list");
        System.out.println("===================================");

        ServletContext servletContext = req.getServletContext();
        log.info("appName : " + servletContext.getAttribute("appName"));

        List<BbsDTO> dtoList = null;
        try {
            dtoList = BbsService.INSTANCE.bbsList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("list", dtoList);
        req.getRequestDispatcher("/WEB-INF/views/bbs/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
