package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.Date;
import java.util.ArrayList;

import model.User;
public class DaoUser {
	
		public ArrayList<User> getAllUsers(){
		ArrayList<User> users = new ArrayList<User>();
		Connection connection = ConnectionSQL.getConnectionSQL();
		String sql = "SELECT * FROM taikhoan";
		try {
			
			PreparedStatement ps =(PreparedStatement)connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				User user = new User();
				user.setUserName(rs.getString("USERNAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setEmail(rs.getString("EMAIL"));
				user.setFullName(rs.getString("FULLNAME"));
				user.setSex(rs.getString("GIOITINH"));
				user.setRoles(rs.getString("ROLES"));
				user.setDate((java.util.Date)rs.getDate("NGAYSINH"));
				user.setPhone(rs.getString("SDT"));
				
				users.add(user);
			}
			ps.close();
			ConnectionSQL.closeConnectionSQL(connection);
		}catch(Exception e)
		{
			e.printStackTrace();
		}

			return users;
	}
		
		public void addUser(User user_add){
			Connection connection = ConnectionSQL.getConnectionSQL();
			String sql = "INSERT INTO taikhoan VALUES (?,?,?,?,?,?,?,?)";
			try {
				
				PreparedStatement ps = connection.prepareStatement(sql);				
				@SuppressWarnings("deprecation")
				java.sql.Date date = new Date(user_add.getDate().getYear(),user_add.getDate().getMonth(), user_add.getDate().getDate());
				ps.setString(1,user_add.getUserName().trim());
				ps.setString(2,user_add.getPassword().trim());
				ps.setString(3,user_add.getEmail().trim());
				ps.setString(4,user_add.getFullName().trim());		
				ps.setString(5,user_add.getSex().trim());	
				ps.setString(6,user_add.getRoles().trim());	
				ps.setDate(7,date);
				ps.setString(8, user_add.getPhone());
				

				int rs = ps.executeUpdate();
				System.out.println(rs);
				ConnectionSQL.closeConnectionSQL(connection);
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		public void updateUser(User user_update){
			
			
			Connection connection = ConnectionSQL.getConnectionSQL();
			String sql = "UPDATE taikhoan SET USERNAME= ? , PASSWORD = ? , EMAIL = ?, FULLNAME = ?, GIOITINH = ?,ROLES = ?,NGAYSINH = ?, SDT = ? WHERE USERNAME  = '" +  user_update.getUserName()+"'";
			try {
				
				PreparedStatement ps = connection.prepareStatement(sql);
				@SuppressWarnings("deprecation")
				java.sql.Date date = new Date(user_update.getDate().getYear(),user_update.getDate().getMonth(), user_update.getDate().getDate());
				ps.setString(1,user_update.getUserName().trim());
				ps.setString(2,user_update.getPassword().trim());
				ps.setString(3,user_update.getEmail().trim());
				ps.setString(4,user_update.getFullName().trim());		
				ps.setString(5,user_update.getSex().trim());		
				ps.setString(6,user_update.getRoles().trim());		
				ps.setDate(7,date);
				ps.setString(8,user_update.getPhone().trim());
				int rs = ps.executeUpdate();
				System.out.println(rs);
				ConnectionSQL.closeConnectionSQL(connection);
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		public void deleteUser(User user_delete){
			
			
			Connection connection = ConnectionSQL.getConnectionSQL();
			String sql = "DELETE FROM taikhoan WHERE USERNAME = ?";
			try {
				
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1,user_delete.getUserName().trim());
				int rs = ps.executeUpdate();
				System.out.println(rs);
				ConnectionSQL.closeConnectionSQL(connection);
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}	

}
