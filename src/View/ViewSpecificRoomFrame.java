package View;

import Controller.HRSController;
import Helper.InputHelper;
import Helper.MessageHelper;
import View.Component.TableData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;

public class ViewSpecificRoomFrame extends javax.swing.JFrame {
  private MainView view;
  private HRSController controller;
  private ViewSpecificHotelFrame viewSpecificHotelFrame;
  private ViewSpecificReservationFrame viewSpecificReservationFrame;
  private HashMap<String, String> roomInfo;
  private String selectedHotelName;
  private String selectedRoomName;
  private DefaultListModel<String> bookedDatesModel;
  private DefaultListModel<String> availbleDatesModel;
  private DefaultTableModel tableData;

  /**
   * Creates new form ViewSpecificRoomFrame
   */
  public ViewSpecificRoomFrame(MainView view, HRSController controller, String selectedHotelName,
      String selectedRoomName) {
    this.view = view;
    this.controller = controller;
    this.selectedHotelName = selectedHotelName;
    this.selectedRoomName = selectedRoomName;
    this.bookedDatesModel = new DefaultListModel<>();
    this.availbleDatesModel = new DefaultListModel<>();
    initComponents();
    setLocationRelativeTo(null);
    fetchData();
    refreshDatesList();
    TableData.reservationTableComponent(controller, jTable1, tableData, selectedHotelName, selectedRoomName);
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

    jPanel1 = new javax.swing.JPanel();
    jLabel7 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jList1 = new javax.swing.JList<>();
    jButton2 = new javax.swing.JButton();
    jLabel10 = new javax.swing.JLabel();
    jScrollPane3 = new javax.swing.JScrollPane();
    jList2 = new javax.swing.JList<>();
    jLabel11 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jScrollPane4 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(51, 0, 51));

    jLabel7.setFont(new java.awt.Font("Clarity City", 1, 14)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setText("From Hotel:");

    jLabel4.setFont(new java.awt.Font("Clarity City", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("Number of Reservations (Booked):");

    jLabel8.setFont(new java.awt.Font("Clarity City", 2, 14)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(153, 255, 153));
    jLabel8.setText("jLabel8");

    jLabel5.setFont(new java.awt.Font("Clarity City", 1, 14)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(153, 255, 153));
    jLabel5.setText("Available Dates");

    jLabel9.setFont(new java.awt.Font("Clarity City", 2, 14)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(153, 255, 153));
    jLabel9.setText("jLabel9");

    jList1.setBackground(new java.awt.Color(255, 102, 102));
    jList1.setFont(new java.awt.Font("Clarity City", 1, 18)); // NOI18N
    jList1.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

      public int getSize() {
        return strings.length;
      }

      public String getElementAt(int i) {
        return strings[i];
      }
    });
    jScrollPane2.setViewportView(jList1);

    jButton2.setBackground(new java.awt.Color(255, 102, 102));
    jButton2.setFont(new java.awt.Font("Clarity City", 1, 14)); // NOI18N
    jButton2.setForeground(new java.awt.Color(255, 255, 255));
    jButton2.setText("Back");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jLabel10.setFont(new java.awt.Font("Clarity City", 1, 14)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 255, 255));
    jLabel10.setText("Price Per Night:");

    jList2.setBackground(new java.awt.Color(102, 255, 102));
    jList2.setFont(new java.awt.Font("Clarity City", 1, 18)); // NOI18N
    jList2.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

      public int getSize() {
        return strings.length;
      }

