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

@WebServlet("/PrepareModificaAbitante")
public class PrepareModificaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareModificaAbitanteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroIdDellAbitanteCheVoglioEliminare = request.getParameter("idDaInviareComeParametro");
		Abitante result = null;
		try {
			result = MyServiceFactory.getAbitanteServiceInstance()
					.findById(Long.parseLong(parametroIdDellAbitanteCheVoglioEliminare));// (long)
																							// Integer.parseInt(parametroIdDellAbitanteCheVoglioEliminare));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("abitanteDaModificare", result);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("modifica.jsp");
		rd.forward(request, response);
	}

}
