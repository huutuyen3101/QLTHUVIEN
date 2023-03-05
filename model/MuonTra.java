package model;

import java.util.Date;
import java.util.Objects;

public class MuonTra {
	private String IdMuonTra;
	private User id_user_muon;
	private User id_user_chomuon;
	
	private Sach id_sach;
	private String ttrangsachmuon;
	private int sl_muon;
	
	private Date ngayMuon;
	private Date ngayTra;
	private int hanTra;
	
	public MuonTra(String idMuonTra, User id_user_muon, User id_user_chomuon, Sach id_sach, String ttrangsachmuon,
			int sl_muon, Date ngayMuon, Date ngayTra, int hanTra) {
		IdMuonTra = idMuonTra;
		this.id_user_muon = id_user_muon;
		this.id_user_chomuon = id_user_chomuon;
		this.id_sach = id_sach;
		this.ttrangsachmuon = ttrangsachmuon;
		this.sl_muon = sl_muon;
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
		this.hanTra = hanTra;
	}
	public MuonTra()
	{
		
	}
	@Override
	public String toString() {
		return "MuonTra [IdMuonTra=" + IdMuonTra + ", id_user_muon=" + id_user_muon + ", id_user_chomuon="
				+ id_user_chomuon + ", id_sach=" + id_sach + ", ttrangsachmuon=" + ttrangsachmuon + ", sl_muon="
				+ sl_muon + ", ngayMuon=" + ngayMuon + ", ngayTra=" + ngayTra + ", hanTra=" + hanTra + "]";
	}
	public String getIdMuonTra() {
		return IdMuonTra;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MuonTra other = (MuonTra) obj;
		return Objects.equals(IdMuonTra, other.IdMuonTra) && hanTra == other.hanTra
				&& Objects.equals(id_sach, other.id_sach) && Objects.equals(id_user_chomuon, other.id_user_chomuon)
				&& Objects.equals(id_user_muon, other.id_user_muon) && Objects.equals(ngayMuon, other.ngayMuon)
				&& Objects.equals(ngayTra, other.ngayTra) && sl_muon == other.sl_muon
				&& Objects.equals(ttrangsachmuon, other.ttrangsachmuon);
	}
	public void setIdMuonTra(String idMuonTra) {
		IdMuonTra = idMuonTra;
	}
	public User getId_user_muon() {
		return id_user_muon;
	}
	public void setId_user_muon(User id_user_muon) {
		this.id_user_muon = id_user_muon;
	}
	public User getId_user_chomuon() {
		return id_user_chomuon;
	}
	public void setId_user_chomuon(User id_user_chomuon) {
		this.id_user_chomuon = id_user_chomuon;
	}
	public Sach getId_sach() {
		return id_sach;
	}
	public void setId_sach(Sach id_sach) {
		this.id_sach = id_sach;
	}
	public String getTtrangsachmuon() {
		return ttrangsachmuon;
	}
	public void setTtrangsachmuon(String ttrangsachmuon) {
		this.ttrangsachmuon = ttrangsachmuon;
	}
	public int getSl_muon() {
		return sl_muon;
	}
	public void setSl_muon(int sl_muon) {
		this.sl_muon = sl_muon;
	}
	public Date getNgayMuon() {
		return ngayMuon;
	}
	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}
	public Date getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}
	public int getHanTra() {
		return hanTra;
	}
	public void setHanTra(int hanTra) {
		if(hanTra < 15)
		{
		this.hanTra = hanTra;
		}else
		{
			return;
		}
	}
	
	
}
