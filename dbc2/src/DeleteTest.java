import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {
	private Connection con;
	private Statement st;
	
	public DeleteTest(int empno) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "lion";
			String pwd = "1234";
			Connection con = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB ���� ����");

			String sql = "delete from emp where empno=" + empno;
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
	public static void main(String[] args) { new DeleteTest(1); }
}