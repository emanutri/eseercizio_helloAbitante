<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.helloabitante.model.Abitante"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Elimina Abitante</title>
	</head>
	<body>
		
		<h2><% Abitante abitanteInPagina = (Abitante) request.getAttribute("abitanteDaEliminare"); %>
		
		il nome �: <%=abitanteInPagina.getNome() %> <br>
		il cognome �: <%=abitanteInPagina.getCognome() %> <br>
		il codice fiscale �: <%=abitanteInPagina.getCodiceFiscale() %> <br>
		l'et� �: <%=abitanteInPagina.getEta() %> <br>
		il motto di vita �: <%=abitanteInPagina.getMottoDiVita() %> <br></h2>
		
		<h1>sei sicuro di voler eliminare questo abitante?</h1><br>
		<form action="ExecuteDeleteAbitanteServlet" method="post">
			<input type="submit" value="conferma eliminazione">
			<input type="hidden" name="idAbitante" value="<%= abitanteInPagina.getIdAbitante() %>">
		</form>
		<a href = "searchForm.jsp"> Home </a>
	</body>
</html>