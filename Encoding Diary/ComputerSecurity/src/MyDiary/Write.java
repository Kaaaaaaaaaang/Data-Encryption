package MyDiary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class Write extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTitle;
	private JTextArea txtContent;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Write frame = new Write();
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
	public Write() {
		ImageIcon logo = new ImageIcon("images/logo.png");
		setIconImage(logo.getImage());
		
		getContentPane().setBackground(Color.WHITE);
		
		setTitle("How was your day?");
		setSize(350, 500);
	    setLocation(1100, 180);
	    setResizable(false);
	    setVisible(true);
	    
	    JPanel background = new JPanel();
	    background.setBounds(0, 0, 800, 600);
	    background.setLayout(null);
	    background.setBackground(SystemColor.control);
	    getContentPane().add(background);
	   
	    txtTitle = new JTextField();
	    txtTitle.setBackground(Color.WHITE);
	    txtTitle.setFont(new Font("Dubai", Font.PLAIN, 15));
	    txtTitle.setText("Title");
	    txtTitle.setBounds(83, 45, 166, 30);
	    background.add(txtTitle);
	    txtTitle.setColumns(10);
	    
	    txtContent = new JTextArea();
	    txtContent.setBackground(new Color(255, 250, 250));
	    txtContent.setFont(new Font("Dubai", Font.PLAIN, 13));
	    txtContent.setBounds(42, 114, 242, 239);
	    background.add(txtContent);
	    txtContent.setColumns(10);
	    
	    JButton btnNewButton = new JButton("Save");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String filename = txtTitle.getText();
	    		String txt = txtContent.getText();
	    		
	    		try {
	    			File file = new File("Diary//" + filename);
	    			FileWriter fw = new FileWriter(file, true);
	    			
	    			fw.write(txt);
	    			fw.flush();
	    			
	    			fw.close();
	    			
	    			JOptionPane.showMessageDialog(null,  "Save Complete.", "Save", JOptionPane.PLAIN_MESSAGE);
	    			
	    			dispose();
	    		}catch (Exception e1) {
					// TODO: handle exception
	    			e1.printStackTrace();
				}
	    	}
	    });
	    btnNewButton.setBackground(Color.PINK);
	    btnNewButton.setFont(new Font("Dubai", Font.PLAIN, 18));
	    btnNewButton.setBounds(122, 380, 91, 30);
	    background.add(btnNewButton);
	    
	}

}
