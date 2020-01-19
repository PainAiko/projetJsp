package controlleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Visiteur;
import model.VisiteurManager;


public class TraiteVisiteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher disp=null;
	private ArrayList<Visiteur> listesVisiteurs=null;   
    
    public TraiteVisiteur() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		VisiteurManager visiteurManager= new VisiteurManager();
		Visiteur visiteur =new Visiteur();
		listesVisiteurs=null;
		
		if(path.equals("/listeVisiteur"))
		{
			listesVisiteurs =visiteurManager.readAllVisiteur();
			request.setAttribute("listes",listesVisiteurs);
			disp=request.getRequestDispatcher("readAllVisiteur.jsp");
			disp.forward(request, response);
		}
		
		else if(path.equals("/supprimerVisiteur"))
		{
			String numVisiteur = request.getParameter("numVisiteur");
			visiteurManager.deleteVisiteur(numVisiteur);
			listesVisiteurs =visiteurManager.readAllVisiteur();
			/*request.setAttribute("listes",listesVisiteurs);
			disp=request.getRequestDispatcher("readAllVisiteur.jsp");
			disp.forward(request, response);*/
		}
		
		else if(path.equals("/nouveauVisiteur"))
		{
			disp=request.getRequestDispatcher("saisiVisiteur.jsp");
			disp.forward(request, response);
		}
		
		else if(path.equals("/saveVisiteur")&&request.getMethod().equals("POST"))
		{
			String numVisiteur = request.getParameter("numVisiteur");
			String nomVisiteur = request.getParameter("nomVisiteur");
			String adresseVisiteur = request.getParameter("adresseVisiteur");
			String provenanceVisiteur = request.getParameter("provenanceVisiteur");
			visiteur.setNumVisiteur(numVisiteur);
			visiteur.setNomVisiteur(nomVisiteur);
			visiteur.setAdresseVisiteur(adresseVisiteur);
			visiteur.setProvenanceVisiteur(provenanceVisiteur);
			visiteurManager.createVisiteur(visiteur);
			//listesVisiteurs =visiteurManager.readAllVisiteur();
			/*request.setAttribute("listes",listesVisiteurs);
			disp=request.getRequestDispatcher("readAllVisiteur.jsp");
			disp.forward(request, response);*/
		}
		
		else if(path.equals("/editerVisiteur"))
		{
			String numVisiteur= request.getParameter("numVisiteur");
			visiteur = visiteurManager.readVisiteur(numVisiteur);
			request.setAttribute("visiteur", visiteur);
			disp=request.getRequestDispatcher("editVisiteur.jsp");
			disp.forward(request, response);
		}
		
		else if(path.equals("/updateVisiteur")&&request.getMethod().equals("POST"))
		{

			String numVisiteur = request.getParameter("numVisiteur");
			String nomVisiteur = request.getParameter("nomVisiteur");
			String adresseVisiteur = request.getParameter("adresseVisiteur");
			String provenanceVisiteur = request.getParameter("provenanceVisiteur");
			visiteur.setNumVisiteur(numVisiteur);
			visiteur.setNomVisiteur(nomVisiteur);
			visiteur.setAdresseVisiteur(adresseVisiteur);
			visiteur.setProvenanceVisiteur(provenanceVisiteur);
			visiteurManager.updateVisiteur(visiteur);
			/*listesVisiteurs =visiteurManager.readAllVisiteur();
			request.setAttribute("listes",listesVisiteurs);
			disp=request.getRequestDispatcher("readAllVisiteur.jsp");
			disp.forward(request, response);*/
		}
		
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
