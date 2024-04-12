package org.fullstack4.chap1.controller;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.chap1.dto.BbsDTO;
import org.fullstack4.chap1.service.BbsService;
import org.fullstack4.chap1.util.CommonUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@Log4j2
@WebServlet("/bbs/modify")
public class BbsModifyController extends HttpServlet {
    private BbsService service = BbsService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===================================");
        System.out.println("/bbs/modify");
        System.out.println("===================================");
        int idx = CommonUtil.parseInt(req.getParameter("idx"));
       if (idx <= 0) {
           System.out.println("이상한 idx");
           resp.sendRedirect("/bbs/list");
       } else {
           try {
               BbsDTO dto = service.bbsView(idx);
               req.setAttribute("view",dto);
           } catch (Exception e) {
               log.info("=======================================");
               log.info("수정 에러" + e.getMessage());
               log.info("=======================================");
               e.printStackTrace();
           }
           req.getRequestDispatcher("/WEB-INF/views/bbs/modify.jsp").forward(req,resp);
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        boolean check_flag = true;
        int idx = CommonUtil.parseInt(req.getParameter("idx"));
        String user_id = CommonUtil.parseString(req.getParameter("user_id"));
        String title = CommonUtil.parseString(req.getParameter("title"));
        String display_date = CommonUtil.parseString(req.getParameter("display_date"));
        String content = CommonUtil.parseString(req.getParameter("content"));

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
                    .idx(idx)
                    .user_id(user_id)
                    .title(title)
                    .content(content)
                    .display_date(display_date)
                    .build();
            int result = 0;
            try {
                result = service.modify(bbsDTO);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (result > 0) {
                System.out.println("수정완료");
                resp.sendRedirect("/bbs/list");
            } else {
                System.out.println("등록실패");
                req.setAttribute("view", bbsDTO);
                req.getRequestDispatcher("/WEB-INF/views/bbs/modify.jsp?idx="+idx).forward(req, resp);
            }
        } else {
            System.out.println("수정실패");
            req.setAttribute("title", title);
            req.setAttribute("reg_date", display_date);
            req.setAttribute("content", content);
            req.getRequestDispatcher("/WEB-INF/views/bbs/modify.jsp").forward(req, resp);
        }
    }
}
