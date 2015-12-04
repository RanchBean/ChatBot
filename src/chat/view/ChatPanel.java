package chat.view;

import javax.swing.*;
import java.awt.event.*;
import chat.controller.ChatController;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class ChatPanel extends JPanel
{

	private ChatController chatController;
	private JButton chatterButton;
	private JTextArea chatterText;
	private SpringLayout mainLayout;
	private JTextField typingField;
	private JCheckBox checkm8;
	
	public ChatPanel(ChatController chatController)
	
	{
		setForeground(Color.WHITE);
		setBackground(Color.BLUE);
		
		this.chatController = chatController;
		mainLayout = new SpringLayout();
		chatterButton = new JButton("Clicking is awesome.");
		chatterText = new JTextArea("Strong learn new word, Strong Learn respect. ");
		
		chatterText.setColumns(15);
		chatterText.setLineWrap(true);
		typingField = new JTextField("",15);
		typingField.setToolTipText("#BlameAdam2015");
		checkm8 = new JCheckBox("checkm8");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupPanel()
	
	{
		this.setLayout(mainLayout);
		this.add(chatterButton);
		this.add(chatterText);
		add(typingField);
		chatterText.setEnabled(false);
		chatterText.setForeground(Color.LIGHT_GRAY);
		chatterText.setBackground(Color.WHITE);
		
		
		
		add(checkm8);
		
	}
	
	private void setupLayout()
	
	{
		mainLayout.putConstraint(SpringLayout.SOUTH, chatterButton, -10, SpringLayout.SOUTH, this);
		mainLayout.putConstraint(SpringLayout.EAST, chatterButton, -10, SpringLayout.EAST, this);
		mainLayout.putConstraint(SpringLayout.NORTH, chatterText, 33, SpringLayout.NORTH, this);
		mainLayout.putConstraint(SpringLayout.WEST, chatterText, -406, SpringLayout.EAST, this);
		mainLayout.putConstraint(SpringLayout.SOUTH, chatterText, 229, SpringLayout.NORTH, this);
		mainLayout.putConstraint(SpringLayout.EAST, chatterText, -39, SpringLayout.EAST, this);
		mainLayout.putConstraint(SpringLayout.NORTH, typingField, -1, SpringLayout.NORTH, chatterButton);
		mainLayout.putConstraint(SpringLayout.WEST, typingField, 10, SpringLayout.WEST, this);
		mainLayout.putConstraint(SpringLayout.NORTH, checkm8, 6, SpringLayout.SOUTH, chatterText);
		mainLayout.putConstraint(SpringLayout.EAST, checkm8, -145, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	
	{
		chatterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
				//give text to chatbot √
				//give chatbots answer √
				String userText = typingField.getText();//grab user text √
				String response = chatController.fromUserToChatbot(userText);//send text to controller √
				chatterText.append("\nUser: " + userText);//display text √
				chatterText.append("\nChatbot: " + response); //display answer √
				typingField.setText(""); //clear user field √ 
			}
		});
	}
	
	public JTextField getTextField()
	{
		return typingField;
	}
}

