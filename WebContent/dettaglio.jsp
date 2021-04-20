<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="it.helloabitante.model.Abitante"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettagli Abitante</title>
</head>
<body>



	<%
	Abitante abitanteDaServlet = (Abitante) request.getAttribute("abitante_trovato");
	%>


	
		<h3>Nome:</h3><h4><%=abitanteDaServlet.getNome()%></h4>
		
		<h3>Cognome:</h3><h4><%=abitanteDaServlet.getCognome()%></h4>
		
		<h3>Codice Fiscale:</h3><h4><%=abitanteDaServlet.getCodiceFiscale()%></h4>
		
		<h3>Età:</h3><h4><%=abitanteDaServlet.getEta()%></h4>
		
		<h3>Motto Di Vita:</h3><h4><%=abitanteDaServlet.getMottoDiVita()%></h4>
		
	<a href = searchForm.jsp>home</a>
	
	
</body>
</html>