      public String getElementAt(int i) {
        return strings[i];
      }
    });
    jScrollPane3.setViewportView(jList2);

    jLabel11.setFont(new java.awt.Font("Clarity City", 2, 14)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(153, 255, 153));
    jLabel11.setText("jLabel11");

    jLabel6.setFont(new java.awt.Font("Clarity City", 1, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 255, 255));
    jLabel6.setText("Reservations:");

    jButton1.setBackground(new java.awt.Color(255, 255, 153));
    jButton1.setFont(new java.awt.Font("Clarity City", 1, 14)); // NOI18N
    jButton1.setText("View a Reservation");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Clarity City", 1, 36)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("ROOM NAME");

    jTable1.setBackground(new java.awt.Color(255, 255, 153));
    jTable1.setFont(new java.awt.Font("Clarity City", 0, 13)); // NOI18N
    jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {

        },
        new String[] {
            "Id", "Guest Name", "Check In Date", "Check Out Date", "Total Price"
        }) {
      boolean[] canEdit = new boolean[] {
          false, false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });
    jScrollPane4.setViewportView(jTable1);
    if (jTable1.getColumnModel().getColumnCount() > 0) {
      jTable1.getColumnModel().getColumn(0).setResizable(false);
      jTable1.getColumnModel().getColumn(1).setResizable(false);
      jTable1.getColumnModel().getColumn(2).setResizable(false);
      jTable1.getColumnModel().getColumn(3).setResizable(false);
      jTable1.getColumnModel().getColumn(4).setResizable(false);
    }

    jLabel2.setFont(new java.awt.Font("Clarity City", 3, 18)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(204, 204, 204));
    jLabel2.setText("Room Type");

    jLabel3.setFont(new java.awt.Font("Clarity City", 1, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 153, 153));
    jLabel3.setText("Booked Dates");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(8, 8, 8)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 239,
                                    javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276,
                            javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
    // View a Reservation
    String selectedReservationId = InputHelper.askInputString("Enter the Id of the Reservation to view");
    if (controller.checkIfReservationExists(selectedHotelName, selectedRoomName, selectedReservationId) == null) {
      MessageHelper.showErrorMessage("Reservation does not exist!");
      return;
    }

    viewSpecificReservationFrame = new ViewSpecificReservationFrame(view, controller, selectedHotelName,
        selectedRoomName, roomInfo.get("Room Type"), selectedReservationId);
    viewSpecificReservationFrame.setVisible(true);
    ViewSpecificRoomFrame.this.setVisible(false);
  }// GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:
    // Back button
    viewSpecificHotelFrame = new ViewSpecificHotelFrame(view, controller, selectedHotelName);
    viewSpecificHotelFrame.setVisible(true);
    ViewSpecificRoomFrame.this.dispose();
  }// GEN-LAST:event_jButton2ActionPerformed

  public void fetchData() {
    roomInfo = controller.getSpecificRoomInfo(selectedHotelName, selectedRoomName);
    jLabel1.setText(roomInfo.get("Room Name")); // room name
    jLabel2.setText(roomInfo.get("Room Type")); // room type
    jLabel8.setText(selectedHotelName); // hotel name
    jLabel9.setText(roomInfo.get("Number of Reservations")); // number of reservations (booked)
    jLabel11.setText(roomInfo.get("Price Per Night")); // price per night
  }

  public void refreshDatesList() {
    // booked dates
    jList1.setModel(bookedDatesModel);
    jScrollPane2.setViewportView(jList1);
    bookedDatesModel.clear();
    if (controller.getRoomBookedDatesList(selectedHotelName, selectedRoomName).isEmpty()) {
      bookedDatesModel.addElement("None...");
    } else {
      for (String date : controller.getRoomBookedDatesList(selectedHotelName, selectedRoomName))
        bookedDatesModel.addElement("Day " + date);
    }

    // available dates
    jList2.setModel(availbleDatesModel);
    jScrollPane3.setViewportView(jList2);
    availbleDatesModel.clear();
    if (controller.getRoomAvailableDatesList(selectedHotelName, selectedRoomName).isEmpty()) {
      availbleDatesModel.addElement("None...");
    } else {
      for (String date : controller.getRoomAvailableDatesList(selectedHotelName, selectedRoomName))
        availbleDatesModel.addElement("Day " + date);
    }
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
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
  private javax.swing.JList<String> jList1;
  private javax.swing.JList<String> jList2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JTable jTable1;
  // End of variables declaration//GEN-END:variables
}
