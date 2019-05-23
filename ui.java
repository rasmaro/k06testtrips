import java.util.Scanner;

public class ui {

	public static void main(String[] args) {
		Trips tripsArr = new Trips();
		Scanner s = new Scanner(System.in);
		System.out.println("TRIPS-TRAPS-TRULL");
		
		while(!tripsArr.kontrolliVoitu()) {
			render(tripsArr);
			System.out.println("__________________________");
			System.out.println("SINU KORD: "+tripsArr.kelleKord());
			System.out.print("Sisesta mitmendale reale soovid panna (1-3):");
			int rida = s.nextInt();
			System.out.print("Sisesta mitmendale veerule soovid panna (1-3):");
			int veerg = s.nextInt();
			rida -= 1;
			veerg -= 1;
			char currentSpotSymbol = tripsArr.kysi(rida, veerg);
			
			if(rida >= 0 && rida <= 2 && veerg >= 0 && veerg <= 2) { // checkime et oleks mõõtmetes ja asukohas poleks juba mingit sümbolit.
				if(currentSpotSymbol != 'X' && currentSpotSymbol != '0') {
					System.out.println("Paigutasid kohale ["+(rida+1)+":"+(veerg+1)+"] sümboli ["+tripsArr.kelleKord()+"]");
					tripsArr.paiguta(tripsArr.kelleKord(), rida, veerg);
				} else {
					System.out.println("Sellises asukohas oli juba keegi ees.");
				}
			} else {
				System.out.println("Sisestasid liiga väiksed või suured arvud.");
			}
		}
		render(tripsArr);
	}
	
	public static void render(Trips trips) {
		char[] spots = new char[9];
		spots[0] = trips.kysi(0,0);
		spots[1] = trips.kysi(0,1);
		spots[2] = trips.kysi(0,2);
		spots[3] = trips.kysi(1,0);
		spots[4] = trips.kysi(1,1);
		spots[5] = trips.kysi(1,2);
		spots[6] = trips.kysi(2,0);
		spots[7] = trips.kysi(2,1);
		spots[8] = trips.kysi(2,2);
		
		for(int i = 0; i < spots.length; i++) {
			if(spots[i] != 'X' && spots[i] != '0') {
				spots[i] = '_';
			}
		}
		
		System.out.println(spots[0]+" "+spots[1]+" "+spots[2]);
		System.out.println(spots[3]+" "+spots[4]+" "+spots[5]);
		System.out.println(spots[6]+" "+spots[7]+" "+spots[8]);
	}
}