package footprints.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//http://fengyongfa2006.blog.163.com/blog/static/3665465920106288451611/
public class HsqlDemo {
	public static void main(String[] args) {
		runInMem();
	}

	public static void runInMem() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection c = DriverManager.getConnection(
					"jdbc:hsqldb:mem:.", "sa", "");
			if (c != null) {
				System.out.println("Connected db success!");
				String sql = "CREATE TABLE TBL_USERS(ID INTEGER, NAME VARCHAR(100), BIRTHDAY DATE);";
				Statement st = c.createStatement();
				st.execute(sql);
				sql = "INSERT INTO TBL_USERS(ID, NAME, BIRTHDAY) VALUES ('1', 'ADMIN', SYSDATE);";
				st.executeUpdate(sql);
				
				sql = "select * from tbl_users;";
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					System.out.println(id + "--" + name);
				}
				
				if (st != null) {
					st.close();
				}
				c.close();
			}
		} catch (Exception e) {
			System.out.println("ERROR:failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
			return;
		}
	}

	public static void runOnServer() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection c = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost:9001/mydb", "sa", "");
			if (c != null) {
				System.out.println("Connected db success!");
				String sql = "CREATE TABLE TBL_USERS(ID INTEGER, NAME VARCHAR(100), BIRTHDAY DATE);";
				Statement st = c.createStatement();
				st.execute(sql);
				sql = "INSERT INTO TBL_USERS(ID, NAME, BIRTHDAY) VALUES ('1', 'ADMIN', SYSDATE);";
				st.executeUpdate(sql);
				if (st != null) {
					st.close();
				}
				c.close();
			}
		} catch (Exception e) {
			System.out.println("ERROR:failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
			return;
		}
	}
}