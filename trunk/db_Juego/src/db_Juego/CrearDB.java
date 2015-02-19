package db_Juego;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearDB{
	
	public static void main(String[] args) {
		try{
			//cargo driver
			String driver = "com.mysql.jdbc.Driver";	
			Class.forName(driver);
		
			String url = "jdbc:mysql://localhost:3306/";
			
			System.out.println("********** CONECTANDO MYSQL **********");
			//creo conexion
			Connection con = DriverManager.getConnection(url, "root", "admin");
			
			System.out.println("********** CONECTADO MYSQL **********");
			//Creamos la DB correspondiente al juego
			System.out.println("********** CREANDO BASE DE DATOS **********");
			String createDB = "CREATE DATABASE juego;";
			PreparedStatement pstmt = con.prepareStatement(createDB);	
			int cant = pstmt.executeUpdate();
			pstmt.close();	
			System.out.println("********** CREADA BASE DE DATOS **********");
			//seteo la db a usar 
			String strSetDB = "Use juego;";
			pstmt = con.prepareStatement(strSetDB);	
			cant = pstmt.executeUpdate();
			pstmt.close();		
			System.out.println("********** CREANDO TABLAS **********");
				
			
			String createTableRoles = "CREATE TABLE roles (" +
				"tipo_rol enum('Carguero', 'Lancha') NOT NULL PRIMARY KEY, " +
				"UNIQUE KEY (tipo_rol)" +
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;";	
			pstmt = con.prepareStatement(createTableRoles);	
			cant = pstmt.executeUpdate();
			pstmt.close();
			System.out.println("********** TABLA Roles ok **********");
			
			
			String createTableFigura = "CREATE TABLE figuras (" +
				"id_figura INT NOT NULL PRIMARY KEY, " +
				"posX INT NOT NULL, " + 
				"posY INT NOT NULL, " +
				"angulo INT NOT NULL, " +
				"UNIQUE KEY (id_figura)" +
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;";	
			pstmt = con.prepareStatement(createTableFigura);	
			cant = pstmt.executeUpdate();
			pstmt.close();
			System.out.println("********** TABLA Figuras ok **********");
		
			
			String createTableCrearPartidas = "CREATE TABLE partidas (" +
				"id_partida INT NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
				"nombre VARCHAR(45) NOT NULL, " +
				"jugador1 VARCHAR(45) NOT NULL, " +
				"jugador2 VARCHAR (45) NOT NULL, " +
				"tipo_mapa enum('MarAbierto', 'Islas') NOT NULL, " +
				"estado enum ('Creada', 'EnCurso', 'Terminada') NOT NULL, " +
				"UNIQUE KEY (id_partida)" +
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
			pstmt = con.prepareStatement(createTableCrearPartidas);	
			cant = pstmt.executeUpdate();
			pstmt.close();
			System.out.println("********** TABLA Partidas ok **********");
			
			String createTableFigurasPartidas = "CREATE TABLE figuras_partidas (" +
					"id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
					"id_partida INT NOT NULL, " +
					"id_figura INT NOT NULL, " +
					"posicion_x INT NOT NULL, " +
					"posicion_y INT NOT NULL, " +
					"impactosPermitidos INT NOT NULL, " +
					"mangueras INT NOT NULL, " +
					"FOREIGN KEY (id_partida) REFERENCES partidas(id_partida) ON DELETE CASCADE, " +
					"FOREIGN KEY (id_figura) REFERENCES figuras(id_figura)" +				
					 ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";			
			pstmt = con.prepareStatement(createTableFigurasPartidas);	
			cant = pstmt.executeUpdate();
			pstmt.close();
			System.out.println("********** TABLA Figuras Partidas ok **********");
		
			
			
			System.out.println("********** TABLAS CREADAS **********");
			//cerramos la conexion hacia la base de datos
			con.close();
			System.out.println("********** DESCONECTADO MYSQL **********");
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
}
