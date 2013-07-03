/*
 * FolderSettingsForm.java
 *
 * Created on January 20, 2007, 2:15 PM
 */

package org.jmeld.ui.settings;

/**
 *
 * @author  kees
 */
public class FolderSettingsForm
    extends javax.swing.JPanel
{

  /** Creates new form FolderSettingsForm */
  public FolderSettingsForm()
  {
    initComponents();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    gradientLabel1 = new org.jmeld.ui.swing.GradientLabel();
    detailHeader1 = new org.jmeld.ui.swing.DetailHeader();
    hierarchyComboBox = new javax.swing.JComboBox();
    onlyLeftButton = new javax.swing.JToggleButton();
    leftRightChangedButton = new javax.swing.JToggleButton();
    onlyRightButton = new javax.swing.JToggleButton();
    leftRightUnChangedButton = new javax.swing.JToggleButton();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    detailHeader2 = new org.jmeld.ui.swing.DetailHeader();

    gradientLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10,
      1, 1));
    gradientLabel1.setText("Folder settings");
    gradientLabel1.setFont(new java.awt.Font("Dialog", 1, 18));

    detailHeader1.setText("File filter");

    hierarchyComboBox.setModel(new javax.swing.DefaultComboBoxModel(
        new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    onlyLeftButton.setText("L");

    leftRightChangedButton.setText("LR");

    onlyRightButton.setText("R");

    leftRightUnChangedButton.setText("Un");

    jLabel3.setFont(new java.awt.Font("Dialog", 0, 12));
    jLabel3.setText("Show files that only exist on the left side");

    jLabel4.setFont(new java.awt.Font("Dialog", 0, 12));
    jLabel4.setText("Show files that are different");

    jLabel5.setFont(new java.awt.Font("Dialog", 0, 12));
    jLabel5.setText("Show files that only exist on the right side");

    jLabel6.setFont(new java.awt.Font("Dialog", 0, 12));
    jLabel6.setText("Show files that are equal");

    jLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
    jLabel2.setText("Default hierarchy");

    detailHeader2.setText("Miscellaneous");

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
        this);
    this.setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(
      org.jdesktop.layout.GroupLayout.LEADING).add(
      layout.createSequentialGroup().add(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(
              layout.createSequentialGroup().add(24, 24, 24).add(
                layout.createParallelGroup(
                  org.jdesktop.layout.GroupLayout.LEADING).add(onlyLeftButton)
                    .add(leftRightChangedButton).add(onlyRightButton).add(
                      leftRightUnChangedButton)).addPreferredGap(
                org.jdesktop.layout.LayoutStyle.RELATED).add(
                layout.createParallelGroup(
                  org.jdesktop.layout.GroupLayout.LEADING).add(jLabel6).add(
                  jLabel5).add(jLabel4).add(jLabel3))).add(
              layout.createSequentialGroup().add(24, 24, 24).add(jLabel2,
                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105,
                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                  .add(hierarchyComboBox,
                    org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                    org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                    org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)).add(
              layout.createSequentialGroup().addContainerGap().add(
                detailHeader2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                333, Short.MAX_VALUE)).add(
              layout.createSequentialGroup().addContainerGap().add(
                detailHeader1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                333, Short.MAX_VALUE))).add(30, 30, 30)).add(gradientLabel1,
      org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE));

    layout.linkSize(new java.awt.Component[] { leftRightChangedButton,
        leftRightUnChangedButton, onlyLeftButton, onlyRightButton },
      org.jdesktop.layout.GroupLayout.HORIZONTAL);

    layout.setVerticalGroup(layout.createParallelGroup(
      org.jdesktop.layout.GroupLayout.LEADING).add(
      layout.createSequentialGroup().add(gradientLabel1,
        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28,
        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(
        org.jdesktop.layout.LayoutStyle.RELATED).add(detailHeader1,
        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(
        org.jdesktop.layout.LayoutStyle.RELATED).add(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
            .add(onlyLeftButton).add(jLabel3)).add(5, 5, 5).add(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
            .add(leftRightChangedButton).add(jLabel4)).addPreferredGap(
        org.jdesktop.layout.LayoutStyle.RELATED).add(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
            .add(onlyRightButton).add(jLabel5)).addPreferredGap(
        org.jdesktop.layout.LayoutStyle.RELATED).add(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
            .add(leftRightUnChangedButton).add(jLabel6)).addPreferredGap(
        org.jdesktop.layout.LayoutStyle.UNRELATED).add(detailHeader2,
        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(
        org.jdesktop.layout.LayoutStyle.RELATED).add(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
            .add(jLabel2).add(hierarchyComboBox,
              org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
              org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
              org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)).addContainerGap(
        52, Short.MAX_VALUE)));
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private org.jmeld.ui.swing.DetailHeader detailHeader1;
  private org.jmeld.ui.swing.DetailHeader detailHeader2;
  private org.jmeld.ui.swing.GradientLabel gradientLabel1;
  protected javax.swing.JComboBox hierarchyComboBox;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  protected javax.swing.JToggleButton leftRightChangedButton;
  protected javax.swing.JToggleButton leftRightUnChangedButton;
  protected javax.swing.JToggleButton onlyLeftButton;
  protected javax.swing.JToggleButton onlyRightButton;
  // End of variables declaration//GEN-END:variables

}
