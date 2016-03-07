package chat.model;

import java.util.ArrayList;

import twitter4j.*;
import chat.controller.ChatController;
/*
 * @author ethr5627
 * @version .1 added sendTweet method
 */
public class CTECTwitter 
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordsList;
	private ChatController baseController;
	private Twitter chatbotTwitter;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		this.statusList = new ArrayList<Status>();
		this.wordsList = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
	}
	public void sendTweet(String message)
	{
		try
		{
			chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
		
	}
	
}
