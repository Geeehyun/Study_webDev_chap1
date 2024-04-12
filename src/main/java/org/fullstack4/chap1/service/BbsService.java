package org.fullstack4.chap1.service;

import org.fullstack4.chap1.dao.BbsDAO;
import org.fullstack4.chap1.domain.BbsVO;
import org.fullstack4.chap1.dto.BbsDTO;
import org.fullstack4.chap1.util.MapperUtil;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum BbsService {
    INSTANCE;
     private BbsDAO dao;
     private ModelMapper modelMapper;

    BbsService() {
        dao = new BbsDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();
    }
    public List<BbsDTO> bbsList() throws Exception {
        List<BbsVO> bbsVOList = dao.list();
        List<BbsDTO> bbsDTOList = bbsVOList.stream()
                .map(vo -> modelMapper.map(vo, BbsDTO.class))
                .collect(Collectors.toList());
        // 원래라면 하나하나 get해서 set 해야하는데 steam 이랑 modelMapper로 간단히 할 수 있음.
        return bbsDTOList;
    }

    public BbsDTO bbsView(int idx) throws Exception {
        BbsDTO dto = new BbsDTO();
        BbsVO bbsVO = dao.view(idx);
        if (bbsVO != null) {
            dto = modelMapper.map(bbsVO, BbsDTO.class);
        } else {
            dto = null;
        }
        return dto;
    }

    public int regist(BbsDTO bbsDTO) throws Exception {
        BbsVO bbsVO = modelMapper.map(bbsDTO, BbsVO.class);
        return dao.regist(bbsVO);
    }

    public int modify(BbsDTO bbsDTO) throws Exception {
        BbsVO bbsVO = modelMapper.map(bbsDTO, BbsVO.class);
        return dao.modify(bbsVO);
    }

    public int delete(int idx) throws Exception {
        return dao.delete(idx);
    }
}
