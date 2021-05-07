package Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import engine.Game;
import engine.GameListener;
import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.minions.MinionListener;
import model.cards.spells.AOESpell;
import model.cards.spells.CurseOfWeakness;
import model.cards.spells.DivineSpirit;
import model.cards.spells.FieldSpell;
import model.cards.spells.Flamestrike;
import model.cards.spells.HeroTargetSpell;
import model.cards.spells.HolyNova;
import model.cards.spells.KillCommand;
import model.cards.spells.LeechingSpell;
import model.cards.spells.LevelUp;
import model.cards.spells.MinionTargetSpell;
import model.cards.spells.MultiShot;
import model.cards.spells.Polymorph;
import model.cards.spells.Spell;
import model.cards.spells.TwistingNether;
import model.heroes.*;
import view.HearthstoneView;

public class Controller extends MouseAdapter  implements ActionListener , GameListener  {
     Game model;
     HearthstoneView view;
     JButton CurrHero;
	 JButton OppHero;
	 JButton HeroPower;
	 JButton EndTurn;
     JButton Mage1;
	 JButton Hunter1;
	 JButton Paladin1;
	 JButton Priest1;
	 JButton Warlock1;
	 JButton Mage2;
	 JButton Hunter2;
	 JButton Paladin2;
	 JButton Priest2;
	 JButton Warlock2;
	 JButton Ok1;
     JButton Ok2;
     JButton Start;
     Hero h1;
	 Hero h2;
	 ArrayList<JButton> HandMinions;
	 ArrayList<JButton> FieldMinionsCurr;
	 ArrayList<JButton> FieldMinionsOpp; 
	 Minion attack;
	 JButton attack1; 
     Hero winner;
     Minion m1;
     Minion m2;
     Hero target;
    
