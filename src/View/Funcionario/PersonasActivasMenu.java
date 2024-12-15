package View.Funcionario;

import Controller.FuncionarioController;
import Model.Persona;
import Model.Usuario;
import Repository.Impl.ConcurrenciaRegistros;
import View.SuperUsuario.InicioSesion;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class PersonasActivasMenu extends JFrame {
    private Usuario funcionario;
    DefaultTableModel mt = new DefaultTableModel(new Object[]{"Documento", "Nombre", "Activo", "Tipo"},0){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Deshabilitar edición
        }
    };


    public PersonasActivasMenu(Usuario funcionario) {
        this.funcionario = funcionario;
        initComponents();
        this.setLocationRelativeTo(null);
        lblNombreUsuario.setText(funcionario.getNombre());
        // TABLA ----------------------------------------------------------------
        ConcurrenciaRegistros.manejoRegistros(jTextArea1, funcionario);
        FuncionarioController funcionarioController = new FuncionarioController();
        List<Persona> personas = funcionarioController.mostrarTodos();

        jTable1.setModel(mt);
        for (Persona person : personas){
            String tipo = person.getClass().getName();
            tipo = tipo.replace("Model.","");
            mt.addRow(new Object[]{person.getDocumento(),person.getNombre(),person.isActivo(),tipo});
        }

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
        private void initComponents () {

            superiorBackground = new javax.swing.JPanel();
            lblLogo = new javax.swing.JLabel();
            lblNombreUsuario = new javax.swing.JLabel();
            lblTipoUsuario = new javax.swing.JLabel();
            lblMonitoreoRegistros = new javax.swing.JLabel();
            btnHouse = new javax.swing.JButton();
            btnLogout = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTextArea1 = new javax.swing.JTextArea();
            jScrollPane3 = new javax.swing.JScrollPane();
            jTable1 = new javax.swing.JTable();
            // CODIGO
            jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                               boolean hasFocus, int row, int column) {
                    // Obtener el componente predeterminado
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    // Verificar el valor del atributo "Activo"
                    boolean isActive = (boolean) table.getValueAt(row, 2); // Columna 1 es "Activo"
                    if (isActive) {
                        c.setBackground(Color.GREEN); // Cambiar el color de fondo si activo es true
                    } else {
                        c.setBackground(Color.RED); // Cambiar el color de fondo si activo es false
                    }

                    // Si la fila está seleccionada, usar el color predeterminado de selección
                    if (isSelected) {
                        c.setBackground(table.getSelectionBackground());
                        c.setForeground(table.getSelectionForeground());
                    } else {
                        c.setForeground(Color.BLACK); // Texto en negro para ambas condiciones
                    }

                    return c;
                }
            });
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
            lblTipoUsuario.setText("FUNCIONARIO");

            javax.swing.GroupLayout superiorBackgroundLayout = new javax.swing.GroupLayout(superiorBackground);
            superiorBackground.setLayout(superiorBackgroundLayout);
            superiorBackgroundLayout.setHorizontalGroup(
                    superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                    .addComponent(lblLogo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                                    .addGroup(superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(22, 22, 22))
            );
            superiorBackgroundLayout.setVerticalGroup(
                    superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                    .addGroup(superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                                    .addGap(14, 14, 14)
                                                    .addComponent(lblTipoUsuario)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lblNombreUsuario)))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            lblMonitoreoRegistros.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
            lblMonitoreoRegistros.setText("Personas Activas");

            btnHouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/casa.png"))); // NOI18N
            btnHouse.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
            btnHouse.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnHouseActionPerformed(evt);
                }
            });

            btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); // NOI18N
            btnLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

            jTextArea1.setColumns(20);
            jTextArea1.setRows(5);
            jScrollPane1.setViewportView(jTextArea1);

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null}
                    },
                    new String[]{
                            "Documento", "Nombre", "Activo", "Estado"
                    }
            ) {
                Class[] types = new Class[]{
                        java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                        false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            jScrollPane3.setViewportView(jTable1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(superiorBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(94, 94, 94)
                                                    .addComponent(lblMonitoreoRegistros)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(27, 27, 27)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(btnHouse)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(btnLogout)
                                                                    .addGap(65, 65, 65)))))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(superiorBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(lblMonitoreoRegistros)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnHouse))
                                                    .addGap(15, 15, 15))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jScrollPane1))))
            );

            pack();
        }// </editor-fold>

        private void btnHouseActionPerformed (java.awt.event.ActionEvent evt){
            // TODO add your handling code here:
        }


        // Variables declaration - do not modify
        private javax.swing.JButton btnHouse;
        private javax.swing.JButton btnLogout;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JTable jTable1;
        private javax.swing.JTextArea jTextArea1;
        private javax.swing.JLabel lblLogo;
        private javax.swing.JLabel lblMonitoreoRegistros;
        private javax.swing.JLabel lblNombreUsuario;
        private javax.swing.JLabel lblTipoUsuario;
        private javax.swing.JPanel superiorBackground;
        // End of variables declaration
}