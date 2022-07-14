<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

	<script type="text/javascript">
 		$(document).ready(function() {
			//$('#select-hamburguesas').select2();			
			$('#select-clientes').select2({
				  maximumSelectionLength: 1
			});
			$('#form-pedido').validate();
			$("#entregadoCB").click(function() { return false; });
			 //logica para agregar y quitar hamburguesas a lista de compras.
			$("#btn-agregar").click(function() {				
				var o = new Option($('#select-hamburguesas option').filter(':selected').text(), $('#select-hamburguesas option').filter(':selected').val());
				$(o).html($('#select-hamburguesas option').filter(':selected').text());
				$("#select-lista").append(o);			
			});
			$("#btn-quitar").click(function() {				
				$('option:selected', "#select-lista").remove();
			});
			//logica para sumar precio a importe total
			$("#select-lista").bind("DOMSubtreeModified", function() {
	 			let precio = 0;
				$("#select-lista > option").each(function() {
					
					//console.log(this.value)
					$.ajax({
				        url: "http://localhost:8080/api/hamburguesas/hamburguesa/" + this.value
				    }).then(function(data) {
				       //console.log(data.precio.precio)
				       precio = precio + data.precio;
				       $("#importe").val(precio);
				    });
				
			    });
				if($("#select-lista").children().length <= 0){
					$("#importe").val(0);
				}
			});
			
		}); 
 		
 		function sumarTotal(){
 			
 		}

	</script>

	<h1>Cargar nuevo pedido</h1>
	<form:form method="post" action="/hamburguesas/pedido/guardar" modelAttribute="pedidoForm" id="form-pedido">
		<div class="form-group">
			<label>Id</label>
			<form:input path="id" readonly="true" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>Cliente</label>
			<form:select path="hamburguesas" items="${clientes}" itemLabel="nombre" itemValue="id" data-completa="${clientes.get(0).direccion}" cssClass="form-control" id="select-clientes" />
		</div>
		<div class="form-group">
			<label>Dirección de entrega</label>
			<form:input path="fechaAlta" cssClass="form-control required" />
			<form:errors path="fechaAlta" cssClass="error"/>
		</div>
		<div class="form-group d-flex justify-content-center d-flex align-items-center" >
			<div class="col-sm-3">
				<label>Hamburguesas</label>
				<form:select style="min-width:90%;" size="10" path="hamburguesas" items="${hamburguesas}" itemLabel="nombre" itemValue="id" cssClass="form-control" id="select-hamburguesas" />
			</div>
			<div class="d-flex flex-column bd-highlight mb-3">
				<button id="btn-agregar" class="m-3" type="button">Agregar Hamburguesa</button>
				<button id="btn-quitar" class="m-3" type="button">Quitar Hamburguesa</button>
			</div>

			<div class="col-sm-3">
				<label>Lista de compra</label>
				<select style="min-width:90%;" class="form-control" size="10" cssClass="form-control" id="select-lista"/></select>
			</div>
		</div>
			
		<div class="form-group">
			<label>Importe total</label>
			<form:input id="importe" readonly="true" path="fechaAlta" cssClass="form-control required" />
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