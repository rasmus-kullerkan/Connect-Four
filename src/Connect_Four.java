import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Connect_Four extends JFrame {
	public BufferedImage rb, yb, bb, redw, yelw, ol, butb, draww; {
		try {
			rb = ImageIO.read(new File("resources/redblock.bmp"));
			yb = ImageIO.read(new File("resources/yellowblock.bmp"));
			bb = ImageIO.read(new File("resources/backblock.bmp"));
			redw = ImageIO.read(new File("resources/redwin.png"));
			yelw = ImageIO.read(new File("resources/yellowwin.png"));
			ol = ImageIO.read(new File("resources/overlay.png"));
			butb = ImageIO.read(new File("resources/buttonback.png"));
			draww = ImageIO.read(new File("resources/draw.png"));
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
	
	public static ImageIcon icon = new ImageIcon("resources/cficon.png");
	
	public int x1 = 0;
	public int x2 = 0;
	public int x3 = 0;
	public int x4 = 0;
	public int x5 = 0;
	public int x6 = 0;
	public int x7 = 0;
	public boolean turn = true;
	int[][] grid = new int[7][6];
	public boolean rw = false;
	public boolean yw = false;
	public boolean draw = false;
	public static boolean click = false;
	public static boolean click2 = false;
	
	public Connect_Four() {
		super("Connect Four");
		
		setIconImage(icon.getImage());
		setLayout(new BorderLayout());
        setSize(500, 460);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel buttons = new JPanel() {
        	protected void paintComponent (Graphics g) {
        		Graphics2D g2 = (Graphics2D) g;
        		g2.drawImage(butb, 0, 0, null);
			}
        };
        
        JButton bRestart = new JButton("Restart");
        JButton back = new JButton("Tagasi");
        buttons.add(bRestart);
        buttons.add(back);
        
        add(buttons, BorderLayout.NORTH);
        
        JPanel gridpanel = new JPanel() {
        	protected void paintComponent (Graphics g) {
            	for(int i = 0; i < 7; i++) {
            		for(int j = 0; j < 6; j++) {
            			if(grid[i][j] == 1) {
            				g.drawImage(rb, 30 + i*67, 320 - j*50, null);
            			}else if(grid[i][j] == 2) {
            				g.drawImage(yb, 30 + i*67, 320 - j*50, null);
            			}else {
            				g.drawImage(bb, 30 + i*67, 320 - j*50, null);
            			}
            		}
            	}
            	g.drawImage(ol, 0, 0, null);
            	if(rw == true) {
            		g.drawImage(redw, 17, 11, null);
            	} else if(yw == true) {
            		g.drawImage(yelw, 17, 11, null);
            	} else if(draw == true) {
            		g.drawImage(draww, 17, 11, null);
            	}
        	}
        };
        
        FlowLayout flow = new FlowLayout();
        flow.setVgap(20);
        flow.setHgap(27);
        gridpanel.setLayout(flow);
        
        add(gridpanel, BorderLayout.CENTER);
        
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        
        gridpanel.add(b1);
        gridpanel.add(b2);
        gridpanel.add(b3);
        gridpanel.add(b4);
        gridpanel.add(b5);
        gridpanel.add(b6);
        gridpanel.add(b7);       
        
        ActionListener listener = (new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource() == b1) {
        			repaint();
                    turn = !turn;
                    if(turn == false) {
                    	grid[0][x1] = 1;
                    } else if (turn == true) {
                    	grid[0][x1] = 2;
                    }
                    x1++;
                    if(x1 == 6) {
                    	gridpanel.remove(b1);
                    }
                    test();
                    if(rw == true || yw == true || draw == true) {
                    	gridpanel.removeAll();
                    }
        		} if(e.getSource() == b2) {
        			repaint();
                    turn = !turn;
                    if(turn == false) {
                    	grid[1][x2] = 1;
                    } else if (turn == true) {
                    	grid[1][x2] = 2;
                    }
                    x2++;
                    if(x2 == 6) {
                    	gridpanel.remove(b2);
                    }
                    test();
                    if(rw == true || yw == true || draw == true) {
                    	gridpanel.removeAll();
                    }
        		} if(e.getSource() == b3) {
        			repaint();
                    turn = !turn;
                    if(turn == false) {
                    	grid[2][x3] = 1;
                    } else if (turn == true) {
                    	grid[2][x3] = 2;
                    }
                    x3++;
                    if(x3 == 6) {
                    	gridpanel.remove(b3);
                    }
                    test();
                    if(rw == true || yw == true || draw == true) {
                    	gridpanel.removeAll();
                    }
        		} if(e.getSource() == b4) {
        			repaint();
                    turn = !turn;
                    if(turn == false) {
                    	grid[3][x4] = 1;
                    } else if (turn == true) {
                    	grid[3][x4] = 2;
                    }
                    x4++;
                    if(x4 == 6) {
                    	gridpanel.remove(b4);
                    }
                    test();
                    if(rw == true || yw == true || draw == true) {
                    	gridpanel.removeAll();
                    }
        		} if(e.getSource() == b5) {
        			repaint();
                    turn = !turn;
                    if(turn == false) {
                    	grid[4][x5] = 1;
                    } else if (turn == true) {
                    	grid[4][x5] = 2;
                    }
                    x5++;
                    if(x5 == 6) {
                    	gridpanel.remove(b5);
                    }
                    test();
                    if(rw == true || yw == true || draw == true) {
                    	gridpanel.removeAll();
                    }
        		} if(e.getSource() == b6) {
        			repaint();
                    turn = !turn;
                    if(turn == false) {
                    	grid[5][x6] = 1;
                    } else if (turn == true) {
                    	grid[5][x6] = 2;
                    }
                    x6++;
                    if(x6 == 6) {
                    	gridpanel.remove(b6);
                    }
                    test();
                    if(rw == true || yw == true || draw == true) {
                    	gridpanel.removeAll();
                    }
        		} if(e.getSource() == b7) {
        			repaint();
                    turn = !turn;
                    if(turn == false) {
                    	grid[6][x7] = 1;
                    } else if (turn == true) {
                    	grid[6][x7] = 2;
                    }
                    x7++;
                    if(x7 == 6) {
                    	gridpanel.remove(b7);
                    }
                    test();
                    if(rw == true || yw == true || draw == true) {
                    	gridpanel.removeAll();
                    }
        		} if(e.getSource() == bRestart) {
        			for(int i = 0; i < 7; i++) {
    					for(int j = 0; j < 6; j++) {
    						grid[i][j] = 0;
    					}
    				}
    				x1 = 0;
    				x2 = 0;
    				x3 = 0;
    				x4 = 0;
    				x5 = 0;
    				x6 = 0;
    				x7 = 0;
    				turn = true;
    				rw = false;
    				yw = false;
    				draw = false;
    				gridpanel.removeAll();
    				gridpanel.add(b1);
    				gridpanel.add(b2);
    				gridpanel.add(b3);
    				gridpanel.add(b4);
    				gridpanel.add(b5);
    				gridpanel.add(b6);
    				gridpanel.add(b7);
    				repaint();
        		} if(e.getSource() == back) {
        			dispose();
        		}
        	}	
        });
        
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
        b6.addActionListener(listener);
        b7.addActionListener(listener);
        bRestart.addActionListener(listener);
        back.addActionListener(listener);
	}
	
	public void test() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 7; j++) {
				if(grid[j][i] == 1 && grid[j][i+1] == 1 && grid[j][i+2] == 1 && grid[j][i+3] == 1) {
					rw = true;
				}
				if(grid[j][i] == 2 && grid[j][i+1] == 2 && grid[j][i+2] == 2 && grid[j][i+3] == 2) {
					yw = true;
				}
			}
		} for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 6; j++) {
				if(grid[i][j] == 1 && grid[i+1][j] == 1 && grid[i+2][j] == 1 && grid[i+3][j] == 1) {
					rw = true;
				}
				if(grid[i][j] == 2 && grid[i+1][j] == 2 && grid[i+2][j] == 2 && grid[i+3][j] == 2) {
					yw = true;
				}
			}
		} for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				if(grid[j][i] == 1 && grid[j+1][i+1] == 1 && grid[j+2][i+2] == 1 && grid[j+3][i+3] == 1) {
					rw = true;
				}
				if(grid[j][i] == 2 && grid[j+1][i+1] == 2 && grid[j+2][i+2] == 2 && grid[j+3][i+3] == 2) {
					yw = true;
				}
			}
		} for(int i = 5; i > 2; i--) {
			for(int j = 0; j < 4; j++) {
				if(grid[j][i] == 1 && grid[j+1][i-1] == 1 && grid[j+2][i-2] == 1 && grid[j+3][i-3] == 1) {
					rw = true;
				}
				if(grid[j][i] == 2 && grid[j+1][i-1] == 2 && grid[j+2][i-2] == 2 && grid[j+3][i-3] == 2) {
					yw = true;
				}
			}
		}
		if(grid[0][5] != 0 && grid[1][5] != 0 && grid[2][5] != 0 && grid[3][5] != 0 && grid[4][5] != 0 && grid[5][5] != 0 && grid[6][5] != 0) {
			draw = true;
		}
    }
	
	public static class helpw extends JFrame {
		public helpw() {
			super("Õpetus");
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setIconImage(icon.getImage());
			
			JPanel background = new JPanel() {
	        	protected void paintComponent (Graphics g) {
	        		Graphics2D g2 = (Graphics2D) g;
	        		BufferedImage background = null; {
	        			try {
	        				background = ImageIO.read(new File("resources/helpbg.png"));
	        		    } catch (IOException ex) {
	        		        ex.printStackTrace();
	        		    }
	        		}
	        		g2.drawImage(background, 0, 0, null);
				}
	        };
	        
	        add(background);
	        
	        JButton back = new JButton("Tagasi");

	        back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
	        });
	        
	        JLabel text = new JLabel("<html>Mängu eesmärk on paigutada kolm sama värvi ketast"
	        		+ "<br>horisontaalselt, vertikaalselt või diagonaalselt ritta.<br>"
	        		+ "<br>Mängijad valivad kumb on punane ja kumb on kollane.<br>"
	        		+ "<br>Mängijad teevad käike kordamööda.<br>"
	        		+ "<br>Ketaid kukutataks ülevalt alla.<br>"
	        		+ "<br>Rida kust ketast soovitakse kukkutada, valitakse"
	        		+ "<br>veeru kohal oleva nuppu abil.</html>", SwingConstants.CENTER);
	        text.setForeground(Color.white);
	        text.setAlignmentX(Component.CENTER_ALIGNMENT);
	        back.setAlignmentX(Component.CENTER_ALIGNMENT);
	        background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
	        background.add(Box.createVerticalGlue());
	        background.add(Box.createVerticalGlue());
	        background.add(text);
	        background.add(Box.createVerticalGlue());
	        background.add(Box.createVerticalGlue());
	        background.add(back);
	        background.add(Box.createVerticalGlue());
	        
			setSize(350, 350);
	        setResizable(false);
	        setLocationRelativeTo(null);
		}
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Connect Four");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setIconImage(icon.getImage());
		
		JPanel menu = new JPanel() {
        	protected void paintComponent (Graphics g) {
        		Graphics2D g2 = (Graphics2D) g;
        		BufferedImage background = null; {
        			try {
        				background = ImageIO.read(new File("resources/startbg.png"));
        		    } catch (IOException ex) {
        		        ex.printStackTrace();
        		    }
        		}
        		g2.drawImage(background, 0, 0, null);
			}
        };
		
		window.add(menu);
		
		JButton start = new JButton("Alusta mängu");
		JButton help = new JButton("Õpetus");
		JButton exit = new JButton("Välju");
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		help.setAlignmentX(Component.CENTER_ALIGNMENT);
		exit.setAlignmentX(Component.CENTER_ALIGNMENT);
		menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
		menu.add(Box.createVerticalGlue());
		menu.add(Box.createVerticalGlue());
		menu.add(Box.createVerticalGlue());
		menu.add(Box.createVerticalGlue());
		menu.add(start);
		menu.add(Box.createVerticalGlue());
		menu.add(help);
		menu.add(Box.createVerticalGlue());
		menu.add(exit);
		menu.add(Box.createVerticalGlue());
		
		
		ActionListener listener = (new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == start) {
					Connect_Four game = new Connect_Four();
					game.addWindowListener(new WindowListener() {
						public void windowOpened(WindowEvent e) {
							start.setVisible(false);
						} public void windowClosed(WindowEvent e) {
							start.setVisible(true);
							click = false;
						} public void windowActivated(WindowEvent e) {
						} public void windowClosing(WindowEvent e) {
						} public void windowDeactivated(WindowEvent e) {
						} public void windowDeiconified(WindowEvent e) {
						} public void windowIconified(WindowEvent e) {
						}
					});
					if(click == false) {
						game.setVisible(true);
						click = true;
					}
				} if(e.getSource() == help) {
					helpw helpmenu = new helpw();
					helpmenu.addWindowListener(new WindowListener() {
						public void windowOpened(WindowEvent e) {
							help.setVisible(false);
						} public void windowClosed(WindowEvent e) {
							help.setVisible(true);
							click2 = false;
						} public void windowActivated(WindowEvent e) {
						} public void windowClosing(WindowEvent e) {
						} public void windowDeactivated(WindowEvent e) {
						} public void windowDeiconified(WindowEvent e) {
						} public void windowIconified(WindowEvent e) {
						}
					});
					if(click2 == false) {
						helpmenu.setVisible(true);
						click2 = true;
					}
				} if(e.getSource() == exit) {
					window.dispose();
				}
			}
		});
		start.addActionListener(listener);
		help.addActionListener(listener);
		exit.addActionListener(listener);
		
		window.setSize(200, 300);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}