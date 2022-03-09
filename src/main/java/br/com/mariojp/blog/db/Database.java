package br.com.mariojp.blog.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

	public static void main(String[] args) {
		
		/**
		 * Formas de String de conexão
		 * 
		 * Memoria:  jdbc:hsqldb:mem:mymemdb
		 * Arquivo:  jdbc:hsqldb:file:./db/myfile.db
		 * Servidor: jdbc:hsqldb:hsql://localhost/serverdb
		 * porta padrão 9001
		 * 
		 */
		String url = "jdbc:hsqldb:mem:mymemdb";
		
		String user = "SA";
		String password = "";
		Connection connection = null;
		
		try {
			 connection = DriverManager.getConnection(url,user,password);
			 System.out.println("Conectou");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlCreate = "CREATE TABLE news (id integer PRIMARY KEY, "
				+ "title varchar(50) not null,"
				+ "desc varchar(5000) not null )";
		
		String sqlInsert = "INSERT  INTO news "
				+ "values(1,'Title New','News for test')";
		
		try {
			connection.createStatement().execute(sqlCreate);
			connection.createStatement().execute(sqlInsert);
			System.out.println("Criou e Inseriu");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sqlListar = "SELECT id,title,desc from news";
		
		ResultSet resultSet;
		try {
			resultSet = connection.createStatement().executeQuery(sqlListar);
			while(resultSet.next()) {
				System.out.println(resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
