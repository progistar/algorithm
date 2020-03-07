package codejam.code;

import java.util.*;

public class ValidBrackets
{
	static Map<Character, Integer> map = new HashMap<Character, Integer>();
	static ArrayList<Character> stack = new ArrayList<Character>();
    
    public static void main(String[] args) {
        System.out.println(ValidBrackets.isValid("[{()}]"));
    }

    public static boolean isValid(String s) {
        char[] array = s.toCharArray();
        map.put(')', 1); map.put('}', 2); map.put(']', 3);
        for (int i=0; i<array.length; i++) {
            if (stack.size() == 0) {
                if (array[i] == ')' || 
                   array[i] == '}' || 
                   array[i] == ']') {
                    return false;
                }
                stack.add(array[i]);
                continue;
            }
            
            char prevBracket = stack.get(stack.size() - 1);
            char currentBracket = array[i];
            if (!validate(prevBracket, currentBracket)) {
                return false;
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean validate(char prev, char next) {
        if (map.get(next) == null){
            stack.add(next);
            return true;
        } else {
            int type = map.get(next);
            switch (type) {
                case 1:
                    if(prev == '(') {
                        stack.remove(stack.size()-1);
                        return true;
                    }
                        
                    break;
                case 2:
                    if(prev == '{'){
                        stack.remove(stack.size()-1);
                        return true;
                    }
                    break;
                case 3:
                    if(prev == '['){
                        stack.remove(stack.size()-1);
                        return true;
                    }
                    break;
                default:
                    System.out.println("error");
            }
        }
        return false;
    }
}
