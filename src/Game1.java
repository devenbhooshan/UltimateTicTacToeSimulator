import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Game1 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader file=new BufferedReader(new FileReader("boardFile"));
		String s;
		int count=0;
		while((s=file.readLine())!=null){
			
			String board[]=s.split(" ");
			int i=0;
			while(i<board.length){
				count++;
				
				if(board[i].equals("0")){
						
					System.out.println(count);
							}
				i++;
			}
		}

	}

}
