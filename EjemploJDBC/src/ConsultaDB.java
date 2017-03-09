import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author andres.ceballoss
 * Clase para realizar consultas a la base de datos usando JDBC
 *
 */
public class ConsultaDB {
	
	public static void consultCities(){
		
		Connection con = null; //Create the connection
		PreparedStatement ps = null; //Create the query
		ResultSet rs = null; //Iterate over the result
		try{
			Class.forName("com.mysql.jdbc.Driver");		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceballos","root","root");
			ps = con.prepareStatement("SELECT * FROM ciudades");
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("codigo") + ": " + rs.getString("Nombre"));
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main (String[] args) {
		consultCities();		
	}	
	
}
