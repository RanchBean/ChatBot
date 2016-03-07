package chat.view;

import javax.swing.*;

import java.awt.event.*;

import chat.controller.ChatController;

import java.awt.Color;

public class TwitterPanel extends JPanel
{
	
	private baseController baseController;
	private SpringLayout mainLayout;
	private JButton tweetButton;
	private JTextArea tweetArea;
	
	public TwitterPanel (ChatController baseController)
	{
		this.baseController = new baseController();
		this.tweetButton = new tweetButton();
		this.mainLayout = new SpringLayout();
		setupPanel();
		setupLayout();
		setupListeners();

	}
	private void setupPanel()
	{
		
	}
	private void setupLayout()
	{
		
	}
	private void setupListeners()
	{
		
	}
}
