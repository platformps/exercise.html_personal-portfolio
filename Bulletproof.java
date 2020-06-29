/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package bulletproof;
import java.util.Scanner;
/**
 * PROGRAM: Bulletproof Hands-On Test
 * PURPOSE: To test proficiency in Java coding
 * and to have user enter two numbers and choose 
 * a mathematical operator and have that operation performed
 * BY: DAVID YIRCHOTT
 * FOR: MR. THOMAS
 * @author David
 */
public class Bulletproof {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**set up keyboard as input */    
        Scanner kb = new Scanner(System.in);
        boolean error = false; 
        double Num1 = 0, Num2 = 0;
        
        /**
         * Setup a do-while loop to re-ask for input after invalidation.
         * It is set up to do while error == true
         */        
        do{   
            /**Tell user how this is going to work */
            System.out.println("Please input the first of two numbers, then you will be asked to enter an operator (+, -, *, /)");
            System.out.println("Alternately, enter both numbers now separated by a space\n");
            /**create string from next keyboard input*/
            String number1 = kb.next();
            /* set/reset boolean flag for controlling error message overflow and controlling do-while loop*/
            error = false;
            int decimals = 0; //used to count decimal points below

            /** Test for digits and decimals -- each item is retrieved from the String as a char             
             * first, check for multiple decimal points
             * go char by char through number1, for each '.' increment decimals accumulator, if there are
             * at least two, make error = true. If error == true, display too many decimals
             * message once.
             */
             for (int i=0; i < number1.length(); i++){
                 if (number1.charAt(i) == '.'){
                     decimals++;
                        if(decimals == 2){
                           error = true;
                        }
                }
            }

            if (error == true){
                 System.out.println("\nERROR: Too many decimals in your first number");

            }

               /**
                * Check to see if a negative number was entered by checking if the first char is a '-'. If so, change the 
                * search parameters from z=0 to z=1. 
                * 
                * Then prevent letters and other characters from showing up
                * Similar to above, go char by char to check string number1. If a char is not a digit
                * and is not a decimal point (we've already checked for too many of those above)
                * then display error message and pinpoint the position number of the incorrect 
                * character within the string, starting from the far left. If an error is found, 
                * set error = true to prevent the string from being parsed in the next step.
                */ 

            if(number1.charAt(0) == '-' || number1.charAt(0) == '+'){ //if the first character is a negative or positive sign don't check it
              for(int z = 1; z < number1.length(); z++) { //check all other characters for validity
                if (!Character.isDigit(number1.charAt(z)) && (number1.charAt(z)) != '.') {

                    System.out.println("\nERROR:  Character " + (z + 1) + " in your first entry is not a digit or decimal.");
                    error = true;
                }
            }  
                
                
            }
            else{ //if the first character is not a negative or positive sign
               for(int z = 0; z < number1.length(); z++) { //check all characters for validity
                if (!Character.isDigit(number1.charAt(z)) && (number1.charAt(z)) != '.') { 

                    System.out.println("\nERROR:  Character " + (z + 1) + " in your first entry is not a digit or decimal.");
                    error = true;
                }
            }

            }
               /**If error == false then convert the string to a double named Num1 and 
                * display confirmation to the user
               */

            if(error == false){
                Num1 = Double.parseDouble(number1);

                System.out.println("Thank you!"); //The first number is " + Num1); 

            }
               //otherwise, please try again
                else {
                    System.out.println("Please try again\n");
                }

        }while(error == true);// If there is an error, restart the do-while loop
        
        /**
         * Set up another do-while loop for the second number to re-ask for input after invalidation
         * This one is also set up as do while error == true
         */
        
