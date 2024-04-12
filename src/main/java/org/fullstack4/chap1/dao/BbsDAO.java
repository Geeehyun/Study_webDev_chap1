package org.fullstack4.chap1.dao;

import lombok.Cleanup;
import org.fullstack4.chap1.domain.BbsVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BbsDAO {
    public String getTime() {
        String now = null;
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT now()");
                ResultSet rs = preparedStatement.executeQuery();
                // try with resource 방식으로, 리소스를 사용하고 다 쓰면 자동으로 close하는 방식
        ) {
            rs.next();
            now = rs.getString(1);
        } catch (Exception e) {
            System.out.println("Errr : " + e.getMessage());
            e.printStackTrace();
        }
        return now;
    }

    public String getTime2() throws Exception {
        // lombok의 클린업 어노테이션 이용하기 : 리소스 다 쓰고 알아서 close 해줌
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = conn.prepareStatement("SELECT now()");
        @Cleanup ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        String now = rs.getString(1);
        return now;
    }

    public int regist(BbsVO vo) throws Exception {
        int result = 0;
        String sql = "INSERT INTO tbl_bbs (user_id, title, content, display_date)" +
                     " VALUES (?, ?, ?, ?)";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, vo.getUser_id());
        psmt.setString(2, vo.getTitle());
        psmt.setString(3, vo.getContent());
        psmt.setString(4, vo.getDisplay_date());

        result = psmt.executeUpdate();
        return result;
    }

    public List<BbsVO> list() throws Exception {
        String sql = "SELECT idx, user_id, title, content, display_date, readCnt, to_char(reg_date, 'YYYY-MM-DD') as 'reg_date', to_char(modify_date, 'YYYY-MM-DD') as 'modify_date'" +
                " FROM tbl_bbs ORDER BY idx DESC";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = psmt.executeQuery();

        List<BbsVO> bbsList = new ArrayList<>();
        while (rs.next()) {
            BbsVO vo = BbsVO.builder()
                    .idx(rs.getInt("idx"))
                    .user_id(rs.getString("user_id"))
                    .title(rs.getString("title"))
                    .content(rs.getString("content"))
                    .display_date(rs.getString("display_date"))
                    .readCnt(rs.getInt("readCnt"))
                    .reg_date(LocalDate.parse(rs.getString("reg_date")))
                    .modify_date((rs.getString("modify_date") != null) ? (LocalDate.parse(rs.getString("modify_date"))) : (null))
                    .build();
            bbsList.add(vo);
        }
        return bbsList;
    }

    public BbsVO view(int idx) throws Exception {
        BbsVO vo = null;
        String sql = "SELECT idx, user_id, title, content, display_date, readCnt, to_char(reg_date, 'YYYY-MM-DD') as 'reg_date', to_char(modify_date, 'YYYY-MM-DD') as 'modify_date'" +
                " FROM tbl_bbs WHERE idx = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setInt(1, idx);
        @Cleanup ResultSet rs = psmt.executeQuery();

        if(rs.next()) {
            vo = BbsVO.builder()
                    .idx(rs.getInt("idx"))
                    .user_id(rs.getString("user_id"))
                    .title(rs.getString("title"))
                    .content(rs.getString("content"))
                    .display_date(rs.getString("display_date"))
                    .readCnt(rs.getInt("readCnt"))
                    .reg_date(LocalDate.parse(rs.getString("reg_date")))
                    .modify_date((rs.getString("modify_date") != null) ? (LocalDate.parse(rs.getString("modify_date"))) : (null))
                    .build();
        }
        return vo;
    }



    public int modify(BbsVO vo) throws Exception {
        int result = 0;
        String sql = "UPDATE tbl_bbs" +
                     " SET user_id = ?" +
                     " , title = ?" +
                     " , content = ?" +
                     " , display_date = ?" +
                     " , modify_date = now()" +
                     " WHERE idx = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, vo.getUser_id());
        psmt.setString(2, vo.getTitle());
        psmt.setString(3, vo.getContent());
        psmt.setString(4, vo.getDisplay_date());
        psmt.setInt(5, vo.getIdx());
        result = psmt.executeUpdate();
        return result;
    }

    public int delete(int idx) throws Exception {
        int result = 0;
        String sql = "DELETE FROM tbl_bbs" +
                     " WHERE idx = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setInt(1, idx);
        result = psmt.executeUpdate();
        return result;
    }
}
