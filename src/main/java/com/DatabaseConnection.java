package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import org.springframework.stereotype.Controller;



public class DatabaseConnection {

	static public String hostName="ec2-52-54-212-232.compute-1.amazonaws.com";
	static public String DBName="d3juig38qlpane";
	static public String port="5432";
	static public String user = "ispfozezsllypp";
	static public String url ="jdbc:postgresql://ec2-52-54-212-232.compute-1.amazonaws.com:5432/d3juig38qlpane";
	static private String password ="d726cabb37d69cafb3156b57eb2ea3ac90c6c1057506f7317a1d0c7959215a45";
	static public String nameAuthDataTable ="UserAuthData";
	static public String nameUserSignTable ="UserSignDataTable";
	static public String nameOffersTable ="SaleOffersTable";


	static Connection connectionDB;

	public static void createConnect() throws SQLException {

		openConnectionDB();

		closeConnectionDB();

	}



	public static void openConnectionDB()  {


		try{
			Class.forName("org.postgresql.Driver");
			connectionDB= DriverManager
					.getConnection("jdbc:postgresql://"+hostName+":"+port+"/"+DBName+"?user="+user+"&password="+password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}



	}







	public static void closeConnectionDB() throws SQLException {


		//connectionDB.close();



	}





}
