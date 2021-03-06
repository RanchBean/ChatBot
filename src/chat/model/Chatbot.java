package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author ethr5627
 * @version 1.3 10/23/15 built and called buildMemesList method.
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;
		this.content = "Dank Memes";
		buildMemesList();
		buildPoliticalTopicsList();
	}
	/**
	 * Puts all of the string in the memeslist into arraylist.
	 */
	private void buildMemesList()
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("Aleks Face");
		this.memesList.add("");
		this.memesList.add("TSM DoubleLift");
		this.memesList.add("Money in the bank");
		this.memesList.add("Aron");
		this.memesList.add("Porcelain Contact");
		this.memesList.add("Dank Memes Can't Melt Playoff Dreams");
		this.memesList.add("Always bet on paper");
	}
	
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("Hillary The Devil Clinton ");
		this.politicalTopicList.add("Donald Trump");
		this.politicalTopicList.add("Feel the Bern");
		this.politicalTopicList.add("Republican");
		this.politicalTopicList.add("Democrat");
		this.politicalTopicList.add("Jed Bush");
		this.politicalTopicList.add("Ted Cruz");
		this.politicalTopicList.add("11/4/16");
		this.politicalTopicList.add("Yes");
		this.politicalTopicList.add("No");
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		if(currentInput != null)
		{
			if(currentInput.length() > 0)
			{
				hasLength = true;
			}
		}
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPoliticalTopics = false;
		
		for(String politicalTopics: politicalTopicList)
		{
			if(currentInput.toLowerCase().contains(politicalTopics.toLowerCase()))
			{	
			hasPoliticalTopics = true;
			}
		}
		
		return hasPoliticalTopics;
	}
	
	public String processQuestion(String currentInput)
	{
		String talkBack = "lets talk about salty bets.";
		int randomTopic = (int) (Math.random() * 5); //Generates random number 0-4
		
		 if (keyboardMashChecker(currentInput))
		 {
			 return "#StoptheMash";
		 }
		switch (randomTopic)
		{
		case 0:
			if(contentChecker(currentInput))
			{
				talkBack = "You talked about the memes. What is your favorite meme?";
			}
			break;
		case 1:
			if(memeChecker(currentInput))
			{
				talkBack = "Thats a high quality meme right there! Where do you find your memes?";
			}
			break;
		case 2:
			if(politicalTopicChecker(currentInput))
			{
				talkBack = "I didnt know you were apart of that party! Who do you want to be president?";
			}
			break;
		case 3:
			if(currentInput.contains("TSM"))
			{
				talkBack = "Awesome meme dude! What is your favorite car?";
			}
			break;
		case 4:				
				talkBack = "Dank meme dude Baylife for life. ";
			break;
		default:
			
			break;
			
		}
		return talkBack;
		
	}
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMemes = false;
		
		for(String meme: memesList)
		{
			if(currentInput.toLowerCase().equals(meme.toLowerCase()))
			{
				hasMemes = true;
			}
		}
		return hasMemes;
	}
	
	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
		
		if(currentInput.toLowerCase().equals("quit"))
		{
			hasQuit =true;
		}
		return hasQuit;
	}
	
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean isMash = false;
		if(currentInput.equals("sdf") || (currentInput.equals("dfg") || (currentInput.equals("cvb") || (currentInput.equals(",./")))))
		{
			isMash = true;
		}
		return isMash;
	}
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
}