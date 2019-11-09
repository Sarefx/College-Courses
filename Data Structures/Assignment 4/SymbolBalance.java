
public class SymbolBalance {

	public static void main(String[] args) {
		String code = "{asdgfdghdfghdnv54q54[bfghbdytsrtb2twergstgbv(345t2345)}]";
		System.out.println(balanced(code));
	}
	public static boolean balanced(String c)
	{
		MyStack<Character> brackets = new MyStack<>();
		for(int i = 0; i < c.length(); i++)
		{
			switch(c.charAt(i))
			{
			case '[':
			case '{':
			case '(':
				brackets.push(c.charAt(i));
				break;
			case ']':
				if(brackets.pop() != '[')
					return false;
				break;
			case '}':
				if(brackets.pop() != '{')
					return false;
				break;
			case ')':
				if(brackets.pop() != '(')
					return false;
				break;
			}
		}
		if(brackets.top() == null)
			return true;
		return false;
	}
}
