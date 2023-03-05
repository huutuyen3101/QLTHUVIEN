package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ServiceUser;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DangNhap extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textField;
	public JPasswordField passwordField;
	public JRadioButton	rdbtnAdmin;
	public JRadioButton	rdbtnUser;
	public ButtonGroup btn_chon;
	public ServiceUser serviceUser = new ServiceUser();
	public User users =new User();
	public String roles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Phần mềm quản lý thư viện 1.0");
		setLocation(550, 200);
		URL urllogo = DangNhap.class.getResource("logo.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urllogo);
		this.setIconImage(img);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setBounds(148, 28, 147, 45);
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBackground(new Color(255, 128, 192));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		contentPane.add(lblNewLabel);
		
		JLabel lblTiKhon = new JLabel("Tài khoản:");
		lblTiKhon.setIcon(new ImageIcon(DangNhap.class.getResource("/view/user_add.png")));
		lblTiKhon.setBounds(36, 71, 97, 32);
		lblTiKhon.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(lblTiKhon);
		
		JLabel lblMtKhu = new JLabel("  Mật khẩu:");
		lblMtKhu.setIcon(new ImageIcon(DangNhap.class.getResource("/view/pass.png")));
		lblMtKhu.setBounds(36, 113, 97, 22);
		lblMtKhu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(lblMtKhu);
		
		rdbtnAdmin = new JRadioButton("ADMIN");
		rdbtnAdmin.setBounds(117, 158, 77, 27);
		rdbtnAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(rdbtnAdmin);
		
		rdbtnUser = new JRadioButton("USER");
		rdbtnUser.setBounds(239, 158, 77, 27);
		rdbtnUser.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(rdbtnUser);
		
		btn_chon = new ButtonGroup();
		btn_chon.add(rdbtnAdmin);
		btn_chon.add(rdbtnUser);
		
		textField = new JTextField();
		textField.setBounds(148, 78, 199, 18);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 114, 199, 19);
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(passwordField);
		
		JButton btn_DN = new JButton("Đăng Nhập");
		btn_DN.setIcon(new ImageIcon(DangNhap.class.getResource("/view/login.png")));
		btn_DN.setBounds(87, 209, 126, 27);
		btn_DN.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				
				if(textField.getText().equals("")|| passwordField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(btn_DN,"Vui lòng nhập tài khoản hoặc mật khẩu");
				}
				else if(rdbtnAdmin.isSelected() == false && rdbtnUser.isSelected() == false )
				{
					JOptionPane.showMessageDialog(btn_DN,"Vui lòng chọn chức năng");

				}
				else{
					try {
						users.setUserName(textField.getText().trim());
						users.setPassword(passwordField.getText().trim());	
						if(rdbtnAdmin.isSelected())
						{
							roles = "Admin";	
						}else if(rdbtnUser.isSelected())
						{
							roles = "User";
						}
						System.out.println(roles);
						boolean dn = serviceUser.DangNhap(users,roles);	
						
						if(dn == true && rdbtnUser.isSelected() == true){

							HomeUser homeuser = new HomeUser();
							homeuser.setVisible(true);
							DangNhap.this.dispose();
							JOptionPane.showMessageDialog(btn_DN, "Đăng nhập thành công !");
						}else if (dn == true && rdbtnAdmin.isSelected() == true)
						{

							Home home = new Home();
							home.setVisible(true);
							DangNhap.this.dispose();
							JOptionPane.showMessageDialog(btn_DN, "Đăng nhập thành công !");
						}
						else
						{
							JOptionPane.showMessageDialog(btn_DN,"Tài khoản hoặc mật khẩu chưa chính xác");
							textField.setText("");
							passwordField.setText("");
						}						
				}
			catch(Exception e1) {
					System.out.println(e1.toString());
					}
				}
			}
		});
		btn_DN.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(btn_DN);
		
		JButton btn_DK = new JButton("Đăng Ký");
		btn_DK.setIcon(new ImageIcon(DangNhap.class.getResource("/view/add_user.png")));
		btn_DK.setBounds(223, 209, 124, 27);
		btn_DK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				
				DangKy dk = new DangKy();
				dk.setVisible(true);;
				DangNhap.this.dispose();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.toString());
			}
				
				
				
			}
		});
		btn_DK.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(btn_DK);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(77, 65, 288, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(77, 143, 288, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(77, 191, 288, 2);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DangNhap.class.getResource("/view/background6.jpg")));
		lblNewLabel_1.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel_1);
		
		this.setVisible(true);
	}
}
