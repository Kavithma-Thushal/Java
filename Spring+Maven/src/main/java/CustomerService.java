import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Service("customerService")
public class CustomerService {
    public void save(String name, String address, double salary) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "1234");

            String sql = "INSERT INTO customers (name, address, salary) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setDouble(3, salary);
            stmt.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}