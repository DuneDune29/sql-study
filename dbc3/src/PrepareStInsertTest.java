import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareStInsertTest {
	private Connection con;			
    private PreparedStatement ps;
	
	public PrepareStInsertTest(int empno, String ename, double sal){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "lion"; 			String db_pw = "1234";
		    con = DriverManager.getConnection(url, db_id, db_pw);
			System.out.println("DB ���� ����");

			String sql = "insert into emp(empno, ename, sal) values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, empno); 			ps.setString(2, ename);  
			ps.setDouble(3, sal);
			int result = ps.executeUpdate();
			System.out.println("ó���� ���ڵ� ����: " + result);
			ps.close(); 		con.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e + "=> ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println(e + "=> Sql ����");
		} catch (Exception e) {
			System.out.println(e + "=> �Ϲ� ����");
		}
	}
	public static void main(String[] args) {
		new PrepareStInsertTest(1, "JavaPris", 100);
	}
}