package it.helloabitante.model;

public class Abitante {

	private Long idAbitante;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private int eta;
	private String mottoDiVita;

	public Abitante() {
	}

	public Abitante(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}

	public Abitante(Long idAbitante, String nome, String cognome, String codiceFiscale, int eta, String mottoDiVita) {
		super();
		this.idAbitante = idAbitante;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.eta = eta;
		this.mottoDiVita = mottoDiVita;
	}
	
	public Abitante(String nome, String cognome, String codiceFiscale, int eta, String mottoDiVita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.eta = eta;
		this.mottoDiVita = mottoDiVita;
	}

	public Long getIdAbitante() {
		return idAbitante;
	}

	public void setIdAbitante(Long idAbitante) {
		this.idAbitante = idAbitante;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getMottoDiVita() {
		return mottoDiVita;
	}

	public void setMottoDiVita(String mottoDiVita) {
		this.mottoDiVita = mottoDiVita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + eta;
		result = prime * result + ((idAbitante == null) ? 0 : idAbitante.hashCode());
		result = prime * result + ((mottoDiVita == null) ? 0 : mottoDiVita.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abitante other = (Abitante) obj;
		if (codiceFiscale == null) {
			if (other.codiceFiscale != null)
				return false;
		} else if (!codiceFiscale.equals(other.codiceFiscale))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (eta != other.eta)
			return false;
		if (idAbitante == null) {
			if (other.idAbitante != null)
				return false;
		} else if (!idAbitante.equals(other.idAbitante))
			return false;
		if (mottoDiVita == null) {
			if (other.mottoDiVita != null)
				return false;
		} else if (!mottoDiVita.equals(other.mottoDiVita))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
