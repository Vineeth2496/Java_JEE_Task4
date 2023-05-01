

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.properties.jdbcCon;

public class MyntraAction extends GenericServlet {
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Firstname=request.getParameter("fn");
		String Lastname=request.getParameter("ln");
		String Username=request.getParameter("un");
		String Password=request.getParameter("pass");
		
		//PrintWriter out=response.getWriter();
		try
		{
		/*	jdbcCon c=new jdbcCon();
			Connection con=c.con();
			System.out.println(con);
		*/
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "vine96");
			
			System.out.println(con);
			PreparedStatement ps=con.prepareStatement("insert into myntra values(?,?,?,?)");
			ps.setString(1, Firstname);
			ps.setString(2, Lastname);
			ps.setString(3, Username);
			ps.setString(4, Password);
			
			int i=ps.executeUpdate();
			
			PrintWriter out=response.getWriter();
			
			out.println("Account is Registered: "+ i);
		
		
		}
		catch (Exception e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
