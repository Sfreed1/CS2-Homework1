import java.util.Scanner;

public class ISBN {
    
    public static String isbn10(int num){
        int holder = num;
        int counter = 9;
        int mod;
        int total = 0;
        
        while(counter > 0){
            mod = num % 10;
            total += counter * mod;
            num = num / 10;
            counter--;
        }
        total = total % 11;
        
        //String str = Integer.toString(holder);

        if (total == 10){
            //str += 'X';
            String ten = "X";
            return ten;
        }else{
            //str += total;
            return Integer.toString(total);
        }
    }


    public static String isbn13(Long num){
        long holder = num;    //Do I need this?
        int counter = 12;
        long mod;
        int total = 0;
        
        while(counter > 0){
            mod = num % 10;
            if (counter % 2 == 0){
                total += (3 * mod);
            }else{
                total += mod;
            }
            num = num / 10;
            counter--;
        }

        total = total % 10;
        total = 10 - total;
        //String str = Long.toString(holder);

        if (total == 10){
            //str += 'X';
            String ten = "0";
            return ten;
        }else{
            //str += total;
            return Integer.toString(total);
        }
    }

    public static void main(String[] args) {
        //get first 9 digits of the ISBN
        Boolean valid = false;
        Scanner input = new Scanner(System.in);
            
        while (!valid){
            System.out.print("Enter a 9 or 12 digit ISBN: ");
            String num = input.nextLine();

            String check = "0123456789";
            
            int tracker = 0;
            for (int i = 0; i < num.length(); i++){
                int charLoc = check.indexOf(num.charAt(i));
                if (charLoc == -1){
                    tracker++;
                }
            }
           
            if (tracker == 0){
                long numLong = Long.parseLong(num);
            
                int numSize = num.length();

                if (numSize == 9){
                    int num1 = Integer.parseInt(num);
                    System.out.println(isbn10(num1));
                    valid = true;
                }else if (numSize == 12){
                    System.out.println(isbn13(numLong));
                    valid = true;
                }else{
                    System.out.println("invalid input");
                }
            } else{
                System.out.println("invalid input");
            }
        }
    }
}
