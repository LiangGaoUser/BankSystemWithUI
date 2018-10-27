package mysqlconnect4;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import mysqlconnect3.connect3;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class MainLoginUI extends JFrame implements ActionListener{
	static String account,password;
	JLabel jlb1,jlb2;
	JButton jblogin,jbexit,jbzhuce,jbclear;
	JPanel jp1,jp2,jp3,jp4;
	JTextField jtf1,jtf2;
	static connect3  cn=new connect3();
	
	Connection con = cn.createconnect("root","admin");
	public static void main(String[] args) {
		
		MainLoginUI ui= new MainLoginUI();
		//ui.show();
	}

	public static String getaccount()
	{
		
		return account;
	}
	public static String getpassword()
	{
		
		return password;
	}
	public MainLoginUI() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		jblogin=new JButton("登录");
		jbzhuce=new JButton("开户");
		jbexit=new JButton("退出");
		jbclear=new JButton("清空");
		jblogin.addActionListener(this);  
	    jbzhuce.addActionListener(this);  
	    jbexit.addActionListener(this);  
	    jbclear.addActionListener(this);
	    jtf1=new JTextField(20);
	    jtf2=new JTextField(20);
	    jp1=new JPanel();
	    jp2=new JPanel();
	    jp3=new JPanel();
	    jp4=new JPanel();
		jp4.add(jblogin);
		jp4.add(jbzhuce);
		jp4.add(jbclear);
		jp4.add(jbexit);	
		jlb1=new JLabel("卡号:");
		jlb2=new JLabel("密码:");
		jp1.add(jlb1);
		jp1.add(jtf1);
		jp2.add(jlb2);
		jp2.add(jtf2);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		
		
		
		this.setLayout(new GridLayout(4,1));            //选择GridLayout布局管理器        
        this.setTitle("简易银行管理系统");          
        this.setSize(300,200);         
        this.setLocation(400, 200);           
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置当关闭窗口时，保证JVM也退出 
        this.setVisible(true);  
        this.setResizable(true); 
        
        
        

		this.addWindowListener(new WindowAdapter()//
		  		{
		  			@Override
		  			public void windowClosing(WindowEvent e)
		  			{
		  				// TODO Auto-generated method stub
		  				
		  				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(MainLoginUI.this, "是否退出？", "询问", JOptionPane.YES_NO_OPTION))
		  				{
		  					//WindowsAndMenu.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  					MainLoginUI.this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  				}
		  				else
		  				{
		  					MainLoginUI.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		  				}
		  			}
		  		});//
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="登录")
		{
			
			
			if(jtf1.getText().isEmpty()&&jtf2.getText().isEmpty())  
            {  
                JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
            }
        	else if(jtf1.getText().isEmpty())  
            {  
                JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);  
            }
        	else  if(jtf2.getText().isEmpty())
            {  
                JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
            
            }
        	else
        	{
        		//connect3 cn=new connect3();
        		//Connection con = cn.createconnect("root","admin");
        		account=jtf1.getText();
        		password=jtf2.getText();
        		
        		if(cn.search1(account, password)==1)
        		{
        			JOptionPane.showMessageDialog(null,"密码错误！","提示消息",JOptionPane.WARNING_MESSAGE); 
        			return ;
        		}
        		if(cn.search1(account, password)==2)
        		{
        			JOptionPane.showMessageDialog(null,"账号不存在！","提示消息",JOptionPane.WARNING_MESSAGE); 
        			return ;
        		}
        		
				if(cn.inuse1(account,password)==0)
				{
					
					JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE); 
					clear();  
					 MenuUI mi=new MenuUI();
					 //this.dispose();
					 mi.setVisible(true);
					 
				}
				else
				{
					
					 JOptionPane.showMessageDialog(null,"该卡已挂失！","提示消息",JOptionPane.WARNING_MESSAGE);
				     return ;
				}
        	}
			
			
		}
		else if(e.getActionCommand()=="开户")
		{
			//this.setVisible(false);
			OpenAcountUI oai=new OpenAcountUI();
			oai.setVisible(true);
			
			
			
			
		}
		else if(e.getActionCommand()=="清空")
		{
			
			clear();
			
		}
		else if(e.getActionCommand()=="退出")
		{
			
			if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(MainLoginUI.this, "是否退出？", "询问", JOptionPane.YES_NO_OPTION))
				{
				 System.exit(0); 
				
				}
				else
				{
					;
				}
			  
		}
		
		
	
		
	}
	 public  void clear()  
	    {  
	        jtf1.setText("");  
	        jtf2.setText("");  
	    }  
	 
	 

}
