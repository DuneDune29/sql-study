import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	private Connection con;
	private Statement st;

	public InsertTest(int empno, String ename, double sal) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "lion";
			String pwd = "1234";
			Connection con = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB ���� ����");

			String sql = "insert into emp(empno, ename, sal) values(" + empno + ",'" + ename + "'," + sal + ")";
			st = con.createStatement();
			int result = st.executeUpdate(sql);
			// ó���� ���ڵ��� ������ int������ ��ȯ
			// update, insert, delete ���� executeUpdate()�� ���
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
		new InsertTest(1, "Tom", 100);
	}
}