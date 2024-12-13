package View.Funcionario;

import Model.Usuario;
import View.SuperUsuario.InicioSesion;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PersonaInformationMenu extends JFrame {
    private Usuario funcionario;

    public PersonaInformationMenu(Usuario funcionario) {
        this.funcionario = funcionario;
        initComponents();
        this.setLocationRelativeTo(null);
        lblNombreUsuario.setText(funcionario.getNombre());

        btnHouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FuncionarioMainMenu funcionarioMainMenu = new FuncionarioMainMenu(funcionario);
                funcionarioMainMenu.setVisible(true);
                dispose();
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioSesion inicioSesion = new InicioSesion();
                inicioSesion.setVisible(true);
                dispose();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        superiorBackground = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        lblImgSide = new javax.swing.JLabel();
        lblCrearSupervisor = new javax.swing.JLabel();
        DocLabel = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtFieldNombre = new javax.swing.JTextField();
        txtFieldActivo = new javax.swing.JTextField();
        txtFieldDocumento = new javax.swing.JTextField();
        txtFieldEstado = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnHouse = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblEmpresa1 = new javax.swing.JLabel();
        txtFieldEmpresa = new javax.swing.JTextField();
        lblEmpresa2 = new javax.swing.JLabel();
        lblEmpresa3 = new javax.swing.JLabel();
        txtFieldPlaca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(52, 33, 91));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        superiorBackground.setBackground(new java.awt.Color(52, 33, 91));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Banner.png"))); // NOI18N

        lblNombreUsuario.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("Username");

        lblTipoUsuario.setFont(new java.awt.Font("FreeSans", 1, 36)); // NOI18N
        lblTipoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoUsuario.setText("Funcionario");

        javax.swing.GroupLayout superiorBackgroundLayout = new javax.swing.GroupLayout(superiorBackground);
        superiorBackground.setLayout(superiorBackgroundLayout);
        superiorBackgroundLayout.setHorizontalGroup(
                superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                .addComponent(lblLogo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))
        );
        superiorBackgroundLayout.setVerticalGroup(
                superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, superiorBackgroundLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblTipoUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNombreUsuario)
                                .addGap(12, 12, 12))
        );

        lblImgSide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Empresa.png"))); // NOI18N
        lblImgSide.setText("jLabel1");

        lblCrearSupervisor.setFont(new java.awt.Font("FreeSans", 1, 36)); // NOI18N
        lblCrearSupervisor.setText("Datos Persona");

        DocLabel.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        DocLabel.setText("Documento");

        lblEmpresa.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lblEmpresa.setText("Estado");

        nombreLabel.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        nombreLabel.setText("Nombre");

        lblPassword.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lblPassword.setText("Activo");


        btnCrear.setBackground(new java.awt.Color(255, 102, 102));
        btnCrear.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnCrear.setText("Desactivar");
        btnCrear.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnHouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/casa.png"))); // NOI18N
        btnHouse.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));


        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); // NOI18N
        btnLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblEmpresa1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lblEmpresa1.setText("Nit Empresa");



        lblEmpresa2.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N

        lblEmpresa3.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lblEmpresa3.setText("Placa");



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(superiorBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(lblImgSide, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnHouse)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(236, 236, 236)
                                                                .addComponent(btnLogout)
                                                                .addGap(36, 36, 36))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblEmpresa2)
                                                                .addGap(128, 128, 128)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(lblPassword)
                                                                                        .addComponent(lblEmpresa))
                                                                                .addGap(71, 71, 71)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(txtFieldEstado)
                                                                                        .addComponent(txtFieldActivo)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(lblEmpresa1)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(6, 6, 6)
                                                                                                .addComponent(lblEmpresa3)))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(txtFieldPlaca)
                                                                                        .addComponent(txtFieldEmpresa)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(DocLabel)
                                                                                        .addComponent(nombreLabel))
                                                                                .addGap(19, 19, 19)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(txtFieldNombre)
                                                                                        .addComponent(txtFieldDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addContainerGap(166, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(231, 231, 231)
                                                .addComponent(lblCrearSupervisor)
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(superiorBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblImgSide, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(28, 28, 28)
                                                                .addComponent(lblCrearSupervisor)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(352, 352, 352)
                                                                                .addComponent(lblEmpresa2))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(28, 28, 28)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(DocLabel)
                                                                                        .addComponent(txtFieldDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(28, 28, 28)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(nombreLabel)
                                                                                        .addComponent(txtFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(33, 33, 33)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(lblPassword)
                                                                                        .addComponent(txtFieldActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(38, 38, 38)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(lblEmpresa)
                                                                                        .addComponent(txtFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(32, 32, 32)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(lblEmpresa1)
                                                                                        .addComponent(txtFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(37, 37, 37)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(lblEmpresa3)
                                                                                        .addComponent(txtFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnHouse))))
                                                .addGap(29, 29, 29))))
        );

        pack();
    }// </editor-fold>



    // Variables declaration - do not modify
    private javax.swing.JLabel DocLabel;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnHouse;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel lblCrearSupervisor;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblEmpresa1;
    private javax.swing.JLabel lblEmpresa2;
    private javax.swing.JLabel lblEmpresa3;
    private javax.swing.JLabel lblImgSide;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JPanel superiorBackground;
    private javax.swing.JTextField txtFieldActivo;
    private javax.swing.JTextField txtFieldDocumento;
    private javax.swing.JTextField txtFieldEmpresa;
    private javax.swing.JTextField txtFieldEstado;
    private javax.swing.JTextField txtFieldNombre;
    private javax.swing.JTextField txtFieldPlaca;
    // End of variables declaration
}
