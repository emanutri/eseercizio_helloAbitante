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

@WebServlet("/VisualizzaDettaglioServlet")
public class VisualizzaDettaglioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualizzaDettaglioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroIdDellAbitanteDiCuiVoglioIlDettaglio = request.getParameter("idDaInviareComeParametro");

		Long id = Long.parseLong(parametroIdDellAbitanteDiCuiVoglioIlDettaglio);
		String destinazione = null;
		Abitante abitanteTrovato = null;

		try {
			abitanteTrovato = MyServiceFactory.getAbitanteServiceInstance().findById(id);
			destinazione = "dettaglio.jsp";

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("abitante_trovato", abitanteTrovato);
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
//		AbitanteService abitanteServiceInstance = MyService.... 
//		
//		Abitante result = abitanteServiceInstance.caricaSingolo(Integer.parseInt(parametroIdDellAbitanteDiCuiVoglioIlDettaglio);
//		
//		request.setAttribute("abitanteDaInviareAPaginaDettalio", result);

		// response.getWriter().append("Volevi visualizzare abitante con id:
		// "+parametroIdDellAbitanteDiCuiVoglioIlDettaglio).append(request.getContextPath());
	}

}
