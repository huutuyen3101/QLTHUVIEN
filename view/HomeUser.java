package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.MuonTra;
import model.Sach;
import model.ServiceMuonTra;
import model.ServiceSach;
import model.ServiceUser;
import model.ServiceVP;
import model.User;

public class HomeUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JPanel panelMain;
	public ServiceSach ListSach = new ServiceSach(); 
	public ServiceUser ListUser = new ServiceUser(); 
	public ServiceMuonTra ListMT = new ServiceMuonTra(); 
	public ServiceVP ListVP = new ServiceVP(); 
	public ButtonGroup btn_chon;
	public JCheckBox chckbxNuu;
	public ButtonGroup btn_chon_update;
	public JTable table_sach;
	public JTextField text_maSach;
	public JTextField text_tenSach;
	public JTextField text_tacGia;
	public JTextField text_theLoai;
	public JTextField text_NXB;
	public JTextField text_TinhTrang;
	public JTextField text_soLuong;
	public JTextField text_GiaTien;
	public JTextField text_maKho;
	public JTable tabletimSach;
	public JTextField textField_maSachtim;
	public JTextField textField_tenSachtim;
	public JTextField textField_tacgiatim;
	public JTextField textField_theloaitim;
	public JTextField textField_nxbtim;
	public JTextField textField_tinhtrangtim;
	public JTextField textField_sltim;
	public JTextField textField_giasachtim;
	public JTextField textField_makhotim;
	public JTable table_muontra;
	public JTextField textF_idmuon;
	public JTextField textF_nguoimuon;
	public JTextField textF_nguoiChomuon;
	public JTextField textF_SachMuon;
	public JTextField textF_soLuong;
	public JTextField textF_hanTra;
	public JTextField textF_ngayMuon;
	public JTextField textF_NgayTra;
	public JTable table_timMT;
	public JTextField textF_idtra;
	public JTextField textF_timNgayTra;
	public JTextField textF_timmaPhieu;
	public JTextField textF_timTinhTrang;
	public JTable table_intaiLieu;
	public JTable table_inPM;
	public JTextField textFi_doiTK;
	public JPasswordField passwordField_mkhientai;
	public JPasswordField passwordField_mkDoi;
	public JPasswordField passwordField_mkDoiXN;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeUser frame = new HomeUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeUser() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 592);
		setTitle("Phần mềm quản lý thư viện 1.0");
		setLocation(350, 100);
		URL urllogo = DangNhap.class.getResource("logo.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urllogo);
		this.setIconImage(img);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu menuSystem = new JMenu("Hệ thống");
		menuSystem.setIcon(new ImageIcon(Home.class.getResource("/view/icons8-homework-20.png")));
		menuSystem.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		menuBar.add(menuSystem);
		
		JMenuItem menuTrangChu = new JMenuItem("Trang chủ");
		menuTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)(panelMain.getLayout());
				card.show(panelMain,"wellcom");
				}
				});
		menuTrangChu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		menuSystem.add(menuTrangChu);
		
		JMenuItem menuLogOut = new JMenuItem("Đăng xuất");
		menuLogOut.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		menuLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap dn = new DangNhap();
				dn.setVisible(true);
				HomeUser.this.dispose();
				}
				});
		menuSystem.add(menuLogOut);
		
		JSeparator separator = new JSeparator();
		menuSystem.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Thoát");
		menuExit.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				}
				});
		menuSystem.add(menuExit);
		
		JMenu mnNewMenu = new JMenu("Chức năng");
		mnNewMenu.setIcon(new ImageIcon(Home.class.getResource("/view/icons8-dashboard-layout-20.png")));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmDoiMK = new JMenuItem("Đổi mật khẩu");
		mntmDoiMK.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)(panelMain.getLayout());
				card.show(panelMain,"doiMK");
				}
				});
		mntmDoiMK.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		mnNewMenu.add(mntmDoiMK);
		
		JMenu mnTrGip = new JMenu("Trợ giúp");
		mnTrGip.setIcon(new ImageIcon(Home.class.getResource("/view/icons8-inquiry-20.png")));
		mnTrGip.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnTrGip);
		
		JMenuItem mntm_help = new JMenuItem("Chi tiết ");
		mntm_help.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		mntm_help.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)(panelMain.getLayout());
				card.show(panelMain,"panel_chitiet");
				}
				});
		mnTrGip.add(mntm_help);
		
		
		JMenuItem new_nqThuVien = new JMenuItem("Nội quy thư viện");
		new_nqThuVien.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		new_nqThuVien.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)(panelMain.getLayout());
				card.show(panelMain,"noiquy");
				}
				});	
		mnTrGip.add(new_nqThuVien);
		
		JMenu mnNewMenu_1 = new JMenu("Tìm kiếm");
		mnNewMenu_1.setIcon(new ImageIcon(Home.class.getResource("/view/icons8-search-more-20.png")));
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tài liệu");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)(panelMain.getLayout());
				card.show(panelMain,"timkiemtaiLieu");
				}
				});	
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		mnNewMenu_1.add(mntmNewMenuItem_1);
	
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh sách tài liệu");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/view/quanlytailieuu.png")));
		lblNewLabel.setBounds(10, 10, 158, 29);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblQunLMn = new JLabel("Danh sách mượn trả");
		lblQunLMn.setIcon(new ImageIcon(Home.class.getResource("/view/quanlymuontra.png")));
		lblQunLMn.setBounds(10, 70, 168, 29);
		lblQunLMn.setForeground(new Color(0, 0, 255));
		lblQunLMn.setHorizontalAlignment(SwingConstants.LEFT);
		lblQunLMn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblQunLMn);
		
		JLabel lblMnTr = new JLabel("Tra Cứu");
		lblMnTr.setIcon(new ImageIcon(Home.class.getResource("/view/tracuu.png")));
		lblMnTr.setBounds(10, 171, 158, 29);
		lblMnTr.setForeground(new Color(0, 0, 255));
		lblMnTr.setHorizontalAlignment(SwingConstants.LEFT);
		lblMnTr.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblMnTr);
		
	
		
		JButton btn_phieunhap = new JButton("In phiếu mượn trả");
		btn_phieunhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)(panelMain.getLayout());
				card.show(panelMain,"inPM");
				ListMT.thucHienTaiLaiMT(table_inPM);	
			}
		});
		btn_phieunhap.setBounds(10, 280, 158, 21);
		btn_phieunhap.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(btn_phieunhap);
		
		JButton btn_xuatExcell = new JButton("In sách");
		btn_xuatExcell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)(panelMain.getLayout());
				card.show(panelMain,"inTaiLieu");
				ListSach.thucHienTaiLaiDuLieuSach(table_intaiLieu);	
			}
		});
		btn_xuatExcell.setBounds(10, 311, 158, 21);
		btn_xuatExcell.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(btn_xuatExcell);
		
		JButton btn_muonTL = new JButton("Mượn tài liệu");
		btn_muonTL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)(panelMain.getLayout());
				card.show(panelMain,"muontailieu");
				ListMT.thucHienTaiLaiMT(table_muontra);
			}
		});
		btn_muonTL.setBounds(10, 109, 158, 21);
		btn_muonTL.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(btn_muonTL);
		
		JButton btn_TraTL = new JButton("Trả tài liệu");
		btn_TraTL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)(panelMain.getLayout());
				card.show(panelMain,"traTL");
				ListMT.thucHienTaiLaiMT(table_timMT);
			}
		});
		btn_TraTL.setBounds(10, 140, 158, 21);
		btn_TraTL.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(btn_TraTL);
		
		JButton btn_TimTaiLieu = new JButton("Tìm kiếm tài liệu");
		btn_TimTaiLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)(panelMain.getLayout());
				card.show(panelMain,"timkiemtaiLieu");
				ListSach.thucHienTaiLaiDuLieuSach(tabletimSach);
			}
		});
		btn_TimTaiLieu.setBounds(10, 210, 158, 21);
		btn_TimTaiLieu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(btn_TimTaiLieu);
		
		panelMain = new JPanel();
		panelMain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMain.setBounds(188, 20, 753, 499);
		contentPane.add(panelMain);
		panelMain.setLayout(new CardLayout(0, 0));
		
		JPanel panel_wellcom = new JPanel();
		panel_wellcom.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMain.add(panel_wellcom, "wellcom");
		panel_wellcom.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/view/hinhnenHome.jpg")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(0, 0, 749, 495);
		panel_wellcom.add(lblNewLabel_1);
		
		JPanel panel_bienmuctl = new JPanel();
		panel_bienmuctl.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMain.add(panel_bienmuctl, "BMTL");
		panel_bienmuctl.setLayout(null);
		
		
		table_sach = new JTable();
		table_sach.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "T\u00E1c gi\u1EA3", "Th\u1EC3 lo\u1EA1i", "Nh\u00E0 xu\u1EA5t b\u1EA3n", "T\u00ECnh tr\u1EA1ng", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 ti\u1EC1n", "Mã Kho"
			}
		));
		table_sach.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane(table_sach);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(10, 270, 729, 214);
		panel_bienmuctl.add(scrollPane);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("THÔNG TIN TÀI LIỆU");
		lblNewLabel_3_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_1_2.setBounds(10, 10, 169, 26);
		panel_bienmuctl.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("DANH SÁCH TÀI LIỆU");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(10, 234, 169, 26);
		panel_bienmuctl.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1_3 = new JLabel("Mã sách:");
		lblNewLabel_3_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_3.setBounds(10, 48, 62, 26);
		panel_bienmuctl.add(lblNewLabel_3_1_1_3);
		
		JLabel lblNewLabel_3_1_1_3_1 = new JLabel("Tên sách:");
		lblNewLabel_3_1_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_3_1.setBounds(260, 48, 62, 26);
		panel_bienmuctl.add(lblNewLabel_3_1_1_3_1);
		
		JLabel lblNewLabel_3_1_1_3_2 = new JLabel("Tác giả:");
		lblNewLabel_3_1_1_3_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_3_2.setBounds(522, 48, 62, 26);
		panel_bienmuctl.add(lblNewLabel_3_1_1_3_2);
		
		JLabel lblNewLabel_3_1_1_3_3 = new JLabel("Thể loại:");
		lblNewLabel_3_1_1_3_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_3_3.setBounds(10, 97, 62, 26);
		panel_bienmuctl.add(lblNewLabel_3_1_1_3_3);
		
		JLabel lblNewLabel_3_1_1_3_4 = new JLabel("Nhà xuất bản:");
		lblNewLabel_3_1_1_3_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_3_4.setBounds(260, 97, 84, 26);
		panel_bienmuctl.add(lblNewLabel_3_1_1_3_4);
		
		JLabel lblNewLabel_3_1_1_3_5 = new JLabel("Tình trạng:");
		lblNewLabel_3_1_1_3_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_3_5.setBounds(522, 97, 62, 26);
		panel_bienmuctl.add(lblNewLabel_3_1_1_3_5);
		
		JLabel lblNewLabel_3_1_1_3_6 = new JLabel("Số lượng:");
		lblNewLabel_3_1_1_3_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_3_6.setBounds(10, 157, 62, 26);
		panel_bienmuctl.add(lblNewLabel_3_1_1_3_6);
		
		JLabel lblNewLabel_3_1_1_3_7 = new JLabel("Giá tiền:");
		lblNewLabel_3_1_1_3_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_3_7.setBounds(260, 157, 62, 26);
		panel_bienmuctl.add(lblNewLabel_3_1_1_3_7);
		
		JLabel lblNewLabel_3_1_1_3_8 = new JLabel("Mã kho:");
		lblNewLabel_3_1_1_3_8.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_3_8.setBounds(522, 157, 62, 26);
		panel_bienmuctl.add(lblNewLabel_3_1_1_3_8);
		
		text_maSach = new JTextField();
		text_maSach.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		text_maSach.setBounds(66, 51, 133, 19);
		panel_bienmuctl.add(text_maSach);
		text_maSach.setColumns(10);
		
		text_tenSach = new JTextField();
		text_tenSach.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		text_tenSach.setColumns(10);
		text_tenSach.setBounds(332, 51, 150, 19);
		panel_bienmuctl.add(text_tenSach);
		
		text_tacGia = new JTextField();
		text_tacGia.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		text_tacGia.setColumns(10);
		text_tacGia.setBounds(594, 51, 133, 19);
		panel_bienmuctl.add(text_tacGia);
		
		text_theLoai = new JTextField();
		text_theLoai.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		text_theLoai.setColumns(10);
		text_theLoai.setBounds(66, 100, 133, 19);
		panel_bienmuctl.add(text_theLoai);
		
		text_NXB = new JTextField();
		text_NXB.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		text_NXB.setColumns(10);
		text_NXB.setBounds(349, 100, 133, 19);
		panel_bienmuctl.add(text_NXB);
		
		text_TinhTrang = new JTextField();
		text_TinhTrang.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		text_TinhTrang.setColumns(10);
		text_TinhTrang.setBounds(594, 100, 133, 19);
		panel_bienmuctl.add(text_TinhTrang);
		
		text_soLuong = new JTextField();
		text_soLuong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		text_soLuong.setColumns(10);
		text_soLuong.setBounds(66, 160, 133, 19);
		panel_bienmuctl.add(text_soLuong);
		
		text_GiaTien = new JTextField();
		text_GiaTien.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		text_GiaTien.setColumns(10);
		text_GiaTien.setBounds(332, 160, 150, 19);
		panel_bienmuctl.add(text_GiaTien);
		
		text_maKho = new JTextField();
		text_maKho.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		text_maKho.setColumns(10);
		text_maKho.setBounds(594, 160, 133, 19);
		panel_bienmuctl.add(text_maKho);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 201, 729, 2);
		panel_bienmuctl.add(separator_4);
		
		btn_chon = new ButtonGroup();
		
		btn_chon_update = new ButtonGroup();
		
		JPanel panel_timkiemtaiLieu = new JPanel();
		panel_timkiemtaiLieu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMain.add(panel_timkiemtaiLieu, "timkiemtaiLieu");
		panel_timkiemtaiLieu.setLayout(null);
		
		tabletimSach = new JTable();
		tabletimSach.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "T\u00E1c gi\u1EA3", "Th\u1EC3 lo\u1EA1i", "Nh\u00E0 xu\u1EA5t b\u1EA3n", "T\u00ECnh tr\u1EA1ng", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 ti\u1EC1n", "Mã Kho"
			}
		));
		tabletimSach.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JScrollPane scrollPane_3 = new JScrollPane(tabletimSach);
		scrollPane_3.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_3.setBounds(10, 269, 729, 215);
		panel_timkiemtaiLieu.add(scrollPane_3);
		
		JLabel lblNewLabel_4_1 = new JLabel("CẬP NHẬT TÀI LIỆU");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4_1.setBounds(10, 10, 160, 25);
		panel_timkiemtaiLieu.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1_1_2_1 = new JLabel("Mã sách:");
		lblNewLabel_3_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1.setBounds(10, 45, 62, 26);
		panel_timkiemtaiLieu.add(lblNewLabel_3_1_1_2_1);
		
		JLabel lblNewLabel_3_1_1_2_2 = new JLabel("Tên sách:");
		lblNewLabel_3_1_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_2.setBounds(261, 45, 62, 26);
		panel_timkiemtaiLieu.add(lblNewLabel_3_1_1_2_2);
		
		JLabel lblNewLabel_3_1_1_2_2_1 = new JLabel("Tác giả:");
		lblNewLabel_3_1_1_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_2_1.setBounds(537, 45, 62, 26);
		panel_timkiemtaiLieu.add(lblNewLabel_3_1_1_2_2_1);
		
		JLabel lblNewLabel_3_1_1_2_2_2 = new JLabel("Thể loại:");
		lblNewLabel_3_1_1_2_2_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_2_2.setBounds(10, 109, 62, 26);
		panel_timkiemtaiLieu.add(lblNewLabel_3_1_1_2_2_2);
		
		JLabel lblNewLabel_3_1_1_2_2_3 = new JLabel("Nhà xuất bản:");
		lblNewLabel_3_1_1_2_2_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_2_3.setBounds(251, 109, 90, 26);
		panel_timkiemtaiLieu.add(lblNewLabel_3_1_1_2_2_3);
		
		JLabel lblNewLabel_3_1_1_2_2_4 = new JLabel("Tình trạng:");
		lblNewLabel_3_1_1_2_2_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_2_4.setBounds(537, 109, 62, 26);
		panel_timkiemtaiLieu.add(lblNewLabel_3_1_1_2_2_4);
		
		JLabel lblNewLabel_3_1_1_2_2_5 = new JLabel("Số lượng:");
		lblNewLabel_3_1_1_2_2_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_2_5.setBounds(10, 170, 62, 26);
		panel_timkiemtaiLieu.add(lblNewLabel_3_1_1_2_2_5);
		
		JLabel lblNewLabel_3_1_1_2_2_6 = new JLabel("Giá sách:");
		lblNewLabel_3_1_1_2_2_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_2_6.setBounds(261, 170, 62, 26);
		panel_timkiemtaiLieu.add(lblNewLabel_3_1_1_2_2_6);
		
		JLabel lblNewLabel_3_1_1_2_2_7 = new JLabel("Mã kho:");
		lblNewLabel_3_1_1_2_2_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_2_7.setBounds(537, 170, 62, 26);
		panel_timkiemtaiLieu.add(lblNewLabel_3_1_1_2_2_7);
		
		textField_maSachtim = new JTextField();
		textField_maSachtim.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_maSachtim.setColumns(10);
		textField_maSachtim.setBounds(70, 49, 130, 19);
		panel_timkiemtaiLieu.add(textField_maSachtim);
		
		textField_tenSachtim = new JTextField();
		textField_tenSachtim.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_tenSachtim.setColumns(10);
		textField_tenSachtim.setBounds(326, 48, 172, 19);
		panel_timkiemtaiLieu.add(textField_tenSachtim);
		
		textField_tacgiatim = new JTextField();
		textField_tacgiatim.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_tacgiatim.setColumns(10);
		textField_tacgiatim.setBounds(609, 48, 130, 19);
		panel_timkiemtaiLieu.add(textField_tacgiatim);
		
		textField_theloaitim = new JTextField();
		textField_theloaitim.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_theloaitim.setColumns(10);
		textField_theloaitim.setBounds(70, 112, 130, 19);
		panel_timkiemtaiLieu.add(textField_theloaitim);
		
		textField_nxbtim = new JTextField();
		textField_nxbtim.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_nxbtim.setColumns(10);
		textField_nxbtim.setBounds(337, 112, 161, 19);
		panel_timkiemtaiLieu.add(textField_nxbtim);
		
		textField_tinhtrangtim = new JTextField();
		textField_tinhtrangtim.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_tinhtrangtim.setColumns(10);
		textField_tinhtrangtim.setBounds(609, 112, 130, 19);
		panel_timkiemtaiLieu.add(textField_tinhtrangtim);
		
		textField_sltim = new JTextField();
		textField_sltim.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_sltim.setColumns(10);
		textField_sltim.setBounds(70, 173, 130, 19);
		panel_timkiemtaiLieu.add(textField_sltim);
		
		textField_giasachtim = new JTextField();
		textField_giasachtim.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_giasachtim.setColumns(10);
		textField_giasachtim.setBounds(326, 173, 172, 19);
		panel_timkiemtaiLieu.add(textField_giasachtim);
		
		textField_makhotim = new JTextField();
		textField_makhotim.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_makhotim.setColumns(10);
		textField_makhotim.setBounds(609, 173, 130, 19);
		panel_timkiemtaiLieu.add(textField_makhotim);
		
		JButton btn_timSach = new JButton("Tìm kiếm");
		btn_timSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model11 = (DefaultTableModel) tabletimSach.getModel();
				 int sl_dong = tabletimSach.getRowCount();
				try {
					if(!textField_maSachtim.getText().trim().equals(""))
					{
						
						Set<String> list_xoasach = new TreeSet<String>();
						String ndTim = textField_maSachtim.getText();
						
						for(int i = 0; i < sl_dong ; i++)
							{
								String maSach = tabletimSach.getValueAt(i,0).toString();
								if(!maSach.equals(ndTim))
								{
									list_xoasach.add(maSach);
								}
							}
						for (String maSachXoa : list_xoasach) {
							int solg1_dong = tabletimSach.getRowCount(); 
							for(int i = 0; i < solg1_dong; i++)
							{
								String maSachXoa1 = tabletimSach.getValueAt(i,0)+"";
								if(maSachXoa.equals(maSachXoa1))
								{
									try {
										model11.removeRow(i);
									} catch (Exception e2) {
										System.out.println(e2.toString());
									}
									break;
								}
								
							}
						}
						textField_maSachtim.setText("");
					}
					if(!textField_tenSachtim.getText().trim().equals(""))
					{
						
						Set<String> list_xoasach1 = new TreeSet<String>();
						String ndTim = textField_tenSachtim.getText();
						
						for(int i = 0; i < sl_dong ; i++)
							{
								String tenSach = tabletimSach.getValueAt(i,1).toString();
								if(!tenSach.equals(ndTim))
								{
									list_xoasach1.add(tenSach);
								}
							}
						for (String tenSachXoa : list_xoasach1) {
							int solg1_dong = tabletimSach.getRowCount(); 
							for(int i = 0; i < solg1_dong; i++)
							{
								String tenSachXoa1 = tabletimSach.getValueAt(i,1)+"";
								if(tenSachXoa.equals(tenSachXoa1))
								{
									try {
										model11.removeRow(i);
									} catch (Exception e2) {
										System.out.println(e2.toString());
									}
									break;
								}
								
							}
						}
						textField_tenSachtim.setText("");
					}
					if(!textField_tacgiatim.getText().trim().equals(""))
					{
						Set<String> list_xoasach2 = new TreeSet<String>();
						String ndTim = textField_tacgiatim.getText();
						
						for(int i = 0; i < sl_dong ; i++)
							{
								String tenSach = tabletimSach.getValueAt(i,2).toString();
								if(!tenSach.equals(ndTim))
								{
									list_xoasach2.add(tenSach);
								}
							}
						for (String tenSachXoa : list_xoasach2) {
							int solg1_dong = tabletimSach.getRowCount(); 
							for(int i = 0; i < solg1_dong; i++)
							{
								String tenSachXoa1 = tabletimSach.getValueAt(i,2)+"";
								if(tenSachXoa.equals(tenSachXoa1))
								{
									try {
										model11.removeRow(i);
									} catch (Exception e2) {
										System.out.println(e2.toString());
									}
									break;
								}
								
							}
						}
						textField_tacgiatim.setText("");
					}
					if(!textField_theloaitim.getText().trim().equals(""))
					{					
						Set<String> list_xoasach3 = new TreeSet<String>();
						String ndTim = textField_theloaitim.getText();
						
						for(int i = 0; i < sl_dong ; i++)
							{
								String tenSach = tabletimSach.getValueAt(i,3).toString();
								if(!tenSach.equals(ndTim))
								{
									list_xoasach3.add(tenSach);
								}
							}
						for (String tenSachXoa : list_xoasach3) {
							int solg1_dong = tabletimSach.getRowCount(); 
							for(int i = 0; i < solg1_dong; i++)
							{
								String tenSachXoa1 = tabletimSach.getValueAt(i,3).toString();
								if(tenSachXoa.equals(tenSachXoa1))
								{
									try {
										model11.removeRow(i);
									} catch (Exception e2) {
										System.out.println(e2.toString());
									}
									break;
								}
								
							}
						}
						textField_theloaitim.setText("");
					}
					if(!textField_nxbtim.getText().trim().equals(""))
					{					
						Set<String> list_xoasach3 = new TreeSet<String>();
						String ndTim = textField_nxbtim.getText();
						
						for(int i = 0; i < sl_dong ; i++)
							{
								String tenSach = tabletimSach.getValueAt(i,4).toString();
								if(!tenSach.equals(ndTim))
								{
									list_xoasach3.add(tenSach);
								}
							}
						for (String tenSachXoa : list_xoasach3) {
							int solg1_dong = tabletimSach.getRowCount(); 
							for(int i = 0; i < solg1_dong; i++)
							{
								String tenSachXoa1 = tabletimSach.getValueAt(i,4).toString();
								if(tenSachXoa.equals(tenSachXoa1))
								{
									try {
										model11.removeRow(i);
									} catch (Exception e2) {
										System.out.println(e2.toString());
									}
									break;
								}
								
							}
						}
						textField_nxbtim.setText("");
					}
					if(!textField_tinhtrangtim.getText().trim().equals(""))
					{					
						Set<String> list_xoasach3 = new TreeSet<String>();
						String ndTim = textField_tinhtrangtim.getText();
						
						for(int i = 0; i < sl_dong ; i++)
							{
								String tenSach = tabletimSach.getValueAt(i,5).toString();
								if(!tenSach.equals(ndTim))
								{
									list_xoasach3.add(tenSach);
								}
							}
						for (String tenSachXoa : list_xoasach3) {
							int solg1_dong = tabletimSach.getRowCount(); 
							for(int i = 0; i < solg1_dong; i++)
							{
								String tenSachXoa1 = tabletimSach.getValueAt(i,5).toString();
								if(tenSachXoa.equals(tenSachXoa1))
								{
									try {
										model11.removeRow(i);
									} catch (Exception e2) {
										System.out.println(e2.toString());
									}
									break;
								}
								
							}
						}
						textField_tinhtrangtim.setText("");
					}
					if(!textField_sltim.getText().trim().equals(""))
					{					
						Set<String> list_xoasach3 = new TreeSet<String>();
						String ndTim = textField_sltim.getText();
						
						for(int i = 0; i < sl_dong ; i++)
							{
								String tenSach = tabletimSach.getValueAt(i,6).toString();
								if(!tenSach.equals(ndTim))
								{
									list_xoasach3.add(tenSach);
								}
							}
						for (String tenSachXoa : list_xoasach3) {
							int solg1_dong = tabletimSach.getRowCount(); 
							for(int i = 0; i < solg1_dong; i++)
							{
								String tenSachXoa1 = tabletimSach.getValueAt(i,6).toString();
								if(tenSachXoa.equals(tenSachXoa1))
								{
									try {
										model11.removeRow(i);
									} catch (Exception e2) {
										System.out.println(e2.toString());
									}
									break;
								}
								
							}
						}
						textField_sltim.setText("");
					}
					if(!textField_giasachtim.getText().trim().equals(""))
					{					
						Set<String> list_xoasach3 = new TreeSet<String>();
						String ndTim = textField_giasachtim.getText();
						
						for(int i = 0; i < sl_dong ; i++)
							{
								String tenSach = tabletimSach.getValueAt(i,7).toString();
								if(!tenSach.equals(ndTim))
								{
									list_xoasach3.add(tenSach);
								}
							}
						for (String tenSachXoa : list_xoasach3) {
							int solg1_dong = tabletimSach.getRowCount(); 
							for(int i = 0; i < solg1_dong; i++)
							{
								String tenSachXoa1 = tabletimSach.getValueAt(i,7).toString();
								if(tenSachXoa.equals(tenSachXoa1))
								{
									try {
										model11.removeRow(i);
									} catch (Exception e2) {
										System.out.println(e2.toString());
									}
									break;
								}
								
							}
						}
						textField_giasachtim.setText("");
					}
					if(!textField_makhotim.getText().trim().equals(""))
					{					
						Set<String> list_xoasach3 = new TreeSet<String>();
						String ndTim = textField_makhotim.getText();
						
						for(int i = 0; i < sl_dong ; i++)
							{
								String tenSach = tabletimSach.getValueAt(i,8).toString();
								if(!tenSach.equals(ndTim))
								{
									list_xoasach3.add(tenSach);
								}
							}
						for (String tenSachXoa : list_xoasach3) {
							int solg1_dong = tabletimSach.getRowCount(); 
							for(int i = 0; i < solg1_dong; i++)
							{
								String tenSachXoa1 = tabletimSach.getValueAt(i,8).toString();
								if(tenSachXoa.equals(tenSachXoa1))
								{
									try {
										model11.removeRow(i);
									} catch (Exception e2) {
										System.out.println(e2.toString());
									}
									break;
								}
								
							}
						}
						textField_makhotim.setText("");
					}
				} catch (Exception e2) {
					textField_maSachtim.setText("");
					textField_giasachtim.setText("");
					textField_sltim.setText("");
					textField_nxbtim.setText("");
					textField_theloaitim.setText("");
					textField_tenSachtim.setText("");
					textField_tacgiatim.setText("");
					textField_makhotim.setText("");
					textField_tinhtrangtim.setText("");
					JOptionPane.showMessageDialog(btn_timSach, "Không tìm thấy vui lòng nhập lại");
				}
				
			}
		});
		btn_timSach.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btn_timSach.setBounds(10, 218, 100, 41);
		panel_timkiemtaiLieu.add(btn_timSach);
		
		JSeparator separator_3_1_2_1 = new JSeparator();
		separator_3_1_2_1.setBounds(10, 206, 729, 2);
		panel_timkiemtaiLieu.add(separator_3_1_2_1);
		
		JButton btn_huytimSach = new JButton("Hủy tìm");
		btn_huytimSach.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btn_huytimSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_maSach.setText("");
				text_tenSach.setText("");
				text_tacGia.setText("");
				text_theLoai.setText("");
				text_NXB.setText("");
				text_TinhTrang.setText("");
				text_soLuong.setText("");
				text_GiaTien.setText("");
				text_maKho.setText("");
				ListSach.thucHienTaiLaiDuLieuSach(tabletimSach);
			}
			
		});
		btn_huytimSach.setBounds(126, 218, 90, 41);
		panel_timkiemtaiLieu.add(btn_huytimSach);
		
		JPanel panel_muonTL = new JPanel();
		panel_muonTL.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMain.add(panel_muonTL, "muontailieu");
		panel_muonTL.setLayout(null);
		
		table_muontra = new JTable();
		table_muontra.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		table_muontra.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Phi\u1EBFu", "Ng\u01B0\u1EDDi m\u01B0\u1EE3n", "Ng\u01B0\u1EDDi cho m\u01B0\u1EE3n", "T\u00E0i li\u1EC7u m\u01B0\u1EE3n", "S\u1ED1 l\u01B0\u1EE3ng", "Ng\u00E0y m\u01B0\u1EE3n", "Ng\u00E0y tr\u1EA3", "H\u1EA1n tr\u1EA3", "Tình trạng"
			}
		));
		
		
		JScrollPane scrollPane_4 = new JScrollPane(table_muontra);
		scrollPane_4.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_4.setBounds(10, 265, 729, 219);
		panel_muonTL.add(scrollPane_4);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("PHIẾU MƯỢN ");
		lblNewLabel_4_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4_1_1.setBounds(10, 10, 160, 25);
		panel_muonTL.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_3_1_1_2_1_1 = new JLabel("Mã phiếu:");
		lblNewLabel_3_1_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1.setBounds(10, 48, 62, 26);
		panel_muonTL.add(lblNewLabel_3_1_1_2_1_1);
		
		JLabel lblNewLabel_3_1_1_2_1_1_1 = new JLabel("Người mượn:");
		lblNewLabel_3_1_1_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_1.setBounds(272, 48, 78, 26);
		panel_muonTL.add(lblNewLabel_3_1_1_2_1_1_1);
		
		JLabel lblNewLabel_3_1_1_2_1_1_2 = new JLabel("Người cho mượn:");
		lblNewLabel_3_1_1_2_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_2.setBounds(497, 48, 102, 26);
		panel_muonTL.add(lblNewLabel_3_1_1_2_1_1_2);
		
		JLabel lblNewLabel_3_1_1_2_1_1_2_1 = new JLabel("Tài liệu mượn:");
		lblNewLabel_3_1_1_2_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_2_1.setBounds(10, 97, 84, 26);
		panel_muonTL.add(lblNewLabel_3_1_1_2_1_1_2_1);
		
		JLabel lblNewLabel_3_1_1_2_1_1_2_2 = new JLabel("Số lượng:");
		lblNewLabel_3_1_1_2_1_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_2_2.setBounds(272, 97, 62, 26);
		panel_muonTL.add(lblNewLabel_3_1_1_2_1_1_2_2);
		
		JLabel lblNewLabel_3_1_1_2_1_1_2_3 = new JLabel("Hạn trả:");
		lblNewLabel_3_1_1_2_1_1_2_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_2_3.setBounds(536, 97, 56, 26);
		panel_muonTL.add(lblNewLabel_3_1_1_2_1_1_2_3);
		
		JLabel lblNewLabel_3_1_1_2_1_1_2_4 = new JLabel("Ngày mượn:");
		lblNewLabel_3_1_1_2_1_1_2_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_2_4.setBounds(10, 150, 78, 26);
		panel_muonTL.add(lblNewLabel_3_1_1_2_1_1_2_4);
		
		JLabel lblNewLabel_3_1_1_2_1_1_2_4_1 = new JLabel("Ngày trả:");
		lblNewLabel_3_1_1_2_1_1_2_4_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_2_4_1.setBounds(272, 150, 62, 26);
		panel_muonTL.add(lblNewLabel_3_1_1_2_1_1_2_4_1);
		
		textF_idmuon = new JTextField();
		textF_idmuon.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textF_idmuon.setColumns(10);
		textF_idmuon.setBounds(70, 51, 167, 19);
		panel_muonTL.add(textF_idmuon);
		
		textF_nguoimuon = new JTextField();
		textF_nguoimuon.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textF_nguoimuon.setColumns(10);
		textF_nguoimuon.setBounds(352, 51, 128, 19);
		panel_muonTL.add(textF_nguoimuon);
		
		textF_nguoiChomuon = new JTextField();
		textF_nguoiChomuon.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textF_nguoiChomuon.setColumns(10);
		textF_nguoiChomuon.setBounds(609, 51, 130, 19);
		panel_muonTL.add(textF_nguoiChomuon);
		
		textF_SachMuon = new JTextField();
		textF_SachMuon.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textF_SachMuon.setColumns(10);
		textF_SachMuon.setBounds(95, 100, 154, 19);
		panel_muonTL.add(textF_SachMuon);
		
		textF_soLuong = new JTextField();
		textF_soLuong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textF_soLuong.setColumns(10);
		textF_soLuong.setBounds(333, 100, 154, 19);
		panel_muonTL.add(textF_soLuong);
		
		textF_hanTra = new JTextField();
		textF_hanTra.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textF_hanTra.setColumns(10);
		textF_hanTra.setBounds(609, 100, 130, 19);
		panel_muonTL.add(textF_hanTra);
		
		textF_ngayMuon = new JTextField();
		textF_ngayMuon.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textF_ngayMuon.setColumns(10);
		textF_ngayMuon.setBounds(83, 153, 154, 19);
		panel_muonTL.add(textF_ngayMuon);
		
		textF_NgayTra = new JTextField();
		textF_NgayTra.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textF_NgayTra.setColumns(10);
		textF_NgayTra.setBounds(333, 153, 154, 19);
		panel_muonTL.add(textF_NgayTra);
		
		JButton btn_taomoi = new JButton("Tạo mới ");
		btn_taomoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textF_idmuon.setText("");
				textF_nguoimuon.setText("");
				textF_nguoiChomuon.setText("");
				textF_SachMuon.setText("");
				textF_soLuong.setText("");
				textF_hanTra.setText("");
				textF_ngayMuon.setText("");
				textF_NgayTra.setText("");
			}
		});
		btn_taomoi.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btn_taomoi.setBounds(598, 216, 141, 39);
		panel_muonTL.add(btn_taomoi);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 204, 729, 2);
		panel_muonTL.add(separator_5);
		
		JButton btn_themMT = new JButton("Thêm");
		btn_themMT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textF_hanTra.getText().equals("")||
					textF_idmuon.getText().equals("")
					||textF_ngayMuon.getText().equals("")
					||textF_NgayTra.getText().equals("")
					||textF_nguoiChomuon.getText().equals("")
					||textF_nguoimuon.getText().equals("")
					||textF_SachMuon.getText().equals("")
					||textF_soLuong.getText().equals("")
					)
				
				{
					JOptionPane.showMessageDialog(btn_themMT, "Vui lòng nhập đủ thông tin phiếu");
					return;
				}else
				{
				MuonTra mtra_add = new MuonTra();
				String maPhieu = textF_idmuon.getText().trim();
				mtra_add.setIdMuonTra(maPhieu);
				
				String UserMuon = textF_nguoimuon.getText().trim();
				try {
					for (User usermuon : ListUser.getAllUser()) {
						if (usermuon.getUserName().equals(UserMuon)) {
							mtra_add.setId_user_muon(usermuon);
						}
					}
					
					String userChoMuon = textF_nguoiChomuon.getText().trim();
					for (User userchomuon : ListUser.getAllUser()) {
						if (userchomuon.getUserName().equals(userChoMuon)) {
							mtra_add.setId_user_chomuon(userchomuon);
						}
					}
					
					String sachMuon = textF_SachMuon.getText().trim();
					for (Sach sachmuon : ListSach.getAllSach()) {
						if (sachmuon.getMaSach().equals(sachMuon)) {
							mtra_add.setId_sach(sachmuon);
						}
					} 
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btn_themMT,"Không tìm thấy người dùng hoặc sách trong thư viện");
					return;
				}
				
				int sl_muon = Integer.valueOf(textF_soLuong.getText().trim()) ; 
				mtra_add.setSl_muon(sl_muon);
				
				SimpleDateFormat dp1 = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat dp2 = new SimpleDateFormat("dd/MM/yyyy");
				String ngaymuon = textF_ngayMuon.getText().trim();
				Date date1 = null;
				try {
					date1 = dp1.parse(ngaymuon);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btn_themMT, "Vui lòng nhập đúng ngày mượn (dd/MM/yyyy)");
					return;
				}
				
				String ngaytra = textF_NgayTra.getText().trim();
				Date date2 = null;
				try {
					date2 = dp2.parse(ngaytra);
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btn_themMT, "Vui lòng nhập đúng ngày trả (dd/MM/yyyy)");
					return;
				}

				mtra_add.setNgayMuon(date1);
				mtra_add.setNgayTra(date2);
				
				int hantra = Integer.valueOf(textF_hanTra.getText().trim());
				mtra_add.setHanTra(hantra);
				mtra_add.setTtrangsachmuon("Chưa trả");
				boolean kq = ListMT.addMuonTra(mtra_add);
				if(kq)
				{
					ListMT.printf_tableMT(table_muontra, mtra_add);
					JOptionPane.showMessageDialog(btn_themMT, "Đã thêm thành công");
				}else
				{
					JOptionPane.showMessageDialog(btn_themMT, "Mã phiếu đã tồn tại");
				}
			}
					
				
			}
		});
		btn_themMT.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btn_themMT.setBounds(10, 216, 102, 39);
		panel_muonTL.add(btn_themMT);
		
		JButton btn_xoaMT = new JButton("Xóa");
		btn_xoaMT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model1 = (DefaultTableModel) table_muontra.getModel();
				int i_row = -1;
				i_row = table_muontra.getSelectedRow();
				int luachon = JOptionPane.showConfirmDialog(btn_xoaMT, "Bạn có chắc chắn muốn xóa!");
				if(luachon == JOptionPane.YES_OPTION)
				{					
					if(i_row != -1)
					{	
					String id_xoaMT = model1.getValueAt(i_row,0)+"";
					for (MuonTra MT_delete : ListMT.getAllMuonTra()) {
						if(MT_delete.getIdMuonTra().equals(id_xoaMT))
						{
							ListMT.deleteMT(MT_delete);
						}	
					}
					model1.removeRow(i_row);
					}else {
						JOptionPane.showMessageDialog(btn_xoaMT, "Vui lòng chọn tài khoản để xóa");
						return;
					}
				}
			}
		});
		btn_xoaMT.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btn_xoaMT.setBounds(122, 216, 102, 39);
		panel_muonTL.add(btn_xoaMT);
		
		JPanel panel_traTL = new JPanel();
		panelMain.add(panel_traTL, "traTL");
		panel_traTL.setLayout(null);
		
		table_timMT = new JTable();
		table_timMT.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"M\u00E3 Phi\u1EBFu", "Ng\u01B0\u1EDDi m\u01B0\u1EE3n","Người cho mượn", "T\u00E0i li\u1EC7u m\u01B0\u1EE3n", "S\u1ED1 l\u01B0\u1EE3ng", "Ng\u00E0y m\u01B0\u1EE3n", "Ng\u00E0y tr\u1EA3", "H\u1EA1n tr\u1EA3", "Tình trạng"
			}
		));
		table_timMT.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		
		JScrollPane scrollPane_5 = new JScrollPane(table_timMT);
		scrollPane_5.setBounds(10, 244, 729, 240);
		panel_traTL.add(scrollPane_5);
		
		JLabel lblNewLabel_3_1_1_2_1_1_3 = new JLabel("Mã phiếu:");
		lblNewLabel_3_1_1_2_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_3.setBounds(50, 42, 62, 26);
		panel_traTL.add(lblNewLabel_3_1_1_2_1_1_3);
		
		textF_idtra = new JTextField();
		textF_idtra.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textF_idtra.setColumns(10);
		textF_idtra.setBounds(119, 45, 167, 19);
		panel_traTL.add(textF_idtra);
		
		JSeparator separator_5_1 = new JSeparator();
		separator_5_1.setBounds(10, 139, 729, 2);
		panel_traTL.add(separator_5_1);
		
		JButton btn_timMT = new JButton("Tìm kiếm");
		btn_timMT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model20 = (DefaultTableModel) table_timMT.getModel();
				int sl_dong = table_timMT.getRowCount();
			
				if(!textF_timmaPhieu.getText().equals(""))
				{
					Set<String> list_xoaMT = new TreeSet<String>();
					String ndTim = textF_timmaPhieu.getText();
					
					for(int i = 0; i < sl_dong ; i++)
						{
							String maMT = table_timMT.getValueAt(i,0).toString();
							if(!maMT.equals(ndTim))
							{
								list_xoaMT.add(maMT);
							}
						}
					for (String maMTXoa : list_xoaMT) {
						int solg1_dong = tabletimSach.getRowCount(); 
						for(int i = 0; i < solg1_dong; i++)
						{
							String maMTXoa1 = table_timMT.getValueAt(i,0)+"";
							if(maMTXoa.equals(maMTXoa1))
							{
								try {
									model20.removeRow(i);
								} catch (Exception e2) {
									System.out.println(e2.toString());
								}
								break;
							}
							
						}
					}
					textF_timmaPhieu.setText("");
				}
				else if(!textF_timTinhTrang.getText().equals(""))
				{
					
					Set<String> list_xoaMT = new TreeSet<String>();
					String ndTim = textF_timTinhTrang.getText();
					
					for(int i = 0; i < sl_dong ; i++)
						{
							String tinhTrang = table_timMT.getValueAt(i,8).toString();
							if(!tinhTrang.equals(ndTim))
							{
								list_xoaMT.add(tinhTrang);
							}
						}
					for (String maMTXoa : list_xoaMT) {
						int solg1_dong = table_timMT.getRowCount(); 
						for(int i = 0; i < solg1_dong; i++)
						{
							String tinhTrang1 = table_timMT.getValueAt(i,8)+"";
							if(maMTXoa.equals(tinhTrang1))
							{
								try {
									model20.removeRow(i);
								} catch (Exception e2) {
									System.out.println(e2.toString());
								}
								break;
							}
							
						}
					}
					textF_timTinhTrang.setText("");
				}else
				{
					JOptionPane.showMessageDialog(btn_timMT, "Điền thông tin cần tìm");
				}
			
		}
		});
		btn_timMT.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btn_timMT.setBounds(10, 157, 102, 39);
		panel_traTL.add(btn_timMT);
		
		JButton btn_timMT_1 = new JButton("Hủy");
		btn_timMT_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textF_idtra.setText("");
				textF_timNgayTra.setText("");
				textF_timmaPhieu.setText("");
				textF_timTinhTrang.setText("");
				ListMT.thucHienTaiLaiMT(table_timMT);
			}
		});
		btn_timMT_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btn_timMT_1.setBounds(125, 157, 102, 39);
		panel_traTL.add(btn_timMT_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("PHIẾU TRẢ ");
		lblNewLabel_4_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4_1_1_1.setBounds(10, 10, 160, 25);
		panel_traTL.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_3_1_1_2_1_1_3_1 = new JLabel("Ngày trả:");
		lblNewLabel_3_1_1_2_1_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_3_1.setBounds(458, 42, 62, 26);
		panel_traTL.add(lblNewLabel_3_1_1_2_1_1_3_1);
		
		textF_timNgayTra = new JTextField();
		textF_timNgayTra.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textF_timNgayTra.setColumns(10);
		textF_timNgayTra.setBounds(521, 45, 167, 19);
		panel_traTL.add(textF_timNgayTra);
		
		JLabel lblNewLabel_3_1_1_2_1_1_3_2 = new JLabel("Mã phiếu tìm:");
		lblNewLabel_3_1_1_2_1_1_3_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_3_2.setBounds(262, 163, 81, 26);
		panel_traTL.add(lblNewLabel_3_1_1_2_1_1_3_2);
		
		textF_timmaPhieu = new JTextField();
		textF_timmaPhieu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textF_timmaPhieu.setColumns(10);
		textF_timmaPhieu.setBounds(353, 166, 130, 19);
		panel_traTL.add(textF_timmaPhieu);
		
		JSeparator separator_5_1_1 = new JSeparator();
		separator_5_1_1.setBounds(10, 219, 729, 2);
		panel_traTL.add(separator_5_1_1);
		
		JLabel lblNewLabel_3_1_1_2_1_1_3_1_1 = new JLabel("Tình trạng:");
		lblNewLabel_3_1_1_2_1_1_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_3_1_1.setBounds(525, 163, 62, 26);
		panel_traTL.add(lblNewLabel_3_1_1_2_1_1_3_1_1);
		
		textF_timTinhTrang = new JTextField();
		textF_timTinhTrang.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textF_timTinhTrang.setColumns(10);
		textF_timTinhTrang.setBounds(597, 167, 130, 19);
		panel_traTL.add(textF_timTinhTrang);
		
		JPanel panel_ChiTiet = new JPanel();
		panel_ChiTiet.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMain.add(panel_ChiTiet, "panel_chitiet");
		panel_ChiTiet.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("CHI TIẾT VỀ PHÂN MỀM QUẢN LÝ THƯ VIỆN");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(154, 51, 438, 50);
		panel_ChiTiet.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Trường đại học Khoa Học Tự Nhiên");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(502, 443, 237, 41);
		panel_ChiTiet.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("BÁO CÁO ĐỒ ÁN CUỐI KÌ MÔN HỌC JAVA");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(172, 10, 409, 50);
		panel_ChiTiet.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Sinh viên thực hiện: ");
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(10, 122, 142, 30);
		panel_ChiTiet.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("19200513 - Đỗ Ngọc Thuận");
		lblNewLabel_2_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_1.setBounds(154, 149, 174, 30);
		panel_ChiTiet.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("19200562 - Kiều Hữu Tuyên ");
		lblNewLabel_2_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_1_1.setBounds(154, 189, 174, 30);
		panel_ChiTiet.add(lblNewLabel_2_3_1_1);
		
		JLabel lblNewLabel_2_3_1_1_1 = new JLabel("19200515 - Trần Nguyễn Hòa Thuận");
		lblNewLabel_2_3_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_1_1_1.setBounds(154, 229, 223, 30);
		panel_ChiTiet.add(lblNewLabel_2_3_1_1_1);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Nội dung: ");
		lblNewLabel_2_3_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_3_2.setBounds(10, 269, 72, 30);
		panel_ChiTiet.add(lblNewLabel_2_3_2);
		
		JLabel lblNewLabel_2_3_2_1 = new JLabel("Hệ thống quản lý Thư viện là một hệ thống liên thông, liên kết, cùng phối hợp cung cấp các nguồn tài nguyên thông tin và ");
		lblNewLabel_2_3_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_2_1.setBounds(10, 309, 729, 30);
		panel_ChiTiet.add(lblNewLabel_2_3_2_1);
		
		JLabel lblNewLabel_2_3_2_1_1 = new JLabel("các dịch vụ thông tin cho tất cả độc giả là sinh viên, giảng viên, nhà nghiên cứu, và cán bộ viên chức của ĐH KHTN.");
		lblNewLabel_2_3_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_2_1_1.setBounds(10, 340, 729, 30);
		panel_ChiTiet.add(lblNewLabel_2_3_2_1_1);
		
		JLabel lblNewLabel_2_3_2_1_1_1 = new JLabel("Hãy tích cực, chủ động khai thác các nguồn tài nguyên và dịch vụ của Hệ thống thư viện ĐH KHTN và đóng góp ý kiến\r\n\r\n\r\n\r\n");
		lblNewLabel_2_3_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_2_1_1_1.setBounds(10, 374, 729, 30);
		panel_ChiTiet.add(lblNewLabel_2_3_2_1_1_1);
		
		JLabel lblNewLabel_2_3_2_1_1_1_1 = new JLabel("để thư viện phục vụ bạn đọc ngày càng tốt hơn.\r\n");
		lblNewLabel_2_3_2_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_2_1_1_1_1.setBounds(10, 403, 729, 30);
		panel_ChiTiet.add(lblNewLabel_2_3_2_1_1_1_1);
		
		JLabel lblNewLabel_2_3_2_2 = new JLabel("Trân trọng");
		lblNewLabel_2_3_2_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_3_2_2.setBounds(48, 434, 88, 30);
		panel_ChiTiet.add(lblNewLabel_2_3_2_2);
		
		JPanel panel_NoiQui = new JPanel();
		panel_NoiQui.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMain.add(panel_NoiQui, "noiquy");
		panel_NoiQui.setLayout(null);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("NỘI QUY THƯ VIỆN ");
		lblNewLabel_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_2_1.setBounds(10, 10, 201, 50);
		panel_NoiQui.add(lblNewLabel_2_2_1);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 58, 729, 2);
		panel_NoiQui.add(separator_6);
		
		JLabel lblNewLabel_2_3_2_1_2 = new JLabel("1. Mang theo thẻ thư viện / thẻ sinh viên để làm các thủ tục cần thiết hoặc sử dụng dịch vụ tại Thư viện Trung tâm; Không ");
		lblNewLabel_2_3_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_2_1_2.setBounds(10, 81, 729, 30);
		panel_NoiQui.add(lblNewLabel_2_3_2_1_2);
		
		JLabel lblNewLabel_2_3_2_1_2_1 = new JLabel("dùng thẻ thư viện của người khác và không cho người khác mượn thẻ.");
		lblNewLabel_2_3_2_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_2_1_2_1.setBounds(20, 109, 682, 30);
		panel_NoiQui.add(lblNewLabel_2_3_2_1_2_1);
		
		JLabel lblNewLabel_2_3_2_1_2_2 = new JLabel("2. Không mang túi xách hoặc vật cồng kềnh vào Thư viện; Tự bảo quản tài sản cá nhân. Thư viện sẽ xử phạt các trường\r\n");
		lblNewLabel_2_3_2_1_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_2_1_2_2.setBounds(10, 149, 729, 30);
		panel_NoiQui.add(lblNewLabel_2_3_2_1_2_2);
		
		JLabel lblNewLabel_2_3_2_1_2_1_1 = new JLabel("hợp thất lạc hay mất mát tài sản của độc giả.");
		lblNewLabel_2_3_2_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_2_1_2_1_1.setBounds(20, 177, 682, 30);
		panel_NoiQui.add(lblNewLabel_2_3_2_1_2_1_1);
		
		JLabel lblNewLabel_2_3_2_1_2_2_1 = new JLabel("3. Tuân thủ luật bản quyền khi sử dụng tài liệu tại Thư viện.");
		lblNewLabel_2_3_2_1_2_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_2_1_2_2_1.setBounds(10, 217, 729, 30);
		panel_NoiQui.add(lblNewLabel_2_3_2_1_2_2_1);
		
		JLabel lblNewLabel_2_3_2_1_2_2_1_1 = new JLabel("4. Thực hiện và nhắc nhở người khác giữ gìn tài liệu, trang thiết bị và các tài sản chung của Thư viện.\r\n");
		lblNewLabel_2_3_2_1_2_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_2_1_2_2_1_1.setBounds(10, 257, 729, 30);
		panel_NoiQui.add(lblNewLabel_2_3_2_1_2_2_1_1);
		
		JLabel lblNewLabel_2_3_2_1_2_2_1_1_1 = new JLabel("5. Giữ trật tự, yên tĩnh; tắt điện thoại di động tại những khu vực có dấu hiệu quy ước.\r\n\r\n");
		lblNewLabel_2_3_2_1_2_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_2_1_2_2_1_1_1.setBounds(10, 297, 729, 30);
		panel_NoiQui.add(lblNewLabel_2_3_2_1_2_2_1_1_1);
		
		JLabel lblNewLabel_2_3_2_1_2_2_1_1_1_1 = new JLabel("6. Giữ vệ sinh chung, không hút thuốc, không sử dụng các vật dễ cháy nổ trong Thư viện");
		lblNewLabel_2_3_2_1_2_2_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_2_1_2_2_1_1_1_1.setBounds(10, 337, 729, 30);
		panel_NoiQui.add(lblNewLabel_2_3_2_1_2_2_1_1_1_1);
		
		JLabel lblNewLabel_2_3_2_1_2_2_2 = new JLabel("Độc giả nghiêm túc thực hiện Nội quy để xây dựng một môi trường học tập, nghiên cứu thuận tiện, văn minh. Các trường");
		lblNewLabel_2_3_2_1_2_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_2_1_2_2_2.setBounds(10, 391, 729, 30);
		panel_NoiQui.add(lblNewLabel_2_3_2_1_2_2_2);
		
		JLabel lblNewLabel_2_3_2_1_2_2_2_1 = new JLabel("hợp vi phạm sẽ bị xử lý theo quy định.");
		lblNewLabel_2_3_2_1_2_2_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_3_2_1_2_2_2_1.setBounds(10, 416, 729, 30);
		panel_NoiQui.add(lblNewLabel_2_3_2_1_2_2_2_1);
		
		JPanel panel_intaiLieu = new JPanel();
		panel_intaiLieu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMain.add(panel_intaiLieu, "inTaiLieu");
		panel_intaiLieu.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("IN TÀI LIỆU :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(10, 10, 116, 43);
		panel_intaiLieu.add(lblNewLabel_6);
		
		
		table_intaiLieu = new JTable();
		table_intaiLieu.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "T\u00E1c gi\u1EA3", "Th\u1EC3 lo\u1EA1i", "Nh\u00E0 xu\u1EA5t b\u1EA3n", "T\u00ECnh tr\u1EA1ng", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 ti\u1EC1n", "Mã Kho"
			}
		));
		table_intaiLieu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		JScrollPane scrollPane_8 = new JScrollPane(table_intaiLieu);
		scrollPane_8.setBounds(10, 183, 729, 300);
		panel_intaiLieu.add(scrollPane_8);
		
		JButton btnIn = new JButton("IN");
		btnIn.setIcon(new ImageIcon(Home.class.getResource("/view/in.png")));
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
					FileOutputStream fos = new FileOutputStream("F:\\java\\Baitap\\QLThuVien\\in\\sach.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					for (Sach sach_in : ListSach.getAllSach()) {
						oos.writeObject("\n");
						oos.writeObject(sach_in.toString());
						oos.writeObject("\n");
					}
					oos.close();
					JOptionPane.showMessageDialog(btnIn, "In thành công !");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
