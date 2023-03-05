package test;

import javax.swing.UIManager;

import view.DangNhap;

public class test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new DangNhap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
		