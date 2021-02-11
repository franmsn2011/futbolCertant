package maven_jpa.futbol.dao.interfaces;
import java.sql.*;  
public class OracleConnection {
	public static void main(String args[]){  
	try{  
	//step1 load the driver class  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	  System.out.println("asd");
	//step2 create  the connection object  
	Connection con=DriverManager.getConnection(  
	"jdbc:oracle:thin:@NABOO2:1521/NABOO12C","CAPACITACIONES_DESA","CAPACITACIONES_DESA");  
	  if(con != null) {
		  System.out.println("Exito");
	  }
	//step3 create the statement object  
	//Statement stmt=con.createStatement();  
	  
	//step4 execute query  
	//ResultSet rs=stmt.executeQuery("select * from emp");  
	//while(rs.next())  
	//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	  
	//step5 close the connection object  
	con.close();  
	  
	}catch(Exception e){ System.out.println(e);}  
	  
	}  
}
