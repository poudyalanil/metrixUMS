
package CRUDuser;

import com.metrix.loginpackage.ConnectionProvider;
import com.metrix.loginpackage.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditUserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditUserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditUserServlet at " + request.getContextPath() + "</h1>");
            
            int iduser = Integer.parseInt(request.getParameter("iduser"));
            String firstName = request.getParameter("fname");
            String middleName = request.getParameter("mname");
            String lastName = request.getParameter("lname");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            LocalDate today = LocalDate.now();
            int userRole = 0;
            int userStatus = 1;

            User user = new User(iduser, firstName, middleName, lastName, address, email, password, today, userRole, userStatus);
            try {
                UserDAO usdao = new UserDAO(ConnectionProvider.getConnection());
                if (usdao.editUserInfo(user)) {
                    response.sendRedirect("userList.jsp");
                } else {
                    out.print("wrong cre3dential");
                }

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
