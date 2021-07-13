package tom.had.FirstServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseServlet
                extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String CarType = req.getParameter("CarType");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/firstservlet", "root", "");
            Statement statement = connection.createStatement();
            ResultSet temp = statement.executeQuery("SELECT COUNT(*) FROM car WHERE CarType=\"" + CarType + "\"");
            temp.next();
            int rowcount= temp.getInt(1);
            ResultSet rs = statement.executeQuery("SELECT * FROM car WHERE CarType=\"" + CarType + "\"");



            String[][] result = new String[rowcount][7];
            req.setAttribute("result",result);
            int i = 0;
            System.out.println(result.length);
            while (rs.next()) {
                for (int j = 0; j <7 ; j++) {
                    result[i][j]=rs.getString(j+1);
                }
                i++;
            }
            connection.close();
            req.getRequestDispatcher("/display").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
