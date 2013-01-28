package Gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import Main.DataManager;

import java.awt.Font;

public class AttemptingSocket extends Thread
{
	private JPanel contentPane;

	private String com;
	public JFrame frame;
	public AttemptingSocket() 
	{
		this.start();
	}
	public void run()
	{
		frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 223, 66);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Attempting Socket Connect...");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		frame.pack();
		new DataManager(com,1,this);	
	}

}
