//AddUserServlet.java is used for adding user by admin
package CRUDuser;
import com.metrix.loginpackage.ConnectionProvider;
import com.metrix.loginpackage.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
public class AddUserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddUserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddUserServlet at " + request.getContextPath() + "</h1>");
            
            // getting form data
            String firstName = request.getParameter("fname");
            String middleName = request.getParameter("mname");
            String lastName = request.getParameter("lname");
            String address   = request.getParameter("address");
            String email = request.getParameter("email");
            String password =request.getParameter("password");
            
        // getting current date
            LocalDate today = LocalDate.now();
        
           // userRole =0 is normal user and userRole=1 is admin
            int userRole = 0;
             // userStatus =0 is blocked and userStatus=1 is active user
            int userStatus = 1;
            
            // creating new User object
            User user = new User(firstName, middleName,lastName,address, email,password,today,userRole,userStatus);
            try{
                // getting database connection
                UserDAO usdao = new UserDAO(ConnectionProvider.getConnection());
                if(usdao.addUser(user)){
                    response.sendRedirect("userList.jsp");
                }else{
                    out.print("Unable to add user");
                }
                
            }catch(Exception e){
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
