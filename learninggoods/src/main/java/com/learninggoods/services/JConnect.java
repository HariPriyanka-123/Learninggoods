package com.learninggoods.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;



@Service
public class JConnect{

	public static final String URL="jdbc:mysql://localhost:3306/priyatest";
	public static final String USR="root";
	public static final String PWD="priya1234";

	
	public static Connection getConnection(){
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=(Connection)DriverManager.getConnection(URL,USR,PWD);
		return con;
		}catch(Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	public static Statement getStatement() {
		try {
		return (Statement) getConnection().createStatement();
		}catch(SQLException exception){
			exception.printStackTrace();
			return null;
		}
		}
	
	public static PreparedStatement getPreparedStatement(String sql) {
		try {
			return (PreparedStatement) getConnection().prepareStatement(sql);
		}catch(SQLException exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
}
