package br.uff.puro.ict.labides.projbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AcessoBDSimplesPostgres {
	
	public static void main(String[] args) {
		try {
			// Registra driver de conex„o com o banco de dados
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("org.postgresql.Driver");
			
			// Obtem conex„o com o banco de dados
//			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bd",
//					  "root", 
//					  "root");
			
			Connection con = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
					  "postgres", 
					  "postgresadmin");
			
			// Cria um objeto que ir· armazenar uma consulta SQL
			Statement stmt = con.createStatement();		
			
			// Executa uma consulta SQL ‡ partir do objeto Statement criado e armazena o resultado
			//numa coleÁ„o ResultSet
			//ResultSet rs = stmt.executeQuery("select * from laptop l;");
			ResultSet rs = stmt.executeQuery("select * from taluno a;");
			
			// Percorre o resultado da consulta
			while (rs.next()) {
//				System.out.print("Modelo: " + rs.getInt("model"));
//				System.out.print(" PreÁo: " + rs.getFloat("price"));
				System.out.print("Nome: " + rs.getString("nome"));
				System.out.print(" CR: " + rs.getDouble("cr"));
				System.out.println();
			}
			
			// Fecha o Statement e a conex„o com o banco de dados
			stmt.close();
			
			/*String stm = "INSERT INTO teste(nome, tipo, contador) VALUES(?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(stm);
			pst.setString(1, "Postgresql");
        	pst.setString(2, "database");                    
        	pst.setInt(3, 1);
			
        	System.out.println("Inicio da execução !!!");
			
        	Timer tempo = new Timer();
			tempo.start();
			
			for (int i=0; i<1000000; i++) {
            	pst.executeUpdate();
			}
			
			tempo.end();
			
			System.out.println("Fim da execução !!!");
			 
			System.out.println(tempo.getTotalTime());
			
			con.close();*/
			
		} catch (ClassNotFoundException e) {
			System.out.println("A classe do driver de conex„o n„o foi encontrada!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Ocorreu erro em alguma operaÁ„o no banco de dados!");
			e.printStackTrace();
		} 
	}
}
