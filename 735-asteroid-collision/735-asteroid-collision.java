class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack <Integer> stack = new Stack();
        
        for(int ast:asteroids){
            collision: {
                while(!stack.isEmpty() && ast < 0 && 0< stack.peek()){
                    if(stack.peek() < -ast){
//                         peek gets destroyed bitch;
                        stack.pop();
                        continue;
                    }
                    else if(stack.peek()== -ast){
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }
        
        int a[] = new int [stack.size()];
        for(int i=a.length-1;i>=0;i--){
            a[i]=stack.pop();
        }
        return a;
        
    }
}