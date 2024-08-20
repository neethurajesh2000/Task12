package com.jdbcTask;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class task12 {

	public static void main(String[] args) {
		
		//database information
		String db_url="jdbc:mysql://localhost:3306/";
		String username="root";
		String password="root";
		try {
			//Establish the connection
			Connection conn=DriverManager.getConnection(db_url,username,password);
			
			//validate connection is sucess.
			if(conn!=null) {
				System.out.println("The database connection is successful");
			}else {
				System.out.println("The database connection is not successful");
			}
			
			//Create reference to Statement ->create,insert 			
			Statement stmt=conn.createStatement();
			
			// statement ->create,insert, select
			String createDB="create database jat20task";
			String use="use jat20task";
			String creatable="create table empinfo(empcode int,empname varchar(10),empage int,empsalary int)";
			String insert="insert into empinfo values(101,'Jenny',25,10000),"+ "(102,'Jacky',30,20000),"+ "(103,'Joe',20,40000),"+ "(104,'John',40,80000),"+ "(105,'Shameer',25,90000)";
			String select="select * from empinfo";
			
			stmt.execute(createDB);
			stmt.execute(use);
			stmt.execute(creatable);
			stmt.execute(insert);
			
			//ResultSet
			ResultSet rs=stmt.executeQuery(select);
			
             System.out.println("=====================================");
			
			while(rs.next()) {
				System.out.println(rs.getInt("empcode")+" "+rs.getString("empname")+" "+rs.getInt("empage")+" "+rs.getInt("empsalary"));
				
			}
			
//			close the connection object
			conn.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
