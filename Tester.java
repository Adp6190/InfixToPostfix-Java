package InfixToPostFix;

import java.util.Scanner;

 class Stack {
	private int size;
	private int[] arr;
	private int top;

	public Stack() { // default ctor for Stack class
		size = 5;
		arr = new int[size];
		top = -1;
	}

	public Stack(int s) {
		size = s;
		arr = new int[size];
		top = -1;
	}

	public boolean isFull() {
		return top == size - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int val) throws Exception {
		if (!isFull())
			arr[++top] = val;
		else
			throw new Exception("overflow");
	}

	public int pop() throws Exception {
		if (!isEmpty())
			return arr[top--];
		else
			throw new Exception("Underflow");
	}
	public int peep() throws Exception {
		if (!isEmpty())
			return arr[top];
		else
			throw new Exception("Underflow");
	}
	

	 
	 

	static String infixToPostfix(String exp) {
		String result = new String("");

		return result;
	}

}

public class Tester {
	
	public static int findprecedence(char ch){
		switch (ch) {
		case '^':
		return 3;
		case '*':
		case '/':
		return 2;
		case '+':
		case '-':
		return 1;
		}
		return -1;
	
		}
	


	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		Stack s1 = new Stack(100);
		System.out.println("Enter paranthesized Expression to convert from infix to postfix");
		char [] infix=new char[100];
		char [] postfix =new char[50];

		infix=(sc.next()).toCharArray();
	
		int i=0,j=0;
		for(char c:infix) {
			if(c=='(') {
				s1.push(c);
			}
			else if(c>='a' && c<='z'){
				postfix[j++]=c;					//for each will iterate and it will store in next mem location
			}
			else if(c=='+' || c=='-' || c== '*' || c=='/'){
			
				while(s1.peep()=='+'|| s1.peep()=='-' || s1.peep()=='*' || s1.peep()=='/') {
					if(findprecedence((char)s1.peep())>=findprecedence(c))
					{
						postfix[j++]=(char)s1.pop();
					}
					else 
						break;
				}
				s1.push(c);
			}
			else if(c==')') 
			{
				while((c=(char)s1.pop())!='(')
				{
				postfix[j++]=c;	
				}
			}
			
			
		}

		System.out.println("Postfix form of given infix: " + String.valueOf(postfix));
		

	}

}
