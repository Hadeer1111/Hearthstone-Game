package view;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.heroes.Priest;
@SuppressWarnings("serial")
public class HearthstoneView extends JFrame implements ActionListener  {
	private JPanel CurrentHero;
	private JPanel HandOfCurrHero;
	private JPanel FieldOfCurrHero;
	private JPanel OpponentHero;
	private JPanel FieldOfOppHero;
	private JTextArea CurrHeroInfo;
	private JTextArea OppHeroInfo;
	private JFrame Player1;
	private JTextArea PlayerOne;
	private JFrame Player2;
	private JTextArea PlayerTwo;
	private JFrame WindowException;
	private JTextArea Exception;
	private JFrame Winner;
	private JTextArea WinnerAnnouncement;
	private JFrame BurnedCard;
	private JTextArea BurnedCardInfo;
	private JFrame InstructionWindow;
	private JTextArea InstructionWind;
	
    
    
	public HearthstoneView (){
		
		setTitle("Hearthstone");
		setBounds(300, 100, 800, 1000);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(5,1));
		CurrentHero = new JPanel();
		CurrentHero.setPreferredSize(new Dimension(600,200));
		CurrentHero.setBackground(Color.black);
		CurrHeroInfo = new JTextArea();
		CurrHeroInfo.setBackground(Color.pink);
		CurrHeroInfo.setEditable(false);
		CurrentHero.setLayout(new GridLayout(5,1));
		CurrentHero.add(CurrHeroInfo);
		
		this.add(CurrentHero);
		
		 HandOfCurrHero = new JPanel();
		 HandOfCurrHero.setPreferredSize(new Dimension(800,50));
		 HandOfCurrHero.validate();
		 HandOfCurrHero.setLayout(new GridLayout(10,1));
		 HandOfCurrHero.setBackground(Color.magenta);
		 this.add(HandOfCurrHero);
		
		 
		 
		 FieldOfCurrHero = new JPanel();
		 FieldOfCurrHero.setPreferredSize(new Dimension(800,200));
		 FieldOfCurrHero.validate();
		 FieldOfCurrHero.setLayout(new GridLayout(8,1));
		 FieldOfCurrHero.setBackground(Color.RED);
		 this.add(FieldOfCurrHero);
		
		 
		 FieldOfOppHero = new JPanel();
		 FieldOfOppHero.setPreferredSize(new Dimension(400,100));
		 FieldOfOppHero.setLayout(new GridLayout(7,1));
		 FieldOfOppHero.setBackground(Color.green);
		 this.add(FieldOfOppHero);
		 
		 
		 OpponentHero = new JPanel();
		 OpponentHero.setPreferredSize(new Dimension(800,200));
		 OpponentHero.setBackground(Color.blue);
		 OppHeroInfo = new JTextArea();
		 OppHeroInfo.setBackground(Color.GRAY);
		 OppHeroInfo.setEditable(false);
		 OpponentHero.setLayout(new GridLayout(2,1));
		 OpponentHero.add(OppHeroInfo);
	
		
		 this.add(OpponentHero);
		 
         Player1 = new JFrame();
         Player1.setTitle("Hearthstone");
         Player1.setBounds(500, 100,600,600);
         Player1.setLayout(new GridLayout(7,1));
         PlayerOne = new JTextArea();
         PlayerOne.setText("                                  Player 1");
         PlayerOne.setEditable(false);
         Player1.add(PlayerOne);
         
				 
		 Player2 = new JFrame();
         Player2.setTitle("Hearthstone");
         Player2.setBounds(500, 100,600,600);
         Player2.setLayout(new GridLayout(7,1));
         PlayerTwo = new JTextArea();
         PlayerTwo.setText("                                  Player 2");
         PlayerTwo.setEditable(false);
         Player2.add(PlayerTwo);
         
         
		 WindowException = new JFrame();
		 WindowException.setTitle("Hearthstone");
		 WindowException.setBounds(500, 100,400,400);
		 WindowException.setLayout(new GridLayout(0,1));
		 Exception = new JTextArea();
		 Exception.setEditable(false);
		 WindowException.add(Exception);
		 
		 Winner = new JFrame();
		 Winner.setTitle("Hearthstone");
		 Winner.setBounds(500, 100,200,200);
		 Winner.setLayout(new GridLayout(0,1));
		 WinnerAnnouncement = new JTextArea();
		 WinnerAnnouncement.setEditable(false);
		 Winner.add(WinnerAnnouncement);
		 Winner.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		 BurnedCard = new JFrame();
		 BurnedCard.setTitle("Hearthstone");
		 BurnedCard.setBounds(500, 100,200,200);
		 BurnedCard.setLayout(new GridLayout(0,1));
		 BurnedCardInfo = new JTextArea();
		 BurnedCardInfo.setEditable(false);
		 BurnedCard.add(BurnedCardInfo);
		 
		 
		 
