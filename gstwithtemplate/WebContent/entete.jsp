<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>GST</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">


  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
  
  <script type="text/javascript">
  	function loadPage(){
  		
  		var url = window.location.href;
  		var chaine = "http://localhost:8080/GestionSite/";
  		
  		
        if(url ==chaine +"saveVisite")
        	{
        	 url=chaine+"listeVisite";
        	}
	 
	  		
	  		
  	}
  </script> 
</head>

<body id="page-top" onload="loadPage()">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-info sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="header.jsp">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">GST</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item active">
        <a class="nav-link" href="header.jsp">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Addons
      </div>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="lister">
          <i class="fas fa-fw fa-table"></i>
          <span>Site</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="listeVisiteur">
          <i class="fas fa-fw fa-table"></i>
          <span>Visiteur</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="listeVisite">
          <i class="fas fa-fw fa-table"></i>
          <span>Visite</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="chercher">
          <i class="fas fa-fw fa-table"></i>
          <span>Visiteur visite le site</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="visiteParSite">
          <i class="fas fa-fw fa-table"></i>
          <span> visite par site</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->