package View.Supervisor;

import Model.Usuario;
import Repository.Impl.ConcurrenciaRegistros;
import View.SuperUsuario.DesactivarSupervisorMenu;
import View.SuperUsuario.InicioSesion;
import View.SuperUsuario.SuperUsuarioMainMenu;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SupervisorMainMenu extends JFrame {
    private Usuario supervisor;

    /**
     * Creates new form InicioSesion
     */
    public SupervisorMainMenu(Usuario supervisor) {
        this.supervisor = supervisor;
        initComponents();
        this.setLocationRelativeTo(null);
        lblBienvenida.setText(supervisor.getNombre());
        ConcurrenciaRegistros.manejoRegistros(jTextArea1, supervisor);
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioSesion inicioSesion = new InicioSesion();
                inicioSesion.setVisible(true);
                dispose();
            }
        });

        brnCrearSupervisor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearGuardaMenu crearGuardaMenu = new CrearGuardaMenu(supervisor);
                crearGuardaMenu.setVisible(true);
                dispose();
            }
        });
        // ----------------------------------------------------------------
        // * BOTON CREAR FUNCIONARIO
        btnDesactivarSupervisor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearFuncionarioMenu crearFuncionarioMenu = new CrearFuncionarioMenu(supervisor);
                crearFuncionarioMenu.setVisible(true);
                dispose();
            }
        });

        // ----------------------------------------------------------------
        // * BOTON DESACTIVAR USUARIO
        btnConfigurarDB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesactivarUsuarioMenu desactivarUsuarioMenu = new DesactivarUsuarioMenu(supervisor);
                desactivarUsuarioMenu.setVisible(true);
                dispose();
            }
        });

        // ----------------------------------------------------------------
        // * BOTON ANOTACIONES
        btnEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnotacionesMenu anotacionesMenu = new AnotacionesMenu(supervisor);
                anotacionesMenu.setVisible(true);
                dispose();
            }
        });

        // REGISTRAR SALIDA MANUAL
        btnConfigurarDB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalidaManualMenu salidaManualMenu = new SalidaManualMenu(supervisor);
                salidaManualMenu.setVisible(true);
                dispose();
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        superiorBackground = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblBienvenida = new javax.swing.JLabel();
        lblBienvenida2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        brnCrearSupervisor = new javax.swing.JButton();
        btnEmpresa = new javax.swing.JButton();
        btnDesactivarSupervisor = new javax.swing.JButton();
        btnConfigurarDB = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnConfigurarDB1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(52, 33, 91));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        superiorBackground.setBackground(new java.awt.Color(52, 33, 91));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Banner.png"))); // NOI18N

        lblBienvenida.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenida.setText("Username");

        lblBienvenida2.setFont(new java.awt.Font("FreeSans", 1, 36)); // NOI18N
        lblBienvenida2.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenida2.setText("SUPERVISOR");

        javax.swing.GroupLayout superiorBackgroundLayout = new javax.swing.GroupLayout(superiorBackground);
        superiorBackground.setLayout(superiorBackgroundLayout);
        superiorBackgroundLayout.setHorizontalGroup(
                superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                                .addGroup(superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblBienvenida2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblBienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))
        );
        superiorBackgroundLayout.setVerticalGroup(
                superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, superiorBackgroundLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblBienvenida2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBienvenida)
                                .addGap(12, 12, 12))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/imgSuperUsuario.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");

        brnCrearSupervisor.setBackground(new java.awt.Color(52, 33, 91));
        brnCrearSupervisor.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        brnCrearSupervisor.setForeground(new java.awt.Color(255, 255, 255));
        brnCrearSupervisor.setText("Crear Guarda");
        brnCrearSupervisor.setToolTipText("");
        brnCrearSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnCrearSupervisorActionPerformed(evt);
            }
        });

        btnEmpresa.setBackground(new java.awt.Color(52, 33, 91));
        btnEmpresa.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpresa.setText("Anotaciones");
        btnEmpresa.setToolTipText("");
        btnEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresaActionPerformed(evt);
            }
        });

        btnDesactivarSupervisor.setBackground(new java.awt.Color(52, 33, 91));
        btnDesactivarSupervisor.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnDesactivarSupervisor.setForeground(new java.awt.Color(255, 255, 255));
        btnDesactivarSupervisor.setText("Crear Funcionario");
        btnDesactivarSupervisor.setToolTipText("");
        btnDesactivarSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarSupervisorActionPerformed(evt);
            }
        });

        btnConfigurarDB.setBackground(new java.awt.Color(52, 33, 91));
        btnConfigurarDB.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnConfigurarDB.setForeground(new java.awt.Color(255, 255, 255));
        btnConfigurarDB.setText("Salida Manual");
        btnConfigurarDB.setToolTipText("");
        btnConfigurarDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigurarDBActionPerformed(evt);
            }
        });

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); // NOI18N
        btnLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnConfigurarDB1.setBackground(new java.awt.Color(52, 33, 91));
        btnConfigurarDB1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnConfigurarDB1.setForeground(new java.awt.Color(255, 255, 255));
        btnConfigurarDB1.setText("Desactivar Usuario");
        btnConfigurarDB1.setToolTipText("");
        btnConfigurarDB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigurarDB1ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(superiorBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnDesactivarSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(brnCrearSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnConfigurarDB)
                                                .addComponent(btnEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnConfigurarDB1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39)
                                .addComponent(btnLogout)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(superiorBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnDesactivarSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(brnCrearSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnConfigurarDB1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnConfigurarDB, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(19, 19, 19))))
        );

        pack();
    }// </editor-fold>

    private void brnCrearSupervisorActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnEmpresaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnDesactivarSupervisorActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnConfigurarDBActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnConfigurarDB1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify
    private javax.swing.JButton brnCrearSupervisor;
    private javax.swing.JButton btnConfigurarDB;
    private javax.swing.JButton btnConfigurarDB1;
    private javax.swing.JButton btnDesactivarSupervisor;
    private javax.swing.JButton btnEmpresa;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblBienvenida2;
    private javax.swing.JPanel superiorBackground;
    // End of variables declaration
}
