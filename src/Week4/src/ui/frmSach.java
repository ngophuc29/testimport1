package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import database.Database;
import entity.Sach;
import entity.ThuVien;

public class frmSach extends JFrame implements ActionListener{

	private JTextField txtMaSach, txtTenSach, txtTacGia,txtNamXb, txtNhaXb, txtSoTrang, txtDonGia, txtISBN;
	private JButton btnThem,btnXoaTrang, btnXoa, btnSua, btnLuu, btnLoc ;
	private JComboBox<String> cboMaSach;
	private JTable table;
	private JPanel pnMain;
	private DefaultTableModel tableModel;
	private ThuVien dsSach = new ThuVien();
	private Database data= new Database();
	
	public frmSach() {
		this.setTitle("Quản lý sách");
		this.setSize(900,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		buildUI();
		loadData();
	}



	private void buildUI() {
		pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
	
//		 Form input sach 
		
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();
		
		b.add(b1);
		b.add(Box.createVerticalStrut(10));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		b.add(b5);
		b.add(Box.createVerticalStrut(5));
		pnNorth.add(b);
		pnNorth.add(Box.createVerticalStrut(10));
		
		JLabel lbMaSach, lbTenSach, lbTacGia,  lbNamXb, lbNhaXb, lbSoTrang, lbDonGia,lbISBN;
		
		lbMaSach = new JLabel("Mã Sách:");
		lbTenSach = new JLabel("Tên Sách:");
		lbTacGia = new JLabel("Tác Giả:");
		lbNamXb = new JLabel("Năm Xuất Bản:");
		lbNhaXb = new JLabel("Nhà Xuất Bản:");
		lbSoTrang = new JLabel("Số Trang:");
		lbDonGia = new JLabel("Đơn Gia:");
		lbISBN = new JLabel("ISBN");
		
		
		txtMaSach = new JTextField();
		b1.add(lbMaSach);
		b1.add(txtMaSach);
		
		txtTenSach = new JTextField();
		txtTacGia = new JTextField();
		b2.add(lbTenSach);
		b2.add(txtTenSach);
		b2.add(lbTacGia);
		b2.add(txtTacGia);
		
		txtNamXb = new JTextField();
		txtNhaXb = new JTextField();
		b3.add(lbNamXb);
		b3.add(txtNamXb);
		b3.add(lbNhaXb);
		b3.add(txtNhaXb);
		
		txtSoTrang = new JTextField();
		txtDonGia = new JTextField();
		b4.add(lbSoTrang);
		b4.add(txtSoTrang);
		b4.add(lbDonGia);
		b4.add(txtDonGia);
		
		
		txtISBN = new JTextField();
		b5.add(lbISBN);
		b5.add(txtISBN);
		
//		lbTenSach.setPreferredSize(lbMaSach.getPreferredSize());
//		lbNamXb.setPreferredSize(lbMaSach.getPreferredSize());
//		lbSoTrang.setPreferredSize(lbMaSach.getPreferredSize());
//		lbISBN.setPreferredSize(lbMaSach.getPreferredSize());
//		lbNhaXb.setPreferredSize(lbTacGia.getPreferredSize());
//		lbNamXb.setPreferredSize(lbTacGia.getPreferredSize());
		Border borderNorth = BorderFactory.createTitledBorder("Record Editor");
		pnNorth.setBorder(borderNorth);
		
		pnMain.add(pnNorth , BorderLayout.NORTH); 
//		Chuc Nang 
		JSplitPane split;
		pnMain.add(split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT), BorderLayout.CENTER);
		split.setResizeWeight(0.5);
		
		
		JPanel pnBtn = new JPanel();
		btnThem = new JButton("Thêm");
		btnXoa = new JButton("Xóa");
		btnXoaTrang = new JButton("Xóa Trắng");
		btnSua = new JButton("Sửa");
		btnLuu = new JButton("Lưu");
		
		btnSua.setEnabled(false);
//		dang ky su kien click
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		
		
		pnBtn.add(btnThem);
		pnBtn.add(btnXoaTrang);
		pnBtn.add(btnXoa);
		pnBtn.add(btnSua);
		pnBtn.add(btnLuu);
		split.add(pnBtn);
		
		JPanel pnLoc = new JPanel();
		JLabel lbTim= new JLabel("Tìm theo mã sách");
	
		
		cboMaSach = new JComboBox();
		
		pnLoc.add(lbTim);
		pnLoc.add(cboMaSach);
		
		split.add(pnLoc);
//		Bang 
		TaoBang();
		
		
		
		this.add(pnMain);
		
		
	}
	
