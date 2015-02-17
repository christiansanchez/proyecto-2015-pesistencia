package servidor.persistencia.PoolConexiones;

import java.sql.Connection;

public class Conexion implements IConexion {

	private Connection con;
	
	public Conexion(Connection con)
	{
		this.con = con;
	}
	
	public Connection getConnection()
	{
		return this.con;
	}
	
}