/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Majus
 */
public class Log extends javax.swing.JFrame {

    Practica2 principal = new Practica2();
    DefaultTableModel model;
    
    // escojer la direccion
    JFileChooser fc = new JFileChooser();
    
    /**
     * Creates new form Log
     */
    public Log() {
        initComponents();
        this.setTitle("Log de Operaciones");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.pack();
        
        model = (DefaultTableModel)jTable1.getModel();
        
        TableColumn col1 = jTable1.getColumnModel().getColumn(0);
        col1.setPreferredWidth(85);
        TableColumn col2 = jTable1.getColumnModel().getColumn(1);
        col2.setPreferredWidth(85);
        TableColumn col3 = jTable1.getColumnModel().getColumn(2);
        col3.setPreferredWidth(85);
    }
    
    public Log(Practica2 principal) {
        initComponents();
        this.setTitle("Log de Operaciones");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.pack();
        
        this.principal = principal;
        
        model = (DefaultTableModel)jTable1.getModel();
        
        TableColumn col1 = jTable1.getColumnModel().getColumn(0);
        col1.setPreferredWidth(100);
        TableColumn col2 = jTable1.getColumnModel().getColumn(1);
        col2.setPreferredWidth(85);
        TableColumn col3 = jTable1.getColumnModel().getColumn(2);
        col3.setPreferredWidth(85);
        
        try{
            for(int i = 0; i < this.principal.countLogs; i++){
                model.insertRow(model.getRowCount(), new Object[]{
                this.principal.logs[i].getDato(),
                this.principal.logs[i].getOperacion(),
                this.principal.logs[i].getEstadoPila()
            });
            }
            
        }catch(Exception e){}         
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));

        jPanel1.setBackground(java.awt.Color.black);
        jPanel1.setMaximumSize(new java.awt.Dimension(600, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 400));
        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dato", "Operacion", "Estado de la pila"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 70, 530, 180);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(160, 300, 80, 40);

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(350, 300, 80, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Log de Operaciones");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 10, 210, 50);

        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica/images/back.jpg"))); // NOI18N
        jLabel1.setDoubleBuffered(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // back
        principal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // btn Guardar
        int response = fc.showSaveDialog(this);
        String pathSave="";
        
        if(response == JFileChooser.APPROVE_OPTION){
            pathSave = fc.getSelectedFile().toString() + ".csv";
           System.out.println(pathSave);
           try {
           FileWriter fw = new FileWriter(pathSave,true);
           BufferedWriter bw = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bw);
           
           // HEADER
           pw.println("Valor;Operacion;Pila");
           for(int i=0; i< principal.countLogs;i++){
               pw.println(principal.logs[i].getDato().trim() + ";" +
                       principal.logs[i].getOperacion().trim() + ";" +
                       principal.logs[i].getEstadoPila().trim());
           }
           
            pw.flush();
            pw.close();
        } catch (Exception e) {}
        }else{
            JOptionPane.showMessageDialog(this, "No selecciono donde Guardar","Info", JOptionPane.INFORMATION_MESSAGE);
        }
        
         
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Log().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
