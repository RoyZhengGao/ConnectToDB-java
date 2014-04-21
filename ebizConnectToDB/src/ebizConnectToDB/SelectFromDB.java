package ebizConnectToDB;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;


public class SelectFromDB {
	
	ConnectingToMysql connecting;
	static Connection connection;
	static private String tableName="consumerreview";



	public SelectFromDB() {

		
	}
	public static void main(String[] args){
		try {
			ConnectingToMysql connecting = new ConnectingToMysql();
			connection = connecting.Get_Connection();
			//System.out.println("year");
		} catch (Exception e) {
			System.out.println(e);
		}
	String year="2000";
	String make="subaru";
	String model="forester";
	String score="";
	String review="";
	ResultSet rs;
	java.sql.Statement ps;
	//System.out.println(year);
	try{
		ps = connection.createStatement();
//		Statement ps =connection.createStatement();	
		rs = ps.executeQuery("SELECT year,make,model,score,review FROM "
				+tableName+" WHERE year="+year+" And make= '"+make+"' And model= '"+model+"'");
		while (rs.next()) {
           String year2=rs.getString("year");
           String make2=rs.getString("make");
           String model2=rs.getString("model");
           String score2=rs.getString("score");
           String review2=rs.getString("review");
            System.out.println("year score review \n"); 
            System.out.println(year2+score2+review2); 
        }
		
		//rs.close();
	}catch (Exception e){
		System.out.println(e);
	}
}
}
