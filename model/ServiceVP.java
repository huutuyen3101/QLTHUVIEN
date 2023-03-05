package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.DaoVP;

public class ServiceVP {
	private DaoVP daoVP;
	public ServiceUser ListUser = new ServiceUser(); 
	public ServiceMuonTra ListMT = new ServiceMuonTra(); 

	
	public ServiceVP() {
		daoVP = new DaoVP();
	}
	
	public ArrayList<ViPham> getAllVP()
	{
		return daoVP.getAllVP();
	}
	
	
	public boolean addVP(ViPham vp_add)
	{		
		for (ViPham vp : daoVP.getAllVP()) {
			if(vp_add.getId_vp().equals(vp.getId_vp()))
			{
				return false;
			}
		}
		daoVP.addVP(vp_add);
		return true;
	}
	
	public boolean updateVP(ViPham vp_update)
	{	
		daoVP.updateVP(vp_update);
		for (ViPham listVP : daoVP.getAllVP()) {
			if(vp_update.getId_vp().equals(listVP.getId_vp()))
			{
				return true;
			}
		}
		return false;
	}
	
	public void deleteVP(ViPham VP_delete)
	{
		daoVP.deleteVP(VP_delete);
	}
	
	@SuppressWarnings("deprecation")
	public void printf_tableVP(JTable table_dsVP,ViPham VP_add)
	{
		String fullname_vp = null;
		
				for (User usermuon : ListUser.getAllUser()) {
					if (VP_add.getMt_vp().getId_user_muon().getUserName().equals(usermuon.getUserName())) {
						fullname_vp = usermuon.getFullName();
					}
				}
		
		DefaultTableModel model2 = (DefaultTableModel) table_dsVP.getModel();
		model2.addRow(new Object[] { 
				VP_add.getId_vp(),
				fullname_vp,
				VP_add.getNgay_xl().getDate() + "/" + (VP_add.getNgay_xl().getMonth()+1) +  "/" + (VP_add.getNgay_xl().getYear()+1900),
				VP_add.getTienPhat(),
				VP_add.getLydo()
				});
	}
	
	@SuppressWarnings("deprecation")
	public void thucHienTaiLaiVP(JTable table_dsVP) {
		DefaultTableModel model = (DefaultTableModel) table_dsVP.getModel();
		Locale lc = new Locale("vi","VN");
		NumberFormat numf = NumberFormat.getCurrencyInstance(lc);
		while (true) {
			int soLuongDong = table_dsVP.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		}
			String fullname_vp = null;
			String id_vp = null;
			String date_vp = null;
			String rice_vp = null;
			String lydo_vp = null;
			ServiceMuonTra listMT = new ServiceMuonTra();
			
			for (ViPham list_vp : daoVP.getAllVP()) {
				for(MuonTra muontra : listMT.getAllMuonTra())
				{
					for(User user_vp :ListUser.getAllUser())
						if (list_vp.getMt_vp().getIdMuonTra().equals(muontra.getIdMuonTra())) {
							if(muontra.getId_user_muon().getUserName().equals(user_vp.getUserName()))
							{
								fullname_vp = user_vp.getFullName();
								id_vp = list_vp.getId_vp();
								date_vp = list_vp.getNgay_xl().getDate() + "/" + (list_vp.getNgay_xl().getMonth()+1) +  "/" + (list_vp.getNgay_xl().getYear()+1900);
								rice_vp = numf.format(list_vp.getTienPhat());
								lydo_vp = list_vp.getLydo();
								
								model.addRow(new Object[] { 
										id_vp,
										fullname_vp,
										date_vp,
										rice_vp,					
										lydo_vp
									});
							}
				
						}
					
				}
			
			}
		
		
	}
}
		
		
			

