import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
	private Connection con;
	private Statement st;

	public UpdateTest(int empno, String ename, double sal) {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "lion";
			String pwd = "1234";
			Connection con = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB ���� ����");

			String sql = "update emp set ename='" + ename + "', sal =" + sal + "where empno=" + empno;
			st = con.createStatement();
			int result = st.executeUpdate(sql);
			System.out.println("ó���� ���ڵ� ����: " + result);
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e + "=> ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println(e + "=> Sql ����");
		} catch (Exception e) {
			System.out.println(e + "=> �Ϲ� ����");
		}
	}
		public static void main(String[] args) {
			new UpdateTest(1, "Javaking", 500);
		}
}
		
