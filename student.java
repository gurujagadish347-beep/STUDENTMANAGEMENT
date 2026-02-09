import java.sql.*;
public class student {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();

            String insert = "INSERT INTO student VALUES (36,'ludu',20,'female')";

            ;
            stmt.executeUpdate(insert);

            String select = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(select);
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getInt("age") + " " +
                                rs.getString("gender")
                );
            }



            String update = "UPDATE student SET gender=null WHERE id=2";
            stmt.executeUpdate(update);

            String delete = "DELETE FROM student WHERE id=2";
            stmt.executeUpdate(delete);

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}