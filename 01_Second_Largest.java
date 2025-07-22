class Solution {
    public int getSecondLargest(int[] arr) {
     
     int max=Integer.MIN_VALUE;
     int max2=max;
     
     for (int i=0;i<arr.length;i++)
     {
     if(arr[i]>max)
     {
      max2=max;
      max=arr[i];
     }
     else if(arr[i]<max && arr[i]>max2)
     max2=arr[i];
     }
     
     if (max2==max || max2==Integer.MIN_VALUE)
     return -1;
     return max2;
        
    }
}