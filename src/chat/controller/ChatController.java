package chat.controller;

import chat.view.*;
import chat.model.Chatbot;

/**
 * Controller for Chatbot.
 * 
 * @author ethr5627
 * @Version 1.4 12/4/2015 Added documentation to Controller methods
 */
public class ChatController 
{

	private Chatbot Chatbot;
	private ChatView ChatView;
	private ChatFrame chatFrame;

	/**
	 * Holds all the compents anc calls the frame and ChatBot
	 */
	public ChatController() 
	{
		ChatView = new ChatView();
		String user = ChatView.getAnswer("What is your name?");
		Chatbot = new Chatbot(user);
		chatFrame = new ChatFrame(this);
	}

	public void start()
	{
		
	}

	private void chat() 
	{
		String textFromUser = ChatView.getAnswer("What are we talking about? ");
		while (Chatbot.lengthChecker(textFromUser)) 
		{
			
			textFromUser = Chatbot.processQuestion(textFromUser);	
			textFromUser = ChatView.getAnswer(textFromUser);
		}

	}
	/**
	 * Grabs text from user and inputs into chat bot
	 */
	public String fromUserToChatbot(String textFromUser)
	{
		String botResponse = "";
		
		if(Chatbot.quitChecker(textFromUser))
		{
			shutDown();
		}
		
		botResponse = Chatbot.processQuestion(textFromUser);
		
		return botResponse;
		
	}
	/**
	 * shuts down the program
	 */
	private void shutDown()
	{
		ChatView.displayResponse("See ya l8tr Nerd, " + Chatbot.getUserName() + " See you in the salt mines");
		System.exit(0);
	}
			

	public Chatbot getChatbot()
	{
		return Chatbot;
	}
	
	public ChatView getChatView()
	{
		return ChatView;
	}

	public ChatFrame getBaseFrame()
	{
		return chatFrame;
	}
	
}
