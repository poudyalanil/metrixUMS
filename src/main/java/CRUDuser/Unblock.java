// Unblock id used for ublockking blocked user.
package CRUDuser;

import com.metrix.loginpackage.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author goani
 */
public class Unblock extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Unblock</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Unblock at " + request.getContextPath() + "</h1>");
            int id = Integer.parseInt(request.getParameter("id"));

            try {
                // getting database connection
                UserDAO usdo = new UserDAO(ConnectionProvider.getConnection());
                usdo.unBlockUser(id);
                response.sendRedirect("userList.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
