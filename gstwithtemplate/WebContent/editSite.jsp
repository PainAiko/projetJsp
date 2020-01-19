	   			 <form action="" method="post" id="form_updSite">
	   			        <div class="form-group">
	   			 			
	   			 			<input type="hidden" class="form-control" name="numSite"  value="${site.numSite}" required="required" >
	   			 			<span></span>
	   			 		</div>
	   			 		<div class="form-group">
	   			 			<label class="control-label">nom</label>
	   			 			<input  style="text-transform: uppercase;" type="text" class="form-control" name="nomSite" value="${site.nomSite}" required="required" >
	   			 			<span></span>
	   			 		</div>
	   			 		<div class="form-group">
	   			 			<label class="control-label">Lieu</label>
	   			 			<input  style="text-transform: uppercase;" type="text" class="form-control" name="lieuSite" value="${site.lieuSite}"  required="required">
	   			 			<span></span>
	   			 		</div>
	   			 		<div class="form-group">
	   			 			<label class="control-label">tarif journalier</label>
	   			 			<input type="number" class="form-control" value="${site.tarifJour}" name="tarif"  required="required">
	   			 			<span></span>
	   			 		</div>
	   			 		<div>
	   			 			<button type="submit" class="btn btn-primary">Ajouter</button>
	   			 		</div>
	   			 </form>
	  