    public Controller () throws FullHandException, CloneNotSupportedException, IOException{
 	   
  	  // h1 = null;
  	  // h2 = null;
  	   view = new HearthstoneView();
  	   Mage1 = new JButton();
         Mage1.setText("Mage1");
         Hunter1 = new JButton();
         Hunter1.setText("Hunter1");
         Paladin1 = new JButton();
         Paladin1.setText("Paladin1");
         Priest1 = new JButton();
         Priest1.setText("Priest1");
         Warlock1 = new JButton();
         Warlock1.setText("Warlock1");
         view.getPlayer1().add(Mage1);
         view.getPlayer1().add(Hunter1);
         view.getPlayer1().add(Paladin1);
         view.getPlayer1().add(Priest1);
         view.getPlayer1().add(Warlock1);
		 Ok1 = new JButton();
		 Ok1.setText("Ok");
		 view.getPlayer1().add(Ok1);
		 
		Mage2 = new JButton();
      Mage2.setText("Mage2");
      Hunter2 = new JButton();
      Hunter2.setText("Hunter2");
      Paladin2 = new JButton();
      Paladin2.setText("Paladin2");
      Priest2 = new JButton();
      Priest2.setText("Priest2");
      Warlock2 = new JButton();
      Warlock2.setText("Warlock2");
      view.getPlayer2().add(Mage2);
      view.getPlayer2().add(Hunter2);
      view.getPlayer2().add(Paladin2);
      view.getPlayer2().add(Priest2);
      view.getPlayer2().add(Warlock2);
		 Ok2 = new JButton();
		 Ok2.setText("Ok");
		 view.getPlayer2().add(Ok2);
		 Start = new JButton();
		 Start.setText("Start");
		 Start.setPreferredSize(new Dimension(150,150));
		 view.getInstructionWindow().add(Start); 
		 
	
		 
		HandMinions = new ArrayList<>();
	    FieldMinionsCurr = new ArrayList<>();
		FieldMinionsOpp = new ArrayList<>();
		
		CurrHero = new JButton();
		CurrHero.setText("Current Hero");
		HeroPower = new JButton();
		HeroPower.setText("Hero Power");
		EndTurn = new JButton();
		EndTurn.setText("End Turn");
		view.getCurrentHero().add(CurrHero);
		view.getCurrentHero().add(HeroPower);
		view.getCurrentHero().add(EndTurn);
		
		OppHero = new JButton();
		OppHero.setText("Opponent Hero");
		view.getOpponentHero().add(OppHero);
		
		attack1 = new JButton();
		attack1.setText("Attack");
		view.getCurrentHero().add(attack1);
		
		
		 
		 
		 Mage1.addActionListener(this);
		 Hunter1.addActionListener(this);
		 Paladin1.addActionListener(this);
		 Priest1.addActionListener(this);
		 Warlock1.addActionListener(this);
		 
		 Mage2.addActionListener(this);
		 Hunter2.addActionListener(this);
		 Paladin2.addActionListener(this);
		 Priest2.addActionListener(this);
		 Warlock2.addActionListener(this);
		 
		 Minion m1 = null;
		 Minion m2 = null;
	//	 Ok3.addActionListener(this);
		// Ok1.addActionListener(this);
	//	 Ok2.addActionListener(this);
		 
		 Start.addMouseListener(this);
		 Ok2.addMouseListener(this);
		 Ok1.addMouseListener(this);
		 
		 view.revalidate();
			view.repaint();
		 
		 Start.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e)
				{
					view.revalidate();
					view.repaint();
						view.getInstructionWindow().setVisible(false);
						view.getPlayer1().setVisible(true);
						
					
				}
			 });
		 Ok1.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e)
				{
					
						view.getPlayer1().setVisible(false);
						view.getPlayer2().setVisible(true);
	              			
				}
			 });
		
		 Ok2.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e)
				{
					
						view.getPlayer2().setVisible(false);
						view.setVisible(true);
												
						try {
							model = new Game(h1,h2);
						} catch (FullHandException e1) {
						
							view.getException().setText(e1.getMessage() +" "+ e1.getBurned().getName()+" "+e1.getBurned().getRarity()+" "+e1.getBurned().getManaCost());
							view.getWindowException().setVisible(true);
						} catch (CloneNotSupportedException e1) {
							view.getException().setText(e1.getMessage());
							view.getWindowException().setVisible(true);
						}
					
						
	              		update();	
				}
			 });
			CurrHero.addMouseListener(this);
		 CurrHero.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e)
				{
					
					    
						addMinionToField();
					    CastSpell(); 
	              			
				}
			 });
		 
		 
		
			
			
			HeroPower.addMouseListener(this);
			HeroPower.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e)
				{
				       if(model.getCurrentHero() instanceof Hunter)
				       {
						try {
							model.getCurrentHero().useHeroPower();
							update();
						} catch (NotEnoughManaException e1) {
							view.getException().setText(e1.getMessage());
							view.getWindowException().setVisible(true);
						} catch (HeroPowerAlreadyUsedException e1) {
							view.getException().setText(e1.getMessage());
							view.getWindowException().setVisible(true);
						} catch (NotYourTurnException e1) {
							view.getException().setText(e1.getMessage());
							view.getWindowException().setVisible(true);
						} catch (FullHandException e1) {
							view.getException().setText(e1.getMessage()+" "+e1.getBurned().getName()+" "+e1.getBurned().getManaCost()+" "+e1.getBurned().getRarity());
							view.getWindowException().setVisible(true);
						} catch (FullFieldException e1) {
							view.getException().setText(e1.getMessage());
							view.getWindowException().setVisible(true);
						} catch (CloneNotSupportedException e1) {
							view.getException().setText(e1.getMessage());
							view.getWindowException().setVisible(true);
						}
				       }
				       
				       if(model.getCurrentHero() instanceof Mage) {
				    	   JButton minion = new JButton();
				    	   minion.addMouseListener(this);
							minion.addMouseListener(new MouseAdapter(){
								public void mousePressed(MouseEvent e)
								
								{
								for(int i=0; i<model.getCurrentHero().getField().size(); i++) {	
									if(minion.equals(FieldMinionsCurr.get(i)))
									{
								try {
									(	(Mage)	model.getCurrentHero()).useHeroPower(model.getCurrentHero().getField().get(i));
									    update();
									    minion.setBackground(Color.yellow);
								} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
										| FullHandException | FullFieldException | CloneNotSupportedException e1) {
									view.getException().setText(e1.getMessage());
									view.getWindowException().setVisible(true);
								}
									}
								}
								
								
									
								}
							});
							try {
								(	(Mage)	model.getCurrentHero()).useHeroPower(model.getOpponent());
								update();
							} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
									| NotYourTurnException | FullHandException | FullFieldException
									| CloneNotSupportedException e1) {
								view.getException().setText(e1.getMessage());
								view.getWindowException().setVisible(true);
							}			
							
				       }
				       
				       if(model.getCurrentHero() instanceof Priest) {
				    	   JButton minion = new JButton();
				    	   minion.addMouseListener(this);
							minion.addMouseListener(new MouseAdapter(){
								public void mousePressed(MouseEvent e)
								
								{
								for(int i=0; i<model.getCurrentHero().getField().size(); i++) {	
									if(minion.equals(FieldMinionsCurr.get(i)))
									{
								try {
									(	(Priest)	model.getCurrentHero()).useHeroPower(model.getCurrentHero().getField().get(i));
									    update();
									    minion.setBackground(Color.yellow);
								} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
										| FullHandException | FullFieldException | CloneNotSupportedException e1) {
									view.getException().setText(e1.getMessage());
									view.getWindowException().setVisible(true);
								}
									}
								}	
								}
							});
							try {
								(	(Priest)	model.getCurrentHero()).useHeroPower(model.getOpponent());
								update();
								OppHero.setBackground(Color.yellow);
							} catch (NotEnoughManaException e1) {
								view.getException().setText(e1.getMessage());
								view.getWindowException().setVisible(true);
							} catch (HeroPowerAlreadyUsedException e1) {
								view.getException().setText(e1.getMessage());
								view.getWindowException().setVisible(true);
							} catch (NotYourTurnException e1) {
								view.getException().setText(e1.getMessage());
								view.getWindowException().setVisible(true);
							} catch (FullHandException e1) {
								view.getException().setText(e1.getMessage());
								view.getWindowException().setVisible(true);
							} catch (FullFieldException e1) {
								view.getException().setText(e1.getMessage());
								view.getWindowException().setVisible(true);
							} catch (CloneNotSupportedException e1) {
								view.getException().setText(e1.getMessage());
								view.getWindowException().setVisible(true);
							}
							
				       }
				       
				       
				       if(model.getCurrentHero() instanceof Paladin) {
				    	   try {
							model.getCurrentHero().useHeroPower();
							update();
						} catch (NotEnoughManaException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (HeroPowerAlreadyUsedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NotYourTurnException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (FullHandException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (FullFieldException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (CloneNotSupportedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    	   
				       }
				       
				       if(model.getCurrentHero() instanceof Warlock) {
				    	   try {
							model.getCurrentHero().useHeroPower();
							 update();
						} catch (NotEnoughManaException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (HeroPowerAlreadyUsedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NotYourTurnException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (FullHandException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (FullFieldException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (CloneNotSupportedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    	  
				       }
				       
				
				}
			});
			 

		
			attack1.addMouseListener(this);
			attack1.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e)
			
			{
			 attack1.setBackground(Color.black);
			 for(int i=0; i<model.getCurrentHero().getField().size(); i++) {
			     Minion m = model.getCurrentHero().getField().get(i);
			     JButton j = FieldMinionsCurr.get(i);
			     j.addMouseListener(this);
				j.addMouseListener(new MouseAdapter(){
					public void mousePressed(MouseEvent e)				
					{
						j.setBackground(Color.black);
			       if(attack == null) {
			    	   attack = m;
					}
					else {
						try {
							model.getCurrentHero().attackWithMinion(m,attack);
							update();
							attack = null;
						} catch (CannotAttackException e1) {
							view.getException().setText(e1.getMessage());
							view.getWindowException().setVisible(true);
						} catch (NotYourTurnException e1) {
							view.getException().setText(e1.getMessage());
							view.getWindowException().setVisible(true);
						} catch (TauntBypassException e1) {
							view.getException().setText(e1.getMessage());
							view.getWindowException().setVisible(true);
						} catch (InvalidTargetException e1) {
							view.getException().setText(e1.getMessage());
							view.getWindowException().setVisible(true);
						} catch (NotSummonedException e1) {
							view.getException().setText(e1.getMessage());
							view.getWindowException().setVisible(true);
						}
						
					}
			       
					}});
				}
				
			
					}
				});
		
			
			 EndTurn.addMouseListener(this);
				EndTurn.addMouseListener(new MouseAdapter(){
					public void mousePressed(MouseEvent e)
					{
						
							try {
								model.endTurn();
								model.getCurrentHero().getListener();
						    	model.getOpponent().getListener();
						   	    // changeField();
						    	update();
								
							} catch (FullHandException e1) {
								view.getException().setText(e1.getMessage()+" "+e1.getBurned().getName()+" "+e1.getBurned().getManaCost()+" "+e1.getBurned().getRarity());
								view.getWindowException().setVisible(true);
							} catch (CloneNotSupportedException e1) {
								view.getException().setText(e1.getMessage());
								view.getWindowException().setVisible(true);
							}
							finally {
							
							view.revalidate();
							view.repaint();}	
					}
				 });
			 
		
		view.revalidate();
		view.repaint();
			 	
  }
 
    
    public void update() {
    	
    	model.getCurrentHero().getListener();
    	model.getOpponent().getListener();
    	view.getHandOfCurrHero().removeAll();
    	
    	view.getFieldOfCurrHero().removeAll();
    	view.getFieldOfOppHero().removeAll();
    	
    	HandMinions.removeAll(HandMinions);
    	FieldMinionsCurr.removeAll(FieldMinionsCurr);
    	FieldMinionsOpp.removeAll(FieldMinionsOpp);
    	
    	view.getCurrHeroInfo().setText(
				"Name :" + model.getCurrentHero().getName()+
				" Current HP : "+model.getCurrentHero().getCurrentHP()+
				" Total Mana Crystals : "+model.getCurrentHero().getTotalManaCrystals()+
				" Current Mana Crystals : "+model.getCurrentHero().getCurrentManaCrystals()+
				" No. of cards in the deck : "+model.getCurrentHero().getDeck().size());
		view.getOppHeroInfo().setText(
		  "Name :" + model.getOpponent().getName()+
		  " Current HP : "+model.getOpponent().getCurrentHP()+
		  " Total Mana Crystals : "+model.getOpponent().getTotalManaCrystals()+
		  " Current Mana Crystals : "+model.getOpponent().getCurrentManaCrystals()+
		  " No. of cards in the deck : "+model.getOpponent().getDeck().size()+
		  " the no of cards in his hand "+model.getOpponent().getHand().size());
		
		for(int i=0; i<model.getCurrentHero().getHand().size(); i++) {
			
			JButton j = new JButton();
			if(model.getCurrentHero().getHand().get(i) instanceof Minion) {
				
				
j.setText(  
"Name : " + ((Minion) model.getCurrentHero().getHand().get(i)).getName()+
" ManaCost : "+((Minion) model.getCurrentHero().getHand().get(i)).getManaCost() +
" Rarity : "+((Minion) model.getCurrentHero().getHand().get(i)).getRarity()+
	" Attack points : "		+((Minion) (model.getCurrentHero().getHand().get(i))).getAttack()+
			" Current Hp : "+((Minion) (model.getCurrentHero().getHand().get(i))).getCurrentHP()+
			" isTaunt : "+((Minion) (model.getCurrentHero().getHand().get(i))).isTaunt()+
			"isDivine : " + ((Minion) (model.getCurrentHero().getHand().get(i))).isDivine()+
			"isSleeping : "+((Minion) (model.getCurrentHero().getHand().get(i))).isSleeping());
     
			}
		
		else {
			if(model.getCurrentHero().getHand().get(i) instanceof Spell) {
			j.setText(
					"Name : "+ ((Spell)model.getCurrentHero().getHand().get(i)).getName()+
			        " Rarity : "+((Spell)model.getCurrentHero().getHand().get(i)).getRarity()+
                      " Mana Cost "+ ((Spell)model.getCurrentHero().getHand().get(i)).getManaCost());
		}
		}
			j.addActionListener(this);
			j.addMouseListener(this);
			view.getHandOfCurrHero().add(j);
			HandMinions.add(j);
		}
		
for(int i=0; i<model.getCurrentHero().getField().size(); i++) {
			
			JButton j = new JButton();
			j.setText(
					"Name : " + ((Minion) model.getCurrentHero().getField().get(i)).getName()+
					" ManaCost : "+((Minion) model.getCurrentHero().getField().get(i)).getManaCost() +
					" Rarity : "+((Minion) model.getCurrentHero().getField().get(i)).getRarity()+
						" Attack points : "		+((Minion) (model.getCurrentHero().getField().get(i))).getAttack()+
								" Current Hp : "+((Minion) (model.getCurrentHero().getField().get(i))).getCurrentHP()+
								" isTaunt : "+((Minion) (model.getCurrentHero().getField().get(i))).isTaunt()+
								"isDivine : " + ((Minion) (model.getCurrentHero().getField().get(i))).isDivine()+
								"isSleeping : "+((Minion) (model.getCurrentHero().getField().get(i))).isSleeping());
			j.addActionListener(this);
			j.addMouseListener(this);
			model.getCurrentHero().listenToMinions();
			FieldMinionsCurr.add(j);view.getFieldOfCurrHero().add(j);
			
			
		}
		
		
		for(int i=0; i<model.getOpponent().getField().size(); i++) {
			
			JButton j = new JButton();
			j.setText(
					"Name : " + ((Minion) model.getOpponent().getField().get(i)).getName()+
					" ManaCost : "+((Minion) model.getOpponent().getField().get(i)).getManaCost() +
					" Rarity : "+((Minion) model.getOpponent().getField().get(i)).getRarity()+
						" Attack points : "		+((Minion) (model.getOpponent().getField().get(i))).getAttack()+
								" Current Hp : "+((Minion) (model.getOpponent().getField().get(i))).getCurrentHP()+
								" isTaunt : "+((Minion) (model.getOpponent().getField().get(i))).isTaunt()+
								"isDivine : " + ((Minion) (model.getOpponent().getField().get(i))).isDivine()+
								"isSleeping : "+((Minion) (model.getOpponent().getField().get(i))).isSleeping());
			j.addActionListener(this);
			j.addMouseListener(this);
			model.getOpponent().listenToMinions();
			FieldMinionsOpp.add(j);view.getFieldOfOppHero().add(j);
			
		}
		
		if(model.getCurrentHero().getCurrentHP() == 0) {
			winner = model.getOpponent();
			onGameOver();
		}
		else
			if(model.getOpponent().getCurrentHP() == 0) {
				winner = model.getCurrentHero();
				onGameOver();
			}
		
		
		model.getCurrentHero().getListener();
    	model.getOpponent().getListener();
		view.revalidate();
		view.repaint();
		
    }
    
   public void changeField() {
	   
	   if(FieldMinionsCurr.size() == 1 && FieldMinionsOpp.size() == 0 ) {
		   JButton b = FieldMinionsCurr.remove(0);
		   FieldMinionsOpp.add(b);
		   view.getFieldOfCurrHero().remove(b);
		   view.getFieldOfOppHero().add(b);
	   }
	   
	   for(int i=0; i<FieldMinionsCurr.size(); i++) {
			view.getFieldOfOppHero().add(FieldMinionsCurr.get(i));
		}
		for(int i=0; i<FieldMinionsOpp.size(); i++) {
			view.getFieldOfCurrHero().add(FieldMinionsOpp.get(i));
		}
		view.revalidate();
		view.repaint();
		
   }
   
 
   
    public void CastSpell() {
        
    	for(int i=0; i<model.getCurrentHero().getHand().size();i++) {
    		 JButton b = HandMinions.get(i);
			 int j = i;
			 
			 b.addMouseListener(this);
			 b.addMouseListener(new MouseAdapter(){
					public void mousePressed(MouseEvent e)
					{    
						if(j< model.getCurrentHero().getHand().size()) {
						if(model.getCurrentHero().getHand().get(j) instanceof Spell) {
							if(model.getCurrentHero().getHand().get(j) instanceof HeroTargetSpell) {
								try {
									model.getCurrentHero().castSpell((HeroTargetSpell)model.getCurrentHero().getHand().get(j), model.getOpponent());
									update();
								} catch (NotYourTurnException | NotEnoughManaException e1) {
									view.getException().setText(e1.getMessage());
									view.getWindowException().setVisible(true);
									
								}
						
							}
							if(model.getCurrentHero().getHand().get(j) instanceof AOESpell) {
								try {
									model.getCurrentHero().castSpell((AOESpell)model.getCurrentHero().getHand().get(j), model.getOpponent().getField());
									update();							
								} catch (NotYourTurnException e1) {
									view.getException().setText(e1.getMessage());
									view.getWindowException().setVisible(true);
								} catch (NotEnoughManaException e1) {
									view.getException().setText(e1.getMessage());
									view.getWindowException().setVisible(true);
								}
								
							}
							if(model.getCurrentHero().getHand().get(j) instanceof FieldSpell) {
								
									try {
										model.getCurrentHero().castSpell((FieldSpell)model.getCurrentHero().getHand().get(j));
										update();
									} catch (NotYourTurnException e1) {
										view.getException().setText(e1.getMessage());
										view.getWindowException().setVisible(true);
									} catch (NotEnoughManaException e1) {
										view.getException().setText(e1.getMessage());
										view.getWindowException().setVisible(true);
									}	
							}
							
						
							for(int i=0; i<model.getOpponent().getField().size();i++) {
								JButton j1 = FieldMinionsOpp.get(i);
								j1.addMouseListener(this);
								 j1.addMouseListener(new MouseAdapter(){
										public void mousePressed(MouseEvent e)
										{
											
											if(j<model.getCurrentHero().getHand().size()) {
												if(model.getCurrentHero().getHand().get(j) instanceof MinionTargetSpell) {
											
										
											try {
												model.getCurrentHero().castSpell((MinionTargetSpell)model.getCurrentHero().getHand().get(j), model.getOpponent().getField().get(j));
												update();
											} catch (NotYourTurnException e1) {
												view.getException().setText(e1.getMessage());
												view.getWindowException().setVisible(true);
											} catch (NotEnoughManaException e1) {
												view.getException().setText(e1.getMessage());
												view.getWindowException().setVisible(true);
											} catch (InvalidTargetException e1) {
												view.getException().setText(e1.getMessage());
												view.getWindowException().setVisible(true);
											}
											
									
										
											}
											}
											}
								
								 });
								 
							}
						
							
						
					
						
			
								
									for(int i=0; i<model.getOpponent().getField().size();i++) {
										JButton j1 = FieldMinionsOpp.get(i);
										j1.addMouseListener(this);
										 j1.addMouseListener(new MouseAdapter(){
												public void mousePressed(MouseEvent e)
												{
													
													if(j<model.getCurrentHero().getHand().size()) {
														if(model.getCurrentHero().getHand().get(j) instanceof LeechingSpell) {
													
												try {
													model.getCurrentHero().castSpell((LeechingSpell)model.getCurrentHero().getHand().get(j), model.getOpponent().getField().get(j));
													update();
												} catch (NotYourTurnException e1) {
													view.getException().setText(e1.getMessage());
													view.getWindowException().setVisible(true);
												} catch (NotEnoughManaException e1) {
													view.getException().setText(e1.getMessage());
													view.getWindowException().setVisible(true);
												}
												
													}
													}
													}
										
										 });
										 
									}
								
									
								
							
								
					}
					}
			 }});
		 }
    }
    
    public void addMinionToField() {
    	for(int i=0; i<model.getCurrentHero().getHand().size();i++) {
			 JButton b = HandMinions.get(i);
			 int j = i;
			 
			 b.addMouseListener(this);
			 b.addMouseListener(new MouseAdapter(){
					public void mousePressed(MouseEvent e)
					{
						if(j<model.getCurrentHero().getHand().size()) {
						if(model.getCurrentHero().getHand().get(j) instanceof Minion) {
							
								try {
									model.getCurrentHero().playMinion((Minion) (model.getCurrentHero().getHand().get(j)));
									model.getCurrentHero().getListener();
								//	model.getCurrentHero().getHand().remove(model.getCurrentHero().getHand().get(j));
							//		model.getCurrentHero().getField().add((Minion)model.getCurrentHero().getHand().get(j));
							//	view.getHandOfCurrHero().remove(b);	
								//	view.getFieldOfCurrHero().add(b);
									
									update();
								//	FieldMinionsCurr.add(b);
									
								} catch (NotYourTurnException e1) {
									view.getException().setText(e1.getMessage());
									view.getWindowException().setVisible(true);
									
								} catch (NotEnoughManaException e1) {
							
									view.getException().setText(e1.getMessage());
									view.getWindowException().setVisible(true);
									
									
								} catch (FullFieldException e1) {
									// TODO Auto-generated catch block
									view.getException().setText(e1.getMessage());
									view.getWindowException().setVisible(true);
									
								}
								
						}
						}
						}
				});
						}
    	
    	}
    
    public void attack1(Minion m1 , Hero target) {
    	try {
			model.getCurrentHero().attackWithMinion(m1, target);
			update();
			m1 = null;
			target = null;
		} catch (CannotAttackException e) {
			view.getException().setText(e.getMessage());
			view.getWindowException().setVisible(true);
		} catch (NotYourTurnException e) {
			view.getException().setText(e.getMessage());
			view.getWindowException().setVisible(true);
		} catch (TauntBypassException e) {
			view.getException().setText(e.getMessage());
			view.getWindowException().setVisible(true);
		} catch (NotSummonedException e) {
			view.getException().setText(e.getMessage());
			view.getWindowException().setVisible(true);
		} catch (InvalidTargetException e) {
			view.getException().setText(e.getMessage());
			view.getWindowException().setVisible(true);
		}
    }
    
    public void attack(Minion m1 , Minion m2 )
    {    
    	try {
			model.getCurrentHero().attackWithMinion(m1, m2);
			update();
			m1 = null;
			m2 = null;
			
			
		} catch (CannotAttackException e) {
			view.getException().setText(e.getMessage());
			view.getWindowException().setVisible(true);
		} catch (NotYourTurnException e) {
			view.getException().setText(e.getMessage());
			view.getWindowException().setVisible(true);
		} catch (TauntBypassException e) {
			view.getException().setText(e.getMessage());
			view.getWindowException().setVisible(true);
		} catch (InvalidTargetException e) {
			view.getException().setText(e.getMessage());
			view.getWindowException().setVisible(true);
		} catch (NotSummonedException e) {
			view.getException().setText(e.getMessage());
			view.getWindowException().setVisible(true);
		}
    }
	
    
  
    @Override
	public void actionPerformed(ActionEvent e) {
    	JButton j = (JButton) e.getSource();
    	
    	if(j.getText().equals("Mage1")) {
			try {
				h1 = new Mage();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	else {
    		if(j.getText().equals("Hunter1")) {
				try {
					h1 = new Hunter();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
    		else {
    			if(j.getText().equals("Paladin1")) {
    				try {
						h1 = new Paladin();
					} catch (IOException | CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			}
    			else {
    				if(j.getText().equals("Priest1")) {
    					try {
							h1 = new Priest();
						} catch (IOException | CloneNotSupportedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    				}
    				else {
    					if(j.getText().equals("Warlock1")) {
    						try {
								h1 = new Warlock();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (CloneNotSupportedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
    					}
    				}
    			}
    		
    			
    	  JButton j1 = (JButton) e.getSource();
    					
    			if(j1.getText().equals("Mage2")) {
    				try {
    					h2 = new Mage();
    				} catch (IOException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				} catch (CloneNotSupportedException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
    	    	}
    	    	else {
    	    		if(j1.getText().equals("Hunter2")) {
    					try {
    						h2 = new Hunter();
    					} catch (IOException e1) {
    						System.out.println(e1.getMessage());
    					} catch (CloneNotSupportedException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    	    		}
    	    		else { 
    	    			if(j1.getText().equals("Paladin2")) {
    	    				try {
    							h2 = new Paladin();
    						} catch (IOException | CloneNotSupportedException e1) {
    							// TODO Auto-generated catch block
    							e1.printStackTrace();
    						}
    	    			}
    	    			else {
    	    				if(j1.getText().equals("Priest2")) {
    	    					try {
    								h2 = new Priest();
    							} catch (IOException | CloneNotSupportedException e1) {
    								// TODO Auto-generated catch block
    								e1.printStackTrace();
    							}
    	    				}
    	    				else {
    	    					if(j1.getText().equals("Warlock2")) {
    	    						try {
    									h2 = new Warlock();
    								} catch (IOException e1) {
    									// TODO Auto-generated catch block
    									e1.printStackTrace();
    								} catch (CloneNotSupportedException e1) {
    									// TODO Auto-generated catch block
    									e1.printStackTrace();
    								}
    	    					}
    		}
    	    			}
    	    		}
    	    	}
    	
    		}
    	}
    	
    	JButton j3 = (JButton) e.getSource();
    	if(model !=null)
    	{
    
    	for(int i=0; i<model.getCurrentHero().getField().size(); i++) {
    		if(j3.equals(FieldMinionsCurr.get(i))) {
    			j3.setBackground(Color.BLUE);
    		      m1 = model.getCurrentHero().getField().get(i);
    		     
    		}
    		
    	}
    	
    	if(m1 != null) {
    	
    	JButton j2 = (JButton) e.getSource();
    	
    	for(int i=0; i<model.getOpponent().getField().size(); i++)
    	{
    		if(j2.equals(FieldMinionsOpp.get(i))) {
    			j2.setBackground(Color.BLUE);
    			m2 = model.getOpponent().getField().get(i);
    			
    		
    	}
    	}
    		
    	if(m2 != null)
    	{
    	attack(m1,m2);
    	m1= null;
    	m2 = null;
    	}
    	
    	}	
    	if(m1 != null) {
    		JButton j6 = (JButton) e.getSource();
    		if(j6.equals(OppHero)){
    			j6.setBackground(Color.BLUE);
    			target = model.getOpponent();
    		} 
    		
    		if(target != null)
        	{
        		attack1(m1,target);
        		m1 = null;
        		target = null;
        	}
    	}
    	

    	}
    }
  
    	
    

	@Override
	public void onGameOver() {
		view.disable();
		view.getWinnerAnnouncement().setText(winner.getName());
		view.getWinner().add(view.getWinnerAnnouncement());
		view.getWinner().setVisible(true);
		
	}
   
	public void playSound(String filepath) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Game getModel() {
		return model;
	}
	public void setModel(Game model) {
		this.model = model;
	}
	public HearthstoneView getView() {
		return view;
	}
	public void setView(HearthstoneView view) {
		this.view = view;
	}
	public static void main(String[] args) throws FullHandException, CloneNotSupportedException, IOException {
		
       new Controller();
      //System.out.println(c.getModel().getCurrentHero().getName());
	}





	
}

