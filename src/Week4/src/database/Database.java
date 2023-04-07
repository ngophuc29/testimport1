package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import entity.Sach;

public class Database {
	private static final String FILENAME = "dulieu.txt";
	
	public static void ghiXuongFile(ArrayList<Sach> dsSach) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(FILENAME));
			bw.write("MaSach;TenSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN\n");
			for (Sach s : dsSach) {
				bw.write(s.getMaSach()+";"+s.getTenSach()+";"+s.getTacGia()+";"+s.getNamXb()+";"+s.getNhaXb()+";"+s.getSoTrang()+";"+s.getDonGia()+";"+s.getiSBN()+"\n");
			}
			bw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static ArrayList<Sach> docTuFile(){
		ArrayList<Sach> dsSach = new ArrayList<Sach>(10);
		BufferedReader br = null;
	
		try {
			if(new File(FILENAME).exists()) {
				br = new BufferedReader(new FileReader(FILENAME));
				
				br.readLine();
				
				while(br.ready()) {
					String line = br.readLine();
					if(line != null && !line.trim().equals("")) {
						String[] a = line.split(";");
						Sach s = new Sach(a[0],a[1],a[2],a[3],a[4],a[7],Integer.parseInt(a[5]),Double.parseDouble(a[6]));
						dsSach.add(s);
				
					}
				}
				
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsSach;
	}
}
