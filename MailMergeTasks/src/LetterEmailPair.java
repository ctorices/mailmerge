
public class LetterEmailPair {
	
	private final String letter;
	private final String email;
	
	public LetterEmailPair (String letter, String email){
		this.letter = letter;
		this.email = email;
	}
	
	public String getLetter(){
		return letter;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String toString(){
		return "Email: " + email + " Letter: " + letter;
	}
	
}
