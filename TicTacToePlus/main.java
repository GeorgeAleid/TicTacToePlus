package TicTacToePlus;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arrayP1[] = { "x0", "x0", "x1", "x1", "x2", "x2" };
		String arrayP2[] = { "o0", "o0", "o1", "o1", "o2", "o2" };
		Player p1 = new Player('x', arrayP1);
		Player p2 = new Player('o', arrayP2);
		Spielfeld sp = new Spielfeld(p1, p2);
		boolean player = true;
		sp.druckSpielfeld();
		do {
			if (player) {
				System.out.println("Zeile?");
				int z = sc.nextInt();
				System.out.println("Spalte?");
				int s = sc.nextInt();
				System.out.println("x0 oder x1 oder x2");
				String st =sc.next();
				if(sp.zug(z, s, st, p1)){
					sp.spiel(z, s, st, p1);
					player=false;
					sp.druckSpielfeld();
				}
			
				
			}
			else {
				System.out.println("Zeile?");
				int z = sc.nextInt();
				System.out.println("Spalte?");
				int s = sc.nextInt();
				System.out.println("o0 oder o1 oder o2");
				String st =sc.next();
				if(sp.zug(z, s, st, p2)){
					sp.spiel(z, s, st, p2);
					player=true;
					sp.druckSpielfeld();
				}
			}
			

		} while (!sp.win());
		if(player) {
			System.out.println("Spieler O hat gewonnen");
		}
		else System.out.println("Spieler X hat gewonnen");
	}

}
