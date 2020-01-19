<%@ include file="entete.jsp" %>
<%@ include file="navbar.jsp" %>
	

	   <div class="card  shadow mb-4">
	   		<div class="card-header  py-3"> <h6 class="m-0 font-weight-bold ">Liste des  visiteurs qui visite le site</h6></div>
	   		<div class="card-body">
	   		     <form class="form-inline" action="chercher" method="get">
 					  <label for="nomSite" class="control-label">Site: </label>
                      <input type="text" class="form-control" id="nomsite" required="required" name="nomSite">
                          <select style="margin-left: 4px;margin-right: 4px;" name="" id="" class="sel form-control">
                            <option value="annee"  selected="selected" class="form-control">pendant une annee</option>
                            <option value="mois" class="form-control">pendant un mois</option>
	                        <option value="deuxdate" class="form-control">entre 2 date </option> 
	                        <option value="type" class="form-control">type </option> 
                      </select>
                      <div id="annee">
                        <input type="text" name="annee" id="anne" placeholder="recherche . . . " class="form-control">
                     </div>
                      <div id="mois">
                        <select style="margin-left: 4px;margin-right: 4px;" name="month" id="month"   class="form-control">
                            <option value="01" class="form-control">Janvier</option>
                            <option value="02" class="form-control">Fevrier</option>
	                        <option value="03" class="form-control">Mars</option> 
	                        <option value="04" class="form-control">Avril </option> 
	                        <option value="05"   class="form-control">Mai</option>
                            <option value="06" class="form-control">Juin</option>
	                        <option value="07" class="form-control">Juillet</option> 
	                        <option value="08"  selected="selected" class="form-control">Aout </option> 
	                        <option value="09"   class="form-control">Septembre</option>
                            <option value="10" class="form-control">Octobre</option>
	                        <option value="11" class="form-control">Novembre</option> 
	                        <option value="12" class="form-control">Decembre</option> 
                      </select>
                        <input type="text" name="ans" id="ans" placeholder="ans " class="form-control">
                     </div>
                     <div id="deuxdate">
                        <input type="date" name="date1" id="date1" placeholder="d1 " class="form-control">
                        <input type="date" name="date2" id="date2" placeholder="d2 " class="form-control">
                     </div>
                      <button style="margin-left: 4px;" type="submit" id="chercher" class=" btn btn-info" >
                        <span class="fa fa-search"></span>
                        chercher
                      </button>
                </form>
                <br>
                <p><c:out value="${nomSite}"></c:out> et <c:out value="${annee}"></c:out> </p>
	   			<table class="table table-striped table-bordered table-sm  " >
	   				<tr>
	   				   <th>visiteur</th><th>date</th><th>tarif</th><th>nombre de jour</th><th>Montant</th>
	   				</tr>
	   				<c:forEach items="${listesVisite}" var="liste">
	   				 <tr>
	   				     <td>${liste.nomVisiteur}</td>
	   				     <td>${liste.dateVisite}</td>
	   				     <td>${liste.tarifJour }</td>
	   				     <td>${liste.nbJour}</td>
	   				     <td>${liste.nbJour*liste.tarifJour} Ar</td>
	   				    
	   				 </tr>
	   				  <script type="text/javascript">
	   				     
	   				  </script>
	   				</c:forEach>
	   				<tfoot>
	   				     <tr>
	   				     <th colspan="4">Total</th>
	   				     <th>${prix.total} AR</th>
	   				     </tr>
	   				</tfoot>
	   			</table>
	   			
	   			
	   		</div>
        </div>
   
  
<%@ include file="footer.jsp" %>

<script type="text/javascript">
$(document).ready(function(){
    $('.sel').val(['type']);
    $('#annee').hide();
    $('#mois').hide();
    $('#deuxdate').hide();
    
    $(document).on('change','.sel',function(){
        var val = $('.sel').val();
    if(val=='type')
    	{
    	   $('#annee').hide();
    	    $('#mois').hide();
    	    $('#deuxdate').hide();
    	}
   
    else if(val=='annee'){
            $('#annee').show();
            $('#mois').hide();
            $('#deuxdate').hide();
            //button chercher
            $('#chercher').click(function(e) {
            	
        	    var $nomSite =$('#nomsite').val(),
    	        $annee=$('#anne').val();
        	   
        	    if($nomSite !='' && $annee !='' )
    	    	{
    	    	    $('#annee').show();
    	            $('#mois').hide();
    	            $('#deuxdate').hide();
    	            $('.cache').hide();
    	         
    	    	}
        	    else
        	    	{
        	    	alert("remplir les champs");
        	    	}
    	        
            });
            
        }
        else if(val=='mois'){
        	$('#annee').hide();
            $('#mois').show();
            $('#deuxdate').hide();
            
 $('#chercher').click(function(e) {
            	
        	    var $nomSite =$('#nomsite').val(),
    	        $month=$('#month').val(),
        	    $ans=$('#ans').val();
        	    $an=$ans+"-"+$month;
        	    
        	   if($nomSite !='' && $month!='' && $ans!='')
        		   {
        		      alert($an);
        		   }
        	   else
        		   {
        		      alert("remplir les champs");
        		   }
    	        
            });
        }
       
        else if(val=='deuxdate'){
          $('#resultats').hide();
          $('#annee').hide();
          $('#mois').hide();
          $('#deuxdate').show();
          
          $('#chercher').click(function(e) {
          	
      	    var $nomSite =$('#nomsite').val(),
  	        $date1=$('#date1').val(),
      	    $date2=$('#date2').val();
      	    $date=$date1+"-"+$date2;
      	    
      	   if($nomSite !='' && $date1!='' && $date1!='')
      		   {
      		      alert($date);
      		   }
      	   else
      		   {
      		      alert("remplir les champs ");
      		   }
  	        
          });
        }
        
    });
    
   //button chercher
 /*  $('#chercher').click(function(e) {
	   e.preventDefault();
	    var $nomSite =$('#nomsite').val(),
	        $annee=$('#anne').val(),
	        $mois=$('#mois').val(),
	        $ans =$('#ans').val(),
	        $d1 = $('#d1').val(),
	        $d2 = $('#d2').val();
	    
	    if($nomSite !='' && $annee !='' )
	    	{
	    	    $('#annee').show();
	            $('#mois').hide();
	            $('#deuxdate').hide();
	            alert($nomSite + $annee);
	            $.ajax({
	            	type:'get',
	            	url:'chercher',
	            	data:{nomSite:$nomSite,annee:$annee},
	            	success:function (data) {
                       alert(data)
                     }
	            })
	    	}
	    else if($nomSite !='' && $mois !='' && $ans !='')
	    	{
		    	$('#annee').hide();
	            $('#mois').show();
	            $('#deuxdate').hide();
	            alert($nomSite+" "+$mois +"-"+$ans)
	    	}
	   
   });*/
        
});

</script>