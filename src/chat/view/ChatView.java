package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * This class provides Chatbot Responses in PopupBox.
 * @author ethr5627
 * @version 1.0 10/21/2015
 */
public class ChatView
 
{
	private String windowMessage;
	private ImageIcon chatIcon;
	public ChatView()
	{
		windowMessage = "Dank meme provided by chatbot";
		chatIcon = new ImageIcon(getClass().getResource("images/souma.png"));
	}
	/**
	 * Display a GUI Popup for collecting user text.
	 * @param displayMessage
	 * @return
	 */
	public String getAnswer(String displayMessage)
	{
		String answer = "";
		
		answer = JOptionPane.showInputDialog(null,displayMessage);
		
		return answer;
	}
	/**
	 * Shows a Message Dialog in a popup in a textbox.
	 * @param displayMessage
	 */
	public void displayResponse(String displayMessage)
	{
		JOptionPane.showMessageDialog(null, displayMessage);
	}
	
}
