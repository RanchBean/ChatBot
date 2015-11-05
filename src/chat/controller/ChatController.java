package chat.controller;

import chat.view.ChatView;
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

	public ChatController() 
	{
		ChatView = new ChatView();
		String user = ChatView.getAnswer("What is your name?");
		Chatbot = new Chatbot(user);
	}

	public void start() 
	{
		ChatView.getAnswer("Hello " + Chatbot.getUserName());
		chat();
	}

	private void chat() 
	{
		String textFromUser = ChatView.getAnswer("What are we talking about? ");
		while (Chatbot.lengthChecker(textFromUser)) 
		{
			
			if (Chatbot.contentChecker(textFromUser)) 
			{
				ChatView.getAnswer("You like them " + Chatbot.getContent());
			}
			else if (Chatbot.memeChecker(textFromUser))
			{
				ChatView.getAnswer("Thats not a meme!");
			}
			if (Chatbot.memeChecker(textFromUser))
			{
				ChatView.getAnswer("Thats a dank meme broski");
			}
				
			textFromUser = ChatView.getAnswer(textFromUser);
		}

	}

}