	private void TaoBang() {
		JPanel pnTable= new JPanel();
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		tableModel.addColumn("Mã sách");
		tableModel.addColumn("Tên sách");
		tableModel.addColumn("Tác giả");
		tableModel.addColumn("Năm Xuất Bản");
		tableModel.addColumn("Nhà Xuất Bản ");
		tableModel.addColumn("Số Trang");
		tableModel.addColumn("Đơn Giá");
		tableModel.addColumn("ISBN");
		
		TableColumn column = new TableColumn();
		column.setPreferredWidth(100);
		JScrollPane sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(750, 350));
		pnMain.add(sp, BorderLayout.SOUTH);
//		loc su lieu
		
//		cboMaSach.addItemListener(new ItemListener() {
//
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				if(e.getSource().equals(cboMaSach)) {
//					table.removeAll();
//					String ma = cboMaSach.getSelectedItem().toString();
//					for(Sach s : dsSach.filter(ma)) {
//						String [] row = {s.getMaSach(),s.getTenSach(),s.getTacGia(),s.getNamXb(),s.getNhaXb(),s.getSoTrang()+"",s.getDonGia()+"",s.getiSBN()};
//						table.setRowSorter(null)
//					}
//				}
//				
//			}
//			
//		});
		
		
		
//		sk table
		table.addMouseListener((MouseListener) new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtMaSach.setText(tableModel.getValueAt(row, 0).toString());
				txtTenSach.setText(tableModel.getValueAt(row, 1).toString());
				txtTacGia.setText(tableModel.getValueAt(row, 2).toString());
				txtNamXb.setText(tableModel.getValueAt(row, 3).toString());
				txtNhaXb.setText(tableModel.getValueAt(row, 4).toString());
				txtSoTrang.setText(tableModel.getValueAt(row, 5).toString());
				txtDonGia.setText(tableModel.getValueAt(row, 6).toString());
				txtISBN.setText(tableModel.getValueAt(row, 7).toString());
				if(row != -1) {
					btnSua.setEnabled(true);
					txtMaSach.setEditable(false);	
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource()	;
		if(o.equals(btnThem)) {
			
			if(txtMaSach.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Nhập thông tin");
				
			}
			else
			{
				addSachtoTable();

			}
				
		}
		if(o.equals(btnLuu)) {
			Luufile();
		}
		if(o.equals(btnSua)) {
			capnhatSach();
		}
		if(o.equals(btnXoa)) {
			XoaSach();
		}
		if(o.equals(btnXoaTrang)) {
			clearInput();
		
			
		}
		if(o.equals(System.out)) {
			data.ghiXuongFile(dsSach.getDsSach());
		}
		
	}
	
	private void XoaSach() {
		if(table.getSelectedRow()== -1) {
			JOptionPane.showMessageDialog(this, "Phải chọn dòng cần xóa");
		}
		else {
			int row = table.getSelectedRow();
			dsSach.xoa1CuonSach(row);
			tableModel.removeRow(row);
			cboMaSach.removeItem(txtMaSach.getText());
			txtMaSach.setEditable(true);
			btnSua.setEnabled(false);
			clearInput();
		}
		
	}



	private void clearInput() {
		txtMaSach.requestFocus();
		txtMaSach.setText("");
		txtTenSach.setText("");
		txtTacGia.setText("");
		txtNamXb.setText("");
		txtNhaXb.setText("");
		txtSoTrang.setText("");
		txtDonGia.setText("");
		txtISBN.setText("");
		
	}



	private void capnhatSach() {
		String ma = txtMaSach.getText();
		String tenSach = txtTenSach.getText();
		String tacGia = txtTacGia.getText();
		String namXB = txtNamXb.getText();
		String nhaXB = txtNhaXb.getText();
		String soTrang = txtSoTrang.getText();
		String donGia = txtDonGia.getText();
		String isbn = txtISBN.getText();
		Sach s = new Sach(ma, tenSach, tacGia, namXB, nhaXB,isbn, Integer.parseInt(soTrang) ,Double.parseDouble(donGia) );
		dsSach.capNhatSach(ma, s);
		int index = table.getSelectedRow();
		tableModel.setValueAt(tenSach, index, 1);
		tableModel.setValueAt(tacGia, index, 2);
		tableModel.setValueAt(namXB, index, 3);
		tableModel.setValueAt(nhaXB, index, 4);
		tableModel.setValueAt(soTrang, index, 5);
		tableModel.setValueAt(donGia, index, 6);
		tableModel.setValueAt(isbn, index, 7);
		
		JOptionPane.showMessageDialog(this, "Xong !!");
		txtMaSach.setEditable(true);
		table.setCellSelectionEnabled(false);
		btnSua.setEnabled(false);
		clearInput();
		
	}



	private void Luufile() {
		if(dsSach.getDsSach().size()==0) {
			JOptionPane.showMessageDialog(this, "Danh sách rỗng");
		}else {
			data.ghiXuongFile(dsSach.getDsSach());
			JOptionPane.showMessageDialog(this, "Đã lưu danh sách");
		}
		
	}
	private void loadData() {
		dsSach.napDuLieutuFile();
		for( Sach s : dsSach.getDsSach()) {
			String [] row = {s.getMaSach(),s.getTenSach(),s.getTacGia(),s.getNamXb(),s.getNhaXb(),s.getSoTrang()+"",s.getDonGia()+"",s.getiSBN()};
			tableModel.addRow(row);
			String maSach = s.getMaSach();
			cboMaSach.addItem(maSach);
		}
	}

	private void addSachtoTable() {
		// TODO Auto-generated method stub
		String ma = txtMaSach.getText();
		String tenSach = txtTenSach.getText();
		String tacGia = txtTacGia.getText();
		String namXB = txtNamXb.getText();
		String nhaXB = txtNhaXb.getText();
		String soTrang = txtSoTrang.getText();
		String donGia = txtDonGia.getText();
		String isbn = txtISBN.getText();
		
		Sach s = new Sach(ma, tenSach, tacGia, namXB, nhaXB,isbn, Integer.parseInt(soTrang) ,Double.parseDouble(donGia) );
		if(dsSach.themSach(s)) {
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			String [] row = {ma, tenSach, tacGia, namXB, nhaXB,soTrang,donGia, isbn};
			tableModel.addRow(row);
			cboMaSach.addItem(ma);
		}
		else {
			JOptionPane.showMessageDialog(this,"Mã sách đã tồn tại");
			txtMaSach.requestFocus();;
		}

		
	}


}
