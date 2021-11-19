import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.*;
import javax.swing.border.Border;
import java.util.Timer;
public class Menu {
	JFrame frame = new JFrame("Click Click Go");
	private JPanel deck = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JPanel shopPanel = new JPanel();
	private JPanel startPanel = new JPanel();
	CardLayout LAYOUT = new CardLayout();
	//Character player = new Character();
	public Menu() {
		deck.setLayout(LAYOUT);
		
		start(startPanel);
		MainMenu(mainPanel);
		shop(shopPanel);
		LAYOUT.show(deck, "start");
		frame.add(deck);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,500);
        frame.setVisible(true);
	}
	public void MainMenu(Container pane) {
		ImagePanel background = new ImagePanel("background1.jpg");
		pane.setLayout(new BorderLayout()); //make pane border layout
		pane.add(background);
		//int gold = player.getCurrency(); //will be used to create JLabel to show gold
		JPanel BottomButtons = new JPanel(); //JPanel to hold buttons that will be on bottom of the screen
		BottomButtons.setLayout(new GridLayout(1,3,1,1)); //makes JPanel a grid that is 1 by 3 and has a horizontal and vertical gap of 1
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		
		
		//creates buttons
		JButton MainShopButton = new JButton("Shop");
		JButton MainFightButton = new JButton("Fight");
		JButton MainStatsButton = new JButton("Stats");
		JButton MainQuitButton = new JButton("<html><font color=red size=4><b>Quit</b></html>");
		
		//add buttons to BottomButtons Panel
		BottomButtons.add(MainShopButton);
		BottomButtons.add(MainFightButton);
		BottomButtons.add(MainStatsButton);
		BottomButtons.add(MainQuitButton);
		
		//Add JPanel to the bottom of pane 
		pane.add(BottomButtons, BorderLayout.PAGE_END);
		
		//action listener for shop button
		MainShopButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "shop");
			}
		});
		//action listener for fight button
		MainFightButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "fight");
			}
		});
		//action listener for stats button
		MainStatsButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "stats");
			}
		});
		MainQuitButton.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e) {
				LAYOUT.previous(deck);
				 }
			});

		
		deck.add(pane, "main");
	}
	public void shop(Container pane) {
		JLabel goldLabel;
		JButton ShopQuit = new JButton("<html><font color=red size=4><b>Quit</b></html>");
		JButton ShopFightButton = new JButton("Fight");
		JButton ShopStatsButton = new JButton("Stats");
		JButton ShopMainButton = new JButton("Main");
		pane.add(ShopQuit, BorderLayout.NORTH); 
		//pane.add(new Button("Buy")); I think we don't need a buy button and instead we can have button with pictures of weapon 
		//and when clicked on, it will buy the weapon
		pane.add(ShopMainButton);
		pane.add(ShopFightButton);
		pane.add(ShopStatsButton);
		ShopQuit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) { //go back to start menu
				  LAYOUT.show(deck, "start");
				 }
			});

		ShopMainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "main");
			}
		});
		Border goldAndLevel = BorderFactory.createLineBorder(Color.orange);
		goldLabel = new JLabel(); 
		Gold g = new Gold();
		int goldX = g.getGold();
		Level l = new Level();
		int levelX = l.getLevel();
		String goldAmount = String.valueOf(goldX);
		String theLevel = String.valueOf(levelX);
		String gold = "<html>Gold: ";
		String level = "<br/>Level: ";
		String FullText = gold + goldAmount + level + theLevel;
		
		goldLabel.setText(FullText); 
		goldLabel.setBorder(goldAndLevel);
		pane.add(goldLabel);
		 

		// JPanel that will hold all of the buy weapons buttons 
		JPanel buyButtons = new JPanel();
		buyButtons.setLayout(new GridLayout(1,3,1,1));
	
		// buy button for axe
		ImageIcon axe = new ImageIcon("wip_axe.jpg");
		JButton axeButton = new JButton(axe);
		buyButtons.add(axeButton); // add axeButton to buyButtons panel 
				
		// buy button for bow
		ImageIcon bow = new ImageIcon("wip_bow.jpg");
		JButton bowButton = new JButton(bow);
		buyButtons.add(bowButton); // add bowButton to buyButtons panel

		// buy button for dagger
		ImageIcon dagger = new ImageIcon("wip_dagger.jpg");
		JButton daggerButton = new JButton(dagger);
		buyButtons.add(daggerButton); // add daggerButton to buyButtons panel		
		
		// buy button for spear 
		ImageIcon spear = new ImageIcon("wip_spear.jpg");
		JButton spearButton = new JButton(spear);
		buyButtons.add(spearButton);	// add spearButton to buyButtons panel
		
		// buy button for sword
		ImageIcon sword = new ImageIcon("wip_sword.jpg");
		JButton swordButton = new JButton(sword);
		buyButtons.add(swordButton); 	// add swordButton to buyButtons panel
		
		// adds buyButtons to end of pane 
		pane.add(buyButtons, BorderLayout.PAGE_END); 
				
		//buy button for health
		JButton healthButton = new JButton("Upgrade");
		pane.add(healthButton);
		
		deck.add(pane,"shop");
	}
	public void fight(Container pane){
		Timer timer = new Timer(); //Created start of timer
		JButton FightQuit = new JButton("<html><font color=red size=4><b>Quit</b></html>");
		JButton FightMainButton = new JButton("Main");
		pane.add(FightQuit, BorderLayout.NORTH); 
		
		//Creates layout of all buttons in fight menu
		JPanel fightButtons = new JPanel();
		fightButtons.setLayout(new GridLayout(1,3,1,1));
		
		//Quit Button, going back to start menu
		FightQuit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) { //go back to start menu
				  LAYOUT.show(deck, "start");
				 }
			});

		FightMainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "main");
			}
		});
		
		deck.add(pane, "fight");
	}
	public void start(Container pane) {
		JLabel startImg  = new JLabel();
		
		startImg.setIcon(new ImageIcon("castle1.jpg"));
		startImg.setVerticalTextPosition(JLabel.NORTH);
		pane.add(startImg, BorderLayout.PAGE_START);
		JButton startButton = new JButton("Press Here To Start a Adventure!");
		pane.add(startButton, BorderLayout.CENTER);
		JButton startQuit= new JButton("<html><font color=red size=4><b>Quit</b></html>");
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		startQuit.setBorder(blackLine);
		pane.add(startQuit);
		startQuit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) {
				  System.exit(0);
				 }
			});

		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "main");
			}
		});
		deck.add(pane, "start");
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
            public void run() {
                new Menu();
            }
        });
	}
}
