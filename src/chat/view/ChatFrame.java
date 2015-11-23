package chat.view;

import chat.controller.ChatController;
import chat.view.ChatPanel;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
		private ChatController chatController;
		private ChatPanel chatPanel;
		
		public ChatFrame(ChatController mainController)
		{
			this.chatController = mainController;
			chatPanel = new ChatPanel(chatController);
			setupFrame();
		}
		private void setupFrame()
		{
			this.setContentPane(chatPanel);
			this.setTitle("Chat Window");
			this.setSize(1000,1000);
			this.setResizable(true);
			this.setVisible(true);
		}
		public ChatController getBaseController()
		{
			return chatController;
		}
}
