package edu.elon.admin;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import edu.elon.business.User;
import edu.elon.data.BookDB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

//Copyright (c) 2015 Maddie Chili and Lawrence Mullen

/**
 *
 * @author lawrencemullen && maddiechili
 */
public class Servlet extends HttpServlet {

    /**
     *do post method for servlet control
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/home.jsp";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "thanks.jsp";  // default action
        }
        
        // when a book is checked out get information and create a user object
        if (action.equals("checkout")) {            
//           
            url = "/checkout.jsp";
          
        } else if (action.equals("userInput")){
            //set the due date for two weeks from the current date
            GregorianCalendar dueDate = new GregorianCalendar();
            dueDate.add(GregorianCalendar.DATE, 14);
            SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy");
            String dateFormat = fmt.format(dueDate.getTime());
            
            //collect user input 
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String email = request.getParameter("email");
            String title = request.getParameter("title");
            
            //make a new user, set its properties, add user to DB
            User user = new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setTitle(title);
            user.setDueDate(dateFormat);
            BookDB.insert(user);
            ArrayList<User> users = BookDB.selectUsers();
            request.setAttribute("users", users);
            request.setAttribute("title", user.getTitle());
            request.setAttribute("date", user.getDueDate());
            url = "/thanks.jsp";

        } else if (action.equals("delete")){
            String title = request.getParameter("title");
            BookDB.delete(title);
            ArrayList<User> users = BookDB.selectUsers();
            request.setAttribute("users", users);
            url = "/manage.jsp";
        }
        
        else if (action.equals("display_user")) {
            ArrayList<User> copy = BookDB.selectUsers();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");

            for(User x: copy){
                
                try {
                    Date due =  format.parse(x.getDueDate());
                    Date today = new Date();

                    if(today.after(due)){
                        x.setOverdue("Overdue");
                        BookDB.update(x);
                    }
                   
                } catch (ParseException ex) {
                    Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ArrayList<User> users = BookDB.selectUsers();
            request.setAttribute("users", users);
            url = "/manage.jsp";

        } else if (action.equals("goHome")){
            url = "/home.jsp";
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }    
    
    /**
     *do get method for servlet control
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
}