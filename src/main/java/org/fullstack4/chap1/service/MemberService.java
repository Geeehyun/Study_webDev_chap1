package org.fullstack4.chap1.service;

import org.fullstack4.chap1.dao.MemberDAO;
import org.fullstack4.chap1.domain.MemberVO;
import org.fullstack4.chap1.dto.MemberDTO;
import org.modelmapper.ModelMapper;

public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {
        dao = new MemberDAO();
        modelMapper = new ModelMapper();
    }

    public MemberDTO selectMemberInfo(String user_id) throws Exception {
        MemberDTO dto = new MemberDTO();
        MemberVO vo = dao.selectMemberInfo(user_id);
        if(vo != null) {
            dto = modelMapper.map(vo,MemberDTO.class);
        } else {
            dto = null;
        }
        return dto;
    }
}
