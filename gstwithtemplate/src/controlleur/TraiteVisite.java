package controlleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Site;
import model.SiteManager;
import model.Visite;
import model.VisiteManager;
import model.Visiteur;
import model.VisiteurManager;




public class TraiteVisite extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RequestDispatcher dispatcher=null;
    private ArrayList<Visiteur> listesVisiteurs=null; 
    private ArrayList<Visite> listesVisite=null;
    private ArrayList<Site> listesSite=null; 
    private  ArrayList<Visite> visiteParSites =null;
    
    public TraiteVisite() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		VisiteurManager visiteurManager=new VisiteurManager();
		SiteManager siteManager=new SiteManager();
		VisiteManager visiteManager=new VisiteManager();
		Visite visite = new Visite();
		listesSite=null;
		listesVisite=null;
		listesVisiteurs=null;
		
		if(path.equals("/listeVisite"))
		{
			listesVisite=visiteManager.readAllVisite();
			Visite prix =new Visite();
			prix= visiteManager.totalPrix();
			request.setAttribute("listesVisite",listesVisite);
			request.setAttribute("prix",prix);
			//response.sendRedirect("readAllVisite.jsp");
			dispatcher=request.getRequestDispatcher("readAllVisite.jsp");
			dispatcher.forward(request, response);
		}
		else if(path.equals("/nouveauVisite"))
		{
			listesSite=siteManager.readAllSite();
			listesVisiteurs=visiteurManager.readAllVisiteur();
			request.setAttribute("listesSites", listesSite);
			request.setAttribute("listesVisiteurs", listesVisiteurs);
			dispatcher=request.getRequestDispatcher("saisiVisite.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(path.equals("/saveVisite")&&request.getMethod().equals("POST"))
		{
			
			String numVisiteur = request.getParameter("numVisiteur");
			String numSite = request.getParameter("numSite");
			int nbJour =Integer.parseInt(request.getParameter("nbJour"));
			String dateVisite =request.getParameter("dateVisite");
			visite.setNumSite(numSite);
			visite.setNumVisiteur(numVisiteur);
			visite.setNbJour(nbJour);
			visite.setDateVisite(dateVisite);
			visiteManager.createVisite(visite);
			
			listesVisite=visiteManager.readAllVisite();
			Visite prix =new Visite();
			prix= visiteManager.totalPrix();
			request.setAttribute("listesVisite",listesVisite);
			request.setAttribute("prix",prix);
			response.sendRedirect("listeVisite");
			
		}
		else if(path.equals("/editerVisite"))
		{
			int numVisite= Integer.parseInt(request.getParameter("numVisite"));
			visite =visiteManager.readVisite(numVisite);
			listesSite=siteManager.readAllSite();
			listesVisiteurs=visiteurManager.readAllVisiteur();
			request.setAttribute("listesSites", listesSite);
			request.setAttribute("listesVisiteurs", listesVisiteurs);
			request.setAttribute("visite", visite);
			dispatcher=request.getRequestDispatcher("editVisite.jsp");
			dispatcher.forward(request, response);
			
		}
		else if(path.equals("/supprimerVisite"))
		{
			int numVisite =Integer.parseInt(request.getParameter("numVisite"));
			visiteManager.deleteVisite(numVisite);
			
			listesVisite=visiteManager.readAllVisite();
			Visite prix =new Visite();
			prix= visiteManager.totalPrix();
			request.setAttribute("listesVisite",listesVisite);
			request.setAttribute("prix",prix);
			response.sendRedirect("listeVisite");
			
		}
		
		else if(path.equals("/updateVisite")&&request.getMethod().equals("POST"))
		{
			String numVisiteur = request.getParameter("numVisiteur");
			String numSite = request.getParameter("numSite");
			int nbJour =Integer.parseInt(request.getParameter("nbJour"));
			String dateVisite =request.getParameter("dateVisite");
			int numVisite = Integer.parseInt(request.getParameter("numVisite"));
			visite.setNumSite(numSite);
			visite.setNumVisiteur(numVisiteur);
			visite.setNbJour(nbJour);
			visite.setDateVisite(dateVisite);
			visite.setNumVisite(numVisite);
			visiteManager.updateVisite(visite);
			listesVisite=visiteManager.readAllVisite();
			Visite prix =new Visite();
			prix= visiteManager.totalPrix();
			request.setAttribute("listesVisite",listesVisite);
			request.setAttribute("prix",prix);
			response.sendRedirect("listeVisite");
		}
		
		else if(path.equals("/chercher"))
		{
			String nomSite = request.getParameter("nomSite");
			String annee = request.getParameter("annee");
			String ans  =request.getParameter("ans");
			String month  =request.getParameter("month");
			String date1=request.getParameter("date1");
			String date2=request.getParameter("date2");
			
			 if(nomSite==null  && date1==null && date2==null && ans==null && month==null && annee==null)
				{
					listesVisite =visiteManager.readAllVisite();
					Visite prix =new Visite();
					prix= visiteManager.totalPrix();
					request.setAttribute("listesVisite",listesVisite);
					request.setAttribute("prix",prix);
					//response.sendRedirect("readAllVisite.jsp");
					dispatcher=request.getRequestDispatcher("chercher.jsp");
					dispatcher.forward(request, response);
				}
			
			else if(nomSite !="" && annee !="")
			{
				listesVisite =visiteManager.rechercheSiteEtAnnee("%"+annee+"%", "%"+nomSite+"%");
				Visite prix =new Visite();
				prix=visiteManager.totalPrix("%"+annee+"%", "%"+nomSite+"%");
				request.setAttribute("nomSite", nomSite);
				request.setAttribute("annee", annee+"annes");
				request.setAttribute("listesVisite", listesVisite);
				request.setAttribute("prix", prix);
			    dispatcher=request.getRequestDispatcher("chercher.jsp");
				dispatcher.forward(request, response);
			}
			
			else if(nomSite !="" && ans !="" && month !="" )
			{
				String annees =ans +"-"+month;
				listesVisite =visiteManager.rechercheSiteEtAnnee("%"+annees+"%", "%"+nomSite+"%");
				Visite prix =new Visite();
				prix=visiteManager.totalPrix("%"+annees+"%", "%"+nomSite+"%");
				annees =month+"-"+ans;
				request.setAttribute("nomSite", nomSite);
				request.setAttribute("annee", annees);
				request.setAttribute("listesVisite", listesVisite);
				request.setAttribute("prix", prix);
			    dispatcher=request.getRequestDispatcher("chercher.jsp");
				dispatcher.forward(request, response);
			}
			
			else if(nomSite !="" && date1 !="" && date2 !="")
			{
				 String annees = date1+" à "+date2;
				 listesVisite = visiteManager.recherche2Date(date1,date2, "%"+nomSite+"%");
				 Visite prix = new Visite();
				 prix=visiteManager.totalPrix(date1,date2, "%"+nomSite+"%");
				 request.setAttribute("nomSite", nomSite);
					request.setAttribute("annee", annees);
					request.setAttribute("listesVisite", listesVisite);
					request.setAttribute("prix", prix);
				    dispatcher=request.getRequestDispatcher("chercher.jsp");
					dispatcher.forward(request, response);
			}
			
			else
			{
				
			}
		}
		
		else if(path.equals("/visiteParSite"))
		{
			 
			visiteParSites =visiteManager.readAllVisiteBySite();
		    request.setAttribute("visiteParSites", visiteParSites );
		    dispatcher=request.getRequestDispatcher("visiteParSite.jsp");
		    dispatcher.forward(request, response);
		}
		else
		{
			listesVisite=visiteManager.readAllVisite();
			Visite prix =new Visite();
			prix= visiteManager.totalPrix();
			request.setAttribute("listesVisite",listesVisite);
			request.setAttribute("prix",prix);
			response.sendRedirect("listeVisite");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
