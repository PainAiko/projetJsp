// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').dataTable({
	  "language": {
	        "decimal":"",
	        "emptyTable":"Aucune donnée disponible dans le tableau",
	        "lengthMenu": "Afficher _MENU_ &eacute;l&eacute;ments",
	        "zeroRecords": "Aucun &eacute;l&eacute;ment &agrave; afficher",
	        "info": "Affichage de l'&eacute;lement _START_ &agrave; _END_ sur _TOTAL_ &eacute;l&eacute;ments",
	        "infoEmpty": "Affichage de l'&eacute;lement 0 &agrave; 0 sur 0 &eacute;l&eacute;ments",
	        "infoFiltered": "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
	        "search": "Rechercher&nbsp;:",
	        "infoPostFix":    "",
	        "loadingRecords": "Chargement en cours...",
	        "paginate": {
	            "first":      "Premier",
	            "previous":   "Pr&eacute;c&eacute;dent",
	            "next":       "Suivant",
	            "last":       "Dernier"
	        },
	        "aria": {
	            "sortAscending":  ": activer pour trier la colonne par ordre croissant",
	            "sortDescending": ": activer pour trier la colonne par ordre décroissant"
	        }
	    } 
  });
});
