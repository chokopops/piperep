
package ctrl;

import model.User;
import static utils.Constants.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet {


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        User myUser = new User();
        myUser.setLogin(request.getParameter("loginForm"));
        myUser.setPwd(request.getParameter("passForm"));

        if(checkCredentials(myUser)){
            try {

                conn = DataServices.connect(conn);
                listOfFriends =  DataServices.getFriends(listOfFriends,conn);

                request.setAttribute("keyListOfFriends",listOfFriends);
                request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);

            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        } else {
            request.setAttribute("errorMessage", "invalid info : Please try again");
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }
    }

    private boolean checkCredentials(User myUser){
        String goodLogin = this.getServletConfig().getInitParameter(GOOD_LOGIN);
        String goodPwd = this.getServletConfig().getInitParameter(GOOD_PWD);
        return myUser.getLogin().equals(goodLogin) && myUser.getLogin().equals(goodPwd);
    }
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);


    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
