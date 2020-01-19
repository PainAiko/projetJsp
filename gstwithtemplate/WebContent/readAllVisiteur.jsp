<%@ include file="entete.jsp" %>
<%@ include file="navbar.jsp" %>
		<div class="card shadow mb-4">
	   		<div class="card-header  py-3">
	   		<h6 class="m-0 font-weight-bold text-primary">
	   		Liste d'un visiteur
	   		</h6>
	   		</div>
	   		<div class="card-body">
	   			<div class="table-responsive" id="visiteur_table">
	   			<table class="table table-bordered  table-sm " id="dataTable" width="100%" cellspacing="0">
	   			   <thead>
	   			   	<tr>
	   				   <th>numero</th><th>nom</th><th>adresse</th><th>provenance</th><th>action</th>
	   				</tr>
	   			   </thead>
	   			   <tbody>
	   				<c:forEach items="${listes}" var="liste">
	   				 <tr>
	   				     <td>${liste.numVisiteur}</td>
	   				     <td>${liste.nomVisiteur}</td>
	   				     <td>${liste.adresseVisiteur}</td>
	   				     <td>${liste.provenanceVisiteur}</td>
	   				     <td>
	   				     <a  
	   				     class="btn btn-warning delete_data" 
	   				     href=""
	   				     id="${liste.numVisiteur}">
	   				     <i class="fas fa-fw fa-trash-alt" data-toggle="tooltip" data-placement="rigth" title="Supprimer"></i>
	   				     </a>
	   				     <a href=""
	   				     id="${liste.numVisiteur}" role="button"
	   				     class="btn btn-success  edit_data">
	   				     <i data-toggle="tooltip" data-placement="left" title="Modifier" class="fas fa-fw fa-user-edit"></i>
	   				     </a>
	   				     </td>
	   				 </tr>
	   				</c:forEach>
	   			   </tbody>
	   			</table>
	   			</div>
	   			<div>
	   			   
	   			   
                   <a href="#" role="button" id="ajouter" class="btn btn-success add_visiteur "><i class="fas fa-fw fa-plus-circle"></i>Visiteur</a>
                       <%@ include file="modalVisiteur.jsp" %>
	   			</div>
	   				
	   		</div>
        </div>
        
 <%@ include file="footer.jsp" %>