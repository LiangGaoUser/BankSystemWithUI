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
		jblogin=new JButton("��¼");
		jbzhuce=new JButton("����");
		jbexit=new JButton("�˳�");
		jbclear=new JButton("���");
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
		jlb1=new JLabel("����:");
		jlb2=new JLabel("����:");
		jp1.add(jlb1);
		jp1.add(jtf1);
		jp2.add(jlb2);
		jp2.add(jtf2);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		
		
		
		this.setLayout(new GridLayout(4,1));            //ѡ��GridLayout���ֹ�����        
        this.setTitle("�������й���ϵͳ");          
        this.setSize(300,200);         
        this.setLocation(400, 200);           
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //���õ��رմ���ʱ����֤JVMҲ�˳� 
        this.setVisible(true);  
        this.setResizable(true); 
        
        
        

		this.addWindowListener(new WindowAdapter()//
		  		{
		  			@Override
		  			public void windowClosing(WindowEvent e)
		  			{
		  				// TODO Auto-generated method stub
		  				
		  				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(MainLoginUI.this, "�Ƿ��˳���", "ѯ��", JOptionPane.YES_NO_OPTION))
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
		if(e.getActionCommand()=="��¼")
		{
			
			
			if(jtf1.getText().isEmpty()&&jtf2.getText().isEmpty())  
            {  
                JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
            }
        	else if(jtf1.getText().isEmpty())  
            {  
                JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
            }
        	else  if(jtf2.getText().isEmpty())
            {  
                JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
            
            }
        	else
        	{
        		//connect3 cn=new connect3();
        		//Connection con = cn.createconnect("root","admin");
        		account=jtf1.getText();
        		password=jtf2.getText();
        		
        		if(cn.search1(account, password)==1)
        		{
        			JOptionPane.showMessageDialog(null,"�������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
        			return ;
        		}
        		if(cn.search1(account, password)==2)
        		{
        			JOptionPane.showMessageDialog(null,"�˺Ų����ڣ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
        			return ;
        		}
        		
				if(cn.inuse1(account,password)==0)
				{
					
					JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
					clear();  
					 MenuUI mi=new MenuUI();
					 //this.dispose();
					 mi.setVisible(true);
					 
				}
				else
				{
					
					 JOptionPane.showMessageDialog(null,"�ÿ��ѹ�ʧ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				     return ;
				}
        	}
			
			
		}
		else if(e.getActionCommand()=="����")
		{
			//this.setVisible(false);
			OpenAcountUI oai=new OpenAcountUI();
			oai.setVisible(true);
			
			
			
			
		}
		else if(e.getActionCommand()=="���")
		{
			
			clear();
			
		}
		else if(e.getActionCommand()=="�˳�")
		{
			
			if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(MainLoginUI.this, "�Ƿ��˳���", "ѯ��", JOptionPane.YES_NO_OPTION))
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
