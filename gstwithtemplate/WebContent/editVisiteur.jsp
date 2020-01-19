	   			 <form action="" method="post" id="form_updVisiteur">
	   			 			<input type="hidden" class="form-control" name="numVisiteur" value="${visiteur.numVisiteur}" required="required" >
	   			 			
	   			 		<div class="form-group">
	   			 			<label class="control-label">Nom</label>
	   			 			<input type="text" class="form-control" name="nomVisiteur" value="${visiteur.nomVisiteur}"  required="required">
	   			 			<span></span>
	   			 		</div>
	   			 		<div class="form-group">
	   			 			<label class="control-label">Adresse</label>
	   			 			<input type="text" class="form-control" value="${visiteur.adresseVisiteur}" name="adresseVisiteur"  required="required">
	   			 			<span></span>
	   			 		</div>
	   			 		<div class="form-group">
	   			 			<label class="control-label">Provenance</label>
	   			 			<input type="text" class="form-control" value="${visiteur.provenanceVisiteur}" name="provenanceVisiteur"  required="required">
	   			 			<span></span>
	   			 		</div>
	   			 		
	   			 		<div>
	   			 			<button type="submit" class="btn btn-primary">Modifier</button>
	   			 		</div>
	   			 </form>
	   	