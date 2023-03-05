package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import model.MuonTra;
import model.Sach;
import model.User;

public class DaoMuonTra {
	public ArrayList<MuonTra> getAllMuonTra(){
		ArrayList<MuonTra> dssachmuon = new ArrayList<MuonTra>();
		try {
			Connection connection = ConnectionSQL.getConnectionSQL();
			String sql = "SELECT * FROM muontra";
			PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
					
			
			while(rs.next())
			{
				MuonTra muontra = new MuonTra();
				User nguoimuon = new User();
				User nguoichomuon = new User();
				Sach sachmuon = new Sach();
				muontra.setIdMuonTra(rs.getString("IDMUONTRA"));
				
				nguoimuon.setUserName(rs.getString("NGUOIMUON"));
				muontra.setId_user_muon(nguoimuon);
				
				nguoichomuon.setUserName(rs.getString("NGUOICHOMUON"));
				muontra.setId_user_chomuon(nguoichomuon);
				
				sachmuon.setMaSach(rs.getString("SACHMUON"));
				muontra.setId_sach(sachmuon);
				
				muontra.setSl_muon(rs.getInt("SOLUONGMUON"));
				muontra.setNgayMuon(rs.getDate("NGAYMUON"));
				muontra.setNgayTra(rs.getDate("NGAYTRA"));
				muontra.setHanTra(rs.getInt("HANTRA"));
				muontra.setTtrangsachmuon(rs.getString("TINHTRANG"));
				
				dssachmuon.add(muontra);
			}
			ps.close();
			ConnectionSQL.closeConnectionSQL(connection);
			}catch(Exception e1)
				{
					System.out.println("LOI!!!!");
				}
		return dssachmuon;

	}
		@SuppressWarnings("deprecation")
		public void addMuonTra(MuonTra muontra_add){
			Connection connection = ConnectionSQL.getConnectionSQL();
			String sql = "INSERT INTO muontra VALUES (?,?,?,?,?,?,?,?,?)";
			try {
				
				PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);	
				java.sql.Date date_muon = new Date(muontra_add.getNgayMuon().getYear(),muontra_add.getNgayMuon().getMonth(), muontra_add.getNgayMuon().getDate());
				ps.setString(1,muontra_add.getIdMuonTra());
				ps.setString(2,muontra_add.getId_user_muon().getUserName().trim());
				ps.setString(3,muontra_add.getId_user_chomuon().getUserName().trim());
				ps.setString(4,muontra_add.getId_sach().getMaSach().trim());
				ps.setInt(5,muontra_add.getSl_muon());
				ps.setDate(6,date_muon);
				java.sql.Date date_tra = new Date(muontra_add.getNgayTra().getYear(),muontra_add.getNgayTra().getMonth(),muontra_add.getNgayTra().getDate());
				ps.setDate(7,date_tra);
				ps.setInt(8,muontra_add.getHanTra());
				ps.setString(9,muontra_add.getTtrangsachmuon());


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
		@SuppressWarnings("deprecation")
		public void updateMuonTra(MuonTra muontra_update){
			
			
			Connection connection = ConnectionSQL.getConnectionSQL();
			String sql = "UPDATE muontra SET IDMUONTRA= ? ,NGAYTRA = ?,TINHTRANG = ? WHERE IDMUONTRA= '" + muontra_update.getIdMuonTra() +"'";
			try {
				
				PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);	

				ps.setString(1,muontra_update.getIdMuonTra());
				java.sql.Date date_tra = new Date(muontra_update.getNgayTra().getYear(),muontra_update.getNgayTra().getMonth(),muontra_update.getNgayTra().getDate());
				ps.setDate(2,date_tra);
				ps.setString(3,muontra_update.getTtrangsachmuon());


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

		public void deleteMuonTra(MuonTra muontra_delete){
					
			Connection connection = ConnectionSQL.getConnectionSQL();
			String sql = "DELETE FROM muontra WHERE IDMUONTRA = ?";
			try {		
				PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
				ps.setString(1,muontra_delete.getIdMuonTra().trim());
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
