package secondpro;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loto extends JFrame {
	
	
	ArrayList <Integer> lst = new ArrayList<>();
	int numbers[]=new int[6];
	int loto[]=new int[6];
	private JPanel contentPane;
	private JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6 ;
	private JButton btnu,btnk,btns,btnt,btne;
	private String guess="";
	DefaultListModel demolist;
	
	public int c=0;
	private JTextField txtg;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loto frame = new loto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	static int indexOfIntArray(int[] array, int key) 
	{
        int returnvalue = -1;
        for (int i = 0; i < array.length; ++i) 
        {
        	if (key == array[i]) 
            {
                returnvalue = i;
                break;
            }
        }
        return returnvalue;
    }
	
	static void delete(int[] array) 
	{
		for(int i=0 ; i< array.length ; i++) 
		{
			array[i]=0;
		}
	}
	
	public static boolean isInteger(String str) 
	{
		 int count = 0 ;
	     for (int i = 0; i < str.length(); i++) 
		 {
			 int ch = (int)str.charAt(i);
			 if (ch>47&&ch<58) 
			 {
			     count++;
			 }
	     }
		 if (count==str.length()) 
		 {
			return true;
		 }
		 if (str.equals(null)) 
		 {
			return false;
		 }
		 return false;
	}
	
	public loto() {
		setFont(new Font("Tahoma", Font.BOLD, 20));
		setTitle("NUMERICAL LOTO APPLICATION");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnu = new JButton("Generate");
		btnu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnu.setBounds(291, 90, 130, 30);
		contentPane.add(btnu);
		btnu.setEnabled(false);
		
		btne = new JButton("Add");
		btne.setFont(new Font("Tahoma", Font.BOLD, 16));
		btne.setBounds(291, 53, 130, 30);
		contentPane.add(btne);
		
		lbl1 = new JLabel("");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl1.setLabelFor(this);
		lbl1.setBounds(10, 164, 60, 50);
		contentPane.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl2.setBounds(80, 164, 60, 50);
		contentPane.add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl3.setBounds(150, 164, 60, 50);
		contentPane.add(lbl3);
		
		lbl4 = new JLabel("");
		lbl4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setBounds(221, 164, 60, 50);
		contentPane.add(lbl4);
		
		JLabel lbls = new JLabel("Enter a number");
		lbls.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbls.setHorizontalAlignment(SwingConstants.CENTER);
		lbls.setBounds(10, 8, 152, 31);
		contentPane.add(lbls);
		
		txtg = new JTextField();
		txtg.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtg.setBounds(161, 11, 120, 28);
		contentPane.add(txtg);
		txtg.setColumns(10);
		
		btnk = new JButton("Check");
		btnk.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnk.setBounds(291, 127, 130, 30);
		contentPane.add(btnk);
		btnk.setEnabled(false);
		
		lbl5 = new JLabel("");
		lbl5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl5.setBounds(291, 164, 60, 50);
		contentPane.add(lbl5);
		
		lbl6 = new JLabel("");
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl6.setBounds(361, 164, 60, 50);
		contentPane.add(lbl6);
		
		btns = new JButton("Delete");
		btns.setFont(new Font("Tahoma", Font.BOLD, 16));
		btns.setBounds(291, 11, 124, 31);
		contentPane.add(btns);
		btns.setEnabled(false);
		
		JLabel lblLoto = new JLabel("");
		lblLoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLoto.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblLoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoto.setBounds(20, 63, 261, 30);
		contentPane.add(lblLoto);
		
	    btnt = new JButton("Try it again");
		btnt.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnt.setBounds(20, 104, 261, 37);
		contentPane.add(btnt);
		btnt.setEnabled(false);

       btns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtg.setText(null);
			}
		});
		
		btnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblLoto.setText(null);
				btnu.setEnabled(false);
				btnk.setEnabled(false);
				btns.setEnabled(false);
				txtg.setText(null);
				guess=" ";	
				lbl1.setText(null);
				lbl2.setText(null);
				lbl3.setText(null);
				lbl4.setText(null);
				lbl5.setText(null);
				lbl6.setText(null);
				c=0;
				delete(numbers);
				delete(loto);
			}
		});
		
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnt.setEnabled(true);
				int same=0;
				for (int i = 0; i < loto.length; i++) 
				{
					if (indexOfIntArray(loto, numbers[i])!=-1)
					{
						same++;
					}
				}
				JOptionPane.showMessageDialog(null,"You got "+same +" numbers right");
			}
		});
		
		btnu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rnd = new Random();
				int s=0;
				while(s<loto.length) 
				{
					int temp = rnd.nextInt(50);
					if (indexOfIntArray(loto,temp)==-1) 
					{
						loto[s]=temp;
						s++;
					}
					
					lbl1.setText(Integer.toString(loto[0]));
					lbl2.setText(Integer.toString(loto[1]));
					lbl3.setText(Integer.toString(loto[2]));
					lbl4.setText(Integer.toString(loto[3]));
					lbl5.setText(Integer.toString(loto[4]));
					lbl6.setText(Integer.toString(loto[5]));
				}
			}
		});
		
		demolist = new DefaultListModel();
		btne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnt.setEnabled(false);
				btns.setEnabled(true);
				if (isInteger(txtg.getText())==false)
				{
					JOptionPane.showMessageDialog(null, "Please enter number only");
				}
				int a=Integer.parseInt(txtg.getText());
				
				if (a>50 || a<=0)
				{
					JOptionPane.showMessageDialog(null, "Please enter a number between 1-50!");
					return;
				}
				if (indexOfIntArray(numbers,a)==-1 && c<numbers.length)
				{
					numbers[c]=a;
				  //  demolist.addElement(sayýlar[c]);     
	              //lst1.setModel(demolist);
	              //  list.add(Integer.toString(a));
					guess+="  "+ Integer.toString(a);
					lblLoto.setText( guess);
	                c++;
	            }
				else if (c==6)
                {
                   JOptionPane.showMessageDialog(null, "You can only enter six numbers!");						
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "You cannot enter the same number!");
				}
				if(numbers.length==c) 
				{
					btnu.setEnabled(true);
					btnk.setEnabled(true);
				}
			}
		});

	}
}
