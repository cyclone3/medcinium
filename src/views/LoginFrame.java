/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;



import controllers.Observer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import models.User;

/**
 *
 * @author otsaan
 */
public class LoginFrame extends javax.swing.JFrame {

    private Vector<Observer> observers;
    
    
    public LoginFrame() {
        
        observers = new Vector<Observer>();
        
        
        initComponents();
        
        password.addKeyListener(new KeyAdapter() {
            User user = new User();
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER ) {        
                    user.setUsername(usernameTextField.getText());
                    user.setPassword(new String(password.getPassword()));
                    notifyObservers(user,"login");
                }
            } 
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        usernameTextField = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        seConnecterLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medcinium");

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        usernameTextField.setBorder(null);
        mainPanel.add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 265, 250, 30));

        password.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        password.setBorder(null);
        mainPanel.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 315, 250, 30));

        seConnecterLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mainPanel.add(seConnecterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 396, 140, 40));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/login.png"))); // NOI18N
        backgroundLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundLabelMouseClicked(evt);
            }
        });
        mainPanel.add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backgroundLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundLabelMouseClicked
        
        User user = new User();
        user.setUsername(usernameTextField.getText());
        user.setPassword(new String(password.getPassword()));
        notifyObservers(user,"login");
    }//GEN-LAST:event_backgroundLabelMouseClicked
    
    
    public void addObserver(Observer observer) {
       observers.add(observer);
    }
    
    public void notifyObservers(User user, String action ) {
        for (Observer observer : observers) {
            observer.execute(this, user,action);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel seConnecterLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
