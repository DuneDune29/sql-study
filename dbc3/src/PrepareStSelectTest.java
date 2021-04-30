import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStSelectTest {
	private Connection con;			 private PreparedStatement ps;
    private ResultSet rs;
    
    public PrepareStSelectTest() {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "lion"; 			String db_pw = "1234";
		    con = DriverManager.getConnection(url, db_id, db_pw);
			System.out.println("DB ���� ����");

			String sql = "select empno, ename, sal from emp";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("empno") + " , " 
						+ rs.getString("ename") + " , " + rs.getDouble("sal"));
			}
			rs.close();		;ps.close(); 		con.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e + "=> ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println(e + "=> Sql ����");
		} catch (Exception e) {
			System.out.println(e + "=> �Ϲ� ����");
		}
	}
	public static void main(String[] args) {
		new PrepareStSelectTest();
	}
}