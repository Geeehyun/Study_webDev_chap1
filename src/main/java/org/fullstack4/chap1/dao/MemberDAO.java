package org.fullstack4.chap1.dao;

import lombok.Cleanup;
import org.fullstack4.chap1.domain.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    public MemberVO selectMemberInfo(String user_id) throws Exception {
        MemberVO vo = null;
        String sql = "SELECT user_id, name, pwd FROM tbl_member WHERE user_id = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, user_id);
        @Cleanup ResultSet rs = psmt.executeQuery();

        if(rs.next()) {
            vo = MemberVO.builder()
                    .user_id(rs.getString("user_id"))
                    .name(rs.getString("name"))
                    .pwd(rs.getString("pwd"))
                    .build();
        }
        return vo;
    }
}
