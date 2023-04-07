
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;
public class Buttons extends JFrame { 
private JButton jb = new JButton("JButton"); 
private BasicArrowButton 
up = new BasicArrowButton(BasicArrowButton.NORTH), 
down = new BasicArrowButton(BasicArrowButton.SOUTH), 
right = new BasicArrowButton(BasicArrowButton.EAST), 
left = new BasicArrowButton(BasicArrowButton.WEST); 
public Buttons() { 
setTitle("Types of buttons");
setSize(350, 200);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLayout(new FlowLayout());
add(jb); 
add(new JToggleButton("JToggleButton")); 
add(new JCheckBox("JCheckBox")); 
add(new JRadioButton("JRadioButton")); 
JPanel jp = new JPanel(); 
jp.setBorder(new TitledBorder("Directions")); 
jp.add(up); 
jp.add(down); 
jp.add(left); 
jp.add(right); 
add(jp); 
} 
public static void main(String[] args) { 
new Buttons().setVisible(true); 
}
}