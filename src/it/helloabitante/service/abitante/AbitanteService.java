package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public interface AbitanteService {

	public void setAbitanteDAO(AbitanteDAO abitanteDAO);

	public List<Abitante> cercaPerNomeECognome(String nome, String cognome);

	public List<Abitante> listAll() throws Exception;

	public Abitante findById(Long idInput) throws Exception;

	public void inserisciNuovo(Abitante input) throws Exception;

	public void aggiorna(Abitante input) throws Exception;

	public void rimuovi(Abitante input) throws Exception;
}
