<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Banque</title>
</head>
<body>

<!---/modal a la fois insertion  et update -->
<div id="modal" class="modal fade">
     <div class="modal-dialog ">
         <div class="modal-content">
             <div class="modal-header">
                 <h4 id="titre" class="modal-title"></h4>
                 <button type="button"  class="close" data-dismiss="modal" name="button">
                     <span aria-hidden="true">&times;</span>
                 </button>

             </div><!---/end modal-header-->

             <div class="modal-body" id="detail">

             </div><!---/end modal-header-->

             <div class="modal-footer">
                 <button type="button"  name="save" id="oui" class="btn btn-danger active">Oui</button>
                 <button type="button" name="button" id="non" class="btn btn-warning active" data-dismiss="modal">Non</button>
                 <button type="button" name="button" class="btn btn-warning active" id="annuler" data-dismiss="modal">Annuler</button>
             </div><!---/end modal-header-->
         </div><!---/end modal-content-->


     </div>
</div>
<!---/modal a la fois insertion  et update -->


    <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/chart-area-demo.js"></script>
  <script src="js/demo/chart-pie-demo.js"></script>
  
    <!-- Page level plugins -->
  <script src="vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <script>
        $(document).ready(function ()
        {
        //affiche le formulaire modal pour saisir les informations � ajouter
            $(".add_visiteur").onclick(function(e){
                e.preventDefault();
            $('#modal').modal('show');
            $('#titre').html('Ajouter');
            $('#annuler,#Inserer').show();
            $('#oui,#non').hide();
            $.ajax(
                {
                    url:'nouveauVisiteur',
                    success:function (data) {
                    	
                        $('#detail').html(data).slideDown();
                    }
                });
    
            });
           //insert 
            $(document).on('submit','#form_addVisiteur',function (e) {
                e.preventDefault();
               var datas=$(this).serialize();

              $.ajax({
                 type: 'post',
                  url:'saveVisiteur',
                  data:datas,
                  success:function (data) {
                      $('#visiteur_table').html(data).slideDown();
                      //on rafraichit page pour avoir la modification
                      setTimeout("document.location.reload()", 1);
                  }
              });

            });
            //suppression d'une ligne dans la base de donner
            $(document).on('click','.delete_data',function (e) {

                e.preventDefault();
                $('#modal').modal('show');
                var numVisiteur = $(this).attr('id');
                $('#titre').html('Suppression d\'un visiteur');
                $('#annuler').hide();
                $('#oui,#non').show();
                $('#detail').html('Vous etes sur  de supprimer le visiteur numero '+numVisiteur);
               //on suprimme la ligne;
                $('#oui').click(function () {
                    $.ajax({
                        url:'supprimerVisiteur',
                        type:'get',
                        data:{numVisiteur:numVisiteur},
                        success:function (data) {
                            $('#visiteur_table').html(data).slideDown();
                            //on rafraichit page pour avoir la modification
                            setTimeout("document.location.reload()", 1);
                        }
                    });

                });

        });

            //formulaire modification
            $(document).on('click','.edit_data',function (e) {
                e.preventDefault();
                var id =$(this).attr('id');
                $('#modal').modal('show');
                   $('#titre').html('Modifier');
                   $('#annuler,#insertions').show();
                   $('#oui,#non').hide();

                   $.ajax({
                     type:'get',
                     url:'editerVisiteur',
                     data:{numVisiteur:id},
                         success:function (data) {
                             $('#detail').html(data).slideDown();
                         }
                 }); 
                
            });
            
          //on effectue la modification
            $(document).on('submit','#form_updVisiteur',function (e) {
                       e.preventDefault();
                       //var datas=$(this).serialize();
                           $.ajax({
                               url:'updateVisiteur',
                               type:'post',
                               data:$('#form_updVisiteur').serialize(),
                               success:function (data) {
                                   $('#modal').modal('hide');
                                   $('#com_table').html(data);

                                   //on rafraichit page pour avoir la modification
                                   setTimeout("document.location.reload()", 1);
                               }
                           });
                      
                   });
    });
    </script>





</body>
</html>