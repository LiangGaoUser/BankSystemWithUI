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

public class JianMoneyUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JianMoneyUI frame = new JianMoneyUI();
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
	public JianMoneyUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u53D6\u6B3E\u91D1\u989D");
		label.setBounds(74, 41, 72, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(144, 38, 170, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnNewButton.setBounds(14, 180, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"填写完整信息","提示消息",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				else
				{
				float money=Float.valueOf(textField.getText());
				if(MainLoginUI.cn.Jianmoney1(MainLoginUI.getaccount(),MainLoginUI.getpassword(), money)==1)
				{
				JOptionPane.showMessageDialog(null,"取款成功:-"+money,"提示消息",JOptionPane.WARNING_MESSAGE);
				return ;//+money
				}
				if(MainLoginUI.cn.Jianmoney1(MainLoginUI.getaccount(),MainLoginUI.getpassword(), money)==0)
				{
				JOptionPane.showMessageDialog(null,"取款失败，余额不足！","提示消息",JOptionPane.WARNING_MESSAGE);
				return ;//+money
				}
				
			}
			}
		});
		btnNewButton_1.setBounds(144, 180, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE\u83DC\u5355");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(282, 180, 113, 27);
		contentPane.add(btnNewButton_2);
	}
}
