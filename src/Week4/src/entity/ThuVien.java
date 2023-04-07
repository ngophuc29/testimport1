package entity;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import database.Database;

public class ThuVien {
	private ArrayList<Sach>	dsSach;
	
	public ThuVien() {
		dsSach = new ArrayList<Sach>(10);
	}

	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}

	public int count() {
		return dsSach.size();
	}
	
	public Sach timKiem(String maSach) {
		Sach s = new Sach(maSach);
		if (dsSach.contains(s)) {
			return dsSach.get(dsSach.indexOf(s));
		}
		return null;
	}
	public boolean xoa1CuonSach(int index) {
		if(index >=0 && index<dsSach.size()) {
			dsSach.remove(index);
			return true;
			
		}
		return false;
		
	}
	public boolean themSach(Sach s) {
		
		for (int i =0 ; i<dsSach.size() ; i++) {
			if(dsSach.get(i).getMaSach().equalsIgnoreCase(s.getMaSach())) {
				return false;
			}
		}
		dsSach.add(s);
		return true;
	
	}
	public boolean capNhatSach(String maOld,Sach sachNew) {
		Sach sachOld = new Sach(maOld);
		if(dsSach.contains(sachOld)) {
			sachOld = dsSach.get(dsSach.indexOf(sachOld));
			sachOld.setTenSach(sachNew.getTenSach());
			sachOld.setTacGia(sachNew.getTacGia());
			sachOld.setNamXb(sachNew.getNamXb());
			sachOld.setNhaXb(sachNew.getNhaXb());;
			sachOld.setSoTrang(sachNew.getSoTrang());
			sachOld.setDonGia(sachNew.getDonGia());
			sachOld.setiSBN(sachNew.getiSBN());
			return true;
		}
		return false;
		
	}
	
	public ArrayList<Sach> filter (String regex){
		ArrayList<Sach> result = new ArrayList<Sach>();
		
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		for(Sach s: dsSach) {
			Matcher m = p.matcher(s.getTenSach());
			if(m.find()) {
				result.add(s);
			}
		}
		return result;
	}
	public void napDuLieutuFile() {
		dsSach=Database.docTuFile();
	}
	
	
}
