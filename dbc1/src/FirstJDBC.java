import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJDBC {
	public static void main(String[] args) {
		try {
			// 1. ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!");
			
			// 2. DB�� Ŀ�ؼ�(����)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "lion";  			String pwd = "1234";
			Connection con = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB Connected~~!");
			
			// 3. DB�� SQL���� �����ϱ� ���� Statement ��ü �Ҵ�
			Statement st = con.createStatement();
			String sql = "SELECT * FROM dept"; // ��� ���̺� ��� ��ȸ
			
			// 4. DB�� ������ ����
			ResultSet rs = st.executeQuery(sql);
			// select���� ���� executeQuery(sql)�� �̿�, �̶� ��ȯŸ���� ResultSet
			
			// 5. ResultSet�� Ŀ���� �̵��ϸ鼭 �����͸� �о�� ���
			while (rs.next()) {
				int col1 = rs.getInt(1);
				String col2 = rs.getString(2);
			String col3 = rs.getString(3);
				System.out.println(col1 + "\t" + col2 + "\t" + col3);
			}
			
			// 6. DB�� ����� �ڿ� �ݳ�(����)
			if (rs != null) rs.close();
			if (st != null) st.close();
			if (con != null) con.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e + "=> ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println(e + "=> DB ���� ����");
		}
		// ���� XX.Close()�� finally ��Ͽ� �ۼ�
	}
}