        do{            
            /**Tell user how this is going to work */
            System.out.println("\nYour first number is " + Num1 +". Please input the second number, then you will be asked to enter an operator (+, -, *, /)");    
        
            /**create string from next keyboard input*/
            String number2 = kb.next();
           /**reset error flag inside loop for string number2 for controlling 
            * error message overflow and controlling do-while loop*/
            error = false;
            int decimals = 0; //used to count decimal points below


              /** Test for digits and decimals -- As above, each item is retrieved from the String as a char             
             * first, check for multiple decimal points
             * go char by char through number2, for each '.' increment decimals accumulator, if there are
             * at least two, make error = true. If error == true, display too many decimals
             * message once.
             */
            for (int j=0; j < number2.length(); j++){
                if (number2.charAt(j) == '.'){
                    decimals++;
                        if(decimals == 2){
                           error = true;
                        }
                }
            }

            if (error == true){
                System.out.println("\nERROR: Too many decimals in your second number");

            }


            /* Check to see if a negative number was entered by checking if the first char is a '-'. If so, change the 
                * search parameters from n=0 to n=1. 
                * 
                * Then prevent letters and other characters from showing up
                * Similar to above, go char by char to check string number1. If a char is not a digit
                * and is not a decimal point (we've already checked for too many of those above)
                * then display error message and pinpoint the position number of the incorrect 
                * character within the string, starting from the far left. If an error is found, 
                * set error = true to prevent the string from being parsed in the next step.
                */ 

            if(number2.charAt(0) == '-' || number2.charAt(0) == '+'){ //if the first character is a negative or positive sign don't check it
                for(int n = 1; n < number2.length(); n++) { //check all other characters for validity
                    if (!Character.isDigit(number2.charAt(n)) && (number2.charAt(n)) != '.') {

                        System.out.println("\nERROR:  Character " + (n + 1) + " in your second entry is not a digit or decimal.");
                        error = true;
                    }
                }  


            }
            else{ //if the first character is not a negative or positive sign
                for(int n = 0; n < number2.length(); n++) { //check all characters for validity
                    if (!Character.isDigit(number2.charAt(n)) && (number2.charAt(n)) != '.') {

                        System.out.println("\nERROR:  Character " + (n + 1) + " in your second entry is not a digit or decimal.");
                        error = true;
                    }
                }

            }    
               /**If error == false then convert the string to a double named Num2 and
                * display confirmation to the user
               */          

            if(error == false){
                Num2 = Double.parseDouble(number2);

                System.out.println("\nThank you! Your first number is " + Num1 + " and your second number is " + Num2 + ".");         
            }
                else {  //otherwise, please try again
                    System.out.println("Please try again");
                }


        }while(error == true); //If there is an error, restart the do=while loop

        /**
         * A switch statement for selecting a mathematical operator is next.
         *Display instructions and accept input into variable then run through switch statement
         * repeat if necessary. do while error == true
         */
        
        do{
            System.out.println("\nPlease select one of the following operators: +, -, *, /");
            error = false;
            char operator = kb.next().charAt(0);
            
            /**Added printf and %f formatting below. This keeps the results more predictable and accurate. The answers will stretch 6 spaces 
             * after the decimal point before rounding, if necessary. The numbers before the decimal will automatically
             * fit in that space.    
             * The SWITCH statement allows for distinct choices of operators. Anything that doesn't match falls through to the default, 
             * which re-runs the do-while loop (asking for the user to choose an operator) after an error message.
             */

            switch (operator)
            {
                case '+': 
                    System.out.printf("\nYou selected '+'. " + Num1 + " + " + Num2 + " = %f \n",(Num1 + Num2));
                    break;

                case '-': 
                    System.out.printf("\nYou selected '-'. " + Num1 + " - " + Num2 + " = %f \n",(Num1 - Num2));
                    break;

                case '*': 
                    System.out.printf("\nYou selected '*'. " + Num1 + " * " + Num2 + " = %f \n",(Num1 * Num2));
                    break;

                case '/': 
                    System.out.printf("\nYou selected '/'. " + Num1 + " / " + Num2 + " = %f \n",(Num1 / Num2));
                    break;

                 default:
                    System.out.println("\nYou selected an invalid character");
                    error = true;
                    break;   
            }
        
        }while(error == true);
    
}
}