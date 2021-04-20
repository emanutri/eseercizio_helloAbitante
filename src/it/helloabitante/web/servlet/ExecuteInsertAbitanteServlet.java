package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;

@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertAbitanteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeDaPagina = request.getParameter("nomeInput");
		String cognomeDaPagina = request.getParameter("cognomeInput");
		String codiceFiscaleDaPagina = request.getParameter("codiceFiscaleInput");
		String etaDaPagina = request.getParameter("etaInput");
		String mottoDiVitaDaPagina = request.getParameter("mottoDiVitaInput");

		String destinazione = null;

		if (nomeDaPagina.equals("") && cognomeDaPagina.equals("") && codiceFiscaleDaPagina.equals("")
				&& etaDaPagina.equals("") && mottoDiVitaDaPagina.equals("")) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare tutti i campi.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			destinazione = "insert.jsp";
		} else {
			try {
				Abitante abitante = new Abitante(nomeDaPagina, cognomeDaPagina, codiceFiscaleDaPagina,
						Integer.parseInt(etaDaPagina), mottoDiVitaDaPagina);
				MyServiceFactory.getAbitanteServiceInstance().inserisciNuovo(abitante);
			} catch (Exception e) {
				e.printStackTrace();
			}
			destinazione = "searchForm.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}
}
