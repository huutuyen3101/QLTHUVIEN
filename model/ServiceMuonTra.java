package model;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.DaoMuonTra;

public class ServiceMuonTra {
	private DaoMuonTra daoMT;
	public ServiceUser ListUser = new ServiceUser(); 
	public ServiceSach ListSach = new ServiceSach(); 

	
	public ServiceMuonTra() {
		daoMT = new DaoMuonTra();
	}
	
	public ArrayList<MuonTra> getAllMuonTra()
	{
		return daoMT.getAllMuonTra();
	}
	
	
	public boolean addMuonTra(MuonTra muontra_add)
	{		
		for (MuonTra mtadd : daoMT.getAllMuonTra()) {
			if(muontra_add.getIdMuonTra().equals(mtadd.getIdMuonTra()))
			{
				return false;
			}
		}
		daoMT.addMuonTra(muontra_add);
		return true;
	}
	
	public boolean updateMuonTra(MuonTra muontra_update)
	{	
		daoMT.updateMuonTra(muontra_update);
		for (MuonTra listMT : daoMT.getAllMuonTra()) {
			if(muontra_update.getIdMuonTra().equals(listMT.getIdMuonTra()))
			{
				return true;
			}
		}
		return false;
	}
	public void deleteMT(MuonTra muontra_delete)
	{
		daoMT.deleteMuonTra(muontra_delete);
	}
	
	@SuppressWarnings("deprecation")
	public void printf_tableMT(JTable table_dsMT,MuonTra muontra_add)
	{
		String fullname_muon = null;
		String fullname_chomuon = null;
		String tenSach = null;
		for (MuonTra MT_add : daoMT.getAllMuonTra()) {
				for (User usermuon : ListUser.getAllUser()) {
					if (MT_add.getId_user_muon().getUserName().equals(usermuon.getUserName())) {
						fullname_muon = usermuon.getFullName();
					}
				}
				for (User userchomuon : ListUser.getAllUser()) {
					if (userchomuon.getUserName().equals(MT_add.getId_user_chomuon().getUserName())) {
						fullname_chomuon = userchomuon.getFullName();
					}
				}
				for (Sach sachmuon : ListSach.getAllSach()) {
					if (sachmuon.getMaSach().equals(MT_add.getId_sach().getMaSach())) {
						 tenSach= sachmuon.getTenSach();

					}
				}
		}
		
		DefaultTableModel model2 = (DefaultTableModel) table_dsMT.getModel();
		model2.addRow(new Object[] { 
				muontra_add.getIdMuonTra(),
				fullname_muon,
				fullname_chomuon,
				tenSach,
				muontra_add.getSl_muon(),
				muontra_add.getNgayMuon().getDate() + "/" + (muontra_add.getNgayMuon().getMonth()+1) +  "/" + (muontra_add.getNgayMuon().getYear()+1900),
				muontra_add.getNgayTra().getDate() + "/" + (muontra_add.getNgayTra().getMonth()+1) +  "/" + (muontra_add.getNgayTra().getYear()+1900),
				muontra_add.getHanTra(),
				muontra_add.getTtrangsachmuon()
				});
	}
	@SuppressWarnings("deprecation")
	public void thucHienTaiLaiMT(JTable table_MT) {
		while (true) {
			DefaultTableModel model = (DefaultTableModel) table_MT.getModel();
			int soLuongDong = model.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		String fullname_muon = null;
		String fullname_chomuon = null;
		String tenSach = null;
		for (MuonTra MT_add : daoMT.getAllMuonTra()) {
				for (User usermuon : ListUser.getAllUser()) {
					if (MT_add.getId_user_muon().getUserName().equals(usermuon.getUserName())) {
						fullname_muon = usermuon.getFullName();
					}
				}
				for (User userchomuon : ListUser.getAllUser()) {
					if (userchomuon.getUserName().equals(MT_add.getId_user_chomuon().getUserName())) {
						fullname_chomuon = userchomuon.getFullName();
					}
				}
				for (Sach sachmuon : ListSach.getAllSach()) {
					if (sachmuon.getMaSach().equals(MT_add.getId_sach().getMaSach())) {
						 tenSach= sachmuon.getTenSach();
	
					}
				}	
			DefaultTableModel model3 = (DefaultTableModel) table_MT.getModel();
			model3.addRow(new Object[] { 
					MT_add.getIdMuonTra(),
					fullname_muon,
					fullname_chomuon,
					tenSach,
					MT_add.getSl_muon(),
					MT_add.getNgayMuon().getDate() + "/" + (MT_add.getNgayMuon().getMonth()+1) +  "/" + (MT_add.getNgayMuon().getYear()+1900),
					MT_add.getNgayTra().getDate() + "/" + (MT_add.getNgayTra().getMonth()+1) +  "/" + (MT_add.getNgayTra().getYear()+1900),
					MT_add.getHanTra(),
					MT_add.getTtrangsachmuon()
				});
			}
		}
}
