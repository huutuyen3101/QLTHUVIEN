package model;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.DaoUser;

public class ServiceUser {
	private DaoUser userDao;

	public ServiceUser() {
		userDao = new DaoUser();
	}
	
	
	
	public ArrayList<User> getAllUser()
	{
		return userDao.getAllUsers();
	}
	
	
	
	public boolean addUser(User user_add)
	{
		String username = user_add.getUserName();
		
		for (User usercompare : userDao.getAllUsers()) {
			if(usercompare.getUserName().trim().equals(username.trim()))
			{
				return false;
			}
		}
		userDao.addUser(user_add);
		return true;
	}
	
	
	public boolean DangNhap(User user_dn,String roles)
	{
		String username = user_dn.getUserName();
		String password = user_dn.getPassword();
	
		for (User usercompare : userDao.getAllUsers()) {
			if(usercompare.getUserName().trim().equals(username.trim())
			   && usercompare.getPassword().trim().equals(password.trim())
			   && usercompare.getRoles().trim().equals(roles.trim()))
			{
						return true;
			}
		}
		return false;
		
	}
	
	public void deleteUser(User User_delete)
	{
		userDao.deleteUser(User_delete);
	}
	
	@SuppressWarnings("deprecation")
	public void printf_tableUserAdd(JTable table_dsUser,User user_add)
	{
		DefaultTableModel model2 = (DefaultTableModel) table_dsUser.getModel();
		model2.addRow(new Object[] { 
					user_add.getUserName(),
					user_add.getPassword(),
					user_add.getFullName(),
					user_add.getSex(),
					user_add.getEmail(),
					user_add.getRoles(),
					user_add.getDate().getDate() +"/"+ (user_add.getDate().getMonth()+1) +"/"+(user_add.getDate().getYear()+1900),
					user_add.getPhone()
					});
	}
	
	public boolean updateUser(User user_update)
	{
		userDao.updateUser(user_update);
		for (User listUser : userDao.getAllUsers()) {
			if(user_update.getUserName().equals(listUser.getUserName()))
			{
				return true;
			}
		}
		return false;
	}
		
	@SuppressWarnings("deprecation")
	public void thucHienTaiLaiDuLieu(JTable table_timuser) {
		while (true) {
			DefaultTableModel model6 = (DefaultTableModel) table_timuser.getModel();
			int soLuongDong = model6.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model6.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (User user6 : userDao.getAllUsers()) {
			DefaultTableModel model3 = (DefaultTableModel) table_timuser.getModel();
			model3.addRow(new Object[] { 
					user6.getUserName(),
					user6.getPassword(),
					user6.getFullName(),
					user6.getSex(),
					user6.getEmail(),
					user6.getRoles(),
					user6.getDate().getDate() +"/"+ (user6.getDate().getMonth()+1) +"/"+(user6.getDate().getYear()+1900),
					user6.getPhone()
				});
			}
		}
	
	
}
