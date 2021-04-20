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

@WebServlet("/ExecuteModificaAbitanteServlet")
public class ExecuteModificaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ExecuteModificaAbitanteServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idDaPagina = request.getParameter("idAbitanteModifica");
		String nomeDaPagina = request.getParameter("nomeInputModifica");
		String cognomeDaPagina = request.getParameter("cognomeInputModifica");
		String codiceFiscaleDaPagina = request.getParameter("codiceFiscaleInputModifica");
		String etaDaPagina = request.getParameter("etaInputModifica");
		String mottoDiVitaDaPagina = request.getParameter("mottoDiVitaInputModifica");
		
		String destinazione = null;
		Abitante abitante = new Abitante(Long.parseLong(idDaPagina), nomeDaPagina, cognomeDaPagina, codiceFiscaleDaPagina,Integer.parseInt(etaDaPagina), mottoDiVitaDaPagina);
		
		if (nomeDaPagina.equals("") || cognomeDaPagina.equals("") || codiceFiscaleDaPagina.equals("")
				|| etaDaPagina.equals("") || mottoDiVitaDaPagina.equals("")) {
			
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare tutti i campi.";
			request.setAttribute("abitanteDaModificare", abitante);
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			destinazione = "modifica.jsp";
		}else {
			try {
				MyServiceFactory.getAbitanteServiceInstance().aggiorna(abitante);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			destinazione = "searchForm.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}
}


