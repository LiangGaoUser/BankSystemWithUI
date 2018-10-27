package mysqlconnect4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class MenuUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUI frame = new MenuUI();
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
	public MenuUI() {
		this.setTitle("选择功能"); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
		this.addWindowListener(new WindowAdapter()//
		  		{
		  			@Override
		  			public void windowClosing(WindowEvent e)
		  			{
		  				// TODO Auto-generated method stub
		  				
		  				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(MenuUI.this, "是否退出？", "询问", JOptionPane.YES_NO_OPTION))
		  				{
		  					//WindowsAndMenu.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  					MenuUI.this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  				}
		  				else
		  				{
		  					MenuUI.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		  				}
		  			}
		  		});//
		
		
		
		
		
		
		JButton btnNewButton = new JButton("\u5B58\u6B3E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//存款
				
				//MainLoginUI.cn.addmoney1(MainLoginUI.account,MainLoginUI.password, money)
				AddMoneyUI ai=new AddMoneyUI();
				
				ai.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(87, 29, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6B3E");
		btnNewButton_1.addActionListener(new ActionListener() {//取款
			public void actionPerformed(ActionEvent e) {
				JianMoneyUI ji=new JianMoneyUI();
				ji.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(261, 29, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4F59\u989D");
		btnNewButton_2.addActionListener(new ActionListener() {//余额
			public void actionPerformed(ActionEvent e) {
				if(MainLoginUI.cn.search1( MainLoginUI.getaccount(),  MainLoginUI.getpassword())==0)
				{
					float money;//这里的 MainLoginUI.getaccount(),getpassword()是定义在MainLoginUI中的
					//定义在connect类中应该会更方便
					money=MainLoginUI.cn.yumoney1( MainLoginUI.getaccount(), MainLoginUI.getpassword());
					JOptionPane.showMessageDialog(null,"余额:"+money,"提示消息",JOptionPane.WARNING_MESSAGE); 
				}
				
			}
		});
		btnNewButton_2.setBounds(87, 91, 113, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u8F6C\u8D26");
		btnNewButton_3.addActionListener(new ActionListener() {//转账
			public void actionPerformed(ActionEvent e) {
				
				
				ZhuanMoneyUI zi=new ZhuanMoneyUI();
				zi.setVisible(true);
				
				
			}
		});
		btnNewButton_3.setBounds(261, 91, 113, 27);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u6302\u5931");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int n=JOptionPane.showConfirmDialog(null, "确定挂失？", "提示",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if(n==1||n==2)
				{
					
				}
				else if(n==3)
				{
					if(MainLoginUI.cn.guashi1(MainLoginUI.getaccount(), MainLoginUI.getpassword()))
					{
					JOptionPane.showMessageDialog(null,"挂失成功","提示消息",JOptionPane.WARNING_MESSAGE);
					//return ;
					}
					dispose();
				}
				else
				{
					
					
				}
				
			}
		});
		btnNewButton_4.setBounds(87, 150, 113, 27);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u6CE8\u9500");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int n=JOptionPane.showConfirmDialog(null, "谨慎操作，确定注销？", "提示",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if(n==1||n==2)
				{
					
				}
				else if(n==3)//怎么返回登录界面，其他界面全部dispose()
				{
					if(MainLoginUI.cn.guashi1(MainLoginUI.getaccount(), MainLoginUI.getpassword()))
					{
					JOptionPane.showMessageDialog(null,"注销成功","提示消息",JOptionPane.WARNING_MESSAGE);
					//return ;
					
					}
					dispose();//
				}
				else
				{
					
					
				}
				
			}
		});
		btnNewButton_5.setBounds(261, 150, 113, 27);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\u9000\u51FA");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(MenuUI.this, "是否退出？", "询问", JOptionPane.YES_NO_OPTION))
  				{
  					//WindowsAndMenu.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  					
  					dispose();
  				}
  				else
  				{
  					
  				}
				
				//dispose();//
				
			}
		});
		btnNewButton_6.setBounds(174, 213, 113, 27);
		contentPane.add(btnNewButton_6);
	}
}
