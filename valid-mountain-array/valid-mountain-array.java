class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n<=2) return false;
        int i=0;
        boolean inc= false, dec=false;
        while(i< n-1 && arr[i]<arr[i+1]) {
            i++;
            inc = true;
        }
        while(i < n-1 && arr[i]>arr[i+1]) {
            if(!inc) return false;
            i++;
            dec = true;
        }
        if(!inc || !dec || i< n-1) return false;
        return true;
    }
}