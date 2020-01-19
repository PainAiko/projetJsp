<%@ include file="entete.jsp" %>
<%@ include file="navbar.jsp" %>        
        <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Site disponible</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive" id="site_table">
                <table class="table table-bordered table-hover table-sm" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                       <th>numero</th><th>nom</th><th>lieu</th><th>tarif</th><th>action</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                       <th>numero</th><th>nom</th><th>lieu</th><th>tarif</th><th>action</th>
                    </tr>
                  </tfoot>
                  <tbody>
                   <c:forEach items="${listes}" var="liste">
	   				 <tr>
	   				     <td>${liste.numSite}</td>
	   				     <td>${liste.nomSite}</td>
	   				     <td>${liste.lieuSite}</td>
	   				     <td>${liste.tarifJour}</td>
	   				     <td>
	   				     <a   role="button" class="btn btn-info delete_data"
	   				     id="${liste.numSite}">
	   				     <i class="fas fa-fw fa-trash-alt" data-toggle="tooltip" data-placement="rigth" title="Supprimer"></i>
	   				     Supprimer
	   				     </a>
	   				     <a role="button"
	   				      class="btn btn-info edit_data"
	   				      id="${liste.numSite}">
	   				     <i data-toggle="tooltip" data-placement="left" title="Modifier" class="fas fa-fw fa-user-edit"></i> 
	   				      Editer</a></td>
	   				 </tr>
	   				</c:forEach>
                   
                  </tbody>
                </table>
                <div>
	   			
	   				<a href="#" role="button" id="ajouter" class="btn btn-success add_site "><i class="fas fa-fw fa-plus-circle"></i>Site</a>
                    <%@ include file="modalSite.jsp" %>
	   			</div>
              </div>
            </div>
          </div>
   
  
<%@ include file="footer.jsp" %>

