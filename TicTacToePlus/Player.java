package TicTacToePlus;

public class Player {
	private String array[];
	private  char zeichen;
	
	public Player( char zeichen ,String [] array) {
		this.array=array;
		this.zeichen=zeichen;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public char getZeichen() {
		return zeichen;
	}

	
}
