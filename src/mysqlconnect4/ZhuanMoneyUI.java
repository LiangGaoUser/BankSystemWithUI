package mysqlconnect4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZhuanMoneyUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZhuanMoneyUI frame = new ZhuanMoneyUI();
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
	public ZhuanMoneyUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F6C\u8D26\u5361\u53F7\uFF1A");
		lblNewLabel.setBounds(38, 33, 93, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(165, 30, 225, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8F6C\u8D26\u91D1\u989D\uFF1A");
		lblNewLabel_1.setBounds(39, 81, 92, 18);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 78, 225, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton.setBounds(38, 184, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().isEmpty()||textField_1.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"填写完整信息","提示消息",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				else
				{
					
					float money=Float.valueOf(textField_1.getText());
					String acc=textField.getText();
					if(MainLoginUI.cn.zhuang1(MainLoginUI.getaccount(),MainLoginUI.getpassword(), acc,money)==0)
					{
					JOptionPane.showMessageDialog(null,"转账成功\n\t"+money+" to "+acc,"提示消息",JOptionPane.WARNING_MESSAGE);
					return ;//+money
					}
					if(MainLoginUI.cn.zhuang1(MainLoginUI.getaccount(),MainLoginUI.getpassword(), acc,money)==1)
					{
					JOptionPane.showMessageDialog(null,"转账失败，余额不足！","提示消息",JOptionPane.WARNING_MESSAGE);
					return ;//+money
					}
					if(MainLoginUI.cn.zhuang1(MainLoginUI.getaccount(),MainLoginUI.getpassword(), acc,money)==2)
					{
					JOptionPane.showMessageDialog(null,"转账失败，转账卡号不存在！"+acc,"提示消息",JOptionPane.WARNING_MESSAGE);
					return ;//+money
					}
				}
				
				
				
			}
		});
		btnNewButton_1.setBounds(160, 184, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE\u83DC\u5355");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnNewButton_2.setBounds(277, 184, 113, 27);
		contentPane.add(btnNewButton_2);
	}
}
