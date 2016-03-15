package chat.model;

import java.util.*;
import java.io.*;
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
			chatbotTwitter.updateStatus("Ethan I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
		
	}
	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1,200);
		int page = 1;
		while(page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle,statusPage));
			page++;
		}
		for (Status currentStatus : statusList)
		{
			String[] tweetText = currentStatus.getText().split(" ");
			for (String word : tweetText)
			{
				wordsList.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(wordsList);
		removeEmptyText();
	}
	private List removeCommonEnglishWords(List<String> wordList)
	{
		String[] boringWords = importWordsToArray();
		for(int count = 0; count < wordsList.size(); count++)
		{
			for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if(wordsList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordsList.remove(count);
					count--;
					removeSpot = boringWords.length;
				}
			}
		}
		//removeTwitterUsernamesFromList(wordsList);
		return wordsList;
	}
	private void removeEmptyText()
	{
		for(int spot = 0; spot < wordsList.size(); spot++)
		{
			if(wordsList.get(spot).equals(""))
			{
				wordsList.remove(spot);
				spot--;
			}
		}
	}
	public String removePunctuation(String currentString)
	{
		String punctuation = ".,'?:;\"(){}^[]<>-";
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
	
	private String[]importWordsToArray()
	{
	String[] boringWords;
	int wordCount = 0;
	try
	{
		Scanner wordFile = new Scanner(new File("commonWords.txt"));
		while(wordFile.hasNext())
		{
			wordCount++;
			wordFile.next();
		}
		wordFile.reset();
		boringWords = new String[wordCount];
		int boringWordsCount = 0;
		while (wordFile.hasNext())
		{
			boringWords[boringWordsCount] = wordFile.next();
			boringWordsCount++;
		}
		wordFile.close();
	}
	catch (FileNotFoundException error)
	{
		baseController.handleErrors(error.getMessage());
		return new String[0];
	}
	return boringWords;
	}
	
}

