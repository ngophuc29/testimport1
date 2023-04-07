 
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
public class demoFlowlayout extends JFrame{
public demoFlowlayout() {
setTitle("FlowLayout");
setSize(300, 250); 
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocationRelativeTo(null); 
setResizable(false); 
setLayout(new FlowLayout());
for (int i = 1; i <=20; i++) {
add(new JButton("Button "+i));
}
}
public static void main(String[] args) {
new demoFlowlayout().setVisible(true);
}
}