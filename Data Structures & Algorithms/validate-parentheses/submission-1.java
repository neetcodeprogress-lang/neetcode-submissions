class Solution {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();

        //while iterating through the string
        for (char c : s.toCharArray()) {
            //add the left parenthesis to the stack
            //if we encounter right parenthesis
                //compare right parenthesis with popped element
                //if doesn't match, return false
                //else keep going
            if (c == '(' || c == '[' || c == '{') {
                myStack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (myStack.isEmpty()) {
                    return false;
                }
                //compare
                char myChar = myStack.pop();
                if (c == ')') {
                    if (myChar != '(') {
                        return false;
                    }
                } else if (c == ']') {
                    if (myChar != '[') {
                        return false;
                    }
                } else if (c == '}') {
                    if (myChar != '{') {
                        return false;
                    }
                }
            }
        }

        return myStack.isEmpty();
    }
}
