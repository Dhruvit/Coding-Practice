import java.util.Scanner;

/*
 * Optimal operation of Add1 and Multiple2 required for target number
 */
public class Solution3 {

	public static void main(String args[]){
		System.out.println("Optimal number of Add1 and Multiple2 required for target number");
		System.out.println("Enter target : ");
		
		Scanner scan = new Scanner(System.in);
		int step = 0;
		
		int target = scan.nextInt();
		while( target != 1){
             if( target%2 == 1 ){ // Add1
                 target = target - 1;
                 step ++;
             }else if( target%2 == 0){ // Multiply2
                 target = target/2;
                 step ++;
             }    
        } 
		step++;
		System.out.println("number of step : "+step);
		scan.close();		
	}
}
