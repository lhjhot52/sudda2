package sudda2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceImpl implements MemberServiceImpl  {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn = dataSource.getConnection();
	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public int memberInsert(MemberVO vo) {
		int n = 0;
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			psmt.setString(3, vo.getMemberName());
			psmt.setString(4, vo.getMemberPhone());
			psmt.setString(5, vo.getMemberAddress());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	@Override
	public MemberVO login(MemberVO member) {
	    MemberVO vo = new MemberVO();
	    String sql = "SELECT memberPassword FROM USER WHERE memberID = ?";
	    try {
	    	psmt = conn.prepareStatement(sql);
	    	psmt.setString(1, member.getMemberId());
	    	psmt.setString(2, member.getMemberPassword());
	    	rs = psmt.executeQuery();
	    	if(rs.next()) {
	    		vo.setMemberId(rs.getString("memberid"));
	    		vo.setMemberPassword(rs.getString("password"));
	    	}
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
		return vo;
	}

}
