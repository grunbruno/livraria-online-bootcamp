<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"	rel="stylesheet"	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"	crossorigin="anonymous">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<title>Página de Autores - Bootcamp Java</title>
</head>
<body class="container mt-5">
	<h2 class="text-center">Inserir autor</h2>
	<form method="post" action="<c:url value="/autores" />" class="form-group">
		<label for="nome">Nome: </label>
		<div class="row justify-content-md-center">
			<div class="span3">
				<input type="text" id="nome" name="nome" class="form-control">
			</div>
		</div>
		<br> 
		<label for="email">Email: </label>
		 <input type="email" id="email" name="email" class="form-control"> 
		 <br>
		 <label for="dataNascimento">Data Nascimento: </label>
		 <input type="text" id="dataNascimento" name="dataNascimento" class="form-control js-date"  > 
		 <br>
		  <label for="nome">Mini Currículo: </label>
			<textarea class="form-control" rows="5" cols="50" maxlength="300" id="miniCurriculo" name="miniCurriculo"></textarea>
		<br>
		 <input type="submit" class="btn btn-danger" value="Cadastrar">
	</form>
	<h2 class="text-center">Lista de autores</h2>
	<table class="table table-hover table-stripped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Nascimento</th>
				<th>Mini Currículo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="a" items="${autores}">
				<tr>
					<td>${a.nome}</td>
					<td>${a.email}</td>
					<td>
						<fmt:parseDate value="${a.dataNascimento}" pattern="yyyy-MM-dd" var="formatada" type="date" />
						<fmt:formatDate value="${formatada}" pattern="dd/MM/yyyy" type="date"/>	
					</td>
					<td>${a.miniCurriculo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</html>
  <script>
  $( function() {
    $( "#dataNascimento" ).datepicker({ dateFormat: 'dd/mm/yy'} );
  } );
  
  var input = document.querySelectorAll('.js-date')[0];
  
  var dateInputMask = function dateInputMask(elm) {
    elm.addEventListener('keypress', function(e) {
      if(e.keyCode < 47 || e.keyCode > 57) {
        e.preventDefault();
      }
      
      var len = elm.value.length;
      
      // If we're at a particular place, let the user type the slash
      // i.e., 12/12/1212
      if(len !== 1 || len !== 3) {
        if(e.keyCode == 47) {
          e.preventDefault();
        }
      }
      
      // If they don't add the slash, do it for them...
      if(len === 2) {
        elm.value += '/';
      }

      // If they don't add the slash, do it for them...
      if(len === 5) {
        elm.value += '/';
      }
    });
  };
    
  dateInputMask(input);
  </script>