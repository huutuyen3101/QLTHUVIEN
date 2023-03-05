	package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.MuonTra;
import model.ViPham;

public class DaoVP {
	public ArrayList<ViPham> getAllVP(){
		ArrayList<ViPham> vpham = new ArrayList<ViPham>();
		Connection connection = ConnectionSQL.getConnectionSQL();
		String sql = "SELECT * FROM vipham";
		try {
			
			PreparedStatement ps =(PreparedStatement)connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ViPham vipham = new ViPham();
				MuonTra mtra = new MuonTra();
				vipham.setId_vp(rs.getString("ID"));
				mtra.setIdMuonTra(rs.getString("IDMUONTRA"));
				vipham.setMt_vp(mtra);
				vipham.setNgay_xl(rs.getDate("NGAYPHAT"));
				vipham.setTienPhat(rs.getFloat("TIENPHAT"));
				vipham.setLydo(rs.getString("LYDO"));
				
				vpham.add(vipham);
			}
			ps.close();
			ConnectionSQL.closeConnectionSQL(connection);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			return vpham ;
	}
		
		public void addVP(ViPham add_vp){
			Connection connection = ConnectionSQL.getConnectionSQL();
			String sql = "INSERT INTO vipham VALUES (?,?,?,?,?)";
			try {
				
				PreparedStatement ps = connection.prepareStatement(sql);				
				@SuppressWarnings("deprecation")
				java.sql.Date date = new Date(add_vp.getNgay_xl().getYear(),add_vp.getNgay_xl().getMonth(), add_vp.getNgay_xl().getDate());
				ps.setString(1,add_vp.getId_vp().trim());
				ps.setString(2,add_vp.getMt_vp().getIdMuonTra());
				ps.setDate(3,date);
				ps.setFloat(4,add_vp.getTienPhat());		
				ps.setString(5,add_vp.getLydo());	
				int rs = ps.executeUpdate();
				System.out.println(rs);
				ConnectionSQL.closeConnectionSQL(connection);
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		public void updateVP(ViPham vp_update){
			
			
			Connection connection = ConnectionSQL.getConnectionSQL();
			String sql = "UPDATE vipham SET ID= ? , IDMUONTRA = ? , NGAYPHAT = ?, TIENPHAT = ?, LYDO = ? WHERE ID  = '" +  vp_update.getId_vp()+"'";
			try {
				
				PreparedStatement ps = connection.prepareStatement(sql);
				@SuppressWarnings("deprecation")
				java.sql.Date date = new Date(vp_update.getNgay_xl().getYear(),vp_update.getNgay_xl().getMonth(), vp_update.getNgay_xl().getDate());
				ps.setString(1,vp_update.getId_vp().trim());
				ps.setString(2,vp_update.getMt_vp().getIdMuonTra());
				ps.setDate(3,date);
				ps.setFloat(4,vp_update.getTienPhat());		
				ps.setString(5,vp_update.getLydo());	
				int rs = ps.executeUpdate();
				System.out.println(rs);
				ConnectionSQL.closeConnectionSQL(connection);
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		public void deleteVP(ViPham vp_delete){
			
			
			Connection connection = ConnectionSQL.getConnectionSQL();
			String sql = "DELETE FROM vipham WHERE ID = ?";
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1,vp_delete.getId_vp().trim());
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
