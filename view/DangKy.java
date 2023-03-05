package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.ServiceUser;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.util.Date;
import javax.swing.ImageIcon;
public class DangKy extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textField_fullname;
	public JTextField textField_email;
	public JTextField textField_username;
	public JPasswordField passwordField;
	public JPasswordField passwordField_confirm;
	public ServiceUser serviceUser = new ServiceUser();
	public User users = new User();
	public JTextField textField_sdt;
	public JTextField txtd;
	public JRadioButton rdbtnNam;
	public JRadioButton rdbtnNu;
	public ButtonGroup btn_chon;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKy frame = new DangKy();
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
	public DangKy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 410);
		setTitle("Phần mềm quản lý thư viện 1.0");
		setLocation(550, 200);
		URL urllogo = DangNhap.class.getResource("logo.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urllogo);
		this.setIconImage(img);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG KÝ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setBounds(131, 10, 119, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập mật khẩu:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(42, 260, 98, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhập lại mật khẩu:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(42, 289, 98, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Họ và tên:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(42, 72, 98, 29);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(42, 97, 98, 29);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tên đăng nhập:");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(42, 231, 98, 29);
		contentPane.add(lblNewLabel_1_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(52, 219, 284, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(52, 60, 284, 2);
		contentPane.add(separator_1);
		
		textField_fullname = new JTextField();
		textField_fullname.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_fullname.setBounds(150, 76, 195, 19);
		contentPane.add(textField_fullname);
		textField_fullname.setColumns(10);
		
		textField_email = new JTextField();
		textField_email.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_email.setColumns(10);
		textField_email.setBounds(150, 101, 195, 19);
		contentPane.add(textField_email);
		
		textField_username = new JTextField();
		textField_username.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_username.setColumns(10);
		textField_username.setBounds(150, 235, 195, 19);
		contentPane.add(textField_username);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnNam.setBounds(147, 131, 63, 21);
		contentPane.add(rdbtnNam);
		
		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnNu.setBounds(232, 131, 63, 21);
		contentPane.add(rdbtnNu);
		
		btn_chon = new ButtonGroup();
		btn_chon.add(rdbtnNam);
		btn_chon.add(rdbtnNu);
		
		
		JButton btn_DangKy = new JButton("Đăng Ký");
		btn_DangKy.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
//				System.out.println(passwordField.getText().equals(passwordField_confirm.getText()));
				if(textField_username.getText().equals("")||passwordField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(btn_DangKy, "Vui lòng nhập tài khoản và mật khẩu");
					return;
				}else if(textField_email.getText().equals("")||textField_fullname.getText().equals("")
						||textField_sdt.getText().equals("") || txtd.getText().equals(""))
				{
					JOptionPane.showMessageDialog(btn_DangKy, "Vui lòng nhập đầy đủ thông tin cá nhân");
					return;
				}
				else if(passwordField.getText().equals(passwordField_confirm.getText())==false)	
				{
					JOptionPane.showMessageDialog(btn_DangKy, "Mật khẩu chưa chính xác");
					passwordField.setText("");
					passwordField_confirm.setText("");
					return;
				}
				users.setUserName(textField_username.getText());
				users.setPassword(passwordField.getText());
				users.setEmail(textField_email.getText());
				users.setFullName(textField_fullname.getText());
				
				if(rdbtnNam.isSelected())
				{
					users.setSex("Nam");

				}else if(rdbtnNu.isSelected())
				{
					users.setSex("Nữ");
				}else
				{
					JOptionPane.showMessageDialog(btn_DangKy, "Vui lòng chọn giới tính");
					return;
				}
				users.setRoles("User");
				
				SimpleDateFormat dp = new SimpleDateFormat("dd/MM/yyyy");
				String birth = txtd.getText().trim();
				Date date = dp.parse(birth);
				users.setDate(date);
	
				String sdt = textField_sdt.getText(); 
				for(int i = 0;i<sdt.length()-1;i++)
				{
					if(sdt.charAt(i) < '0' && sdt.charAt(i) > '9' && sdt.length() >= 10 )
					{
						JOptionPane.showMessageDialog(btn_DangKy, "Vui lòng nhập lại số điện thoại");
						return;
					}
				}
				users.setPhone(sdt);
		
				boolean n = serviceUser.addUser(users);
				System.out.println(n);
				if(n == true)
				{
					JOptionPane.showMessageDialog(btn_DangKy, "Đăng ký thành công");
					DangKy.this.xoaForm();
	
				}
				else if(n == false)
				{
					JOptionPane.showMessageDialog(btn_DangKy, "Tài khoản đã tồn tại");
					textField_username.setText("");
				}
				else 
				{
					JOptionPane.showMessageDialog(btn_DangKy, "Đăng ký thất bại");
					DangKy.this.xoaForm();
					return;
				}
		}catch(Exception e1)
			{
				System.out.println(e1.toString());
			}
		}
		
		});
		btn_DangKy.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_DangKy.setBounds(42, 328, 103, 35);
		contentPane.add(btn_DangKy);
		
		JButton btn_DangNhap = new JButton("Đăng Nhập");
		btn_DangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					DangNhap dn = new DangNhap();
					dn.setVisible(true);
					DangKy.this.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.toString());
				}
				
			}
		});
		btn_DangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_DangNhap.setBounds(242, 328, 103, 35);
		contentPane.add(btn_DangNhap);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		passwordField.setBounds(150, 264, 195, 19);
		contentPane.add(passwordField);
		
		passwordField_confirm = new JPasswordField();
		passwordField_confirm.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		passwordField_confirm.setBounds(150, 293, 195, 19);
		contentPane.add(passwordField_confirm);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Giới tính:");
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_3_1.setBounds(42, 127, 98, 29);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_3_1_1.setBounds(42, 153, 98, 29);
		contentPane.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("Số điện thoại:");
		lblNewLabel_1_3_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_3_1_2.setBounds(42, 180, 98, 29);
		contentPane.add(lblNewLabel_1_3_1_2);
		
		textField_sdt = new JTextField();
		textField_sdt.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_sdt.setBounds(150, 190, 119, 19);
		contentPane.add(textField_sdt);
		textField_sdt.setColumns(10);
		
		txtd = new JTextField();
		txtd.setText("dd/MM/yyyy");
		txtd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtd.setBounds(150, 158, 119, 19);
		contentPane.add(txtd);
		txtd.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DangKy.class.getResource("/view/background6.jpg")));
		lblNewLabel_2.setBounds(0, 0, 398, 373);
		contentPane.add(lblNewLabel_2);
		
		DangKy.this.setVisible(true);
		
		
	}

	public void xoaForm() {
		textField_fullname.setText("");
		textField_email.setText("");
		textField_username.setText("");
		passwordField.setText("");
		passwordField_confirm.setText("");	
		txtd.setText("");
		textField_sdt.setText("");
	}
}
