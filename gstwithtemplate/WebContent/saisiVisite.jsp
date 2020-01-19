 <%@ include file="entete.jsp" %>
  <%@ include file="navbar.jsp" %>
   
	
		<div class="card shadow mb-4">
	   		<div class="card-header py-3">
	   			<h6 class="m-0 font-weight-bold text-primary">
	   		Saisi un visite
	   			</h6>
	   		</div>
	   		<div class="card-body">
	   			 <form action="saveVisite" method="post">
	   			 		<div class="form-group">
	   			 			 <label for="" class="control-label">Nom visiteur :</label>
				              <select class="form-control" data-toggle="dropdown" name="numVisiteur">
				               <c:forEach items="${listesVisiteurs}" var="listeVisiteur">
				                  <option value="${listeVisiteur.numVisiteur}">${listeVisiteur.nomVisiteur}</option>
				               </c:forEach>
				              </select>
	   			 			  <span></span>
	   			 		</div>
	   			 		
	   			 		<div class="form-group">
	   			 			 <label for="" class="control-label">Nom site :</label>
				              <select class="form-control" data-toggle="dropdown" name="numSite">
				               <c:forEach items="${listesSites}" var="listesSite">
				                  <option value="${listesSite.numSite}">${listesSite.nomSite}</option>
				               </c:forEach>
				              </select>
	   			 			  <span></span>
	   			 		</div>
	   			 		<div class="form-group">
	   			 			<label class="control-label">Nombre du jour :</label>
	   			 			<input type="text" class="form-control" name="nbJour" value=""  required="required">
	   			 			<span></span>
	   			 		</div>
	   			 		<div class="form-group">
	   			 			<label class="control-label">date :</label>
	   			 			<input type="date" class="form-control" name="dateVisite" value=""  required="required">
	   			 			<span></span>
	   			 		</div>
	   			 		
	   			 		<div>
	   			 			<button type="submit" class="btn btn-warning">Ajouter</button>
	   			 		</div>
	   			 		
	   			 		
	   			 </form>
	   		</div>
        </div>
   
  
 <%@ include file="footer.jsp" %>