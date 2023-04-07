 
import javax.swing.JFrame;
public class DemoJframe extends JFrame{
public DemoJframe() {
setTitle("Demo JFrame"); //Tiêu đề JFrame
setSize(300, 200); //Kích thước của JFrame
setDefaultCloseOperation(EXIT_ON_CLOSE);//Thoát chương trình khi click nút exit
setLocationRelativeTo(null); //Canh giữa màn hình
setResizable(false); //không cho phép thay đổi kích thước JFrame
//các thuộc tính khác JFrame
}
public static void main(String[] args) {
new DemoJframe().setVisible(true); //Hiển thị JFrame
}
}