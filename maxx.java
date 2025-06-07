package set;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/checkuserdata")
public class maxx extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
       {
    	   String x,y;
    	   x=req.getParameter("t1");
    	   y=req.getParameter("t2");
    	 try
    	 {
    		 Class.forName("org.postgresql.Driver");
    		 
    		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/animal","postgres","Rushi@098");
    		
    	PreparedStatement ps=con.prepareStatement("Select * from users where username='"+x+"' and upass='"+y+"'" );
    		
    		
    		ResultSet rs=ps.executeQuery();
    		if(rs.next()) {
    			res.getWriter().println("<html>");
    			res.getWriter().println("<body>");
    			res.getWriter().print("<h1>Login Succesful<h1>");
    			res.getWriter().println("</html>");
    			res.getWriter().println("</body>");
    		}
    		else
    		{res.getWriter().println("<html>");
			res.getWriter().println("<body>");
			res.getWriter().print("<h1>Login Fail !<h1>");
			res.getWriter().println("</html>");
			res.getWriter().println("</body>");
    		}
    	 } catch(Exception e){
    		 
    		 
    		 
    	 }
    	   
    	   
    	   
       }
	
	
