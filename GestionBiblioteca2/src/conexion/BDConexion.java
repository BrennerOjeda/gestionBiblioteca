package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDConexion {
	private Connection conexion = null; 
	 public void conectar(){	
			String db = "gestionbiblioteca";
			String driver = "org.gjt.mm.mysql.Driver";
			String host = "localhost:3306";
			String user = "bregre";
			String pass = "bdgestion";
			String url = "jdbc:mysql://"+host+"/"+db;
			try{
				Class.forName(driver);
				conexion = DriverManager.getConnection(url,user,pass);
				System.out.println("Conexion exitosa");
							
			}catch(Exception e){
				System.out.println("Error al conectarse con la BD");
				 e.printStackTrace();
			}
		}
	    
	    public void cerrarConexion() {
			try {
				conexion.close();
			}catch (Exception e) {
				System.out.println("Error al cerrar la conexion.");
			}
		}
	    
	    public void nuevoUsuario(int docIdeUsu, String nomUsu, String apeUsu,int telUsu, String dirUsu, String emaUsu, String passUsu ){
	    	try{
		    	Statement s = conexion.createStatement();
				s.executeUpdate("INSERT INTO usuario VALUES ("+docIdeUsu+",'"+nomUsu+"','"+apeUsu+"',"+telUsu+",'"+dirUsu+"',NULL,'"+emaUsu+"','"+passUsu+"','solicitar')");
				//s.executeUpdate("insert into usuario values ('2334','gre','',2345,'','','','','')");
		    	//cerrarConexion();
	    	
		    }
			catch(SQLException e){//error en sql
				e.printStackTrace();
			}		
	    }
	    public ResultSet seleccionar(){
	    	ResultSet resultado = null;;
	    	try{
		    	Statement s = conexion.createStatement();
				resultado = s.executeQuery("SELECT * FROM Usuario");
				//cerrarConexion();		
	    	}
	    	catch(SQLException e){//error en sql
				e.printStackTrace();
			}
	    	return resultado;
	    }
	    	
	    public static void main(String[] args) {
	    	// YAYAYAYAYA UNA VES MAS
	    	/// yoyo greis
	    	// modificando
			BDConexion bd = new BDConexion();
			bd.conectar();
			bd.nuevoUsuario(2324,"gre","",2345,"","","");
		}

		

}
