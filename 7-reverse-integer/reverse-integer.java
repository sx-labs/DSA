class Solution {
    public int reverse(int x) {
        long rev = 0; // long rev cuz value can excced int so to handle it we have use long here
        while(x!=0) { //this is condition to handle negative no -123%10 = -3 not 3 so -3!=0 so loop will run that's why this will work
            int digit = x%10; 
            rev = rev*10 + digit;//to keep adding rev no we use this formula
            x = x/10;
        }
        if(rev>= -2147483648 && rev<= 2147483647) {
            return (int)rev; //if it is in range of int so we will typecast in int and return rev
        }
        else {
            return 0; //else we will return 0
        }
    }
}