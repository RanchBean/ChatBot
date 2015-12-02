package chat.controller;

import chat.view.*;
import chat.model.Chatbot;

/**
 * Controller for Chatbot.
 * 
 * @author ethr5627
 * @Version 1.3 10/30/2015  Made changes to Meme Checker.
 */
public class ChatController 
{

	private Chatbot Chatbot;
	private ChatView ChatView;
	private ChatFrame chatFrame;

	public ChatController() 
	{
		ChatView = new ChatView();
		String user = ChatView.getAnswer("What is your name?");
		Chatbot = new Chatbot(user);
		chatFrame = new ChatFrame(this);
	}

	public void start()
	{
		//ChatView.getAnswer("Hello " + Chatbot.getUserName());
		//chat();
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
