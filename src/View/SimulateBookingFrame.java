package View;

import Controller.HRSController;
import Helper.MessageHelper;
import View.Component.TableData;

import java.text.ChoiceFormat;

import javax.swing.table.DefaultTableModel;

public class SimulateBookingFrame extends javax.swing.JFrame {
  private MainView view;
  private HRSController controller;
  private ConfirmBookingFrame confirmBookingFrame;
  private String hotelName;
  private DefaultTableModel standardRoomsModel;
  private DefaultTableModel deluxeRoomsModel;
  private DefaultTableModel executiveRoomsModel;

  /**
   * Creates new form SimulateBookingFrame
   */
  public SimulateBookingFrame(MainView view, HRSController controller, String hotelName) {
    this.view = view;
    this.controller = controller;
    this.hotelName = hotelName;
    this.standardRoomsModel = new DefaultTableModel();
    this.deluxeRoomsModel = new DefaultTableModel();
    this.executiveRoomsModel = new DefaultTableModel();
    initComponents();
    fetchData();
    TableData.roomsByTypeTableComponent(controller, jTable1, deluxeRoomsModel, hotelName, "Deluxe");
    TableData.roomsByTypeTableComponent(controller, jTable2, executiveRoomsModel, hotelName, "Executive");
    TableData.roomsByTypeTableComponent(controller, jTable3, standardRoomsModel, hotelName, "Standard");
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel2 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jTextField2 = new javax.swing.JTextField();
    jTextField3 = new javax.swing.JTextField();
    jTextField4 = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jTextField5 = new javax.swing.JTextField();
    jButton4 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jButton5 = new javax.swing.JButton();
    jLabel10 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTable2 = new javax.swing.JTable();
    jLabel11 = new javax.swing.JLabel();
    jScrollPane3 = new javax.swing.JScrollPane();
    jTable3 = new javax.swing.JTable();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(51, 51, 51));

    jLabel2.setFont(new java.awt.Font("Clarity City", 1, 18)); // NOI18N
    jLabel2.setText("Hotel Name:");

    jLabel1.setFont(new java.awt.Font("Clarity City", 1, 36)); // NOI18N
    jLabel1.setText("Booking in Progress...");

    jLabel3.setFont(new java.awt.Font("Clarity City", 1, 18)); // NOI18N
    jLabel3.setText("Guest Name:");

    jLabel4.setFont(new java.awt.Font("Clarity City", 1, 18)); // NOI18N
    jLabel4.setText("Room Type:");

    jLabel5.setFont(new java.awt.Font("Clarity City", 1, 18)); // NOI18N
    jLabel5.setText("Check-in Date:");

    jLabel6.setFont(new java.awt.Font("Clarity City", 2, 14)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(102, 102, 102));
    jLabel6.setText("Please fill up the following fields to book:");

    jLabel7.setFont(new java.awt.Font("Clarity City", 1, 18)); // NOI18N
    jLabel7.setText("Check-out Date:");

