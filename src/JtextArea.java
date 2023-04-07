
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TextStatPanel;
extends JPanel 
implements ActionListener {
private JTextArea textArea; 
private JButton updateButton;
private JLabel[] stats;
public static final String[] statLabels = {"number of words: ","average word length: "};
// ------------------------------------------------------------

// Constructor: Sets up the GUI.
// ------------------------------------------------------------
-----
public TextStatPanel() {
init();
}
private void init() {
textArea = new JTextArea("Paste any text here, I will update the 
statistics.");
textArea.setWrapStyleWord(true);
textArea.setLineWrap(true);
updateButton = new JButton("update text statistics");
updateButton.addActionListener(this);
JPanel statPane = new JPanel();
statPane.setBorder(BorderFactory.createTitledBorder("Text 
Statistics"));
statPane.setPreferredSize(new Dimension(250, 120));
statPane.setOpaque(false);
int n = statLabels.length;
statPane.add(updateButton);
stats = new JLabel[n];
for(int i=0; i<n; ++i) {
JLabel l = new JLabel(statLabels[i]);
statPane.add(l);
stats[i] = new JLabel();
statPane.add(stats[i]);
}
JScrollPane scroll = new JScrollPane(textArea);
scroll.setPreferredSize(new Dimension(350, 400));
scroll.setBorder(BorderFactory.createTitledBorder("Text 
Container"));
this.add(scroll);
this.add(statPane);
this.setBackground(new Color(.8f, 0.9f, 0.8f));
this.setPreferredSize(new Dimension(400, 600));
this.updateStatistics();
}
// 
*****************************************************************
// Represents a listener for button push (action) events.
// 
*****************************************************************
public void actionPerformed(ActionEvent event) {
Object source = event.getSource();
if (source == updateButton) {
updateStatistics();
}
}
private void updateStatistics() {
String text = textArea.getText();
String[] words = text.split(" ");
float ave = (text.length()-
words.length+1.0f)/words.length;
stats[0].setText(String.valueOf(words.length));
stats[1].setText(String.valueOf(ave));
}
// ------------------------------------------------------------
-----
// Creates and displays the main program frame.
// ------------------------------------------------------------
-----
public static void main(String[] args) {
JFrame frame = new JFrame("Text Statistics");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
TextStatPanel panel = new TextStatPanel();
frame.getContentPane().add(panel);
frame.pack();
frame.setVisible(true);
}
