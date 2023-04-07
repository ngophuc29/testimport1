package entity;

public class Sach {
	private String maSach;
	private String tenSach;
	private String tacGia;
	private String namXb;
	private String nhaXb;
	private String iSBN;
	private int soTrang;
	private Double donGia;
	public Sach(String maSach, String tenSach, String tacGia, String namXb, String nhaXb, String iSBN, int soTrang,
			Double donGia) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.namXb = namXb;
		this.nhaXb = nhaXb;
		this.iSBN = iSBN;
		this.soTrang = soTrang;
		this.donGia = donGia;
	}
	public Sach(String maSach2) {
		// TODO Auto-generated constructor stub
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getNamXb() {
		return namXb;
	}
	public void setNamXb(String namXb) {
		this.namXb = namXb;
	}
	public String getNhaXb() {
		return nhaXb;
	}
	public void setNhaXb(String nhaXb) {
		this.nhaXb = nhaXb;
	}
	public String getiSBN() {
		return iSBN;
	}
	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public Double getDonGia() {
		return donGia;
	}
	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}
	
	
	
}
