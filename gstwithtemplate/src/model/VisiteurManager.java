package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VisiteurManager {
	private Connection con=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	
	public VisiteurManager() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionsite","root","");
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println("Probleme de pilote base de donnèes");
			System.out.println(ex.getMessage());
		}
		catch(SQLException ex)
		{
			System.out.println("Probleme de connexion ou de requetes");
			System.out.println(ex.getMessage());
		}
		
	
	}
	
	public ArrayList<Visiteur> readAllVisiteur()
	{
		ArrayList<Visiteur> visiteurs =new ArrayList<Visiteur>();
		try
        {
			st= con.prepareStatement("select numVisiteur,nomVisiteur,adresseVisiteur,provenanceVisiteur from visiteur");
			rs=st.executeQuery();
			while(rs.next())
			{
				Visiteur visiteur =new Visiteur();
		        visiteur.setNumVisiteur(rs.getString("numVisiteur"));
		        visiteur.setNomVisiteur(rs.getString("nomVisiteur"));
		        visiteur.setAdresseVisiteur(rs.getString("adresseVisiteur"));
		        visiteur.setProvenanceVisiteur(rs.getString("provenanceVisiteur"));
		        visiteurs.add(visiteur);
			}
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return visiteurs;
	}
	
	public void createVisiteur(Visiteur visiteur)
	{
		try
		{
		 st=con.prepareStatement("insert into visiteur(numVisiteur,nomVisiteur,adresseVisiteur,provenanceVisiteur)values(?,?,?,?)");
		 st.setString(1,visiteur.getNumVisiteur());
		 st.setString(2, visiteur.getNomVisiteur());
		 st.setString(3, visiteur.getAdresseVisiteur());
		 st.setString(4, visiteur.getProvenanceVisiteur());
		 st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public Visiteur readVisiteur(String numVisiteur)
	{
		Visiteur visiteur=null;
		try
		{
			st=con.prepareStatement("select * from visiteur where numVisiteur=?");
			st.setString(1,numVisiteur);
			rs=st.executeQuery();
			if(rs.next())
			{
				visiteur =new Visiteur();
		        visiteur.setNumVisiteur(rs.getString("numVisiteur"));
		        visiteur.setNomVisiteur(rs.getString("nomVisiteur"));
		        visiteur.setAdresseVisiteur(rs.getString("adresseVisiteur"));
		        visiteur.setProvenanceVisiteur(rs.getString("provenanceVisiteur"));
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return visiteur;
	}
	
	public void updateVisiteur(Visiteur visiteur)
	{
		try
		{
			st=con.prepareStatement("update visiteur set nomVisiteur=?,adresseVisiteur=?,provenanceVisiteur=? where numVisiteur=?");
			
			st.setString(1,visiteur.getNomVisiteur());
			 st.setString(2,visiteur.getAdresseVisiteur());
			 st.setString(3,visiteur.getProvenanceVisiteur());
			 st.setString(4,visiteur.getNumVisiteur());
			
			st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	
	 public void deleteVisiteur(String numVisiteur)
		{
			try
			{
			st=con.prepareStatement("delete from visiteur where numVisiteur=?");
			
			st.setString(1,numVisiteur);
			st.executeUpdate();
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		}
}
