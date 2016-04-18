
import java.util.ArrayList;

public class Stack {

	private ArrayList<LetterEmailPair> stack;

	public Stack(){

		stack = new ArrayList<LetterEmailPair>();
	}

	public void push(LetterEmailPair element){
		stack.add(element);
	}

	public LetterEmailPair pop(){
		if (!isEmpty())
			return stack.remove(size()-1);
		else
			throw new StackEmptyException();
	}

	public boolean isEmpty(){
		return stack.size() == 0;
	}

	public int size(){
		return stack.size();
	}

	public LetterEmailPair peek(){
		if(!isEmpty())
			return stack.get(size()-1);
		else
			throw new StackEmptyException();
	}
	
	public String getEmail(int index)
	{
		return stack.get(index).getEmail();
	}
	
	public String getLetter(int index)
	{
		return stack.get(index).getLetter();
	}

	public String toString(){
		return stack.toString();
	}
}
