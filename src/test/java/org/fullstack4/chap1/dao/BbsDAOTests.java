package org.fullstack4.chap1.dao;

import lombok.Cleanup;
import org.fullstack4.chap1.domain.BbsVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BbsDAOTests {
    private BbsDAO dao;

    @BeforeEach
    public void ready() {
        dao = new BbsDAO();
        // 테스트 실행하기전에 꼭 미리 실행해달라는 BeforEach 어노테이션
    }

    @Test
    public void testGetTime() throws Exception {
        System.out.println("BbsDAO.getTime() : " + dao.getTime());
    }

    @Test
    public void testGetTime2() throws Exception {
        System.out.println("BbsDAO.getTime2() : " + dao.getTime2());
    }

    @Test
    public void testRegist() throws Exception {
        BbsVO vo = BbsVO.builder()
                .user_id("test")
                .title("게시글 타이틀 테스트")
                .content("게시글 내용 테스트")
                .display_date(LocalDate.now().toString())
                .build();
        // Builder를 이용해 VO에 값을 알아서 넣는 방법

        System.out.println("결과는? " + dao.regist(vo));
    }

    @Test
    public void testList() throws Exception {
        List<BbsVO> list = dao.list();
        list.forEach(System.out::println);
    }

    @Test
    public void testView() throws Exception {
        BbsVO vo = dao.view(1);
        System.out.println(vo);
    }

    @Test
    public void testModify() throws Exception {
        BbsVO vo = BbsVO.builder()
                .idx(1)
                .user_id("gee")
                .title("게시글 타이틀 수정 테스트")
                .content("게시글 내용 수정 테스트")
                .display_date(LocalDate.now().toString())
                .build();
        System.out.println(dao.modify(vo));
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println(dao.delete(1));
    }
}
