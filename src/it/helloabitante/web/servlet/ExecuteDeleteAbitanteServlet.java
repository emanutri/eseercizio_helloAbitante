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

@WebServlet("/ExecuteDeleteAbitanteServlet")
public class ExecuteDeleteAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteDeleteAbitanteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idAbitanteParameter = request.getParameter("idAbitante");
		Abitante abitante = null;
		
		try {

			abitante = MyServiceFactory.getAbitanteServiceInstance().findById(Long.parseLong(idAbitanteParameter));
			MyServiceFactory.getAbitanteServiceInstance().rimuovi(abitante);

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("searchForm.jsp");

		rd.forward(request, response);
	}

}
