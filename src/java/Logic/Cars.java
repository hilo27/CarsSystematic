
package Logic;

import View.viewTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Ruslan
 */
public class Cars extends HttpServlet {
        
    String URL = "jdbc:mysql://localhost:3306/cars_database";
    String USERNAME = "root";
    String PASSWORD = "root";

    Connection connection = null;
    PreparedStatement selectCars = null;
    ResultSet resultSet = null;
    
    
//    public ResultSet getCars() {
//       try {
//            resultSet = selectCars.executeQuery();            
//            while (resultSet.next()){
//                resultSet.getString("model");
//                resultSet.getString("color");
//                resultSet.getString("equipment");                
//            }            
//        } catch (SQLException ex) {
//         System.err.println("Unable to connect to database.");
//        }
//        return resultSet;          
//    
//    }
    
    private Collection getAllModels() throws SQLException {
        Collection models = new ArrayList();
        
        resultSet = selectCars.executeQuery(); 
        
        while (resultSet.next()) {            
            models.add(resultSet.getString("model"));           
        }        
        return models;
    }
       
    private Collection getAllColor() throws SQLException {        
        Collection color = new ArrayList();
        
        resultSet = selectCars.executeQuery(); 
        
        while (resultSet.next()) { 
            color.add(resultSet.getString("color"));      
        }        
        return color;
    }
    
    private Collection getAllEquipment() throws SQLException {        
        Collection equipment = new ArrayList();
        
        resultSet = selectCars.executeQuery(); 
        
        while (resultSet.next()) { 
            equipment.add(resultSet.getString("equipment"));     
        }        
        return equipment;
    }
    
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        viewTable form = new viewTable();
        
        try {               
            Class.forName("com.mysql.jdbc.Driver");            
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);            
            selectCars = connection.prepareStatement("SELECT * FROM cars1");
            
            resultSet = selectCars.executeQuery();
                       
            form.setModel(getAllModels());
            form.setColor(getAllColor());
            form.setEquipment(getAllEquipment());
            
                        
            request.setAttribute("form", form);  
            
            getServletContext().getRequestDispatcher("/table.jsp").forward(request, response);
                        
            
        } catch (ClassNotFoundException ex) {           
            response.getWriter().println("<h1>Что-то пошло не так</h1>");
        } catch (SQLException ex) {
            response.getWriter().println("<h1>ошибка базы данных</h1>");
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
    }// </editor-fold>

   

}
