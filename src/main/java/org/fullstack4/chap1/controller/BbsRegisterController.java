package org.fullstack4.chap1.controller;

import org.fullstack4.chap1.dao.BbsDAO;
import org.fullstack4.chap1.domain.BbsVO;
import org.fullstack4.chap1.dto.BbsDTO;
import org.fullstack4.chap1.service.BbsService;
import org.fullstack4.chap1.util.CommonUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/bbs/regist")
public class BbsRegisterController extends HttpServlet {
    private BbsService service = BbsService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/bbs/regist.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        boolean check_flag = true;
        String title = CommonUtil.parseString(req.getParameter("title"));
        String content = CommonUtil.parseString(req.getParameter("content"));
        String display_date = CommonUtil.parseString(req.getParameter("display_date"));
        int readCnt = 0;
        if (!CommonUtil.nullCheck(title)) {
            req.setAttribute("titleNull","null");
            check_flag = false;
        }
        if (!CommonUtil.nullCheck(display_date)) {
            req.setAttribute("display_dateNull","null");
            check_flag = false;
        }
        if (!CommonUtil.nullCheck(content)) {
            req.setAttribute("contentNull","null");
            check_flag = false;
        }
        if(check_flag) {
            BbsDTO bbsDTO = BbsDTO.builder()
                    .user_id("test")
                    .title(title)
                    .content(content)
                    .display_date(display_date)
                    .readCnt(readCnt)
                    .build();
            int result = 0;
            try {
                result = service.regist(bbsDTO);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (result > 0) {
                System.out.println("등록완료");
                resp.sendRedirect("/bbs/list");
            } else {
                System.out.println("등록실패");
                req.getRequestDispatcher("/WEB-INF/views/bbs/regist.jsp").forward(req, resp);
            }
        } else {
            System.out.println("등록실패");
            req.setAttribute("title", title);
            req.setAttribute("display_date", display_date);
            req.setAttribute("content", content);
            req.getRequestDispatcher("/WEB-INF/views/bbs/regist.jsp").forward(req, resp);
        }
    }
}
