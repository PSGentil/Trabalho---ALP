package visao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controle.*;
import modelo.AlunoVO;

public class EditarAlunoVisao extends JFrame {

    private AlunoControle controle;
    public ListarAlunoVisao lista;
    // ListarAlunoVisao a;

    private JTextField txtpront, txtNome, txtInst, txtFav;
    private JButton btBuscar, btFecha, btAtualizar;

    public EditarAlunoVisao(AlunoControle controle, ListarAlunoVisao lista) {

        this.controle = controle;
        this.lista = lista;

        setSize(400, 265);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Editar Aluno");
        setLayout(new FlowLayout());
        setLocation(405, 350);
        setResizable(false);
        setAlwaysOnTop(true);

        buttonHandler handler = new buttonHandler();

        // Input de pront
        JPanel pront = new JPanel();
        pront.setLayout(new FlowLayout());
        JLabel lbpront = new JLabel("                Prontuário: ");
        txtpront = new JTextField(15);
        pront.add(lbpront);
        pront.add(txtpront);

        JPanel busca = new JPanel();
        // Input de nome
        JPanel nome = new JPanel();
        nome.setLayout(new FlowLayout());
        JLabel lbNome = new JLabel("                          Nome: ");
        txtNome = new JTextField(15);
        txtNome.setEditable(false);
        nome.add(lbNome);
        nome.add(txtNome);

        // Input de intrumentos
        JPanel instrumentos = new JPanel();
        instrumentos.setLayout(new FlowLayout());
        JLabel lbInst = new JLabel("            Instrumentos: ");
        txtInst = new JTextField(15);
        txtInst.setEditable(false);
        instrumentos.add(lbInst);
        instrumentos.add(txtInst);

        // Input de favoritos
        JPanel favorito = new JPanel();
        favorito.setLayout(new FlowLayout());
        JLabel lbFav = new JLabel("Instrumento favorito: ");
        txtFav = new JTextField(15);
        txtFav.setEditable(false);
        favorito.add(lbFav);
        favorito.add(txtFav);

        // Painel de botões
        JPanel botoes = new JPanel();
        btBuscar = new JButton("Buscar");
        btBuscar.addActionListener(handler);
        busca.add(btBuscar);
        btFecha = new JButton("Fechar");
        btFecha.addActionListener(handler);

        btAtualizar = new JButton("Atualizar");
        btAtualizar.addActionListener(handler);

        botoes.add(btFecha);
        botoes.add(btAtualizar);

        add(pront);
        add(busca);
        add(nome);
        add(instrumentos);
        add(favorito);
        add(botoes);
    }

    public void mostrar() {
        setVisible(true);
    }

    private class buttonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btBuscar) {

            } else if (e.getSource() == btAtualizar) {

            } else if (e.getSource() == btFecha) {

            }

        }
    }
}
