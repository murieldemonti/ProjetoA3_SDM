package View;

import java.awt.*;

import Model.Vinho;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class GerenciaVinho extends javax.swing.JPanel {

    private TelaPrincipal telaprincipal;
    private JPanel painel;
    private JLabel titulo;
    private JLabel Lpesquisa;
    private javax.swing.JTextField TFpesquisa;
    private javax.swing.JTable gtable;
    private javax.swing.JScrollPane jScrollPane1;
    private JLabel Lnome, Ldescricao, Lestoque, Lpreco, Lfabricacao, Ltipo, Lregiao, Lmarca;
    private JTextField TFnome, TFdescricao, TFestoque, TFpreco, TFfabricacao, TFtipo, TFregiao, TFmarca;
    private javax.swing.JButton BotaoMenu;
    private javax.swing.JButton BotaoAlterar;
    private javax.swing.JButton BotaoApagar;
    private Vinho objVinho;


    public GerenciaVinho(TelaPrincipal telaPrincipal) {
        this.telaprincipal = telaPrincipal;
        this.objVinho = new Vinho();
        initComponents();
        carregaTabela();

    }

    @SuppressWarnings("unchecked")
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


        //TABELA E SCROLL
        Lpesquisa = new javax.swing.JLabel();
        TFpesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        gtable = new javax.swing.JTable();


        Lpesquisa.setText("Pesquisar:");
        Lpesquisa.setOpaque(false);
        Lpesquisa.setBackground(new Color(0, 0, 0, 0));
        Lpesquisa.setForeground(Color.WHITE);
        Lpesquisa.setFont(new Font("Segoe UI", Font.BOLD, 15));
        Lpesquisa.setBounds(30, 170, 200, 25);

        // Remove fundo
        TFpesquisa.setOpaque(false);
        TFpesquisa.setBackground(new Color(0, 0, 0, 0));
        TFpesquisa.setForeground(Color.WHITE);
        TFpesquisa.setFont(new Font("Segoe UI", Font.BOLD, 15));
        TFpesquisa.setBounds(120, 170, 200, 25);
        TFpesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFpesquisaKeyReleased(evt);
            }
        });


        gtable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nome", "Descrição", "Estoque", "Preço", "Fabricação", "Tipo", "Região", "Marca"}

        ) {
            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        TableColumnModel columnModel = gtable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(25);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(50);
        columnModel.getColumn(5).setPreferredWidth(70);
        columnModel.getColumn(6).setPreferredWidth(90);
        columnModel.getColumn(7).setPreferredWidth(150);
        columnModel.getColumn(8).setPreferredWidth(120);

        gtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Renderer PRA CENTRALIZAR E DESTACAR SELEÇÃO
        DefaultTableCellRenderer customRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                Component c = super.getTableCellRendererComponent(table, value, isSelected, false, row, column);

                // CENTRALIZAR TEXTO DA COLUNA
                int[] centralizar = {0, 3, 4, 5}; // COLUNAS COM TEXTO CENTRALIZADO
                boolean deveCentralizar = false;
                for (int col : centralizar) {
                    if (col == column) {
                        deveCentralizar = true;
                        break;
                    }
                }

                if (deveCentralizar) {
                    setHorizontalAlignment(SwingConstants.CENTER);
                } else {
                    setHorizontalAlignment(SwingConstants.LEFT);
                }

                //COR
                setForeground(Color.WHITE);

                if (isSelected) {
                    c.setBackground(new Color(150, 0, 0, 180)); //COR DA SELEÇÃO
                } else {
                    c.setBackground(new Color(0, 0, 0, 0)); // TRANSPARENTE
                }

                setBorder(null);

                setOpaque(true);
                return c;
            }
        };
        gtable.setFocusable(false);

        // RENDERER EM TODAS AS COLUNAS
        for (int i = 0; i < gtable.getColumnCount(); i++) {
            gtable.getColumnModel().getColumn(i).setCellRenderer(customRenderer);
        }


        // TRANSPARENCIA DA TABELA
        gtable.setOpaque(false);
        gtable.setBackground(new Color(0, 0, 0, 0));
        gtable.setForeground(Color.WHITE);

        // RENDERER TRANSPARENTE
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setOpaque(false);
        gtable.setDefaultRenderer(Object.class, renderer);

        // CABEÇALHO TRANSPARENTE
        gtable.getTableHeader().setBorder(BorderFactory.createEmptyBorder());
        gtable.getTableHeader().setBackground(new Color(0, 0, 0, 0));
        gtable.getTableHeader().setForeground(Color.WHITE);
        gtable.getTableHeader().setReorderingAllowed(false);



        // =SCROLLPANE TRANSPARENTE
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane1.setViewportBorder(BorderFactory.createEmptyBorder());


        // REMOVE LINHA DA TABELA
        gtable.setShowGrid(false);                                           // Remove todas as linhas
        gtable.setIntercellSpacing(new Dimension(0, 0));        // Remove espaçamento entre células
        gtable.setBorder(null);                                             // Remove bordas
        jScrollPane1.setViewportBorder(BorderFactory.createEmptyBorder());  // Remove borda do scroll
        jScrollPane1.getViewport().setBorder(null);                         // Remove borda interna


        gtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gtableMouseClicked(evt);
            }
        });
        gtable.setRowHeight(22);
        jScrollPane1.setViewportView(gtable);
        jScrollPane1.setBounds(20, 220, 1040, 130);
        jScrollPane1.setViewportBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


        painel.add(Lpesquisa);
        painel.add(TFpesquisa);
        painel.add(jScrollPane1);


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

        int x1 = 200;
        int y1 = 565;

        Lnome.setText("Nome :");
        Lnome.setBounds(x1, 365, 200, 25);
        Ldescricao.setText("Descrição :");
        Ldescricao.setBounds(x1, 425, 200, 25);
        Lestoque.setText("Estoque :");
        Lestoque.setBounds(x1, 485, 200, 25);
        Lpreco.setText("Preço :");
        Lpreco.setBounds(x1, 545, 200, 25);
        Lfabricacao.setText("Fabricação :");
        Lfabricacao.setBounds(y1, 365, 200, 25);
        Ltipo.setText("Tipo :");
        Ltipo.setBounds(y1, 425, 200, 25);
        Lregiao.setText("Região :");
        Lregiao.setBounds(y1, 485, 200, 25);
        Lmarca.setText("Marca :");
        Lmarca.setBounds(y1, 545, 200, 25);

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

        int x = 200;
        int y = 565;

        TFnome.setBounds(x, 395, 200, 25);
        TFdescricao.setBounds(x, 455, 200, 25);
        TFestoque.setBounds(x, 515, 200, 25);
        TFpreco.setBounds(x, 575, 200, 25);
        TFfabricacao.setBounds(y, 395, 200, 25);
        TFtipo.setBounds(y, 455, 200, 25);
        TFregiao.setBounds(y, 515, 200, 25);
        TFmarca.setBounds(y, 575, 200, 25);

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
        BotaoAlterar = new JButton();
        BotaoApagar = new JButton();


        BotaoMenu.setBorderPainted(false);
        BotaoMenu.setContentAreaFilled(false);
        BotaoMenu.setFocusPainted(false);
        BotaoMenu.setOpaque(false);
        BotaoMenu.setText("Menu");
        BotaoMenu.setForeground(Color.WHITE);

        BotaoAlterar.setBorderPainted(false);
        BotaoAlterar.setContentAreaFilled(false);
        BotaoAlterar.setFocusPainted(false);
        BotaoAlterar.setOpaque(false);
        BotaoAlterar.setText("Alterar");
        BotaoAlterar.setForeground(Color.WHITE);

        BotaoApagar.setBorderPainted(false);
        BotaoApagar.setContentAreaFilled(false);
        BotaoApagar.setFocusPainted(false);
        BotaoApagar.setOpaque(false);
        BotaoApagar.setText("Apagar");
        BotaoApagar.setForeground(Color.WHITE);


        try {
            Font poppins = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Fontes/Poppins-Regular.ttf")).deriveFont(24f);

            BotaoMenu.setFont(poppins);
            BotaoAlterar.setFont(poppins);
            BotaoApagar.setFont(poppins);

        } catch (Exception e) {
            e.printStackTrace();

            // FALLBACK SE DER ERRO
            Font fallback = new Font("Segoe UI", Font.BOLD, 24);
            BotaoMenu.setFont(fallback);
            BotaoAlterar.setFont(fallback);
            BotaoApagar.setFont(fallback);
        }


        // EVENTOS
        BotaoMenu.addActionListener(evt -> BotaoMenuActionPerformed(evt));
        BotaoAlterar.addActionListener(evt -> BotaoAlterarActionPerformed(evt));
        BotaoApagar.addActionListener(evt -> BotaoApagarActionPerformed(evt));

        painel.add(BotaoMenu);
        painel.add(BotaoAlterar);
        painel.add(BotaoApagar);


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
        BotaoAlterar.setBounds(x2 - 165, y, larguraBotao, alturaBotao);
        BotaoApagar.setBounds(x2 + 25, y, larguraBotao, alturaBotao);

        int larguraTitulo = titulo.getPreferredSize().width;
        int alturaTitulo = titulo.getPreferredSize().height;
        int xTitulo = ((larguraJanela - larguraTitulo) / 2) - offset;

        titulo.setBounds(xTitulo, 45, larguraTitulo, alturaTitulo);
    }

    // AÇÕES BOTÕES

    private void TFpesquisaKeyReleased(java.awt.event.KeyEvent evt) {
        DefaultTableModel md = (DefaultTableModel) gtable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(md);
        gtable.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(TFpesquisa.getText()));
    }

    private void gtableMouseClicked(java.awt.event.MouseEvent evt) {
        if (this.gtable.getSelectedRow() != -1) {
            TFnome.setText(gtable.getValueAt(gtable.getSelectedRow(), 1).toString());
            TFdescricao.setText(gtable.getValueAt(gtable.getSelectedRow(), 2).toString());
            TFestoque.setText(gtable.getValueAt(gtable.getSelectedRow(), 3).toString());
            TFpreco.setText(gtable.getValueAt(gtable.getSelectedRow(), 4).toString());
            TFfabricacao.setText(gtable.getValueAt(gtable.getSelectedRow(), 5).toString());
            TFtipo.setText(gtable.getValueAt(gtable.getSelectedRow(), 6).toString());
            TFregiao.setText(gtable.getValueAt(gtable.getSelectedRow(), 7).toString());
            TFmarca.setText(gtable.getValueAt(gtable.getSelectedRow(), 8).toString());
        }
    }

    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.gtable.getModel();
        modelo.setNumRows(0);
        ArrayList<Vinho> minhalista = objVinho.getMinhaLista();

        for (Vinho v : minhalista) {
            modelo.addRow(new Object[]{v.getId(), v.getNome(), v.getDescricao(), v.getQuant_estoque(), v.getPreco(), v.getData_cadastro(), v.getTipo(), v.getRegiao(), v.getMarca()});
        }
    }

    private void BotaoMenuActionPerformed(java.awt.event.ActionEvent evt) {
        if (telaprincipal != null) {
            telaprincipal.setPainel(new PainelInicial(telaprincipal));
        } else {
            JOptionPane.showInternalMessageDialog(this, "Erro: tela principal não definida!");
        }
    }

    private void BotaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int id = 0;
            String nome = "";
            String descricao = "";
            int quant_estoque = 0;
            double preco = 0.0;
            String data_cadastro = "";
            String tipo = "";
            String regiao = "";
            String marca = "";

            if (this.TFnome.getText().length() < 2) {
                throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.TFnome.getText();
            }

            if (this.TFdescricao.getText().length() < 2) {
                throw new Mensagens("Descrição deve conter ao menos 2 caracteres.");
            } else {
                descricao = this.TFdescricao.getText();
            }

            if (this.TFestoque.getText().length() <= 0) {
                throw new Mensagens("Qauntidade em estoque deve ser número e maior que zero.");
            } else {
                quant_estoque = Integer.parseInt(this.TFestoque.getText());
            }

            if (this.TFpreco.getText().length() <= 0.0) {
                throw new Mensagens("Preço deve ser número e maior que zero.");
            } else {
                preco = Double.parseDouble(this.TFpreco.getText());
            }

            if (this.TFfabricacao.getText().length() < 2) {
                throw new Mensagens("Data de Fabricação deve conter uma data.");
            } else {
                data_cadastro = this.TFfabricacao.getText();
            }

            if (this.TFtipo.getText().length() < 2) {
                throw new Mensagens("Tipo deve conter ao menos 2 caracteres.");
            } else {
                tipo = this.TFtipo.getText();
            }

            if (this.TFregiao.getText().length() < 2) {
                throw new Mensagens("Região deve conter ao menos 2 caracteres.");
            } else {
                regiao = this.TFregiao.getText();
            }

            if (this.TFmarca.getText().length() < 2) {
                throw new Mensagens("Marca deve conter ao menos 2 caracteres.");
            } else {
                marca = this.TFmarca.getText();
            }

            if (this.gtable.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro selecione um vinho para alterar.");
            } else {
                id = Integer.parseInt(this.gtable.getValueAt(this.gtable.getSelectedRow(), 0).toString());
            }

            if (this.objVinho.UpdateVinhoBD(tipo, regiao, marca, id, nome, descricao, quant_estoque, preco, data_cadastro)) {

                this.TFnome.setText("");
                this.TFdescricao.setText("");
                this.TFestoque.setText("");
                this.TFpreco.setText("");
                this.TFfabricacao.setText("");
                this.TFtipo.setText("");
                this.TFregiao.setText("");
                this.TFmarca.setText("");
                JOptionPane.showInternalMessageDialog(this, "Vinho alterado com sucesso!");
            }
            System.out.println(this.objVinho.getMinhaLista().toString());
        } catch (Mensagens erro) {
            JOptionPane.showInternalMessageDialog(this, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showInternalMessageDialog(this, "Informe um número.");
        } finally {
            carregaTabela();
        }

    }

    private void BotaoApagarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int id = 0;
            if (this.gtable.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro selecione um Vinho para apagar.");
            } else {
                id = Integer.parseInt(this.gtable.getValueAt(this.gtable.getSelectedRow(), 0).toString());
            }
            int confirma_apagar = JOptionPane.showInternalConfirmDialog(this, "Tem certeza que deseja apagar este Vinho?");

            if (confirma_apagar == 0) {

                if (this.objVinho.DeleteVinhoBD(id)) {

                    this.TFnome.setText("");
                    this.TFdescricao.setText("");
                    this.TFestoque.setText("");
                    this.TFpreco.setText("");
                    this.TFfabricacao.setText("");
                    this.TFtipo.setText("");
                    this.TFregiao.setText("");
                    this.TFmarca.setText("");
                    JOptionPane.showInternalMessageDialog(this, "Vinho apagado com sucesso!");
                }
            }

            System.out.println(this.objVinho.getMinhaLista().toString());

        } catch (Mensagens erro) {
            JOptionPane.showInternalMessageDialog(this, erro.getMessage());
        } finally {

            carregaTabela();
        }
    }
}