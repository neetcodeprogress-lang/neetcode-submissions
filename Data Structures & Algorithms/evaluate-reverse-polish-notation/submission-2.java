class Solution {
    public int evalRPN(String[] tokens) {
        //create stack
        Stack<Integer> myStack = new Stack<>();
        //create computationVar
        int computationVar = 0;
        int tempVar = 0;
        int tempVar2 = 0;

        for(String s : tokens) {
            switch(s){
                case "+":
                    tempVar2 = myStack.pop();
                    tempVar = myStack.pop();
                    computationVar = tempVar + tempVar2;
                    myStack.push(computationVar);
                    break;
                case "/":
                    tempVar2 = myStack.pop();
                    tempVar = myStack.pop();
                    if (tempVar2 != 0){
                        computationVar = tempVar / tempVar2;
                    }
                    myStack.push(computationVar);
                    break;
                case "*":
                    tempVar2 = myStack.pop();
                    tempVar = myStack.pop();
                    computationVar = tempVar * tempVar2;
                    myStack.push(computationVar);
                    break;
                case "-":
                    tempVar2 = myStack.pop();
                    tempVar = myStack.pop();
                    computationVar = tempVar - tempVar2;
                    myStack.push(computationVar);
                    break;
                default: //if number add to stack
                    myStack.push(Integer.parseInt(s));
            }
        }        
            return myStack.pop();
    }
}
