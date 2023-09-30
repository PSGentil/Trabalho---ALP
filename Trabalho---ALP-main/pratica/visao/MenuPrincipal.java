package visao;

import controle.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuPrincipal extends JFrame {

    JButton btAdd, btList, btRemove, btSair, btEdit, btEnsaiar;
    AlunoControle controle;
    ListarAlunoVisao lista;
    AdicionarAlunoVisao adicionar;
    EditarAlunoVisao edit;
    RemoverAlunoVisao remove;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public MenuPrincipal() {
        super("Gerenciador de integrantes: Coletivo AfroIF");

        controle = new AlunoControle();
        lista = new ListarAlunoVisao(controle);
        adicionar = new AdicionarAlunoVisao(controle, lista);
        edit = new EditarAlunoVisao(controle, lista);
        remove = new RemoverAlunoVisao(controle, lista);

        setSize(420, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(((int) screenSize.getWidth()/2) - 210, 40);
        setLayout(new FlowLayout());
        setResizable(false);

        buttonHandler handler = new buttonHandler();
        JPanel botoes1 = new JPanel();
        JPanel botoes2 = new JPanel();
        btSair = new JButton("Sair");
        btAdd = new JButton("Adicionar");
        btList = new JButton(" Listar ");
        btEdit = new JButton("  Editar  ");
        btEnsaiar = new JButton(" Ensaiar ");
        btRemove = new JButton("Remover");

        btSair.addActionListener(handler);
        btAdd.addActionListener(handler);
        btList.addActionListener(handler);
        btRemove.addActionListener(handler);
        btEdit.addActionListener(handler);
        btEnsaiar.addActionListener(handler);

        botoes1.add(btAdd);
        botoes1.add(btList);
        botoes1.add(btRemove);
        botoes1.add(btEdit);
        botoes2.add(btEnsaiar);
        botoes2.add(btSair);

        ImageIcon imagem = new ImageIcon("./imagens/logo.png");
        setIconImage(imagem.getImage());
        add(new JLabel(imagem));
        add(botoes1);
        add(botoes2);

    }

    public void initialize() {
        setVisible(true);
    }

    public void fecha() {
        System.exit(EXIT_ON_CLOSE);
    }

    private class buttonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btSair) {
                fecha();
            } else if (e.getSource() == btAdd) {
                adicionar.mostrar();
            } else if (e.getSource() == btList) {
                lista.mostrar();
            } else if (e.getSource() == btEdit) {
                edit.mostrar();
            } else if (e.getSource() == btEnsaiar) {
                controle.ensaiar();
                lista.atualizar(controle);
            } else if (e.getSource() == btRemove) {
                remove.mostrar();
            }
            

        }

    }

}