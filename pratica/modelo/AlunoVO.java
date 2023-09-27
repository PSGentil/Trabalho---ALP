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

	// Construtor com prontuario
	public AlunoVO(String prontuario) {
		this.prontuario = prontuario;
	}

	public AlunoVO(String prontuario, String nome) {

		this.prontuario = prontuario;
		this.nome = nome;

	}

	public AlunoVO(String prontuario, String nome, int qtdInstrumentos, String favorito) {
		this.prontuario = prontuario;
		this.nome = nome;
		this.qtdInstrumentos = qtdInstrumentos;
		this.favorito = favorito;
	}

	@Override
	public String toString() {
		return String.format("%10s%10s%25d%28s\n", getProntuario(), getNome(), getQtdInstrumentos(), getFavorito());
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

	public void setNome(String nome) {
		this.nome = nome;
	}

}
