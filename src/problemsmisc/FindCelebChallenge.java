package problemsmisc;

import dataStructures.Stack;
class FindCelebChallenge {
    public static int findCelebrity(int[][] party, int numPeople) {
        int celebrity = -1;
        Stack<Integer> stack = new Stack(numPeople);
        for(int i=0;i<numPeople;i++){
            stack.push(i);
        }
        while(!stack.isEmpty()&& stack.getCurrentSize()>1){
            //pop first two and check if first knows second or second knows first and discard the one who knows other
            int firstPerson = stack.pop();
            int secondPerson = stack.pop();
            if(party[firstPerson][secondPerson]==0 && party[secondPerson][firstPerson]==0 ){ // both can not be 0
                //in order to be a celibrity one of the two should know each other
                return celebrity;
            }else if(party[firstPerson][secondPerson]==1){
                stack.push(secondPerson);
            }else if(party[secondPerson][firstPerson]==1){
                stack.push(firstPerson);
            }



        }
        return stack.pop();
    }
    public static void main(String[] args){
        int[][] party = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,0},
                {0,1,1,0},
        };
        int numPeople =4;
        int celebrity = findCelebrity(party, 4);
        System.out.println("celebrity is::"+ celebrity);
    }
}