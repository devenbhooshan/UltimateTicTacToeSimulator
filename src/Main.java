import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main extends  JFrame{
	public static String filename[]=new String[2];
	public static JPanel game_panel[]=new JPanel[82];
	public static JLabel game_jLabel[]=new JLabel[82];
	public static JLabel message=new JLabel("Hey Output Here ");
	public Main() throws IOException, InterruptedException{
		setTiles();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PCLUB");
		setSize(1000,650);
		setLocation(100, 0);
		setVisible(true);
		setResizable(false);
		
	}

	private void setTiles() {
		JPanel tiles=new JPanel(new GridLayout(9,9));
		
		for (int i = 1 ;i <= 81; i++) {
			game_panel[i]=new JPanel();
			game_jLabel[i]=new JLabel();
			game_panel[i].setBorder(BorderFactory.createLineBorder(Color.black));
			game_panel[i].setPreferredSize(new Dimension(90, 65));
			game_panel[i].add(game_jLabel[i]);
			tiles.add(game_panel[i]);
			add(message,"East");
		}
		add(tiles);
		
	}

	public static String [] getPlayersFileNames(){

		return filename;
	}

}
