public class towerofHanoi {
    public static void towerofHanoifunction(int n,String src,String helper,String dest) {
        if(n == 1) {
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        towerofHanoifunction(n-1, src, dest, helper);
        System.out.println("transfer disk " + n + " from " + src + " to " + dest);
        towerofHanoifunction(n-1, helper, src, dest);
    }
    public static void main(String[] args) {
        int n = 3;
        towerofHanoifunction(n,"S", "H", "D");
    }
}

//  --INPUT-- 
    
//         ---|---                    |                         |           
//        | 1 | 1 |                   |                         |           
//         ---|---                    |                         |           
//      ------|------                 |                         |           
//     |   2  |  2   |                |                         |           
//      ------|------                 |                         |           
//   ---------|---------              |                         |           
//  |    3    |    3    |             |                         |           
//   ---------|---------              |                         |           
//____________|_______________________|_________________________|_____________


//  --OUTPUT--

//            |                       |                      ---|---       
//            |                       |                     | 1 | 1 |      
//            |                       |                      ---|---       
//            |                       |                   ------|------
//            |                       |                  |   2  |  2   |
//            |                       |                   ------|------      
//            |                       |                ---------|--------- 
//            |                       |               |    3    |    3    |
//            |                       |                ---------|--------- 
//____________|_______________________|_________________________|__________
