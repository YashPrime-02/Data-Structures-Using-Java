import java.util.ArrayList;
import java.util.Collections;
// We are using Moore's Voting Algorithm two elements version
// to find all elements that appear more than n/3 times in the array.
// This algorithm works in O(n) time and O(1) space complexity.
class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // We are using Moore's Voting Algorithm two elements version
        
        int n=arr.length;
        if(n==0) return new ArrayList<>();
        
        int pivot1=0,pivot2=0, counter1=0,counter2=0;
        
        
// first check pass

for(int i:arr)
{
if( i==pivot1)
counter1++;
else if(i==pivot2)
counter2++;

else if(counter1==0)
{
pivot1=i;    
counter1=1;    
}
else if(counter2==0)
{
 pivot2=i;
 counter2=1;
}
 else
 {
  counter1--;
  counter2--;
 }
}


//pass 2


int count1=0, count2=0;

for(int i :arr)
{
 if(i==pivot1) count1++;
 
 else if(i==pivot2) count2++;
}

ArrayList<Integer> result =new ArrayList<>();
if(count1> n/3) result.add(pivot1);
if(count2>n/3) result.add(pivot2);
Collections.sort(result);
return(result);
}
    
}