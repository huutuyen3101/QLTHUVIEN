package model;

import java.util.Date;
import java.util.Objects;

public class ViPham {
	
	private String id_vp;
	private MuonTra mt_vp;
	private Date ngay_xl;
	private float tienPhat;
	private String lydo;
	
	public ViPham(String id_vp,MuonTra mt_vp, Date ngay_xl, float tienPhat, String lydo) {
		this.id_vp = id_vp;
		this.mt_vp = mt_vp;
		this.ngay_xl = ngay_xl;
		this.tienPhat = tienPhat;
		this.lydo = lydo;
	}

	public ViPham()
	{
		
	}
	public String getId_vp() {
		return id_vp;
	}
	public void setId_vp(String id_vp) {
		this.id_vp = id_vp;
	}
	public MuonTra getMt_vp() {
		return mt_vp;
	}
	public void setMt_vp(MuonTra mt_vp) {
		this.mt_vp = mt_vp;
	}
	public Date getNgay_xl() {
		return ngay_xl;
	}
	public void setNgay_xl(Date ngay_xl) {
		this.ngay_xl = ngay_xl;
	}
	public float getTienPhat() {
		return tienPhat;
	}
	public void setTienPhat(float tienPhat) {
		this.tienPhat = tienPhat;
	}
	public String getLydo() {
		return lydo;
	}
	public void setLydo(String lydo) {
		this.lydo = lydo;
	}
	@Override
	public String toString() {
		return "ViPham [id_vp=" + id_vp + ", mt_vp=" + mt_vp + ", ngay_xl=" + ngay_xl + ", tienPhat=" + tienPhat
				+ ", lydo=" + lydo + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViPham other = (ViPham) obj;
		return Objects.equals(id_vp, other.id_vp) && Objects.equals(lydo, other.lydo)
				&& Objects.equals(mt_vp, other.mt_vp) && Objects.equals(ngay_xl, other.ngay_xl)
				&& Float.floatToIntBits(tienPhat) == Float.floatToIntBits(other.tienPhat);
	}
	
	
}
