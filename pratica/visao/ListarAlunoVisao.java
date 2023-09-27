package visao;

import controle.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.AlunoVO;

public class ListarAlunoVisao extends JFrame {

    String retorno = String.format("%9s %15s %25s %15s\n", "Prontuário", "Nome", "Qtd Instrumentos",
            "Favorito");
    JButton btFecha;
    JTextArea lista;

    public ListarAlunoVisao(AlunoControle controle) {

        super("Listagem de alunos");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(1280, 325);
        setLayout(new FlowLayout());

        JPanel listagem = new JPanel();
        lista = new JTextArea(20, 40);

        buttonHandler handler = new buttonHandler();
        JPanel botoes = new JPanel();
        btFecha = new JButton("Fechar");
        btFecha.addActionListener(handler);
        botoes.add(btFecha);

        ArrayList<AlunoVO> texto = controle.obterListaAluno();

        for (AlunoVO alunoVO : texto) {
            retorno += alunoVO;
        }

        listagem.add(lista);

        lista.setText(retorno);

        add(listagem);
        add(botoes);

    }

    public void mostrar() {
        setVisible(true);
    }

    public void fecha() {
        dispose();
    }

    public void atualizar(AlunoControle controle) {
        retorno = String.format("%9s %15s %25s %15s\n", "Prontuário", "Nome    ",
                "Qtd Instrumentos", "Favorito");
        ArrayList<AlunoVO> texto = controle.obterListaAluno();
        for (AlunoVO alunoVO : texto) {
            retorno += alunoVO;
        }
        lista.setText(retorno);
    }

    private class buttonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btFecha) {
                fecha();
            }

        }

    }

}
