<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Hamburguesas</title>
	
	<script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootbox.all.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.validate.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/messages_es_AR.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/select2.min.js"/>"></script>
	
	<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" >
	<link href="<c:url value="/css/select2.min.css"/>" rel="stylesheet" >
	<link href="<c:url value="/css/general.css"/>" rel="stylesheet" >
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#select-autocomplete-productos').select2({ 
				width: '300px',
				placeholder: 'Buscar hamburguesa',
				minimumInputLength: 2,
				ajax: {
				    url: '/api/hamburguesas',
				    data: function (params) {
				        var query = {
				          nombre: params.term
				        };
				        return query;
				    },
				    processResults: function (data) {
				        var nuevosDatos = [];
				    	
				        for(var hamburguesa of data) {
				        	nuevosDatos.push({ id: hamburguesa.id, text: hamburguesa.nombre + ' ' + hamburguesa.precio });
				        }
				        
				    	return {
				          results: nuevosDatos
				        };
				    },
				    dataType: 'json'
				}
			}).on('select2:select', function(event) {
				window.location = '/hamburguesas/hamburguesa/' + event.params.data.id;
			});
		});
	</script>
</head>
<body>

	<header>
	  <!-- Fixed navbar -->
	  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	    <a class="navbar-brand" href="<c:url value="/hamburguesas"/>">Hamburguesas</a>
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarCollapse">
	      <ul class="navbar-nav mr-auto">
	      	<li class="nav-item">
	          <a class="nav-link" href="<c:url value="/hamburguesas"/>">Listado de hamburguesas</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/hamburguesas/hamburguesa/nuevo"/>">Nueva hamburguesa</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/hamburguesas/ingredientes"/>">Listado de ingredientes</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/hamburguesas/ingrediente/nuevo"/>">Nuevo ingrediente</a>
	        </li>
	      </ul>
	      <form class="form-inline mt-2 mt-md-0">
	      	<select id="select-autocomplete-productos"></select>
	      </form>
	    </div>
	  </nav>
	</header>


	<div class="container">
	<!-- INICIO CONTENIDO -->