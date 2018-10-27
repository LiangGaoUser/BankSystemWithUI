package mysqlconnect4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class OpenAcountUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String id;
	private String password;
	private String repatepd;
	private String name;
	private String acount;
	
	private int symbol;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenAcountUI frame = new OpenAcountUI();
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
	public OpenAcountUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("开户");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(199, 38, 149, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		lblNewLabel.setBounds(77, 41, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u586B\u5199\u4EE5\u4E0B\u4FE1\u606F");
		lblNewLabel_1.setBounds(34, 10, 139, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setBounds(77, 85, 72, 18);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(199, 82, 149, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(77, 122, 37, 18);
		contentPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(199, 119, 149, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label_2.setBounds(77, 164, 72, 18);
		contentPane.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(199, 161, 149, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		
		
		
		  this.addWindowListener(new WindowAdapter()//
	  		{
	  			@Override
	  			public void windowClosing(WindowEvent e)
	  			{
	  				// TODO Auto-generated method stub
	  				
	  				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(OpenAcountUI.this, "是否退出？", "询问", JOptionPane.YES_NO_OPTION))
	  				{
	  					//WindowsAndMenu.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  					OpenAcountUI.this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  				}
	  				else
	  				{
	  					OpenAcountUI.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	  				}
	  			}
	  		});//
		
		
		
		
		
		JButton btnNewButton = new JButton("\u6E05\u7A7A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
        		textField_1.setText("");
        		textField_2.setText("");
        		textField_3.setText("");
			}
		});
		btnNewButton.setBounds(77, 213, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				id=textField.getText();
				name=textField_1.getText();
				password=textField_2.getText();
				repatepd=textField_3.getText();
				
				
				if(id.isEmpty()||name.isEmpty()||password.isEmpty()||repatepd.isEmpty())  
	            {  
	                JOptionPane.showMessageDialog(null,"请填写完整信息！","提示消息",JOptionPane.WARNING_MESSAGE);  
	                return ;
	            }
	        	if(!password.equals(repatepd))
	        	{
	        		JOptionPane.showMessageDialog(null,"两次填写的密码不一致！","提示消息",JOptionPane.WARNING_MESSAGE);  
	        		textField_2.setText("");
	        		textField_3.setText("");
	        		return ;
	        	}
				
	        	
				
				symbol=MainLoginUI.cn.insert1(id, name, password);
				
				acount=MainLoginUI.cn.getaccount();
				
				switch(symbol)
				{
				case 0:
				{
	        		JOptionPane.showMessageDialog(null,"输入身份证号已开户，请重新输入身份证号","提示消息",JOptionPane.WARNING_MESSAGE); 
					// clear();         
		           //  dispose(); 
	        		textField.setText("");
	        		
	        		//System.out.print("as"+acount);
		             break;
	        	}
				case 1:
				{
	        		JOptionPane.showMessageDialog(null,"开户成功，请记住您的账户:"+acount,"提示消息",JOptionPane.WARNING_MESSAGE); 
					// clear();         
		            // dispose(); 
	        		textField.setText("");
	        		textField_1.setText("");
	        		textField_2.setText("");
	        		textField_3.setText("");
	        		
		             break;
	        	}
				case 2:
				{
	        		JOptionPane.showMessageDialog(null,"开户失败，出现exception","提示消息",JOptionPane.WARNING_MESSAGE); 
					// clear();         
		            // dispose(); 	
	        		textField.setText("");
	        		textField_1.setText("");
	        		textField_2.setText("");
	        		textField_3.setText("");
		             break;
	        	}
				
				
				
				
				}
			}
		});
		btnNewButton_1.setBounds(235, 213, 113, 27);
		contentPane.add(btnNewButton_1);
	}
}
