package modelo;

/****
 * Classe que representa as informa�oes que deseja ARMAZENAR
 * e Trafegar entre as camadas
 * 
 * @author naur
 *         em 15/03/2019
 */

public class AlunoVO {

	private String prontuario;
	private String nome;
	private int qtdInstrumentos;
	private String favorito;
	private String dataIngressao;
	private double valorBolsa;

	// Construtor com prontuario
	public AlunoVO(String prontuario) {
		this.prontuario = prontuario;
	}

	public AlunoVO(String prontuario, String nome) {

		this.prontuario = prontuario;
		this.nome = nome;

	}

	public AlunoVO(String prontuario, String nome, int qtdInstrumentos, String favorito, String dataIngressao, double valorBolsa) {
		this.prontuario = prontuario;
		this.nome = nome;
		this.qtdInstrumentos = qtdInstrumentos;
		this.favorito = favorito;
		this.dataIngressao = dataIngressao;
		this.valorBolsa = valorBolsa;
	}

	@Override
	public String toString() {
		return String.format("%10s%14s%30d%30s%23s%19.2f\n", getProntuario(), getNome(), getQtdInstrumentos(), getFavorito(),getDataIngressao(), getValorBolsa());
	}

	public String getProntuario() {
		return prontuario;
	}

	public String getFavorito() {
		return favorito;
	}

	public int getQtdInstrumentos() {
		return qtdInstrumentos;
	}

	public String getNome() {
		return nome;
	}
	public String getDataIngressao() {
		return dataIngressao;
	}
	public double getValorBolsa() {
		return valorBolsa;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setFavorito(String favorito) {
		this.favorito = favorito;
	}
	public void setQtdInstrumentos(int qtdInstrumentos) {
		this.qtdInstrumentos = qtdInstrumentos;
	}
	public void setDataIngressao(String dataIngressao) {
		this.dataIngressao = dataIngressao;
	}
	public void setValorBolsa(double valorBolsa) {
		this.valorBolsa = valorBolsa;
	}

}
