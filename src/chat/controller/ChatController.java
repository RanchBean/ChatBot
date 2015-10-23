package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;
/**
 * Controller for Chatbot.
 * @author ethr5627
 * @Version 1.2 10/23/2015 Displays Chatbot's userName Variable
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
		ChatView.getAnswer("Hello " +Chatbot.getUserName());
	}
}
