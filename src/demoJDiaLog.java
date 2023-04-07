 
import javax.swing.JDialog;
public class demoJDiaLog extends JDialog{
public demoJDiaLog() {
setTitle("Demo JDialog"); //Tiêu đề của hộp thoại JDialog
setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Đóng hộp thoại
setSize(300, 200);
setResizable(false);
//Các thuộc tính khác
}
public static void main(String[] args) {
new demoJDiaLog().setVisible(true);
}
}
