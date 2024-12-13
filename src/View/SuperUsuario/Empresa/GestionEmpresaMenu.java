package View.SuperUsuario.Empresa;

import Controller.SuperUsuarioController;
import Model.Empresa;
import Model.Usuario;
import View.SuperUsuario.InicioSesion;
import View.SuperUsuario.SuperUsuarioMainMenu;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GestionEmpresaMenu extends JFrame {

    private Usuario superUsuario;
    public GestionEmpresaMenu(Usuario superUsuario) {
        this.superUsuario = superUsuario;
        initComponents();
        this.setLocationRelativeTo(null);
        lblNombreUsuario.setText(superUsuario.getNombre());

// ---------------------------------------------------------------- ENTRADAS ----------------------------------------------------------------
        btnHouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuperUsuarioMainMenu superUsuarioMainMenu = new SuperUsuarioMainMenu(superUsuario);
                superUsuarioMainMenu.setVisible(true);
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
// ---------------------------------------------------------------- ENTRADAS ----------------------------------------------------------------

        btnCrearEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearNuevaEmpresaMenu crearNuevaEmpresaMenu = new CrearNuevaEmpresaMenu(superUsuario);
                crearNuevaEmpresaMenu.setVisible(true);
                dispose();
            }
        });

        btnAccederEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String nombreEmpresa = txtFieldNit.getText();

                String nitEmpresa = txtFieldNombre.getText();


                SuperUsuarioController superUsuarioController = new SuperUsuarioController();
                Empresa empresa = superUsuarioController.getEmpresaById(nitEmpresa);

                DatosEmpresaMenu datosEmpresaMenu = new DatosEmpresaMenu(superUsuario,empresa);
                datosEmpresaMenu.setVisible(true);
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
        lblNit = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        txtFieldNombre = new javax.swing.JTextField();
        txtFieldNit = new javax.swing.JTextField();
        btnCrearEmpresa = new javax.swing.JButton();
        btnHouse = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblCrearSupervisor1 = new javax.swing.JLabel();
        btnAccederEmpresa = new javax.swing.JButton();

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
        lblTipoUsuario.setText("SUPERUSUARIO");

        javax.swing.GroupLayout superiorBackgroundLayout = new javax.swing.GroupLayout(superiorBackground);
        superiorBackground.setLayout(superiorBackgroundLayout);
        superiorBackgroundLayout.setHorizontalGroup(
                superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                .addComponent(lblLogo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
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

        lblCrearSupervisor.setFont(new java.awt.Font("FreeSans", 1, 24)); // NOI18N
        lblCrearSupervisor.setText("Seleccione la empresa");

        lblNit.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lblNit.setText("Nit");

        nombreLabel.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        nombreLabel.setText("Nombre");



        btnCrearEmpresa.setBackground(new java.awt.Color(193, 255, 114));
        btnCrearEmpresa.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnCrearEmpresa.setText("Crear Empresa");
        btnCrearEmpresa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnHouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/casa.png"))); // NOI18N
        btnHouse.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));


        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); // NOI18N
        btnLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblCrearSupervisor1.setFont(new java.awt.Font("FreeSans", 1, 36)); // NOI18N
        lblCrearSupervisor1.setText("Gestion De Empresas ");

        btnAccederEmpresa.setBackground(new java.awt.Color(205, 181, 255));
        btnAccederEmpresa.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnAccederEmpresa.setText("Acceder A Empresa");
        btnAccederEmpresa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

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
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(txtFieldNit, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txtFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGap(27, 27, 27)
                                                                .addComponent(btnCrearEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnAccederEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(32, 32, 32))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnHouse)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnLogout))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(lblCrearSupervisor1))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(96, 96, 96)
                                                                                .addComponent(nombreLabel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(lblNit)))
                                                                .addGap(151, 151, 151)))
                                                .addGap(25, 25, 25))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblCrearSupervisor)
                                                .addGap(244, 244, 244))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(superiorBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblImgSide, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(lblCrearSupervisor1)
                                                .addGap(28, 28, 28)
                                                .addComponent(lblCrearSupervisor)
                                                .addGap(81, 81, 81)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblNit)
                                                        .addComponent(nombreLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtFieldNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(35, 35, 35)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnCrearEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnAccederEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnHouse))
                                                .addGap(15, 15, 15))))
        );

        pack();
    }// </editor-fold>


    private javax.swing.JButton btnAccederEmpresa;
    private javax.swing.JButton btnCrearEmpresa;
    private javax.swing.JButton btnHouse;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel lblCrearSupervisor;
    private javax.swing.JLabel lblCrearSupervisor1;
    private javax.swing.JLabel lblImgSide;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNit;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JPanel superiorBackground;
    private javax.swing.JTextField txtFieldNit;
    private javax.swing.JTextField txtFieldNombre;
    // End of variables declaration
}
