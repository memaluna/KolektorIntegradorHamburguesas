<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

	<script type="text/javascript">
 		$(document).ready(function() {
			$('#select-hamburguesas').select2();
			$('#select-clientes').select2({
				  maximumSelectionLength: 1
			});
			$('#form-pedido').validate();
			$("#entregadoCB").click(function() { return false; });
		}); 
	</script>

	<h1>Cargar nuevo pedido</h1>
	<form:form method="post" action="/hamburguesas/pedido/guardar" modelAttribute="pedidoForm" id="form-pedido">
		<div class="form-group">
			<label>Id</label>
			<form:input path="id" readonly="true" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>Cliente</label>
			<form:select path="hamburguesas" items="${clientes}" itemLabel="nombre" itemValue="id" cssClass="form-control" id="select-clientes" />
		</div>
		<div class="form-group">
			<label>Dirección de entrega</label>
			<form:input path="fechaAlta" cssClass="form-control required" />
			<form:errors path="fechaAlta" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Hamburguesas</label>
			<form:select path="hamburguesas" items="${hamburguesas}" itemLabel="nombre" itemValue="id" cssClass="form-control" id="select-hamburguesas" />
		</div>
		<div class="form-group">
			<label>Importe total</label>
			<form:input readonly="true" path="fechaAlta" cssClass="form-control required" />
			<form:errors path="fechaAlta" cssClass="error"/>
		</div>	
		<div class="form-group">
			<label>Fecha y hora de pedido</label>
			<form:input path="fechaAlta" cssClass="form-control required" />
			<form:errors path="fechaAlta" cssClass="error"/>
		</div>	
		<div class="form-group">
			<label>Fecha y hora de entrega</label>
			<form:input readonly="true" path="fechaEntrega" cssClass="form-control required" />
			<form:errors path="fechaEntrega" cssClass="error"/>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
		  <label class="form-check-label" for="flexCheckDefault">
		    Pagado
		  </label>
		</div>
		<br>
		<div class="form-check">
		  <input class="form-check-input" type="checkbox" value="" id="entregadoCB">
		  <label class="form-check-label" for="flexCheckDefault">
		    Entregado
		  </label>
		</div>
		<br>
		<button type="submit" class="btn btn-primary">Enviar datos</button>
	</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>