    jButton4.setBackground(new java.awt.Color(153, 255, 153));
    jButton4.setFont(new java.awt.Font("Clarity City", 1, 24)); // NOI18N
    jButton4.setForeground(new java.awt.Color(102, 102, 102));
    jButton4.setText("Book Now");
    jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jButton4.setOpaque(true);
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    jTable1.setBackground(new java.awt.Color(0, 51, 102));
    jTable1.setFont(new java.awt.Font("Clarity City", 0, 13)); // NOI18N
    jTable1.setForeground(new java.awt.Color(255, 255, 255));
    jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {

        },
        new String[] {
            "Room Name", "Room Type", "Price Per Night", "Reservations"
        }) {
      boolean[] canEdit = new boolean[] {
          false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });
    jScrollPane1.setViewportView(jTable1);

    jLabel8.setFont(new java.awt.Font("Clarity City", 0, 18)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 0, 0));
    jLabel8.setText("jLabel8");

    jLabel9.setFont(new java.awt.Font("Clarity City", 1, 24)); // NOI18N
    jLabel9.setText("Deluxe Rooms");

    jButton5.setFont(new java.awt.Font("Clarity City", 0, 16)); // NOI18N
    jButton5.setText("Back");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton5ActionPerformed(evt);
      }
    });

    jLabel10.setFont(new java.awt.Font("Clarity City", 1, 24)); // NOI18N
    jLabel10.setText("Executive Rooms");

    jTable2.setBackground(new java.awt.Color(0, 51, 102));
    jTable2.setFont(new java.awt.Font("Clarity City", 0, 13)); // NOI18N
    jTable2.setForeground(new java.awt.Color(255, 255, 255));
    jTable2.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {

        },
        new String[] {
            "Room Name", "Room Type", "Price Per Night", "Reservations"
        }) {
      boolean[] canEdit = new boolean[] {
          false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });
    jScrollPane2.setViewportView(jTable2);

    jLabel11.setFont(new java.awt.Font("Clarity City", 1, 24)); // NOI18N
    jLabel11.setText("Standard Rooms");

    jTable3.setBackground(new java.awt.Color(0, 51, 102));
    jTable3.setFont(new java.awt.Font("Clarity City", 0, 13)); // NOI18N
    jTable3.setForeground(new java.awt.Color(255, 255, 255));
    jTable3.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {

        },
        new String[] {
            "Room Name", "Room Type", "Price Per Night", "Reservations"
        }) {
      boolean[] canEdit = new boolean[] {
          false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });
    jScrollPane3.setViewportView(jTable3);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(461, 461, 461)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 111,
                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 105,
                                            javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 86,
                                            javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 438,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addComponent(jLabel6)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 438,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addContainerGap(32, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                            javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
                            javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE)))));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
    // TODO add your handling code here:
    /* Book */
    if (jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty() ||
        jTextField4.getText().isEmpty() || jTextField5.getText().isEmpty()) {
      MessageHelper.showErrorMessage("Please fill in all fields before booking.");
      return;
    }
    String guestNameInput = jTextField2.getText();
    String roomTypeInput = jTextField3.getText();
    int checkIn, checkOut;
    try {
      checkIn = Integer.parseInt(jTextField4.getText());
      checkOut = Integer.parseInt(jTextField5.getText());
    } catch (NumberFormatException e) {
      MessageHelper.showErrorMessage("Check-in and Check-out dates must be valid integers.");
      return;
    }

    if (!controller.areDatesValid(checkIn, checkOut)) {
      MessageHelper.showErrorMessage("Invalid dates!");
      return;
    }

    if (!controller.isARoomAvailable(hotelName, roomTypeInput, checkIn, checkOut)) {
      MessageHelper.showErrorMessage(String.format("No %s rooms available on Day %d to %d", roomTypeInput, checkIn, checkOut));
      return;
    }

    // if everything is good and valid, then proceed to confirming the book
    confirmBookingFrame = new ConfirmBookingFrame(view, controller, hotelName, guestNameInput, roomTypeInput, checkIn, checkOut, "N/A", false);
    confirmBookingFrame.setVisible(true);
    SimulateBookingFrame.this.dispose();
  }// GEN-LAST:event_jButton4ActionPerformed

  private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
    // TODO add your handling code here:
    /* Back */
    view.setVisible(true);
    view.refreshHotelList();
    SimulateBookingFrame.this.dispose();
  }// GEN-LAST:event_jButton5ActionPerformed

  public void fetchData() {
    jLabel8.setText(hotelName); // hotel name (selected from MainView)
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton4;
  private javax.swing.JButton jButton5;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTable jTable1;
  private javax.swing.JTable jTable2;
  private javax.swing.JTable jTable3;
  private javax.swing.JTextField jTextField2;
  private javax.swing.JTextField jTextField3;
  private javax.swing.JTextField jTextField4;
  private javax.swing.JTextField jTextField5;
  // End of variables declaration//GEN-END:variables
}
