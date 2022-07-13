<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

	<script type="text/javascript">
 		$(document).ready(function() {
			//$('#select-ingredientes').select2();
			$('#form-cliente').validate();
		}); 
	</script>

	<h1>Cargar nuevo cliente</h1>
	<form:form method="post" action="/hamburguesas/cliente/guardar" modelAttribute="clienteForm" id="form-cliente">
		<div class="form-group">
			<label>Id</label>
			<form:input path="id" readonly="true" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>Nombre</label>
			<form:input path="nombre" cssClass="form-control required" />
			<form:errors path="nombre" cssClass="error"/>
		</div>		
		<div class="form-group">
			<label>Teléfono</label>
			<form:input path="telefono" cssClass="form-control required number" />
			<form:errors path="telefono" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Dirección</label>
			<form:input path="direccion" cssClass="form-control required" />
			<form:errors path="direccion" cssClass="error"/>
		</div>	
		<div class="form-group">
			<label>Email</label>
			<form:input path="email" cssClass="form-control required" />
			<form:errors path="email" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Fecha alta</label>
			<form:input path="fechaAlta" readonly="true" cssClass="form-control" id="fechaFormateada"/>
		</div>
		<button type="submit" class="btn btn-primary">Enviar datos</button>
	</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>