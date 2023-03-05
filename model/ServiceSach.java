package model;



import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import controller.DaoSach;

public class ServiceSach {
	
	public DaoSach SachDao;
	
	public ServiceSach() {
		SachDao = new DaoSach();
	}
	
	public ArrayList<Sach> getAllSach()
	{
		return SachDao.getAllSach();
	}
	
	
	public boolean addSach(Sach sach_add)
	{
		String masach = sach_add.getMaSach();
		
		for (Sach sachadd : SachDao.getAllSach()) {
			if(sachadd.getMaSach().equals(masach))
			{
				return false;
			}
		}
		SachDao.addSach(sach_add);
		return true;
	}
	
	public boolean updateSach(Sach sach_update)
	{	
		SachDao.updateSach(sach_update);
		for (Sach listSach : SachDao.getAllSach()) {
			if(sach_update.getMaSach().equals(listSach.getMaSach()))
			{
				return true;
			}
		}
		return false;
	}
	public void deleteSach(Sach sach_xoa)
	{
		SachDao.deleteSach(sach_xoa);
	}
	public void printf_tableSachAdd(JTable table_sach,Sach sach_add)
	{
		@SuppressWarnings("deprecation")
		Locale lc = new Locale("vi","VN");
		NumberFormat numf = NumberFormat.getCurrencyInstance(lc);
		
		DefaultTableModel model2 = (DefaultTableModel) table_sach.getModel();
		model2.addRow(new Object[] { 
					sach_add.getMaSach(),
					sach_add.getTenSach(),
					sach_add.getTenTG(),
					sach_add.getTheLoai(),
					sach_add.getNhaXB(),
					sach_add.getTinhTrang(),
					sach_add.getSoLuong(),
					numf.format(sach_add.getGiaTien()),
					sach_add.getKho()
					});
	}
	public void thucHienTaiLaiDuLieuSach(JTable table_Sach) {

		@SuppressWarnings("deprecation")
		Locale lc = new Locale("vi","VN");
		NumberFormat numf = NumberFormat.getCurrencyInstance(lc);
		
		while (true) {
			DefaultTableModel model = (DefaultTableModel) table_Sach.getModel();
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
		for (Sach sach_add : SachDao.getAllSach()) {
			DefaultTableModel model3 = (DefaultTableModel) table_Sach.getModel();
			model3.addRow(new Object[] { 
					sach_add.getMaSach(),
					sach_add.getTenSach(),
					sach_add.getTenTG(),
					sach_add.getTheLoai(),
					sach_add.getNhaXB(),
					sach_add.getTinhTrang(),
					sach_add.getSoLuong(),
					numf.format(sach_add.getGiaTien()),
					sach_add.getKho()
				});
			}
		}
	
			
	
}
