import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
// j'ai rajouté
import java.awt.event.*;





public class SwingEventWindow extends JFrame{
  private int rdoChecked = 1;

  JPanel panel = new JPanel();
  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JPanel panel3 = new JPanel();
  JPanel panel4 = new JPanel();
  JPanel panel5 = new JPanel();
  JPanel panel6 = new JPanel();

  JRadioButton 
    rdoTotal = new JRadioButton("Total"), 
    rdoAverage = new JRadioButton("Average"), 
    rdoMax = new JRadioButton("Maximum"), 
    rdoMin = new JRadioButton("Minimum");
  ButtonGroup grpRadioButtons = new  ButtonGroup();

  JLabel lblMain = new JLabel("Excel Functions");
  JLabel lblRequest = new JLabel("Enter your numbers separated by spaces");

  JTextField txtNum = new JTextField(20);

  JButton btnCalculate = new JButton("Calculate");
  
  JLabel lblResult = new JLabel("Result:");
  JTextField txtResult = new JTextField(10);
  
  public SwingEventWindow() {
    super.setTitle("Excel functions");
    super.setSize(200, 200);
    super.setVisible(true);

    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    grpRadioButtons.add(rdoTotal);
    grpRadioButtons.add(rdoAverage);
    grpRadioButtons.add(rdoMax);
    grpRadioButtons.add(rdoMin);

    panel1.add(lblMain);
    panel2.add(lblRequest);
    panel3.add(txtNum);
    panel4.add(rdoTotal);
    panel4.add(rdoAverage);
    panel4.add(rdoMax);
    panel4.add(rdoMin);
    panel5.add(btnCalculate);
    panel6.add(lblResult);
    panel6.add(txtResult);

    // Add sub-panels to the main panel
    panel.add(panel1);
    panel.add(panel2);
    panel.add(panel3);
    panel.add(panel4);
    panel.add(panel5);
    panel.add(panel6);

    // Add the main panel to the frame
    add(panel);

    /* 
      b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
          tf.setText("Welcome to Javatpoint.");  
        }  
      });  
    */

    rdoTotal.setSelected(true);
    rdoTotal.addActionListener(new java.awt.event.ActionListener() {  
      public void actionPerformed(ActionEvent e) {
        Event_Handler(e);
      }
    });
    rdoAverage.addActionListener(new java.awt.event.ActionListener() {  
      public void actionPerformed(ActionEvent e) {
        Event_Handler(e);
      }
    });
    rdoMax.addActionListener(new java.awt.event.ActionListener() {  
      public void actionPerformed(ActionEvent e) {
        Event_Handler(e);
      }
    });
    rdoMin.addActionListener(new java.awt.event.ActionListener() {  
      public void actionPerformed(ActionEvent e) {
        Event_Handler(e);
      }
    });

    // return; = break;
    
    btnCalculate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (txtNum.getText().isEmpty()) {
          JOptionPane.showMessageDialog(null, "Please enter numbers!");
          return;
        }

        Excel excel = new Excel(txtNum.getText());

        switch (rdoChecked) {
          case 1: 
            txtResult.setText("The total is " + excel.findTotal());
            break;
          case 2:
            txtResult.setText("The average is " + excel.findAvg());
            break;
          case 3:
            txtResult.setText("The max is " + excel.findMax());
            break;
          case 4:
            txtResult.setText("The min is " + excel.findMin());
            break;
        }
      }
    });
  }

  
  public void Event_Handler(ActionEvent e)
  
  {
    if (e.getSource() == rdoTotal)
      rdoChecked = 1;
    else if (e.getSource() == rdoAverage)
      rdoChecked = 2;
    else if (e.getSource() == rdoMax) 
      rdoChecked = 3;
    else
      rdoChecked = 4;
  }
  

}