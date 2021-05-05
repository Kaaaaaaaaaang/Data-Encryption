package MyDiary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Home extends JFrame {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private JTextField enkey_text;
	private JTextField encontent_text;
	private JLabel encode_result;
	public char[][] table;
	String de_result = "";
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		
		ImageIcon logo = new ImageIcon("images/logo.png");
		setIconImage(logo.getImage());
		
		getContentPane().setBackground(Color.WHITE);
		
		setTitle("How was your day?");
		setSize(800, 500);
	    setLocation(400, 150);
	    setResizable(false);
	    setVisible(true);
	    
	    Border blackline = BorderFactory.createLineBorder(Color.black);
	    
	    JPanel background = new JPanel();
	    background.setBounds(0, 0, 800, 500);
	    background.setLayout(null);
	    background.setBackground(SystemColor.menu);
	    getContentPane().add(background);
	    background.setBorder(blackline);
	    
	    enkey_text = new JTextField();
	    enkey_text.setFont(new Font("Dubai", Font.PLAIN, 18));
	    enkey_text.setBounds(136, 118, 180, 30);
	    background.add(enkey_text);
	    enkey_text.setColumns(10);
	    
	    encontent_text = new JTextField();
	    encontent_text.setFont(new Font("Dubai", Font.PLAIN, 18));
	    encontent_text.setColumns(10);
	    encontent_text.setBounds(136, 173, 180, 30);
	    background.add(encontent_text);
	    
	    JLabel encode_key = new JLabel("Key");
	    encode_key.setFont(new Font("Dubai", Font.PLAIN, 17));
	    encode_key.setBounds(60, 113, 44, 40);
	    background.add(encode_key);
	    
	    JLabel encode_content = new JLabel("Content");
	    encode_content.setFont(new Font("Dubai", Font.PLAIN, 17));
	    encode_content.setBounds(45, 168, 80, 40);
	    background.add(encode_content);
	    
	    JButton encode_button = new JButton("Encode");
	    encode_button.setFont(new Font("Dubai", Font.PLAIN, 15));
	    encode_button.setForeground(Color.BLACK);
	    encode_button.setBackground(SystemColor.activeCaption);
	    encode_button.setBounds(443, 145, 110, 30);
	    background.add(encode_button);
	    
	    JLabel encode_lb = new JLabel("Encryption :");
	    encode_lb.setFont(new Font("Dubai", Font.PLAIN, 17));
	    encode_lb.setBounds(437, 226, 100, 40);
	    background.add(encode_lb);
	    
	    encode_result = new JLabel("  ????");
	    encode_result.setForeground(Color.BLACK);
	    encode_result.setOpaque(true);
	    encode_result.setBackground(Color.WHITE);
	    encode_result.setFont(new Font("Dubai", Font.PLAIN, 18));
	    encode_result.setBounds(528, 231, 180, 30);
	    background.add(encode_result);
	    
	    JLabel decode_result = new JLabel("  ????");
	    decode_result.setForeground(Color.BLACK);
	    decode_result.setOpaque(true);
	    decode_result.setFont(new Font("Dubai", Font.PLAIN, 18));
	    decode_result.setBackground(Color.WHITE);
	    decode_result.setBounds(528, 289, 180, 30);
	    background.add(decode_result);
	    
	    JLabel decode_lb = new JLabel("Decryption :");
	    decode_lb.setFont(new Font("Dubai", Font.PLAIN, 17));
	    decode_lb.setBounds(437, 284, 100, 40);
	    background.add(decode_lb);
	    
	    JButton decode_button = new JButton("Decode");
	    decode_button.setForeground(Color.BLACK);
	    decode_button.setFont(new Font("Dubai", Font.PLAIN, 15));
	    decode_button.setBackground(SystemColor.activeCaption);
	    decode_button.setBounds(598, 145, 110, 30);
	    background.add(decode_button);
	    
	    JLabel lblNewLabel = new JLabel("How was your day?");
	    lblNewLabel.setFont(new Font("Dubai", Font.PLAIN, 25));
	    lblNewLabel.setBounds(300, 30, 210, 60);
	    background.add(lblNewLabel);
	    
	    JLabel one = new JLabel("");
	    one.setFont(new Font("Dubai", Font.PLAIN, 15));
	    one.setBounds(136, 270, 180, 22);
	    background.add(one);
	    
	    JLabel two = new JLabel("");
	    two.setFont(new Font("Dubai", Font.PLAIN, 15));
	    two.setBounds(136, 293, 180, 22);
	    background.add(two);
	    
	    JLabel three = new JLabel("");
	    three.setFont(new Font("Dubai", Font.PLAIN, 15));
	    three.setBounds(136, 318, 180, 22);
	    background.add(three);
	    
	    JLabel four = new JLabel("");
	    four.setFont(new Font("Dubai", Font.PLAIN, 15));
	    four.setBounds(136, 343, 180, 22);
	    background.add(four);
	    
	    JLabel five = new JLabel("");
	    five.setFont(new Font("Dubai", Font.PLAIN, 15));
	    five.setBounds(136, 369, 180, 22);
	    background.add(five);
	    
	    JButton btnNewButton = new JButton("Write");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new Write();
	    	}
	    });
	    btnNewButton.setBackground(SystemColor.inactiveCaption);
	    btnNewButton.setFont(new Font("Dubai", Font.PLAIN, 15));
	    btnNewButton.setBounds(516, 404, 100, 40);
	    background.add(btnNewButton);
	    
	    encode_button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String key = enkey_text.getText();
	    		String content = encontent_text.getText();
	    		if(key != null && content != null) {
	    			Encode e1 = new Encode();
	    			e1.Encode(key, content);
	    			table = e1.getTable();
	    			String encode = e1.getEncryption();
	    		    encode_result.setText(encode);
	    		    String en_result = "";
	    		    de_result = e1.getDecryption();
	    		    String[] result_array = new String[5];
	    		    for( int i = 0 ; i < table.length ; i++ )
	    			{
	    		    	en_result = "";
	    		    	
	    				for( int j = 0; j <table[i].length ; j++ )
	    				{
	    					en_result += table[i][j]+"      ";
	    				}
	    				en_result += "\n";
	    				result_array[i] = en_result;
	    			}
	    		    one.setText(result_array[0]);
	    		    two.setText(result_array[1]);
	    		    three.setText(result_array[2]);
	    		    four.setText(result_array[3]);
	    		    five.setText(result_array[4]);
	    		}
	    	}
	    });
	    
	    decode_button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		decode_result.setText(de_result);
	    	}
	    });
	    
	}
}
