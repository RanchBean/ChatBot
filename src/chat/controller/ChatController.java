package chat.controller;

import twitter4j.TwitterException;
import chat.view.*;
import chat.model.Chatbot;
import chat.model.CTECTwitter;

/**
 * Controller for Chatbot.
 * 
 * @author ethr5627
 * @Version 1.4 12/4/2015 Added documentation to Controller methods
 */
public class ChatController 
{

	private Chatbot Chatbot;
	private ChatView chatView;
	private ChatFrame chatFrame;
	private CTECTwitter myTwitter;
	

	/**
	 * Holds all the compents anc calls the frame and ChatBot
	 */
	public ChatController() 
	{
		myTwitter = new CTECTwitter(this);
		chatView = new ChatView();
		String user = chatView.getAnswer("What is your name?");
		Chatbot = new Chatbot(user);
		chatFrame = new ChatFrame(this);
	}
	

	public void start()
	{
		
	}

	private void chat() 
	{
		String textFromUser = chatView.getAnswer("What are we talking about? ");
		while (Chatbot.lengthChecker(textFromUser)) 
		{
			
			textFromUser = Chatbot.processQuestion(textFromUser);	
			textFromUser = chatView.getAnswer(textFromUser);
		}

	}
	public void sendTweet(String tweet)
	{
		myTwitter.sendTweet(tweet);
	}
	public void investigateTweet(String searchWord)
	{
		myTwitter.investigation(searchWord);
	}
	public void handleErrors(String error)
	{
		chatView.displayResponse(error);
	}
	public String analyze(String userName)
	{
		String userAnalysis = "The Twitter user " + userName + " has many tweets. ";
		try 
		{
			myTwitter.loadTweets(userName);
		} 
		catch (TwitterException error) 
		{
			handleErrors(error.getErrorMessage());
		}
		userAnalysis += myTwitter.topResults();
		
		return userAnalysis;
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
		chatView.displayResponse("See ya l8tr Nerd, " + Chatbot.getUserName() + " See you in the salt mines");
		System.exit(0);
	}
			

	public Chatbot getChatbot()
	{
		return Chatbot;
	}
	
	public ChatView getChatView()
	{
		return chatView;
	}

	public ChatFrame getBaseFrame()
	{
		return chatFrame;
	}
	
}
