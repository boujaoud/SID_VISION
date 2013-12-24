package ensa5.sid.radars;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Connexion {
	
	private Connection laConnection;
	private Statement transmission;
	private ResultSet leResultat;
	
	
	public void stockerItem(int val0,String val1,int val2,int val3) 
	{
	 
	
		try{
		Class.forName("com.mysql.jdbc.Driver");
		laConnection =DriverManager.getConnection("jdbc:mysql://localhost:3306/bdsid","root","jamal");
		transmission =laConnection.createStatement();
		
		String sql="INSERT INTO `items` (`idItem`, `nom_long`, `numero_item`, `idAnalyseChamp`) VALUES("+val0+",'"+val1+"',"+val2+","+val3+")";
		System.out.println(sql);
		transmission.executeUpdate(sql);
		
		
		}catch(Exception e){
		
			//System.out.print("Impossible de se connecter à la base de données");
			System.out.println(e.getCause()+e.getMessage());
		}
		}
	public void stockerCollaboration(int val0,int val2,int val3,String date) 
	{
	 
	
		try{
		Class.forName("com.mysql.jdbc.Driver");
		laConnection =DriverManager.getConnection("jdbc:mysql://localhost:3306/bdsid","root","jamal");
		transmission =laConnection.createStatement();
		
		String sql="INSERT INTO `Collaborations`(`numero_1`, `numero_2`, `nbr_collaboration`, `date`) VALUES ("+val0+","+val2+","+val3+",'"+date+"')";
		System.out.println(sql);
		transmission.executeUpdate(sql);
		
		
		}catch(Exception e){
		
			//System.out.print("Impossible de se connecter à la base de données");
			System.out.println(e.getCause()+e.getMessage());
		}
		}
	
	

}
