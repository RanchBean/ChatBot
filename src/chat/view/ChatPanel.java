package chat.view;

import javax.swing.*;
import java.awt.event.*;
import chat.controller.ChatController;
import java.awt.Color;
/**
 * Holds all of the Objects in the Panel
 * @author ethr5627
 *
 */
public class ChatPanel extends JPanel
{

	private ChatController chatController;
	private JButton chatterButton;
	private JTextArea chatterText;
	private SpringLayout mainLayout;
	private JTextField typingField;
	private JCheckBox checkm8;
	private JButton sendTweet;
	private JButton analyzeTwitterButton;
	private JButton investigateTweet;
	
	
	public ChatPanel(ChatController chatController)
	
	/**
	 * Sets up listeners,panels,layout
	 */
	{
				
		this.chatController = chatController;
		mainLayout = new SpringLayout();
		chatterButton = new JButton("Clicking is awesome.");
		chatterText = new JTextArea("Strong learn new word, Strong Learn respect. ");
		checkm8 = new JCheckBox("checkm8");
		investigateTweet = new JButton("investigate");
		analyzeTwitterButton = new JButton("Analyze");
		sendTweet = new JButton("TWEET");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	/**
	 * Holds all of the details about the panel and Object
	 */
	private void setupPanel()
	{
		this.setLayout(mainLayout);
		this.add(chatterButton);
		this.add(chatterText);
		this.add(sendTweet);
		this.add(analyzeTwitterButton);
		this.add(investigateTweet);
		
		setForeground(Color.WHITE);
		setBackground(new Color(128, 0, 0));
		chatterText.setEnabled(false);
		chatterText.setForeground(new Color(0, 0, 0));
		chatterText.setBackground(new Color(250, 250, 210));
		chatterText.setColumns(15);
		chatterText.setLineWrap(true);
		typingField = new JTextField("",15);
		typingField.setBackground(new Color(250, 250, 210));
		typingField.setToolTipText("#BlameAdam2015");
		chatterButton.setForeground(new Color(0, 0, 0));
		chatterButton.setBackground(new Color(250, 250, 210));
		checkm8.setBackground(new Color(250, 250, 210));
		add(typingField);
		add(checkm8);
	} 
	 /**
	  * holds all of the crap code 
	  */
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
		mainLayout.putConstraint(SpringLayout.NORTH, sendTweet, 0, SpringLayout.NORTH, this);
		mainLayout.putConstraint(SpringLayout.NORTH, analyzeTwitterButton, 0, SpringLayout.NORTH, sendTweet);
		mainLayout.putConstraint(SpringLayout.WEST, sendTweet, 20, SpringLayout.WEST, this);
		mainLayout.putConstraint(SpringLayout.EAST, analyzeTwitterButton, -21, SpringLayout.EAST, this);
		mainLayout.putConstraint(SpringLayout.NORTH, investigateTweet, 0, SpringLayout.NORTH, sendTweet);
		mainLayout.putConstraint(SpringLayout.EAST, investigateTweet, -27, SpringLayout.WEST, analyzeTwitterButton);
	}
	/**
	 * Holds and sets the Listeners for buttons and typing fields.
	 */
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
	sendTweet.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent click)
		{
			chatController.sendTweet("no text to send");
		}
	});
	
	analyzeTwitterButton.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent click)
		{
			String user = typingField.getText();
			String results = chatController.analyze(user);
			chatterText.setText(results);
		}
	});
	
	investigateTweet.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent click)
		{
			chatController.investigateTweet("");
		}	
	});
	
	}
	public JTextField getTextField()
	{
		return typingField;
	}
}

