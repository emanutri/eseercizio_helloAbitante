<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Inserisci abitante</title>
	</head>
	<body>
		<% if(request.getAttribute("messaggioDiErrore") != null){ %>
			<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
		<%  }else{ %>
			<h1>inserisci un nuovo abitante:</h1><br>
		<%}    %>
		
		<form action="ExecuteInsertAbitanteServlet" method="post">
			<label for="nomeInputId">NOME:</label><br>
			<input type="text" name="nomeInput" id="nomeInputId">
			<br>
			<label for="cognomeInputId">COGNOME:</label><br>
			<input type="text" name="cognomeInput" id="cognomeInputId">
			<br>
			<label for="codiceFiscaleInputId">CODICE FISCALE:</label><br>
			<input type="text" name="codiceFiscaleInput" id="codiceFiscaleInputId">
			<br>
			<label for="etaInputId">ETA':</label><br>
			<input type="text" name="etaInput" id="etaInputId">
			<br>
			<br>
			<label for="mottoDiVitaInputId">MOTTO DI VITA:</label><br>
			<input type="text" name="mottoDiVitaInput" id="mottoDiVitaInputId">
			<br>
			<input type="submit" value="inserisci">

		</form>
	</body>
</html>