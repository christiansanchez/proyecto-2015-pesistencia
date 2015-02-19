package db_Juego;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CargarDB {

	public static void main(String[] args)  
	{
		//archivo de configuracion
		Properties prop = new Properties();
		WorkingDirectory directory = new WorkingDirectory();		
		String nombreArchivo = directory.RutaJar() + "\\configFiles\\config.properties";
		Connection con = null;		
		try 
		{
			//Se lee el archivo de configuracion
			prop.load( new FileInputStream(nombreArchivo));

			//Cargamos el driver
			String driver = prop.getProperty("driver");			
			Class.forName(driver);
			
			//datos para conexion
			String url = prop.getProperty("url");	
			String user = prop.getProperty("user");	
			String pass = prop.getProperty("pass");
			
			//creo conexion
			con = DriverManager.getConnection(url, user, pass);		
			
			//Falta cargar tablas
			
			
			
			
			
			
			System.out.println("****** FINALIZO CREACION DE ESTRUCTURA Y CARGA DE DATOS CORRECTAMENTE ******");
		} 
		catch (FileNotFoundException e) 
		{		
			e.printStackTrace();
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(con != null)
				{
					con.close();
				}
			}
			catch (SQLException e)
			{			
				e.printStackTrace();
			}
		}	
	}
}

	
	
	
}