		 InstructionWindow = new JFrame();
		 InstructionWindow.setTitle("Hearthstone");
		 InstructionWindow.setBounds(500, 100,600,300);
		 InstructionWindow.setLayout(new GridBagLayout());
		 InstructionWind = new JTextArea();
		 InstructionWind.setEditable(false);
		 InstructionWindow.add(InstructionWind);
		 InstructionWindow.setVisible(true);
		 
		 
		 
		 
		 
		 
		 this.revalidate();
		 this.repaint();
	     
	}
	
	
	




	public JFrame getInstructionWindow() {
		return InstructionWindow;
	}







	public void setInstructionWindow(JFrame instructionWindow) {
		InstructionWindow = instructionWindow;
	}







	public JTextArea getInstructionWind() {
		return InstructionWind;
	}







	public void setInstructionWind(JTextArea instructionWind) {
		InstructionWind = instructionWind;
	}







	public JPanel getCurrentHero() {
		return CurrentHero;
	}



	public void setCurrentHero(JPanel currentHero) {
		CurrentHero = currentHero;
	}



	public JPanel getHandOfCurrHero() {
		return HandOfCurrHero;
	}



	public void setHandOfCurrHero(JPanel handOfCurrHero) {
		HandOfCurrHero = handOfCurrHero;
	}



	public JPanel getFieldOfCurrHero() {
		return FieldOfCurrHero;
	}



	public void setFieldOfCurrHero(JPanel fieldOfCurrHero) {
		FieldOfCurrHero = fieldOfCurrHero;
	}



	public JPanel getOpponentHero() {
		return OpponentHero;
	}



	public void setOpponentHero(JPanel opponentHero) {
		OpponentHero = opponentHero;
	}



	public JPanel getFieldOfOppHero() {
		return FieldOfOppHero;
	}



	public void setFieldOfOppHero(JPanel fieldOfOppHero) {
		FieldOfOppHero = fieldOfOppHero;
	}



	public JTextArea getCurrHeroInfo() {
		return CurrHeroInfo;
	}



	public void setCurrHeroInfo(JTextArea currHeroInfo) {
		CurrHeroInfo = currHeroInfo;
	}



	public JTextArea getOppHeroInfo() {
		return OppHeroInfo;
	}



	public void setOppHeroInfo(JTextArea oppHeroInfo) {
		OppHeroInfo = oppHeroInfo;
	}





	public JFrame getPlayer1() {
		return Player1;
	}



	public void setPlayer1(JFrame player1) {
		Player1 = player1;
	}



	public JTextArea getPlayerOne() {
		return PlayerOne;
	}



	public void setPlayerOne(JTextArea playerOne) {
		PlayerOne = playerOne;
	}



	



	public JFrame getPlayer2() {
		return Player2;
	}



	public void setPlayer2(JFrame player2) {
		Player2 = player2;
	}



	public JTextArea getPlayerTwo() {
		return PlayerTwo;
	}



	public void setPlayerTwo(JTextArea playerTwo) {
		PlayerTwo = playerTwo;
	}



	public JFrame getWindowException() {
		return WindowException;
	}



	public void setWindowException(JFrame windowException) {
		WindowException = windowException;
	}



	public JTextArea getException() {
		return Exception;
	}



	public void setException(JTextArea exception) {
		Exception = exception;
	}



	public JFrame getWinner() {
		return Winner;
	}



	public void setWinner(JFrame winner) {
		Winner = winner;
	}



	public JTextArea getWinnerAnnouncement() {
		return WinnerAnnouncement;
	}



	public void setWinnerAnnouncement(JTextArea winnerAnnouncement) {
		WinnerAnnouncement = winnerAnnouncement;
	}



	public JFrame getBurnedCard() {
		return BurnedCard;
	}



	public void setBurnedCard(JFrame burnedCard) {
		BurnedCard = burnedCard;
	}



	public JTextArea getBurnedCardInfo() {
		return BurnedCardInfo;
	}



	public void setBurnedCardInfo(JTextArea burnedCardInfo) {
		BurnedCardInfo = burnedCardInfo;
	}



	


	public static void main(String[] args) {
		new HearthstoneView();
		 
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
