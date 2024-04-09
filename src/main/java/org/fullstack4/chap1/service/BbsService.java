package org.fullstack4.chap1.service;

import org.fullstack4.chap1.dao.BbsDAO;
import org.fullstack4.chap1.domain.BbsVO;
import org.fullstack4.chap1.dto.BbsDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum BbsService {
    INSTANCE;

    public List<BbsDTO> bbsList() {
        List<BbsDTO> bbsDTOS = IntStream.range(0, 10).mapToObj(i -> {
            BbsDTO dto = new BbsDTO();
            dto.setIdx(i);
            dto.setTitle("Bbs Title ... " + i);
            dto.setContent("Bbs Content ... " + i);
            dto.setUser_id("testId");
            dto.setDisplay_date(LocalDate.now().toString());
            dto.setReadCnt(0);
            return dto;
        }).collect(Collectors.toList());

        return bbsDTOS;
    }

    public BbsDTO bbsView(int idx) {
        BbsDTO dto = new BbsDTO();
        dto.setIdx(idx);
        dto.setTitle("Bbs Title ... " + idx);
        dto.setContent("Bbs Content ... " + idx);
        dto.setUser_id("testId");
        dto.setDisplay_date(LocalDate.now().toString());
        dto.setReadCnt(0);
        return dto;
    }

    public void testRegist() throws Exception {
        BbsDAO dao = new BbsDAO();
        BbsVO vo = BbsVO.builder()
                .user_id("test")
                .title("게시글 타이틀 테스트")
                .content("게시글 내용 테스트")
                .display_date(LocalDate.now().toString())
                .build();
        // Builder를 이용해 VO에 값을 알아서 넣는 방법

        System.out.println("결과는? " + dao.regist(vo));
    }
}
