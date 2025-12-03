package View;

import Model.Vinho;

import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class CadastroVinho extends javax.swing.JPanel {

    private TelaPrincipal telaprincipal;
    private JPanel painel;
    private JLabel titulo;
    private JLabel Lnome, Ldescricao, Lestoque, Lpreco, Lfabricacao, Ltipo, Lregiao, Lmarca;
    private JTextField TFnome, TFdescricao, TFestoque, TFpreco, TFfabricacao, TFtipo, TFregiao, TFmarca;
    private JButton BotaoMenu;
    private JButton BotaoCadastrar;
    private Vinho objVinho;


    public CadastroVinho(TelaPrincipal telaPrincipal) {
        this.telaprincipal = telaPrincipal;
        initComponents();
        this.objVinho = new Vinho();

    }


    private void initComponents() {

        // BACKGROUND
        BackgroundPanel background = new BackgroundPanel();
        background.setLayout(new BorderLayout());

        // PAINEL
        painel = new JPanel();
        painel.setOpaque(false);
        painel.setLayout(null);

        //TITULO
        titulo = new JLabel("Wine & Rose");
        titulo.setForeground(Color.WHITE);
        try {
            Font alexBrush = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Fontes/AlexBrush-Regular.ttf"));
            alexBrush = alexBrush.deriveFont(100f);

            titulo.setFont(alexBrush);

        } catch (Exception e) {
            e.printStackTrace();
            // FALLBACK SE DER ERRO
            titulo.setFont(new Font("Segoe UI", Font.BOLD, 72));
        }

        painel.add(titulo);

        //LABEL
        Lnome = new JLabel();
        Ldescricao = new JLabel();
        Lestoque = new JLabel();
        Lpreco = new JLabel();
        Lfabricacao = new JLabel();
        Ltipo = new JLabel();
        Lregiao = new JLabel();
        Lmarca = new JLabel();

        JLabel[] textos = {Lnome, Ldescricao, Lestoque, Lpreco, Lfabricacao, Ltipo, Lregiao, Lmarca};
        for (JLabel texto : textos) {
            // REMOVE O FUNDO
            texto.setOpaque(false);
            // REMOVE O BACKGROUND PADRÃO
            texto.setBackground(new Color(0, 0, 0, 0));
            // COR DE TEXTO
            texto.setForeground(Color.WHITE);
            // FONTE
            texto.setFont(new Font("Segoe UI", Font.BOLD, 15));
        }

        int x2 = 267;

        Lnome.setText("Nome :");
        Lnome.setBounds(x2, 195, 250, 30);
        Ldescricao.setText("Descrição :");
        Ldescricao.setBounds(x2, 245, 250, 30);
        Lestoque.setText("Estoque :");
        Lestoque.setBounds(x2, 295, 250, 30);
        Lpreco.setText("Preço :");
        Lpreco.setBounds(x2, 345, 250, 30);
        Lfabricacao.setText("Fabricação :");
        Lfabricacao.setBounds(x2, 395, 250, 30);
        Ltipo.setText("Tipo :");
        Ltipo.setBounds(x2, 445, 250, 30);
        Lregiao.setText("Região :");
        Lregiao.setBounds(x2, 495, 250, 30);
        Lmarca.setText("Marca :");
        Lmarca.setBounds(x2, 545, 250, 30);

        painel.add(Lnome);
        painel.add(Ldescricao);
        painel.add(Lestoque);
        painel.add(Lpreco);
        painel.add(Lfabricacao);
        painel.add(Ltipo);
        painel.add(Lregiao);
        painel.add(Lmarca);

        //TEXTFIELD
        TFnome = new JTextField();
        TFdescricao = new JTextField();
        TFestoque = new JTextField();
        TFpreco = new JTextField();
        TFfabricacao = new JTextField();
        TFtipo = new JTextField();
        TFregiao = new JTextField();
        TFmarca = new JTextField();


        JTextField[] campos = {TFnome, TFdescricao, TFestoque, TFpreco, TFfabricacao, TFtipo, TFregiao, TFmarca};
        for (JTextField campo : campos) {
            // REMOVE O FUNDO
            campo.setOpaque(false);
            // REMOVE O BACKGROUND PADRÃO
            campo.setBackground(new Color(0, 0, 0, 0));
            // COR DE TEXTO
            campo.setForeground(Color.WHITE);
            // FONTE
            campo.setFont(new Font("Segoe UI", Font.BOLD, 15));
        }

        int x = 427;

        TFnome.setBounds(x, 195, 250, 30);
        TFdescricao.setBounds(x, 245, 250, 30);
        TFestoque.setBounds(x, 295, 250, 30);
        TFpreco.setBounds(x, 345, 250, 30);
        TFfabricacao.setBounds(x, 395, 250, 30);
        TFtipo.setBounds(x, 445, 250, 30);
        TFregiao.setBounds(x, 495, 250, 30);
        TFmarca.setBounds(x, 545, 250, 30);


        painel.add(TFnome);
        painel.add(TFdescricao);
        painel.add(TFestoque);
        painel.add(TFpreco);
        painel.add(TFfabricacao);
        painel.add(TFtipo);
        painel.add(TFregiao);
        painel.add(TFmarca);


        // BOTÕES
        BotaoMenu = new JButton();
        BotaoCadastrar = new JButton();


        BotaoMenu.setBorderPainted(false);
        BotaoMenu.setContentAreaFilled(false);
        BotaoMenu.setFocusPainted(false);
        BotaoMenu.setOpaque(false);
        BotaoMenu.setText("Menu");
        BotaoMenu.setForeground(Color.WHITE);


        BotaoCadastrar.setBorderPainted(false);
        BotaoCadastrar.setContentAreaFilled(false);
        BotaoCadastrar.setFocusPainted(false);
        BotaoCadastrar.setOpaque(false);
        BotaoCadastrar.setText("Cadastrar");
        BotaoCadastrar.setForeground(Color.WHITE);


        try {
            Font poppins = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Fontes/Poppins-Regular.ttf")).deriveFont(24f);

            BotaoMenu.setFont(poppins);
            BotaoCadastrar.setFont(poppins);

        } catch (Exception e) {
            e.printStackTrace();

            // FALLBACK SE DER ERRO
            Font fallback = new Font("Segoe UI", Font.BOLD, 24);
            BotaoMenu.setFont(fallback);
            BotaoCadastrar.setFont(fallback);
        }


        // EVENTOS
        BotaoMenu.addActionListener(evt -> BotaoMenuActionPerformed(evt));
        BotaoCadastrar.addActionListener(evt -> BotaoCadastrarActionPerformed(evt));

        painel.add(BotaoMenu);
        painel.add(BotaoCadastrar);


        // ADICIONA AO FUNDO
        background.add(painel, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(background, BorderLayout.CENTER);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                centralizar();
            }
        });
        centralizar();
    }


    // CLASSE DO FUNDO
    class BackgroundPanel extends JPanel {

        private Image backgroundImage;

        public BackgroundPanel() {
            backgroundImage = new ImageIcon(getClass().getResource("/Imagens/oak.jpg")).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private int getLarguraJanela() {
        Window janela = SwingUtilities.getWindowAncestor(this);
        return (janela != null) ? janela.getWidth() : getWidth();
    }

    private void centralizar() {

        int larguraJanela = getLarguraJanela();

        int larguraBotao = 175;
        int alturaBotao = 40;
        int espacamento = 200;
        int offset = +315;

        int centro = (larguraJanela / 2) - offset;

        int x1 = centro - larguraBotao - (espacamento / 2);

        int x2 = centro + (espacamento / 2);

        int y = 620;

        BotaoMenu.setBounds(x1 + 35, y, larguraBotao, alturaBotao);
        BotaoCadastrar.setBounds(x2 - 95, y, larguraBotao, alturaBotao);


        int larguraTitulo = titulo.getPreferredSize().width;
        int alturaTitulo = titulo.getPreferredSize().height;
        int xTitulo = ((larguraJanela - larguraTitulo) / 2) - offset;

        titulo.setBounds(xTitulo, 45, larguraTitulo, alturaTitulo);
    }


    // AÇÕES BOTÕES
    private void BotaoMenuActionPerformed(java.awt.event.ActionEvent evt) {
        if (telaprincipal != null) {
            telaprincipal.setPainel(new PainelInicial(telaprincipal));
        } else {
            JOptionPane.showInternalMessageDialog(this, "Erro: tela principal não definida!");
        }
    }

    private void BotaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String nome = TFnome.getText().trim();
            String descricao = TFdescricao.getText().trim();
            int quantEstoque = Integer.parseInt(TFestoque.getText().trim());
            double preco = Double.parseDouble(TFpreco.getText().trim());
            String dataCadastro = TFfabricacao.getText().trim();
            String tipo = TFtipo.getText().trim();
            String regiao = TFregiao.getText().trim();
            String marca = TFmarca.getText().trim();

            if (nome.isEmpty() || descricao.isEmpty() || tipo.isEmpty() || regiao.isEmpty() || marca.isEmpty())
                throw new Exception("Todos os campos devem ser preenchidos corretamente.");

            if (quantEstoque <= 0) throw new Exception("A quantidade deve ser maior que zero.");

            if (preco <= 0) throw new Exception("O preço deve ser maior que zero.");

            if (objVinho.InsertVinhoBD(tipo, regiao, marca, nome, descricao, quantEstoque, preco, dataCadastro)) {
                JOptionPane.showInternalMessageDialog(this, "Vinho cadastrado com sucesso!");
                TFnome.setText("");
                TFdescricao.setText("");
                TFestoque.setText("");
                TFpreco.setText("");
                TFfabricacao.setText("");
                TFtipo.setText("");
                TFregiao.setText("");
                TFmarca.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showInternalMessageDialog(this, "Erro: verifique os campos numéricos (estoque/preço).");
        } catch (SQLException ex) {
            Logger.getLogger(CadastroVinho.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showInternalMessageDialog(this, "Erro de banco de dados.");
        } catch (Exception ex) {
            JOptionPane.showInternalMessageDialog(this, ex.getMessage());
        }
    }
}