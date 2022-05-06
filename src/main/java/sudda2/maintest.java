package sudda2;

import java.sql.Connection;

public class maintest {
	public static void main(String[] args) {
		
		DataSource ds = DataSource.getInstance();
		Connection con = ds.getConnection();
	}
}
