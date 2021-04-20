package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {

	private AbitanteDAO abitanteDAO;

	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) {
		// abitanteDAO.setConnection(MyConnection.getConnection());
		return abitanteDAO.findByNomeAndCognome(nome, cognome);
	}

	@Override
	public List<Abitante> listAll() throws Exception {
		try {
			return abitanteDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Abitante findById(Long idInput) throws Exception {
		try {
			if (idInput > 0) {
				return abitanteDAO.get(idInput);
			} else {
				throw new Exception("dati non validi");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void inserisciNuovo(Abitante input) throws Exception {
		try {
			if (input != null)
				abitanteDAO.insert(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void aggiorna(Abitante input) throws Exception {
		try {
			if (input != null)
				abitanteDAO.update(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void rimuovi(Abitante input) throws Exception {
		try {
			abitanteDAO.delete(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
