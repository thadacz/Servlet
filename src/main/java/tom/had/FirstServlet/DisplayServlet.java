package tom.had.FirstServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DisplayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String[][] rs = (String[][]) req.getAttribute("result");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>");
        out.println("Id");
        out.println("</th>");
        out.println("<th>");
        out.println("Brand");
        out.println("</th>");
        out.println("<th>");
        out.println("Name");
        out.println("</th>");
        out.println("<th>");
        out.println("Year");
        out.println("</th>");
        out.println("<th>");
        out.println("Fuel");
        out.println("</th>");
        out.println("<th>");
        out.println("GearBox");
        out.println("</th>");
        out.println("<th>");
        out.println("CarType");
        out.println("</th>");
        out.println("</tr>");
        for (int i = 0; i < rs.length; i++) {
            out.print("<tr>");
            for (int j = 0; j < 7; j++) {
                out.print("<td>");
                out.print(rs[i][j]);
                out.print("</td>");
            }
            out.print("</tr>");
        }
        out.println("</table>");
    }
}
