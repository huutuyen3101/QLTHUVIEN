package model;

import java.io.Serializable;
import java.util.Objects;

public class Sach implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maSach ,theLoai,tenSach, NhaXB, tenTG, TinhTrang, Kho;
	private float giaTien;
	private int soLuong;
	public Sach(String maSach, String tenSach,String theLoai, String nhaXB, String tenTG, String tinhTrang, String kho, float giaTien,
			int soLuong) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.theLoai = theLoai;
		this.NhaXB = nhaXB;
		this.tenTG = tenTG;
		this.TinhTrang = tinhTrang;
		this.Kho = kho;
		this.giaTien = giaTien;
		this.soLuong = soLuong;
	}
	
	public Sach()
	{
		
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(Kho, other.Kho) && Objects.equals(NhaXB, other.NhaXB)
				&& Objects.equals(TinhTrang, other.TinhTrang)
				&& Float.floatToIntBits(giaTien) == Float.floatToIntBits(other.giaTien)
				&& Objects.equals(maSach, other.maSach) && soLuong == other.soLuong
				&& Objects.equals(tenSach, other.tenSach) && Objects.equals(tenTG, other.tenTG)
				&& Objects.equals(theLoai, other.theLoai);
	}
	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", theLoai=" + theLoai + ", tenSach=" + tenSach + ", NhaXB=" + NhaXB
				+ ", tenTG=" + tenTG + ", TinhTrang=" + TinhTrang + ", Kho=" + Kho + ", giaTien=" + giaTien
				+ ", soLuong=" + soLuong + "]";
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
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public String getNhaXB() {
		return NhaXB;
	}
	public void setNhaXB(String nhaXB) {
		NhaXB = nhaXB;
	}
	public String getTenTG() {
		return tenTG;
	}
	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}
	public String getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		TinhTrang = tinhTrang;
	}
	public String getKho() {
		return Kho;
	}
	public void setKho(String kho) {
		Kho = kho;
	}
	public float getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(float giaTien) {
		this.giaTien = giaTien;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	
	
	
	
}
