

import java.awt.BorderLayout;import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.BorderUIResource;

public class congtrunhanchia extends JFrame implements ActionListener{
	private JLabel firstValue;
	private JLabel secondValue;
	private JLabel answer;
	private JTextField writeOne;
	private JTextField writeSecond;
	private JTextField writeKetQua;
	
	private JButton cong;
	private JButton tru;
	private JButton nhan;
	private JButton chia;
	private JButton laymu;
	private JButton mod;
	private JButton reset;
	private JButton thoat;
	
	public congtrunhanchia() {
		// TODO Auto-generated constructor stub
		this.setTitle("Caltulator");
		this.setSize(600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		createUI();
	}
	public void createUI() {
		
		JPanel head;
		add(head=new JPanel(),BorderLayout.CENTER);
		head.setLayout(null);
		head.add(firstValue=new JLabel("First Value : "));
		int x=30,y=50,weight=100,height=30;
		firstValue.setBounds(x, y, weight, height);
		
		
		head.add(secondValue=new JLabel("Second Value :"));
		y+=50;
		secondValue.setBounds(x, y, weight, height);
		
		head.add(answer=new JLabel("Answer :"));
		y+=50;
		answer.setBounds(x, y, weight, height);
		
		
		// them cac textfield
		x+=100;y=50;weight=100;height=30;
		head.add(writeOne=new JTextField());
		writeOne.setBounds(x , y, 200, height);
		head.add(writeSecond=new JTextField());
		writeSecond.setBounds(x, y+=50, 200, height);
		head.add(writeKetQua=new JTextField());
		writeKetQua.setBounds(x, y+=50, 200, height);
		writeKetQua.setEditable(false);
		
		
		
		//footer calcu
		JPanel footer;
		add(footer=new JPanel(),BorderLayout.SOUTH);
		footer.setBorder(BorderFactory.createTitledBorder("chon tac vu"));
		footer.setLayout(new GridLayout(2,2));
		footer.add(cong=new JButton("+"));
		footer.add(tru=new JButton("-"));
		footer.add(nhan=new JButton("*"));
		footer.add(chia=new JButton("/"));
		footer.add(laymu=new JButton("^"));
		footer.add(mod=new JButton("mod"));
		footer.add(reset=new JButton("reset")); 
		footer.add(thoat=new JButton("thoat"));
		
		cong.addActionListener(this);
		tru.addActionListener(this);
		nhan.addActionListener(this);
		chia.addActionListener(this);
		laymu.addActionListener(this);
		mod.addActionListener(this);
		reset.addActionListener(this);
		thoat.addActionListener(this);
		
	}
	public static void main(String[] args) {
		new congtrunhanchia().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		String src=e.getActionCommand();
		
		
		if(o.equals(thoat)) {
			System.exit(0);
		}
		else if (o.equals(reset)) {
			writeOne.setText("");
			writeSecond.setText("");
			writeKetQua.setText("");
			writeOne.requestFocus();
		}
		else {
			if(!kiemtraSoNguyen(writeOne)) {
				focus(writeOne);
				
			}
			else if(!kiemtraSoNguyen(writeSecond)) {
				focus(writeSecond);
				
			}
			else {
				int a= Integer.parseInt(writeOne.getText());
				int b=Integer.parseInt(writeSecond.getText());
				
				if(o.equals(cong)) {
					writeKetQua.setText(a+b+"");
				}
				if(o.equals(tru)) {
					writeKetQua.setText(a-b+"");
				}
				if(o.equals(nhan)) {
					writeKetQua.setText(a*b+"");
				}
				if(o.equals(chia)) {
					writeKetQua.setText(a/b+"");
				}
				if(o.equals(laymu)) {
					writeKetQua.setText(Math.pow(a, b)+"");
				}
				if(o.equals(mod)) {
					writeKetQua.setText(a%b+"");
				}
				
				
			}
			
		}
	}

	public void focus(JTextField text) {
		JOptionPane.showMessageDialog(null, "loi nhap lieu, ban da nhap chu hoac ban chua nhap hay thu lai");
		text.selectAll();
		text.setText("");
		text.requestFocus();
	}
	
	public boolean kiemtraSoNguyen(JTextField text) {
		boolean result=true;
		try {
			Integer.parseInt(text.getText());
		} catch (Exception e) {
			return false;
		}
		return result;
	}
}
