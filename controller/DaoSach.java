package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Sach;

public class DaoSach {
	public ArrayList<Sach> getAllSach(){
		ArrayList<Sach> dssach = new ArrayList<Sach>();
		try {
			Connection connection = ConnectionSQL.getConnectionSQL();
			String sql = "SELECT * FROM sach";
			PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
					
			
			while(rs.next())
			{
				Sach sach = new Sach();
				sach.setMaSach(rs.getString("MASACH"));
				sach.setTenSach(rs.getString("TENSACH"));;
				sach.setTenTG(rs.getString("TACGIA"));	
				sach.setTheLoai(rs.getString("THELOAI"));
				sach.setNhaXB(rs.getString("NHAXUATBAN"));
				sach.setTinhTrang(rs.getString("TINHTRANG"));
				sach.setSoLuong(rs.getInt("SOLUONG"));
				sach.setGiaTien(rs.getFloat("GIATIEN"));
				sach.setKho(rs.getString("KHO"));
				dssach.add(sach);
			}
			ps.close();
			ConnectionSQL.closeConnectionSQL(connection);
			}catch(Exception e1)
				{
					System.out.println("LOI!!!!");
				}
		return dssach;

	}
		
		public void addSach(Sach sach_add){
			Connection connection = ConnectionSQL.getConnectionSQL();
			String sql = "INSERT INTO sach VALUES (?,?,?,?,?,?,?,?,?)";
			try {
				
				PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);				
				ps.setString(1,sach_add.getMaSach().trim());
				ps.setString(2,sach_add.getTenSach().trim());
				ps.setString(3,sach_add.getTenTG().trim());
				ps.setString(4, sach_add.getTheLoai().trim());
				ps.setString(5,sach_add.getNhaXB().trim());
				ps.setString(6,sach_add.getTinhTrang().trim());
				ps.setInt(7,sach_add.getSoLuong());
				ps.setFloat(8,sach_add.getGiaTien());
				ps.setString(9,sach_add.getKho().trim());

				int rs = ps.executeUpdate();
				System.out.println(rs);
				ps.close();
				ConnectionSQL.closeConnectionSQL(connection);
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		public void updateSach(Sach sach_update){
			
			
			Connection connection = ConnectionSQL.getConnectionSQL();
			String sql = "UPDATE sach SET MASACH= ? , TENSACH = ? , TACGIA = ?,THELOAI = ?, NHAXUATBAN = ?,TINHTRANG = ?,SOLUONG = ?,GIATIEN = ?, KHO = ? WHERE MASACH = '" + sach_update.getMaSach() +"'";
			try {
				
				PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);				
				ps.setString(1,sach_update.getMaSach().trim());
				ps.setString(2,sach_update.getTenSach().trim());
				ps.setString(3,sach_update.getTenTG().trim());
				ps.setString(4, sach_update.getTheLoai().trim());
				ps.setString(5,sach_update.getNhaXB().trim());
				ps.setString(6,sach_update.getTinhTrang().trim());
				ps.setInt(7,sach_update.getSoLuong());
				ps.setFloat(8,sach_update.getGiaTien());
				ps.setString(9,sach_update.getKho().trim());

				int rs = ps.executeUpdate();
				System.out.println(rs);
				ps.close();
				ConnectionSQL.closeConnectionSQL(connection);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}

		public void deleteSach(Sach sach_delete){
			
			
			Connection connection = ConnectionSQL.getConnectionSQL();
			String sql = "DELETE FROM sach WHERE MASACH = ?";
			try {
				
				PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
				ps.setString(1,sach_delete.getMaSach().trim());
				int rs = ps.executeUpdate();
				System.out.println(rs);
				ps.close();
				ConnectionSQL.closeConnectionSQL(connection);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		}		
}
