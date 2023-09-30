package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/***
 * Classe responsavel por realizar as operacoes de PERSIST�NCIA: criar, alterar, remover, listar
 * mais alguns m�todos auxiliares: verificar se esta vazia ou cheia...
 * 
 * @author naur
 * em 25/03/2019
 * alterado 15/08/2023
 */

public class AlunoModelo {

	ArrayList<AlunoVO> listaAluno = new ArrayList<AlunoVO>();

	public AlunoModelo() {
		adiciona(new AlunoVO("HT3015149", "Pedro", 10, "Violão", "03/01/2022", 100.00));
        adiciona(new AlunoVO("HT3046823", "Wesley", 13, "Surdo", "10/02/2022", 500.00));
        adiciona(new AlunoVO("HT3645645", "Felipe", 2, "Pandeiro", "20/03/2022", 100.00));
        adiciona(new AlunoVO("HT3687343", "Gustavo", 4, "Violão", "14/04/2022", 200.00));
        adiciona(new AlunoVO("HT3045754", "Otávio", 6, "Tamborim", "20/05/2022", 100.00));
	}

	public boolean ehVazia() {
			return listaAluno.isEmpty();
	}

	
	public ArrayList<AlunoVO> obterListaAluno() {
		return listaAluno;
	}

	
	public boolean existePront(String codigo) {

		for(int i = 0; i < listaAluno.size(); i++) {
			
			if(listaAluno.get(i).getProntuario() != null) {
			
				if(listaAluno.get(i).getProntuario().toLowerCase().equals(codigo))
				{
					return true;
				}
			}
		}
		
		return false;
	}

	public void atualizarDados(String pront, String nome, int inst, String fav, double val) {
		for (AlunoVO alunoVO : listaAluno) {
			if (pront.equals(alunoVO.getProntuario())) {
				alunoVO.setNome(nome);
				alunoVO.setFavorito(fav);
				alunoVO.setQtdInstrumentos(inst);
				alunoVO.setValorBolsa(val);
				JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
			}
		}
	}
	public void adiciona(AlunoVO novoAmigo) {
		
		listaAluno.add(novoAmigo);

	}
	public void remover(String pront) {
		for (AlunoVO alunoVO : listaAluno) {
			if (pront.equals(alunoVO.getProntuario().toLowerCase())) {
				listaAluno.remove(alunoVO);
				JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
				return;
			}
		}
	}
	public void ensaiar() {
		for (AlunoVO alunoVO : listaAluno) {
			if (alunoVO.getQtdInstrumentos() < 13) {
				alunoVO.setQtdInstrumentos(alunoVO.getQtdInstrumentos() + 1);
			}
		}
	}
	
} 
