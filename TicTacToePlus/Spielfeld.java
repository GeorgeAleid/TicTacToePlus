package TicTacToePlus;

public class Spielfeld {
	private Player player;
	private String array[][];

	public Spielfeld(Player player1, Player player2) {
		this.player = player1;
		this.player = player2;
		this.array = new String[3][3];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				array[i][j] = "  ";

			}
		}
	}

	public void druckSpielfeld() {
		System.out.println("  |   1|   2|   3|");
		for (int i = 0; i < array.length; i++) {
			System.out.println("--+----+----+----+");
			System.out.print(" " + (i + 1) + "|");
			for (int j = 0; j < array[0].length; j++) {
				System.out.print("  ");
				System.out.print(array[i][j]);
				System.out.print("|");
			}
			System.out.println();

		}
		System.out.println("--+----+----+----+");
	}

	public boolean zug(int z, int s, String a, Player p) {
		z = z - 1;
		s = s - 1;
		String array1[] = p.getArray();
		String f = array[z][s];
		int n1;
		if (!array[z][s].equals("  ")) {
			n1 = (int) f.charAt(1);
		} else {
			n1 = 0;
		}
		int n = (int) a.charAt(1);

		if (z >= 0 && z < array.length && s >= 0 && s < array[0].length) {
			// gibt es Stein in player array
			for (int i = 0; i < array1.length; i++) {
				if (array1[i].equals(a)) {
					// leer oder größer
					if (array[z][s].equals("  ") || n > n1) {
						return true;
					}
				}
			}

		}
		return false;
	}

	public void spiel(int z, int s, String a, Player p) {
		String array1[] = p.getArray();
		if (zug(z, s, a, p)) {
			z=z-1;
			s=s-1;
			
			array[z ][s ] = a;
			for (int i = 0; i < array1.length; i++) {
				if (array1[i].equals(a)) {
					array1[i] = "  ";
					break;
				}
			}
			p.setArray(array1);
		}
	}

	public boolean win() {
		

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (!array[i][j].equals("  ")) {
					String f = array[i][j];
					char k = f.charAt(0);

					// vertical
					if (i + 2 < array.length && !array[i][j].equals("  ")) {
						int counter = 0;
						for (int x = i; x < array.length; x++) {
							char l = array[x][j].charAt(0);
							
							if (l == k) {
								
								counter++;
								if (counter == 3) {
									return true;
								}
							} else {
								break;
							}
						}
					}
					if (j + 2 < array[0].length && !array[i][j].equals("  ")) {
						int counter = 0;
						for (int x = j; x < array[0].length; x++) {
							char l = array[i][x].charAt(0);
							if (l == k) {
								counter++;
								if (counter == 3) {
									return true;
								}
							} else {
								break;
							}
						}
					}
					if ((array[0][0].charAt(0) == k && array[1][1].charAt(0) == k && array[2][2].charAt(0) == k)
							|| (array[0][2].charAt(0) == k && array[1][1].charAt(0) == k
									&& array[2][0].charAt(0) == k)) {
						return true;
					}
				}

			}
		}
		return false;
	}

}
