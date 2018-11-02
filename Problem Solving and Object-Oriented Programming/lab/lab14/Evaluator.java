import java.util.*;
public class Evaluator implements Stack{
	private static class Node {
		public String value;
		public Node next;
	}
	private Node head = null;
	
	public Evaluator() { } //constructor, do something
	
	public void push (String value) {
		Node temp = new Node();
		temp.value = value;
		temp.next = head;
		head = temp;		
	}
	public String pop() {
		String value = null;
		if (isEmpty())
			System.out.println("Can't pop empty stack!");
		else {
			value = head.value;
			head = head.next;
		}
		return value;
	}
	public String top() {
		String value = null;
		if (isEmpty())
			System.out.println("No top on an empty stack!");
		else 
			value = head.value;					
		return value;
	}
	public boolean isEmpty() {
		return head == null;
	}
	
    public int evaluate (String expression) {  //static???
    	int result = 0;
    	for (int i = 0; i < expression.length(); i++) {
    		char term = expression.charAt(i);
    		if (term >= '0' && term <= '9')
    			push(Character.toString(term));
    		else {
    			int b = Integer.parseInt(pop());
    			int a = Integer.parseInt(pop());
    			switch(term) {
    			    case '+': push ( Integer.toString(a + b)); break;
    			    case '-': push ( Integer.toString(a - b)); break;
    			    case '*': push ( Integer.toString(a * b)); break;
    			    case '/': push ( Integer.toString(a / b)); break;
    			}
    		}
    	}
    	result = Integer.parseInt(top());
    	return result;
    }
    
    public static void main(String[] args) {
//    	Scanner in = new Scanner (System.in);
//    	String expression = in.nextLine();
//    	System.out.println(expression);
    	Evaluator eval = new Evaluator();
    	
    	System.out.println("The answer is: " + eval.evaluate("512+4*+3-"));
    	
//    	in.close();
    }
}
