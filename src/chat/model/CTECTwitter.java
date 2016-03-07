package chat.model;

import java.util.ArrayList;
import twitter4j.*;
/*
 * @author ethr5627
 * @version .1 added sendTweet method
 */
public class CTECTwitter 
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordsList;
	
	public CTECTwitter()
	{
		this.statusList = new ArrayList<Status>();
		this.wordsList = new ArrayList<String>();
	}
	/*
	 *
	 */
	
	public void sendTweet(String message)
	{
		
	}
}
