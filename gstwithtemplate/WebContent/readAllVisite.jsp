<%@ include file="entete.jsp" %>
<%@ include file="navbar.jsp" %>
	
		<div class="card  shadow mb-4">
	   		<div class="card-header  py-3"> <h6 class="m-0 font-weight-bold ">Liste d'un visite</h6></div>
	   		<div class="card-body">
	   			<table class="table table-striped table-bordered table-sm ">
	   				<tr>
	   				   <th>visiteur</th><th>site</th><th>nombre de jour</th><th>date</th><th>action</th>
	   				</tr>
	   				<c:forEach items="${listesVisite}" var="liste">
	   				 <tr>
	   				     <td>${liste.nomVisiteur}</td>
	   				     <td>${liste.nomSite}</td>
	   				     <td>${liste.nbJour}</td>
	   				     <td>${liste.dateVisite}</td>
	   				     <td><a 
	   				     role="button"
	   				      class="btn btn-primary delete-data"
	   				     onclick="return confirm('etes-vous sur de supprimer ?')" href="supprimerVisite?numVisite=${liste.numVisite}">Supprimer</a>
	   				     <a role="button" 
	   				      class="btn btn-primary edit-data"
	   				      
	   				      href="editerVisite?numVisite=${liste.numVisite}">
	   				       <i data-toggle="tooltip" data-placement="left" title="Modifier" class="fas fa-fw fa-user-edit"></i>
	   				      Editer</a>
	   				      </td>
	   				 </tr>
	   				</c:forEach>
	   				
	   			</table>
	   			<div>
	   				<a class="btn btn-danger" href="nouveauVisite" role="button">add visite</a>
	   			</div>
	   			
	   		</div>
        </div>
        
        
   
  
<%@ include file="footer.jsp" %>

>