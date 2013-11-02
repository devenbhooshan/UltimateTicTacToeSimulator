import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Simulator {

	static Main GUI;
	static int game[]=new int[82];
	static String player1outputfile="output1";
	static String player2outputfile="output2";
	static String boardFileName="boardFile"; //provide this filename to players
	static String player1bashFile="./player1.sh";
	static String player2bashFile="./player2.sh";
	static int playersChance=1;
	public static void main(String args[]) throws IOException, InterruptedException{
		GUI=new Main();
		startGame();
	}
	
	public static void startGame() throws IOException, InterruptedException{
		
		int previous=1;
		while(true){
			changeBoardTextFile();
			int move=getMove();
			//System.out.println("Player "+playersChance+" move:"+move);
			if(game[move]!=0){
				Main.message.setText("Player "+Integer.toString(playersChance)+" Lost. Wrong Move");
				System.out.println("Player "+Integer.toString(playersChance)+" Lost. Wrong Move");
				break;
			}
			else if(isValidMove(move,previous)){
				game[move]=playersChance;
				if(isWinner()){ 
					Main.message.setText("Player "+Integer.toString(playersChance)+" Win");
					break;
					  
				}else if(isGameFinished()){
					Main.message.setText("Match Draw");
					break;
				}
				else{
					playersChance=playersChance==1?2:1;
					previous=move;

				}
			}else {
				Main.message.setText("Player "+Integer.toString(playersChance)+" Loose");
				break;
			}

		}

	}

	private static int getMove() {
		int move;
		if(playersChance==1)
			move=first_player_move();
		else move=second_player_move(); 
		return move;
	}

	private static int first_player_move(){
		int move=0;
		try {
			Process process=Runtime.getRuntime().exec(player1bashFile);
			process.waitFor();
			BufferedReader in=new BufferedReader(new FileReader(player1outputfile));
			move=Integer.parseInt(in.readLine());
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return move;
	}
	
	private static int second_player_move(){
		int move=0;
		try {
			Process process=Runtime.getRuntime().exec(player2bashFile);
			process.waitFor();
			BufferedReader in=new BufferedReader(new FileReader(player2outputfile));
			move=Integer.parseInt(in.readLine());
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		return move;
	}
	
	private static boolean isGameFinished() {
		int i=1;
		while(i<game.length){
			if(game[i]==0) return false;
			i++;
		}
		return true;
	}


	private static boolean isWinner() {
		return false;
	}


	private static void changeBoardTextFile() throws IOException {
		FileWriter boardout=new FileWriter(boardFileName);
		BufferedWriter bw = new BufferedWriter(boardout);
		int i=1;
		while(i<game.length){
			try {
				bw.write(Integer.toString(game[i])+" ");
				if(i%9==0) bw.write("\n");	
				i++;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}

		}
		changeBoard();
		bw.close();

	}

	private static void changeBoard() {
		for (int i = 1 ;i <= 81; i++) {
			if(game[i]!=0)
				Main.game_jLabel[i].setText(Integer.toString(game[i]));
		}
	}


	private static boolean isValidMove(int move, int previous) {

		return true;
	}




}
