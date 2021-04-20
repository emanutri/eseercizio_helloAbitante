package it.helloabitante.dao.abitante;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;

public class AbitanteDAOImpl implements AbitanteDAO {

	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Abitante> findByNomeAndCognome(String nome, String cognome) {
		List<Abitante> result = new ArrayList<>();

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getNome().startsWith(nome) && abitanteItem.getCognome().startsWith(cognome))
				result.add(abitanteItem);
		}
		return result;
	}

	@Override
	public List<Abitante> list() throws Exception {
		try {
			List<Abitante> result = new ArrayList<>();

			for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
				result.add(abitanteItem);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Abitante get(Long id) throws Exception {
		try {
			Abitante result = null;

			for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
				if (abitanteItem.getIdAbitante().equals(id)) {
					result = abitanteItem;
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int update(Abitante input) throws Exception {

		if (input == null || input.getIdAbitante() < 1)
			throw new Exception("Input non valido");

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getIdAbitante() == input.getIdAbitante()) {
				abitanteItem.setNome(input.getNome());
				abitanteItem.setCognome(input.getCognome());
				abitanteItem.setCodiceFiscale(input.getCodiceFiscale());
				abitanteItem.setEta(input.getEta());
				abitanteItem.setMottoDiVita(input.getMottoDiVita());
				return 1;
			}
		}

		return 0;
	}

	@Override
	public int insert(Abitante input) throws Exception {
		try {
			if (input != null) {
				input.setIdAbitante(DB_Mock.getNexIdAvailable());
				DB_Mock.LISTA_ABITANTI.add(input);
				return 0;
			} else {
				return 1; // se non va
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int delete(Abitante input) throws Exception {
		try {
			if (input != null) {
				DB_Mock.LISTA_ABITANTI.remove(input);
				return 0;
			} else {
				return 1; // se non va
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