//				try {
//					
//					XSSFWorkbook workbook = new XSSFWorkbook();
//					XSSFSheet sheet = workbook.createSheet("DanhSachTaiLieu");
//					XSSFRow row ;	
//					XSSFCell cell ;
//						row = sheet.createRow(3);
//						cell = row.createCell(0, CellType.STRING);
//						cell.setCellValue("STT");
//						cell = row.createCell(1, CellType.STRING);
//						cell.setCellValue("Mã Sách");
//						cell = row.createCell(2, CellType.STRING);
//						cell.setCellValue("Tên Sách");
//						cell = row.createCell(3, CellType.STRING);
//						cell.setCellValue("Tác Giả");
//						cell = row.createCell(4, CellType.STRING);
//						cell.setCellValue("Thể Loại");
//						cell = row.createCell(5, CellType.STRING);
//						cell.setCellValue("Nhà Xuất Bản");
//						cell = row.createCell(6, CellType.STRING);
//						cell.setCellValue("Tình Trạng");
//						cell = row.createCell(7, CellType.STRING);
//						cell.setCellValue("Số Lượng");
//						cell = row.createCell(8, CellType.STRING);
//						cell.setCellValue("Giá Tiền");
//						cell = row.createCell(9, CellType.STRING);
//						cell.setCellValue("Mã Kho");
//						
//						for(int i = 0 ;i < ListSach.getAllSach().size();i++)
//						{
//							row = sheet.createRow(4+i);
//							cell = row.createCell(0, CellType.NUMERIC);
//							cell.setCellValue(i+1);
//							cell = row.createCell(1, CellType.STRING);
//							cell.setCellValue(ListSach.getAllSach().get(i).getMaSach());
//							cell = row.createCell(2, CellType.STRING);
//							cell.setCellValue(ListSach.getAllSach().get(i).getTenSach());
//							cell = row.createCell(3, CellType.STRING);
//							cell.setCellValue(ListSach.getAllSach().get(i).getTenTG());
//							cell = row.createCell(4, CellType.STRING);
//							cell.setCellValue(ListSach.getAllSach().get(i).getTheLoai());
//							cell = row.createCell(5, CellType.STRING);
//							cell.setCellValue(ListSach.getAllSach().get(i).getNhaXB());
//							cell = row.createCell(6, CellType.STRING);
//							cell.setCellValue(ListSach.getAllSach().get(i).getTinhTrang());
//							cell = row.createCell(7, CellType.NUMERIC);
//							cell.setCellValue(ListSach.getAllSach().get(i).getSoLuong());
//							cell = row.createCell(8, CellType.NUMERIC);
//							cell.setCellValue(ListSach.getAllSach().get(i).getGiaTien());
//							cell = row.createCell(9, CellType.STRING);
//							cell.setCellValue(ListSach.getAllSach().get(i).getKho());
//						}
//						File f = new File("F:\\java\\Baitap\\QLThuVien\\in\\DanhSach.xlsx");
//						try {
//							FileOutputStream fie = new FileOutputStream(f);
//							workbook.write(fie);
//							fie.close();
//						}catch (FileNotFoundException e1) {
//							// TODO: handle exception
//							System.out.println(e1.toString());
//						}catch (IOException e2) {
//							// TODO: handle exception
//							System.out.println(e2.toString());
//						}
//						JOptionPane.showMessageDialog(btnIn,"In thành công");
//						workbook.close();
//				}catch (IOException e3) {
//					// TODO: handle exception
//					System.out.println(e3.toString());
//				}
//				
				
			}
		});
		btnIn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnIn.setBounds(629, 121, 110, 43);
		panel_intaiLieu.add(btnIn);
		
		JPanel panel_inPM = new JPanel();
		panelMain.add(panel_inPM, "inPM");
		panel_inPM.setLayout(null);
		
		JLabel lblNewLabel_6_1 = new JLabel("IN PHIẾU :");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6_1.setBounds(10, 10, 116, 43);
		panel_inPM.add(lblNewLabel_6_1);
		
		
		table_inPM = new JTable();
		table_inPM.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"M\u00E3 Phi\u1EBFu", "Ng\u01B0\u1EDDi m\u01B0\u1EE3n", "Ng\u01B0\u1EDDi cho m\u01B0\u1EE3n", "T\u00E0i li\u1EC7u m\u01B0\u1EE3n", "S\u1ED1 l\u01B0\u1EE3ng", "Ng\u00E0y m\u01B0\u1EE3n", "Ng\u00E0y tr\u1EA3", "H\u1EA1n tr\u1EA3", "Tình trạng"

			}
		));
		table_inPM.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		JScrollPane scrollPane_9 = new JScrollPane(table_inPM);
		scrollPane_9.setBounds(10, 193, 729, 290);
		panel_inPM.add(scrollPane_9);
		
		JButton btnIn_1 = new JButton("IN");
		btnIn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_inPM.getModel();
				int index = table_inPM.getSelectedRow();
				if(index == -1)
				{
					JOptionPane.showMessageDialog(btnIn_1, "Vui lòng chọn phiếu muốn in");
					return;
				}
				try {
					FileOutputStream fos = new FileOutputStream("F:\\java\\Baitap\\QLThuVien\\in\\MT.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(model.getValueAt(index, 0).toString()+"\n");
					oos.writeObject(model.getValueAt(index, 1).toString()+"\n");		
					oos.writeObject(model.getValueAt(index, 2).toString()+"\n");		
					oos.writeObject(model.getValueAt(index, 3).toString()+"\n");		
					oos.writeObject(model.getValueAt(index, 4).toString()+"\n");		
					oos.writeObject(model.getValueAt(index, 5).toString()+"\n");		
					oos.writeObject(model.getValueAt(index, 6).toString()+"\n");		
					oos.writeObject(model.getValueAt(index, 7).toString()+"\n");		
					oos.writeObject(model.getValueAt(index, 8).toString()+"\n");		
					oos.close();
					JOptionPane.showMessageDialog(btnIn_1, "In thành công !");

				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnIn_1.setIcon(new ImageIcon(Home.class.getResource("/view/in.png")));
		btnIn_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnIn_1.setBounds(629, 140, 110, 43);
		panel_inPM.add(btnIn_1);
		
		JPanel panel_doiMK = new JPanel();
		panel_doiMK.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMain.add(panel_doiMK, "doiMK");
		panel_doiMK.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("ĐỔI MẬT KHẨU");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(279, 40, 195, 37);
		panel_doiMK.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3_1_1_2_1_1_3_3_4_3 = new JLabel("Tài khoản:");
		lblNewLabel_3_1_1_2_1_1_3_3_4_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_3_3_4_3.setBounds(130, 79, 68, 26);
		panel_doiMK.add(lblNewLabel_3_1_1_2_1_1_3_3_4_3);
		
		JLabel lblNewLabel_3_1_1_2_1_1_3_3_4_3_1 = new JLabel("Mật khẩu hiện tại:");
		lblNewLabel_3_1_1_2_1_1_3_3_4_3_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_3_3_4_3_1.setBounds(130, 115, 99, 26);
		panel_doiMK.add(lblNewLabel_3_1_1_2_1_1_3_3_4_3_1);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(120, 151, 395, 2);
		panel_doiMK.add(separator_7);
		
		JLabel lblNewLabel_3_1_1_2_1_1_3_3_4_3_1_1 = new JLabel("Mật khẩu mới:");
		lblNewLabel_3_1_1_2_1_1_3_3_4_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_3_3_4_3_1_1.setBounds(130, 163, 99, 26);
		panel_doiMK.add(lblNewLabel_3_1_1_2_1_1_3_3_4_3_1_1);
		
		JLabel lblNewLabel_3_1_1_2_1_1_3_3_4_3_1_2 = new JLabel("Nhập lại mật khẩu:");
		lblNewLabel_3_1_1_2_1_1_3_3_4_3_1_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3_1_1_2_1_1_3_3_4_3_1_2.setBounds(130, 199, 110, 26);
		panel_doiMK.add(lblNewLabel_3_1_1_2_1_1_3_3_4_3_1_2);
		
		textFi_doiTK = new JTextField();
		textFi_doiTK.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textFi_doiTK.setBounds(239, 82, 262, 19);
		panel_doiMK.add(textFi_doiTK);
		textFi_doiTK.setColumns(10);
		
		JButton btn_doimk = new JButton("Đổi mật khẩu");
		btn_doimk.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				User user_update2 = new User();
				User user_update3 = new User();

				if(textFi_doiTK.getText().equals("")||passwordField_mkhientai.getText().equals("")
						||passwordField_mkDoi.getText().equals("")||passwordField_mkDoiXN.getText().equals(""))
				{
					JOptionPane.showMessageDialog(btn_doimk, "Điền đầy đủ thông tin cập nhật !");
					return;
				}
				
				for (User user_ss : ListUser.getAllUser()) {
					if(user_ss.getUserName().equals(textFi_doiTK.getText().trim())&& user_ss.getPassword().equals(passwordField_mkhientai.getText().trim()))
					{
						user_update2 = user_ss;
					}
				}
				if(user_update2.equals(user_update3))
				{
					JOptionPane.showMessageDialog(btn_doimk, "Không tìm thất tài khoản");
					textFi_doiTK.setText("");
					passwordField_mkhientai.setText("");
					passwordField_mkDoi.setText("");
					passwordField_mkDoiXN.setText("");
					return;
				}
				String mk_1 = passwordField_mkDoi.getText().toString().trim();
				String mk_2 = passwordField_mkDoiXN.getText().toString().trim();

				if(!mk_1.equals(mk_2))
				{
					JOptionPane.showMessageDialog(btn_doimk, "Vui lòng nhập lại mật khẩu mới");
					passwordField_mkDoi.setText("");
					passwordField_mkDoiXN.setText("");
					return;
				}
				user_update2.setPassword(passwordField_mkDoi.getText().trim());
				boolean kq = ListUser.updateUser(user_update2);
				///////////////////////////////////////////////////////////////////
				if(kq)
				{
				
					JOptionPane.showMessageDialog(btn_doimk, "Cập nhật thành công");
				}else
				{
					JOptionPane.showMessageDialog(btn_doimk, "Không tìm thấy tài khoản");

				}
		
			}
		});
		btn_doimk.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btn_doimk.setBounds(302, 228, 129, 37);
		panel_doiMK.add(btn_doimk);
		
		passwordField_mkhientai = new JPasswordField();
		passwordField_mkhientai.setBounds(239, 119, 262, 19);
		panel_doiMK.add(passwordField_mkhientai);
		
		passwordField_mkDoi = new JPasswordField();
		passwordField_mkDoi.setBounds(237, 163, 262, 19);
		panel_doiMK.add(passwordField_mkDoi);
		
		passwordField_mkDoiXN = new JPasswordField();
		passwordField_mkDoiXN.setBounds(237, 199, 262, 19);
		panel_doiMK.add(passwordField_mkDoiXN);
		
		
		
		JButton btn_getAllSach = new JButton("Biên mục tài liệu");
		btn_getAllSach.setForeground(new Color(0, 0, 0));
		btn_getAllSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				CardLayout card = (CardLayout)(panelMain.getLayout());
				card.show(panelMain,"BMTL");
				ListSach.thucHienTaiLaiDuLieuSach(table_sach);				
			}
		});
		btn_getAllSach.setBounds(10, 39, 158, 21);
		btn_getAllSach.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(btn_getAllSach);
		
		JLabel lblMnTr_1 = new JLabel("In");
		lblMnTr_1.setIcon(new ImageIcon(Home.class.getResource("/view/in.png")));
		lblMnTr_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMnTr_1.setForeground(Color.BLUE);
		lblMnTr_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMnTr_1.setBounds(10, 241, 158, 29);
		contentPane.add(lblMnTr_1);
		
		HomeUser.this.setVisible(true);
	
	}

}
