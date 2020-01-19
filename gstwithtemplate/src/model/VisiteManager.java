package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VisiteManager {
	private Connection con=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	
	public VisiteManager() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionsite","root","");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Probleme de pilote base de donnèes");
			System.out.println(e.getMessage());
		}
		catch(SQLException ex)
		{
			System.out.println("Probleme de connexion ou de requetes");
			System.out.println(ex.getMessage());
		}
	}
 
	public ArrayList<Visite> readAllVisite() {
		ArrayList<Visite> visites = new ArrayList<Visite>();
		try {
			st=con.prepareStatement("SELECT visiteur.nomVisiteur,site.nomSite,site.tarif_Journalier,visite.numVisite,visite.numVisiteur,visite.numSite, visite.nbJour,visite.dateVisite FROM visiteur,site,visite WHERE visite.numVisiteur=visiteur.numVisiteur and visite.numSite=site.numSite ");
			rs=st.executeQuery();
			while(rs.next()) {
				Visite visite =new Visite();
				visite.setNumVisite(rs.getInt("numVisite"));
				visite.setNumSite(rs.getString("numSite"));
				visite.setNumVisiteur(rs.getString("numVisiteur"));
				visite.setNbJour(rs.getInt("nbJour"));
				visite.setDateVisite(rs.getString("dateVisite"));
				visite.setNomSite(rs.getString("nomSite"));
				visite.setNomVisiteur(rs.getString("nomVisiteur"));
				visite.setTarifJour(rs.getDouble("tarif_Journalier"));
				//visite.setTotal(rs.getDouble("total"));
				visites.add(visite);
				//sum(site.tarif_Journalier) as total ,
			}
			
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return visites;
	}
	
	public void createVisite(Visite visite)
	{
		try {
			st= con.prepareStatement("INSERT INTO visite (numVisiteur,numSite,nbJour,dateVisite) VALUES (?,?,?,?)" );
			st.setString(1, visite.getNumVisiteur());
			st.setString(2, visite.getNumSite());
			st.setInt(3, visite.getNbJour());
			st.setString(4, visite.getDateVisite());
			st.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Visite readVisite(int numVisite)
	{
		Visite visite =null;
		try {
			st=con.prepareStatement("SELECT visiteur.nomVisiteur,site.nomSite,visite.numVisite,visite.numVisiteur,visite.numSite, visite.nbJour,visite.dateVisite FROM visiteur,site,visite WHERE visite.numVisiteur=visiteur.numVisiteur and visite.numSite=site.numSite and visite.numVisite=?");
			st.setInt(1, numVisite);
			rs=st.executeQuery();
			if(rs.next())
			{
				visite=new Visite();
				visite.setNumVisite(rs.getInt("numVisite"));
				visite.setNumSite(rs.getString("numSite"));
				visite.setNumVisiteur(rs.getString("numVisiteur"));
				visite.setNbJour(rs.getInt("nbJour"));
				visite.setDateVisite(rs.getString("dateVisite"));
				visite.setNomSite(rs.getString("nomSite"));
				visite.setNomVisiteur(rs.getString("nomVisiteur"));
				
			}
		} 
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return visite;
	}
	
	public Visite totalPrix()
	{
		Visite visite =null;
		try {
			st=con.prepareStatement("select nomSite,SUM(tarif_Journalier*nbJour) as total from visiteur,site,visite WHERE visite.numVisiteur=visiteur.numVisiteur and visite.numSite=site.numSite" );
			
			rs=st.executeQuery();
			if(rs.next())
			{
				visite=new Visite();
				visite.setTotal(rs.getDouble("total"));	
				visite.setNomSite(rs.getString("nomSite"));
			}
		} 
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return visite;
	}
	
	public void deleteVisite(int numVisite)
	{
		try {
			st=con.prepareStatement("delete from visite where numVisite=?");
			st.setInt(1,numVisite);
			st.executeUpdate();
		}
		catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		
	}
	
	public void updateVisite(Visite visite)
	{
		try {
			st=con.prepareStatement("update visite set numVisiteur=?,numSite=?,nbJour=?,dateVisite =? WHERE numVisite=?");
			st.setString(1, visite.getNumVisiteur());
			st.setString(2, visite.getNumSite());
			st.setInt(3, visite.getNbJour());
			st.setString(4, visite.getDateVisite());
			st.setInt(5, visite.getNumVisite());
			st.executeUpdate();
			
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Visite> rechercheSiteEtAnnee(String annee,String nomsite)
	{
		ArrayList<Visite> visites = new ArrayList<Visite>();
		
		try
		{
	st=con.prepareStatement("SELECT visiteur.nomVisiteur,site.nomSite,site.tarif_Journalier,visite.nbJour,visite.dateVisite FROM visiteur,site,visite WHERE visite.numVisiteur=visiteur.numVisiteur and visite.numSite=site.numSite and visite.dateVisite LIKE ? AND site.nomSite LIKE ?");
		 st.setString(1, annee);
		 st.setString(2,nomsite);
		rs =st.executeQuery();
		while(rs.next())
		 {
			 Visite visite =new Visite();
			 visite.setNomVisiteur(rs.getString("nomVisiteur"));
			 visite.setNomSite(rs.getString("nomSite"));
			 visite.setTarifJour(rs.getDouble("tarif_Journalier"));
			 visite.setNbJour(rs.getInt("nbJour"));
			 visite.setDateVisite(rs.getString("dateVisite"));
			 
			 visites.add(visite);
		 }
		}
																																				
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return visites;
	}
	
	public Visite totalPrix(String annee,String nomsite)
	{
		Visite visite =null;
		try {
			st=con.prepareStatement("select nomSite,SUM(tarif_Journalier*nbJour) as total from visiteur,site,visite WHERE visite.numVisiteur=visiteur.numVisiteur and visite.numSite=site.numSite and visite.dateVisite LIKE ? and site.nomSite LIKE ?");
			st.setString(1, annee);
			st.setString(2,nomsite);
			rs=st.executeQuery();
			if(rs.next())
			{
				visite=new Visite();
				visite.setTotal(rs.getDouble("total"));	
				visite.setNomSite(rs.getString("nomSite"));
			}
		} 
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return visite;
	}
	
	public ArrayList<Visite> recherche2Date(String date1,String date2,String nomsite)
	{
		ArrayList<Visite> visites = new ArrayList<Visite>();
		
		try
		{
	st=con.prepareStatement("SELECT visiteur.nomVisiteur, site.nomSite,site.tarif_Journalier, visite.numVisite,visite.numVisiteur, visite.numSite, visite.nbJour,visite.dateVisite FROM visiteur,site,visite WHERE visite.numVisiteur=visiteur.numVisiteur and visite.numSite=site.numSite and site.nomSite LIKE ? and visite.dateVisite BETWEEN ? and ?" );
		 st.setString(1, nomsite);
		 st.setString(2,date1);
		 st.setString(3, date2);
		rs =st.executeQuery();
		while(rs.next())
		 {
			 Visite visite =new Visite();
			 visite.setNomVisiteur(rs.getString("nomVisiteur"));
			 visite.setNomSite(rs.getString("nomSite"));
			 visite.setTarifJour(rs.getDouble("tarif_Journalier"));
			 visite.setNbJour(rs.getInt("nbJour"));
			 visite.setDateVisite(rs.getString("dateVisite"));
			 
			 visites.add(visite);
		 }
		}
																																				
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return visites;
	}
	
	public Visite totalPrix(String date1,String date2,String nomsite)
	{
		Visite visite =null;
		try {
			st=con.prepareStatement("select nomSite,SUM(tarif_Journalier*nbJour) as total from visiteur,site,visite WHERE visite.numVisiteur=visiteur.numVisiteur and visite.numSite=site.numSite and  site.nomSite LIKE ? and visite.dateVisite BETWEEN ? and ?");
			 st.setString(1, nomsite);
			 st.setString(2,date1);
			 st.setString(3,date2);
			rs=st.executeQuery();
			if(rs.next())
			{
				visite=new Visite();
				visite.setTotal(rs.getDouble("total"));	
				visite.setNomSite(rs.getString("nomSite"));
			}
		} 
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return visite;
	}
	
	public ArrayList<Visite> readAllVisiteBySite()
	{
		ArrayList<Visite> visites = new ArrayList<Visite>();
		try
		{
			st=con.prepareStatement("select count(site.nomSite) as effectif,sum(visite.nbJour*site.tarif_Journalier) as total, site.nomSite FROM visite,site WHERE visite.numSite=site.numSite GROUP BY site.nomSite order by site.nomSite");
			rs=st.executeQuery();
			while(rs.next())
			{
				Visite visite =new Visite();
				visite.setTotal(rs.getDouble("total"));
				visite.setNomSite(rs.getString("nomSite"));
				visite.setNbVisiteur(rs.getInt("effectif"));
				visites.add(visite);
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return visites;
	}
}
