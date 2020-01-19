package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;






public class SiteManager  {
	private Connection con=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
    
    public SiteManager() {
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
    public ArrayList<Site> readAllSite()
	{
		 ArrayList <Site> sites=new ArrayList<Site>();
		try
		{
			st=con.prepareStatement("select numSite,nomSite,lieuSite,tarif_Journalier from site");
			rs=st.executeQuery();
			while(rs.next())
			{
				Site site=new Site();
				site.setNumSite(rs.getString("numSite"));
				site.setNomSite(rs.getString("nomSite"));
				site.setLieuSite(rs.getString("lieuSite"));
				site.setTarifJour(rs.getDouble("tarif_Journalier"));				
				sites.add(site);
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return sites;
	}
    
    public void createSite(Site site)
	{
		try
		{
		 st=con.prepareStatement("insert into site(numSite,nomSite,lieuSite,tarif_Journalier)values(?,?,?,?)");
		 st.setString(1,site.getNumSite());
		 st.setString(2,site.getNomSite());
		 st.setString(3,site.getLieuSite());
		 st.setDouble(4,site.getTarifJour());

			st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
    
    public Site readSite(String numSite)
	{
		Site site=null;
		try
		{
			st=con.prepareStatement("select * from site where numSite=?");
			st.setString(1,numSite);
			rs=st.executeQuery();
			if(rs.next())
			{
				 site=new Site();
					site.setNumSite(rs.getString("numSite"));
					site.setNomSite(rs.getString("nomSite"));
					site.setLieuSite(rs.getString("lieuSite"));
					site.setTarifJour(rs.getDouble("tarif_Journalier"));				
					
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return site;
	}
    
    public void updateSite(Site site)
	{
		try
		{
			st=con.prepareStatement("update site set nomSite=?,lieuSite=?,tarif_Journalier=? where numSite=?");
			
			st.setString(1,site.getNomSite());
			 st.setString(2, site.getLieuSite());
			 st.setDouble(3, site.getTarifJour());
			 st.setString(4, site.getNumSite());
			
			st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
    
    public void deleteSite(String numSite)
	{
		try
		{
		st=con.prepareStatement("delete from site where numSite=?");
		st.setString(1,numSite);
		st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}

}
