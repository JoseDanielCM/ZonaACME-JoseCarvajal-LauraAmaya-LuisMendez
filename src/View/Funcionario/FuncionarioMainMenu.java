package View.Funcionario;

import Model.Usuario;
import Repository.Impl.ConcurrenciaRegistros;
import View.SuperUsuario.InicioSesion;

import javax.swing.*;
import java.awt.event.ActionListener;
    public class FuncionarioMainMenu extends javax.swing.JFrame {

        private Usuario funcionario;

        public FuncionarioMainMenu(Usuario funcionario) {
            this.funcionario = funcionario;
            initComponents();
            this.setLocationRelativeTo(null);
            lblBienvenida.setText(funcionario.getNombre());
            ConcurrenciaRegistros.manejoRegistros(jTextAreaRegistros, funcionario);
            // --------------------------------------------------------------------------------
            btnLogout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    InicioSesion inicioSesion = new InicioSesion();
                    inicioSesion.setVisible(true);
                    dispose();
                }
            });
            // --------------------------------------------------------------------------------
            brnGestionPersonas.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    GestionPersonasMenu gestionPersonasMenu = new GestionPersonasMenu(funcionario);
                    gestionPersonasMenu.setVisible(true);
                    dispose();
                }
            });
            btnPersonasActivas.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PersonasActivasMenu personasActivasMenu = new PersonasActivasMenu(funcionario);
                    personasActivasMenu.setVisible(true);
                    dispose();
                }
            });
            btnRegistroManual.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    SalidaManualMenu salidaManualMenu = new SalidaManualMenu(funcionario);
                    salidaManualMenu.setVisible(true);
                    dispose();
                }
            });

            btnActualizarPersona.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ActualizarPersonaMenu actualizarPersonaMenu = new ActualizarPersonaMenu(funcionario);
                    actualizarPersonaMenu.setVisible(true);
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
            brnGestionPersonas = new javax.swing.JButton();
            btnPersonasActivas = new javax.swing.JButton();
            btnActualizarPersona = new javax.swing.JButton();
            btnLogout = new javax.swing.JButton();
            btnRegistroManual = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTextAreaRegistros = new javax.swing.JTextArea();

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
            lblBienvenida2.setText("FUNCIONARIO");

            javax.swing.GroupLayout superiorBackgroundLayout = new javax.swing.GroupLayout(superiorBackground);
            superiorBackground.setLayout(superiorBackgroundLayout);
            superiorBackgroundLayout.setHorizontalGroup(
                    superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 408, Short.MAX_VALUE)
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

            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Empresa.png"))); // NOI18N
            jLabel1.setText("jLabel1");

            brnGestionPersonas.setBackground(new java.awt.Color(52, 33, 91));
            brnGestionPersonas.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
            brnGestionPersonas.setForeground(new java.awt.Color(255, 255, 255));
            brnGestionPersonas.setText("Gestion Personas");
            brnGestionPersonas.setToolTipText("");
            brnGestionPersonas.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    brnGestionPersonasActionPerformed(evt);
                }
            });

            btnPersonasActivas.setBackground(new java.awt.Color(52, 33, 91));
            btnPersonasActivas.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
            btnPersonasActivas.setForeground(new java.awt.Color(255, 255, 255));
            btnPersonasActivas.setText("Personas Activas");
            btnPersonasActivas.setToolTipText("");
            btnPersonasActivas.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnPersonasActivasActionPerformed(evt);
                }
            });
            jTextAreaRegistros.setEditable(false);
            btnActualizarPersona.setBackground(new java.awt.Color(52, 33, 91));
            btnActualizarPersona.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
            btnActualizarPersona.setForeground(new java.awt.Color(255, 255, 255));
            btnActualizarPersona.setText("Actualizar Persona");
            btnActualizarPersona.setToolTipText("");
            btnActualizarPersona.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnActualizarPersonaActionPerformed(evt);
                }
            });

            btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); // NOI18N
            btnLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

            btnRegistroManual.setBackground(new java.awt.Color(52, 33, 91));
            btnRegistroManual.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
            btnRegistroManual.setForeground(new java.awt.Color(255, 255, 255));
            btnRegistroManual.setText("Salida Manual");
            btnRegistroManual.setToolTipText("");
            btnRegistroManual.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnRegistroManualActionPerformed(evt);
                }
            });

            jTextAreaRegistros.setColumns(20);
            jTextAreaRegistros.setRows(5);
            jScrollPane1.setViewportView(jTextAreaRegistros);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(superiorBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(107, 107, 107)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(btnPersonasActivas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(brnGestionPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(btnActualizarPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(btnRegistroManual, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnLogout)
                                                    .addGap(18, 18, 18)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(superiorBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGap(16, 16, 16)
                                                    .addComponent(brnGestionPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(39, 39, 39)
                                                    .addComponent(btnPersonasActivas, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(34, 34, 34)
                                                    .addComponent(btnRegistroManual, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(29, 29, 29)
                                                    .addComponent(btnActualizarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(15, 15, 15))))
            );

            pack();
        }// </editor-fold>

        private void brnGestionPersonasActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void btnPersonasActivasActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void btnActualizarPersonaActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void btnRegistroManualActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        // Variables declaration - do not modify
        private javax.swing.JButton brnGestionPersonas;
        private javax.swing.JButton btnActualizarPersona;
        private javax.swing.JButton btnLogout;
        private javax.swing.JButton btnPersonasActivas;
        private javax.swing.JButton btnRegistroManual;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextArea jTextAreaRegistros;
        private javax.swing.JLabel lblBienvenida;
        private javax.swing.JLabel lblBienvenida2;
        private javax.swing.JPanel superiorBackground;
        // End of variables declaration
    }
