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
	      String sql = "INSERT INTO MEMBER VALUES(MEMBERNO.NEXTVAL,?, ?, ?, ?, ?,)";
	      
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
	      String sql = "SELECT * FROM MEMBER WHERE MEMBERID = ? AND MEMBERPASSWORD = ?";
	      try {
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, vo.getMemberId());
	         psmt.setString(2, vo.getMemberPassword());
	         
	         rs = psmt.executeQuery();
	         
	         while(rs.next()) {
	            memberVO.setMemberId(rs.getString("memberId"));
	            memberVO.setMemberPassword(rs.getString("memberPassword"));
	            memberVO.setMemberName(rs.getString("memberName"));
	            memberVO.setMemberPhone(rs.getString("memberPhone"));
	            memberVO.setMemberAddress(rs.getString("memberAddress"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return memberVO;
	   
	   }


	}