package visao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import controle.*;
import modelo.AlunoVO;

public class AdicionarAlunoVisao extends JFrame {

    private AlunoControle controle;
   
    public ListarAlunoVisao lista;
    // ListarAlunoVisao a;

    private JTextField txtpront, txtNome, txtFav, txtBolsa;
    private JButton btAdiciona, btLimpa, btFecha;
    private JComboBox<String> txtInst;

    private String data;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public AdicionarAlunoVisao(AlunoControle controle, ListarAlunoVisao lista) {

        this.controle = controle;
        this.lista = lista;
        
        setSize(420, 260);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Adicionar integrante");
        setLayout(new FlowLayout());
        setLocation(((int) screenSize.getWidth()/2) - 210, 235);
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

        // Input de nome
        JPanel nome = new JPanel();
        nome.setLayout(new FlowLayout());
        JLabel lbNome = new JLabel("                          Nome: ");
        txtNome = new JTextField(15);

        nome.add(lbNome);
        nome.add(txtNome);

        String[] numeros = new String[13];
        for (int i = 1; i <= 13; i++) {
            numeros[i - 1] = String.valueOf(i);
        }
        // Input de intrumentos
        JPanel instrumentos = new JPanel();
        instrumentos.setLayout(new FlowLayout());
        JLabel lbInst = new JLabel("            Instrumentos: ");
        txtInst = new JComboBox<>(numeros);

        instrumentos.add(lbInst);
        instrumentos.add(txtInst);

        // Input de favoritos
        JPanel favorito = new JPanel();
        favorito.setLayout(new FlowLayout());
        JLabel lbFav = new JLabel("Instrumento favorito: ");
        txtFav = new JTextField(15);

        favorito.add(lbFav);
        favorito.add(txtFav);

        JPanel bolsa = new JPanel();
        bolsa.setLayout(new FlowLayout());
        JLabel lbBolsa = new JLabel("         Valor da bolsa:  ");
        txtBolsa = new JTextField(15);

        bolsa.add(lbBolsa);
        bolsa.add(txtBolsa);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        data = df.format(new Date());

        // Painel de botões
        JPanel botoes = new JPanel();
        btAdiciona = new JButton("Adicionar");
        btAdiciona.addActionListener(handler);

        btFecha = new JButton("Fechar");
        btFecha.addActionListener(handler);

        btLimpa = new JButton("Limpar");
        btLimpa.addActionListener(handler);

        botoes.add(btAdiciona);
        botoes.add(btFecha);
        botoes.add(btLimpa);

        ImageIcon imagem = new ImageIcon("./imagens/add.png");
        setIconImage(imagem.getImage());


        // adicionando a janela principal
        add(pront);
        add(nome);
        add(favorito);
        add(instrumentos);
        add(bolsa);
        add(botoes);

        setResizable(true);

    }

    private void adiciona() {

        if(!txtpront.getText().equals("") && !txtNome.getText().equals("") && !txtFav.getText().equals("") && !txtBolsa.getText().equals("")) {
            if (controle.existePront(txtpront.getText().trim().toLowerCase())) {
                JOptionPane.showMessageDialog(AdicionarAlunoVisao.this, "Já existe um aluno com este prontuário!");
                txtpront.requestFocus();
            } else {
                controle.adiciona(new AlunoVO(txtpront.getText().toUpperCase(), txtNome.getText(),
                    txtInst.getSelectedIndex() + 1, txtFav.getText(), data, Double.parseDouble(txtBolsa.getText())));

                JOptionPane.showMessageDialog(AdicionarAlunoVisao.this,
                    "Aluno adicionado! pront: " + txtpront.getText() + " | Nome: " + txtNome.getText()
                            + " | Intrumentos tocados: " + (txtInst.getSelectedIndex() + 1) + " | favoritos: " + txtFav.getText());
            lista.atualizar(controle);
            limpa();
            }
        }
        else {
           JOptionPane.showMessageDialog(AdicionarAlunoVisao.this, "Preencha todos os campos!"); 
        }

       
    }

    private void limpa() {
        txtpront.setText("");
        txtNome.setText("");
        txtInst.setSelectedItem("");
        txtFav.setText("");
        txtInst.setSelectedIndex(0);
        txtBolsa.setText("");
    }

    private void fecha() {
        dispose();
    }

    public void mostrar() {
        setVisible(true);
    }

    private class buttonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btAdiciona) {
                adiciona();
            } else if (e.getSource() == btLimpa) {
                limpa();
            } else if (e.getSource() == btFecha) {
                fecha();
            }

        }

    }

}
