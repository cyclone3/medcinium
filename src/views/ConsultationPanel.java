/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import models.Consultation;
import models.dao.DAOFactory;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author zianwar
 */
public class ConsultationPanel extends javax.swing.JPanel implements ListSelectionListener{
    
    /**
     * Creates new form ConsultationPanel
     */
    public ConsultationPanel() {
        initComponents();
        
        consultationDatePicker.setLocale(Locale.FRENCH);
        buttonGroup.setSelected(consultationsRadioButton.getModel(), true);
        
        listeConsultations.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des Consultations", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N
        actualiserInfo();
        consultationsTable.setModel(TableModelBuilder.buildConsultationsTableModel(DAOFactory.getConsultationDAO().byStatus("finished")));
        
        ListSelectionModel selectionModel = consultationsTable.getSelectionModel();
        selectionModel.addListSelectionListener(this);
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        consultationInfoPanel.setVisible(false);
    }

    
    public void loadConsultationInfoPanel(Consultation consultation) {
        
        infosTable.setModel(TableModelBuilder.buildConsultationInfosTableModel(consultation.getPatientInfoList()));
        allergiesTable.setModel(TableModelBuilder.buildConsultationAllergiesTableModel(consultation.getAllergyList()));
        drugsTable.setModel(TableModelBuilder.buildConsultationDrugsTableModel(DAOFactory.getDrugDAO().all(consultation.getConsultationId())));
        
        
        typeLabel1.setText(consultation.getType());
        dateLabel1.setText(String.valueOf(consultation.getConsultationDate()));
        patientLabel1.setText(consultation.getPatient().getLastName() + " " + consultation.getPatient().getName());
        diagLabel.setText(consultation.getDiagnostics());
        descLabel.setText(consultation.getDescription());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        consultationPanel = new javax.swing.JPanel();
        searchConsultationPanel = new javax.swing.JPanel();
        consultationDatePicker = new org.jdesktop.swingx.JXDatePicker();
        selectionnerDateDatePicker = new javax.swing.JLabel();
        actualiserButton = new javax.swing.JButton();
        consultationsRadioButton = new javax.swing.JRadioButton();
        reservationsRadioButton = new javax.swing.JRadioButton();
        listeConsultations = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        consultationsTable = new javax.swing.JTable();
        infoPanel = new javax.swing.JPanel();
        consultationNumberLabel = new javax.swing.JLabel();
        patientInfoLabel = new javax.swing.JLabel();
        typeInfoLabel = new javax.swing.JLabel();
        descriptionInfoLabel = new javax.swing.JLabel();
        dateInfoLabel = new javax.swing.JLabel();
        diagnosticsInfoLabel = new javax.swing.JLabel();
        prixInfoLabel = new javax.swing.JLabel();
        patientLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        diagnosticsLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        displayButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        consultationInfoPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        typeLabel1 = new javax.swing.JLabel();
        dateLabel1 = new javax.swing.JLabel();
        patientLabel1 = new javax.swing.JLabel();
        plusInfoPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        descLabel = new javax.swing.JLabel();
        diagLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        allergiesTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        drugsTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        infosTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        revenirButton = new javax.swing.JButton();

        consultationPanel.setPreferredSize(new java.awt.Dimension(889, 550));
        consultationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        consultationDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultationDatePickerActionPerformed(evt);
            }
        });

        selectionnerDateDatePicker.setText("Selectionner une date");

        actualiserButton.setText("Actualiser");
        actualiserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualiserButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(consultationsRadioButton);
        consultationsRadioButton.setText("Consultations");
        consultationsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultationsRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(reservationsRadioButton);
        reservationsRadioButton.setText("Réservations");
        reservationsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationsRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchConsultationPanelLayout = new javax.swing.GroupLayout(searchConsultationPanel);
        searchConsultationPanel.setLayout(searchConsultationPanelLayout);
        searchConsultationPanelLayout.setHorizontalGroup(
            searchConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchConsultationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(consultationsRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reservationsRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(selectionnerDateDatePicker)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(consultationDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(actualiserButton)
                .addGap(28, 28, 28))
        );
        searchConsultationPanelLayout.setVerticalGroup(
            searchConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchConsultationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(consultationsRadioButton)
                        .addComponent(reservationsRadioButton))
                    .addGroup(searchConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(consultationDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(selectionnerDateDatePicker)
                        .addComponent(actualiserButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        consultationPanel.add(searchConsultationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 800, 40));

        listeConsultations.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des consultations", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        consultationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Numéro", "Date", "Patient"
            }
        ));
        jScrollPane1.setViewportView(consultationsTable);

        javax.swing.GroupLayout listeConsultationsLayout = new javax.swing.GroupLayout(listeConsultations);
        listeConsultations.setLayout(listeConsultationsLayout);
        listeConsultationsLayout.setHorizontalGroup(
            listeConsultationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listeConsultationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
        );
        listeConsultationsLayout.setVerticalGroup(
            listeConsultationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listeConsultationsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        consultationPanel.add(listeConsultations, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 800, 220));

        infoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        infoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        consultationNumberLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        consultationNumberLabel.setText("Consultation N˚");
        infoPanel.add(consultationNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        patientInfoLabel.setText("Patient");
        infoPanel.add(patientInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        typeInfoLabel.setText("Type de consultation");
        infoPanel.add(typeInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        descriptionInfoLabel.setText("Description");
        infoPanel.add(descriptionInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        dateInfoLabel.setText("Date");
        infoPanel.add(dateInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        diagnosticsInfoLabel.setText("Diagnostics");
        infoPanel.add(diagnosticsInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        prixInfoLabel.setText("Prix");
        infoPanel.add(prixInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));
        infoPanel.add(patientLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 160, 20));
        infoPanel.add(typeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 160, 30));
        infoPanel.add(descriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 161, 20));
        infoPanel.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 180, 20));
        infoPanel.add(diagnosticsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 180, 30));
        infoPanel.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 180, 20));

        displayButton.setText("Afficher");
        displayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayButtonActionPerformed(evt);
            }
        });
        infoPanel.add(displayButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));

        updateButton.setText("Modifier");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        infoPanel.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        deleteButton.setText("Supprimer");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        infoPanel.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        consultationPanel.add(infoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 800, 220));

        consultationInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        typeLabel1.setText("Type");

        dateLabel1.setText("Date");

        patientLabel1.setText("Patient");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(typeLabel1)
                .addGap(106, 106, 106)
                .addComponent(dateLabel1)
                .addGap(78, 78, 78)
                .addComponent(patientLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel1)
                    .addComponent(dateLabel1)
                    .addComponent(patientLabel1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        consultationInfoPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 700, -1));

        plusInfoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        plusInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Description:");
        plusInfoPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel9.setText("Diagnostics:");
        plusInfoPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 40));

        descLabel.setText("bla bla bla bla");
        plusInfoPanel.add(descLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 150, 40));

        diagLabel.setText("hhhhhhhhhhhh");
        plusInfoPanel.add(diagLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 160, 60));

        allergiesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Allergies"
            }
        ));
        jScrollPane4.setViewportView(allergiesTable);

        plusInfoPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 305, 120));

        jLabel10.setText("Informations Supplémentaires");
        plusInfoPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        drugsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Medicaments", "Utilisation"
            }
        ));
        jScrollPane3.setViewportView(drugsTable);

        plusInfoPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 305, 110));

        jLabel11.setText("Medicaments");
        plusInfoPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, -1));

        infosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Valeur", "Propriete"
            }
        ));
        jScrollPane2.setViewportView(infosTable);

        plusInfoPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 299, 120));

        jLabel12.setText("Allergies");
        plusInfoPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        consultationInfoPanel.add(plusInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 700, 390));

        revenirButton.setText("Revenir");
        revenirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revenirButtonActionPerformed(evt);
            }
        });
        consultationInfoPanel.add(revenirButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(consultationInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(consultationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(consultationInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(consultationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void consultationDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultationDatePickerActionPerformed
        try {
            
            if (consultationsRadioButton.isSelected()) {
                consultationsTable.setModel(TableModelBuilder.buildConsultationsTableModel(DAOFactory.getConsultationDAO().byDateAndStatus(new Timestamp(consultationDatePicker.getDate().getTime()),"finished")));
            }
            if (reservationsRadioButton.isSelected()) {
                consultationsTable.setModel(TableModelBuilder.buildConsultationsTableModel(DAOFactory.getConsultationDAO().byDateAndStatus(new Timestamp(consultationDatePicker.getDate().getTime()),"pending")));
            }
            
        } catch (Exception e) {
            SwingUtilities.updateComponentTreeUI(this);
            this.invalidate();
            this.validate();
            this.repaint();
        }
        
        consultationsTable.repaint();
    }//GEN-LAST:event_consultationDatePickerActionPerformed

    private void actualiserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualiserButtonActionPerformed
        try {
            
            if (consultationsRadioButton.isSelected()) {
                consultationsTable.setModel(TableModelBuilder.buildConsultationsTableModel(DAOFactory.getConsultationDAO().byStatus("finished")));
            }
            if (reservationsRadioButton.isSelected()) {
                consultationsTable.setModel(TableModelBuilder.buildConsultationsTableModel(DAOFactory.getConsultationDAO().byStatus("pending")));
            }
            
        } catch (Exception e) {
            SwingUtilities.updateComponentTreeUI(this);
            this.invalidate();
            this.validate();
            this.repaint();
        }
        
        
    }//GEN-LAST:event_actualiserButtonActionPerformed

    public void actualiserInfo() {
        consultationNumberLabel.setText("");
        consultationNumberLabel.setText("");
        patientLabel.setText("");
        typeLabel.setText("");
        descriptionLabel.setText("");
        dateLabel.setText("");
        diagnosticsLabel.setText("");
        priceLabel.setText("");
    }
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String num = null;
        try {
            TableModel model = (TableModel)consultationsTable.getModel();
            num = String.valueOf(model.getValueAt(consultationsTable.getSelectedRow(), 0));
            
            try {
                int val = JOptionPane.showConfirmDialog(this, "Etes vous sûr de vouloir supprimer cette consultation?", "Validation", JOptionPane.OK_CANCEL_OPTION);

                if(val == 0) {
                    Consultation currentConsultation = DAOFactory.getConsultationDAO().find(num);
                    DAOFactory.getConsultationDAO().delete(currentConsultation);

                    if (consultationsRadioButton.isSelected()) {
                        consultationsTable.setModel(TableModelBuilder.buildConsultationsTableModel(DAOFactory.getConsultationDAO().byStatus("finished")));
                    }
                    if (reservationsRadioButton.isSelected()) {
                        consultationsTable.setModel(TableModelBuilder.buildConsultationsTableModel(DAOFactory.getConsultationDAO().byStatus("pending")));
                    }
                }
                
            } catch(Exception e) {
                SwingUtilities.updateComponentTreeUI(this);
                this.invalidate();
                this.validate();
                this.repaint();
                consultationsTable.repaint();
            }
         } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une consultation", "Erreur", JOptionPane.ERROR_MESSAGE);        
        }
        
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void displayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayButtonActionPerformed
        String num = null;
        try {
            TableModel model = (TableModel)consultationsTable.getModel();
            num = String.valueOf(model.getValueAt(consultationsTable.getSelectedRow(), 0));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un patient", "Erreur", JOptionPane.ERROR_MESSAGE);        
        }
        
        if(num != null) {
            try {
                Consultation currentConsultation = DAOFactory.getConsultationDAO().find(num);
                loadConsultationInfoPanel(currentConsultation);
                consultationPanel.setVisible(false);
                consultationInfoPanel.setVisible(true);
            } catch (Exception e) {
                System.out.println("Erreur lors de l'affichage" + e);
            }
        }
    }//GEN-LAST:event_displayButtonActionPerformed

    private void revenirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revenirButtonActionPerformed
        consultationInfoPanel.setVisible(false);
        consultationPanel.setVisible(true);
    }//GEN-LAST:event_revenirButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if(consultationsRadioButton.isSelected())
        {
          
            String num = null;
            try {
                TableModel model = (TableModel)consultationsTable.getModel();
                num = String.valueOf(model.getValueAt(consultationsTable.getSelectedRow(), 0));
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner un patient", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
              int resultat = Integer.parseInt(JOptionPane.showInputDialog("Entrer le prix"));
              
            if(num != null) {
                try {
                    Consultation currentConsultation = DAOFactory.getConsultationDAO().find(num);
                    currentConsultation.getPatient().setCredit(currentConsultation.getPatient().getCredit()-currentConsultation.getPrix()+resultat);
                    currentConsultation.setPrix(resultat);
                    DAOFactory.getConsultationDAO().update(currentConsultation);
                    DAOFactory.getPatientDAO().update(currentConsultation.getPatient());
                    priceLabel.setText(Integer.toString(currentConsultation.getPrix()));
                } catch (Exception e) {
                    System.out.println("Erreur lors de l'affichage" + e);
                }
            }
        }
        
        if(reservationsRadioButton.isSelected())
        {
             Date date = null ;
            String num = null;
            try {
                TableModel model = (TableModel)consultationsTable.getModel();
                num = String.valueOf(model.getValueAt(consultationsTable.getSelectedRow(), 0));
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner un patient", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            
            String resultat = JOptionPane.showInputDialog("Changer la date forme yyyy-MM-dd hh:mm");
            if(Utils.isThisDateValid(resultat, "yyyy-MM-dd hh:mm")) {
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                try {
                    date = sdf.parse(resultat);
                } catch (ParseException ex) {
                    Logger.getLogger(ConsultationPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
          //    if(date.compareTo(new Date())<0) {
            if(num != null) {
                try {
                    Consultation currentConsultation = DAOFactory.getConsultationDAO().find(num);
                    currentConsultation.setConsultationDate(new Timestamp(date.getTime()));
                    if(DAOFactory.getConsultationDAO().update(currentConsultation))
                    {
                        try {
                            dateLabel.setText(date.toString());
                            consultationsTable.setModel(TableModelBuilder.buildConsultationsTableModel(DAOFactory.getConsultationDAO().byStatus("pending")));
                        } catch(Exception e) {
                            SwingUtilities.updateComponentTreeUI(this);
                            this.invalidate();
                            this.validate();
                            this.repaint();
                            consultationsTable.repaint();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Erreur lors de l'affichage" + e);
                }
            }
             // }
            }else {
              JOptionPane.showMessageDialog(this, "Date n'est pas valide", "Erreur", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void consultationsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultationsRadioButtonActionPerformed
        
        buttonGroup.setSelected(consultationsRadioButton.getModel(), true);
        
        try {
            listeConsultations.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des Consultations", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N
            consultationsTable.setModel(TableModelBuilder.buildConsultationsTableModel(DAOFactory.getConsultationDAO().byStatus("finished")));
        } catch (Exception e) {
            SwingUtilities.updateComponentTreeUI(this);
            this.invalidate();
            this.validate();
            this.repaint();
        }
        actualiserInfo();
        

    }//GEN-LAST:event_consultationsRadioButtonActionPerformed

    private void reservationsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservationsRadioButtonActionPerformed
        
        buttonGroup.setSelected(reservationsRadioButton.getModel(), true);
        try {
            listeConsultations.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des Réservations", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N
            consultationsTable.setModel(TableModelBuilder.buildConsultationsTableModel(DAOFactory.getConsultationDAO().byStatus("pending")));
            
        } catch (Exception e) {
            SwingUtilities.updateComponentTreeUI(this);
            this.invalidate();
            this.validate();
            this.repaint();
        }
        actualiserInfo();
    }//GEN-LAST:event_reservationsRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualiserButton;
    private javax.swing.JTable allergiesTable;
    private javax.swing.ButtonGroup buttonGroup;
    private org.jdesktop.swingx.JXDatePicker consultationDatePicker;
    private javax.swing.JPanel consultationInfoPanel;
    private javax.swing.JLabel consultationNumberLabel;
    private javax.swing.JPanel consultationPanel;
    private javax.swing.JRadioButton consultationsRadioButton;
    private javax.swing.JTable consultationsTable;
    private javax.swing.JLabel dateInfoLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel dateLabel1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel descLabel;
    private javax.swing.JLabel descriptionInfoLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel diagLabel;
    private javax.swing.JLabel diagnosticsInfoLabel;
    private javax.swing.JLabel diagnosticsLabel;
    private javax.swing.JButton displayButton;
    private javax.swing.JTable drugsTable;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JTable infosTable;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel listeConsultations;
    private javax.swing.JLabel patientInfoLabel;
    private javax.swing.JLabel patientLabel;
    private javax.swing.JLabel patientLabel1;
    private javax.swing.JPanel plusInfoPanel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel prixInfoLabel;
    private javax.swing.JRadioButton reservationsRadioButton;
    private javax.swing.JButton revenirButton;
    private javax.swing.JPanel searchConsultationPanel;
    private javax.swing.JLabel selectionnerDateDatePicker;
    private javax.swing.JLabel typeInfoLabel;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JLabel typeLabel1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == consultationsTable.getSelectionModel() && e.getValueIsAdjusting()) {
                
            TableModel model = (TableModel)consultationsTable.getModel();
            String num = String.valueOf(model.getValueAt(consultationsTable.getSelectedRow(), 0));

            Consultation consultationSelected = DAOFactory.getConsultationDAO().find(num);
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");           
            
            if (consultationSelected.getStatus().equalsIgnoreCase("finished")) {
                
                consultationNumberLabel.setText("Consultation N˚ " + num);
                patientLabel.setText(consultationSelected.getPatient().getLastName() + " " + consultationSelected.getPatient().getName());
                typeLabel.setText(consultationSelected.getType());
                descriptionLabel.setText(consultationSelected.getDescription());
                dateLabel.setText(df.format(consultationSelected.getConsultationDate()));
                diagnosticsLabel.setText(consultationSelected.getDiagnostics());
                priceLabel.setText(String.valueOf(consultationSelected.getPrix()));
               
            } else {
                consultationNumberLabel.setText("Réservation N˚ " + num);
                patientLabel.setText(consultationSelected.getPatient().getLastName() + " " + consultationSelected.getPatient().getName());
                typeLabel.setText(consultationSelected.getType());
                descriptionLabel.setText("");
                dateLabel.setText(df.format(consultationSelected.getConsultationDate()));
                diagnosticsLabel.setText(consultationSelected.getDiagnostics());
                priceLabel.setText("");
                prixInfoLabel.setVisible(false);
            }
        }
    }
}
