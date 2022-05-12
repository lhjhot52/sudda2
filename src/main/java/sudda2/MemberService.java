package sudda2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberService implements MemberServiceImpl{
	private DataSource dataSource = DataSource.getInstance();
	   private Connection conn = dataSource.getConnection();
	   private PreparedStatement psmt;
	   private ResultSet rs;
	   
	   @Override
	   public int memberInsert(MemberVO vo) {
	      int result = 0;
	      String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?)";
	      
	      try {
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, vo.getMemberId());
	         psmt.setString(2, vo.getMemberPassword());
	         psmt.setString(3, vo.getMemberName());
	         psmt.setString(4, vo.getMemberPhone());
	         psmt.setString(5, vo.getMemberAddress());
	         
	         result = psmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      return result;
	   }

	   @Override
	   public MemberVO login(MemberVO vo) {
	      MemberVO memberVO = new MemberVO();
	      String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
	      try {
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, vo.getMemberId());
	         psmt.setString(2, vo.getMemberPassword());
	         
	         rs = psmt.executeQuery();
	         
	         while(rs.next()) {
	            memberVO.setMemberId(rs.getString("Id"));
	            memberVO.setMemberPassword(rs.getString("Password"));
	            memberVO.setMemberName(rs.getString("Name"));
	            memberVO.setMemberPhone(rs.getString("Phone"));
	            memberVO.setMemberAddress(rs.getString("Address"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return memberVO;
	   
	   }


	}