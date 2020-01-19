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



public class TraiteSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher disp=null;
	private ArrayList<Site> listes=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraiteSite() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		SiteManager siteMng=new SiteManager();
		Site site =new Site();
		listes=null;
		if(path.equals("/lister"))
		{
			listes =siteMng.readAllSite();
			request.setAttribute("listes",listes);
			disp=request.getRequestDispatcher("readAllSite.jsp");
			disp.forward(request, response);
		}
		
		else if(path.equals("/saisiSite"))
		{
			
			disp=request.getRequestDispatcher("saisiSite.jsp");
			disp.forward(request, response);
		}
		
		else if(path.equals("/saveSite")&&(request.getMethod().equals("POST"))) {
			String numSite = request.getParameter("numSite");
			String nomSite = request.getParameter("nomSite");
			String lieuSite = request.getParameter("lieuSite");
			double tarif_jour =Double.parseDouble(request.getParameter("tarif_jour"));
			site.setNumSite(numSite);
			site.setNomSite(nomSite);
			site.setLieuSite(lieuSite);
			site.setTarifJour(tarif_jour);
			siteMng.createSite(site);
			/*listes =siteMng.readAllSite();
			request.setAttribute("listes",listes);
			disp=request.getRequestDispatcher("readAllSite.jsp");
			disp.forward(request, response);*/
		}
		
		else if(path.equals("/supprimer"))
		{
			String id=request.getParameter("id");
			siteMng.deleteSite(id);
			/*listes =siteMng.readAllSite();
			request.setAttribute("listes",listes);
			disp=request.getRequestDispatcher("readAllSite.jsp");
			disp.forward(request, response);
			//response.sendRedirect("readAllSite.jsp");*/
		}
		
		else if(path.equals("/editer"))
		{
			String id=request.getParameter("id");
			site =siteMng.readSite(id); 
			request.setAttribute("site", site);
			request.getRequestDispatcher("editSite.jsp").forward(request, response);
		}
		else if(path.equals("/UpdateSite")&&(request.getMethod().equals("POST"))) {
			String numSite =request.getParameter("numSite");
			String nomSite = request.getParameter("nomSite");
			String lieuSite = request.getParameter("lieuSite");
			double tarifJour =Double.parseDouble(request.getParameter("tarif"));
			
			
			site.setNumSite(numSite);
			site.setNomSite(nomSite);
			site.setLieuSite(lieuSite);
			site.setTarifJour(tarifJour);
		   siteMng.updateSite(site);
		   
		  /*  listes =siteMng.readAllSite();
			request.setAttribute("listes",listes);
			disp=request.getRequestDispatcher("readAllSite.jsp");
			disp.forward(request, response);*/
		}
		else {
			response.sendRedirect("saisiSite.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
