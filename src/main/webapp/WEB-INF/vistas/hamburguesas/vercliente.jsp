<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>


<div class="card">
  <h5 class="card-header">Cliente id: ${cliente.id}</h5>
  <div class="card-body">
    <h5 class="card-title">${cliente.nombre}</h5>
    <p class="card-text"><b>Tel�fono:</b> ${cliente.telefono}</p>
    <p class="card-text"><b>Direcci�n:</b> ${cliente.direccion}</p>
    <p class="card-text"><b>Email:</b> ${cliente.email}</p>
    <p class="card-text"><b>Fecha de alta:</b> ${cliente.fechaAlta}</p>
  </div>
</div>
<br>
<button onclick="history.back()" class="btn btn-primary">Volver</button>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
