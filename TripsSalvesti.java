import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TripsSalvesti implements Tripsuliides {
    private char[][] spots = new char[3][3];
    private char[] symbls = {'X', '0'};
    private char whosTurn = 'X';

    public TripsSalvesti(String... input) throws Exception {
        if (input.length != 0){
            quicksaveToFile(input[0]);
        }
    }

    public void alusta(char symbol) {
        if (new String(symbls).indexOf(symbol) == -1) { // https://stackoverflow.com/a/18581539
            throw new IllegalArgumentException("See sümbol ei sobi!");
        }
        whosTurn = symbol;
    }
	
	public char kelleKord() {
		return whosTurn;
	}
	
    public void paiguta(char symbol, int rida, int veerg) throws Exception {
		loadFromFile();
		
        if (kelleKord() == symbol){
            spots[rida][veerg] = symbol;
        }
        else {
            throw new IllegalArgumentException("Pole selle sümboli kord!");
        }

        if (kelleKord() == symbls[0]){
            whosTurn = symbls[1];
        }
        else if (kelleKord() == symbls[1]) {
            whosTurn = symbls[0];
        }
		saveToFile();
    }
	
    public char kysi(int rida, int veerg) {
        return spots[rida][veerg];
    }
	
    public boolean kontrolliVoitu() throws Exception {
		loadFromFile();
        boolean isDone = false;

        for (char c : symbls) {
            if ((kysi(0, 0) == c && kysi(1, 0) == c && kysi(2, 0) == c) || // ülevalt alla 1 tulp
                    (kysi(0, 1) == c && kysi(1, 1) == c && kysi(2, 1) == c) || // ülevalt alla 2 tulp
                    (kysi(0, 2) == c && kysi(1, 2) == c && kysi(2, 2) == c) || // ülevalt alla 3 tulp
                    (kysi(0, 0) == c && kysi(1, 1) == c && kysi(2, 2) == c) || // ülevalt vasakult alla paremale
                    (kysi(0, 2) == c && kysi(1, 1) == c && kysi(2, 0) == c) || // ülevalt paremalt alla vasakule
                    (kysi(0, 0) == c && kysi(0, 1) == c && kysi(0, 2) == c) || // 1. rida
                    (kysi(1, 0) == c && kysi(1, 1) == c && kysi(1, 2) == c) || // 2. rida
                    (kysi(2, 0) == c && kysi(2, 1) == c && kysi(2, 2) == c)) { // 2. rida
                isDone = true;
                System.out.println("Võitis [" + c + "]");
                break;
            }
        }

        return isDone;
    }
	
    public void quicksaveToFile(String input) throws Exception {
        for (int i = 0; i < input.length(); i++){
			int row = 0;
			int column = 0;
			if(i >= 3 && i <= 5) {
				row = 1;
			} else if(i > 5) {
				row = 2;
			}
			if(i == 1 || i == 4 || i == 7) {
				column = 1;
			} else if(i == 2 || i == 5 || i == 8) {
				column = 2;
			}
            spots[row][column] = input.charAt(i);
        }

        saveToFile();
    }

    public void loadFromFile() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"));
        String row = bufferedReader.readLine();

        while (row != null) {
            System.out.println(row);

            for (int i = 0; i < row.length(); i++) {
				int r = 0;
				int column = 0;
				if(i >= 3 && i <= 5) {
					r = 1;
				} else if(i > 5) {
					r = 2;
				}
				if(i == 1 || i == 4 || i == 7) {
					column = 1;
				} else if(i == 2 || i == 5 || i == 8) {
					column = 2;
				}
				
                if (row.charAt(i) == 'X' || row.charAt(i) == '0'){
                    //spots[i] = row.charAt(i);
					spots[r][column] = row.charAt(i);
                } else if (row.charAt(i) == ' '){
                    //spots[i] = '_';
					spots[r][column] = '_';
                }
            }
            row = bufferedReader.readLine();
        }
    }

    public void saveToFile() throws Exception {
        PrintWriter writer = new PrintWriter(new FileWriter("file.txt"));

        for (int i = 0; i < 3; i++){
			for (int ii = 0; ii < 3; ii++){
				if (spots[i][ii] == '_'){
					writer.print(' ');
				} else {
					writer.print(spots[i][ii]);
				}
			}
        }

        writer.close();
    }
}
