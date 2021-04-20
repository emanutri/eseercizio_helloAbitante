<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.helloabitante.model.Abitante"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Modifica Abitante</title>
	</head>
	<body>
		<% if(request.getAttribute("messaggioDiErrore") != null){ %>
				<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
			<%  }else{ %>
				<h1>inserire i dati da modificare</h1>
		<%}    %>
		<% Abitante abitanteDaServlet = (Abitante) request.getAttribute("abitanteDaModificare");%>
		<form action = "ExecuteModificaAbitanteServlet" method = "post">
			<input type="hidden" name="idAbitanteModifica" value="<%= abitanteDaServlet.getIdAbitante() %>">
			
			<h3>nome: <input type="text" name = "nomeInputModifica" value="<%=abitanteDaServlet.getNome() %>"></h3><br>
			<h3>cognome: <input type="text" name = "cognomeInputModifica" value="<%=abitanteDaServlet.getCognome() %>"></h3><br>
	   		<h3>codiceFiscale: <input type="text" name = "codiceFiscaleInputModifica" value="<%=abitanteDaServlet.getCodiceFiscale() %>"></h3><br>
	    	<h3>età: <input type="text" name = "etaInputModifica" value="<%=abitanteDaServlet.getEta() %>"></h3><br>
	   		<h3>mottoDiVita: <input type="text" name = "mottoDiVitaInputModifica" value="<%=abitanteDaServlet.getMottoDiVita() %>"></h3><br>
	   		
   			<input type="submit">
	    </form>
	</body>
</html>