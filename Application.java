import java.util.Scanner;

public class atm{
    static float balance = 0;
    static float withdraw;
    static  float deposit;
    static  float transfer;
    static String sendAccount;
    static int setPin;
    static String name;
    static long accountNumber = 1_660_006_880L;

    public static void main(String[] args) {
        int x = 1;

        do {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Please enter your name:");
                name = input.nextLine();bakya

                System.out.println("Welcome " + name.toUpperCase() + "!!" + "\nYour assigned account number is " + accountNumber + ".");
                Scanner pin = new Scanner(System.in);
                System.out.print("Please enter your new PIN;\nYour PIN is a secret: ");
                setPin = pin.nextInt();
                x=2;
            }
            catch (Exception e){
                System.out.println("Enter Valid data");
            }

        }while (x==1);


        System.out.println("Welcome! Your Account has been created successfully");
        System.out.println("Name: " + name.toUpperCase());
        System.out.println("A/C No. : " + accountNumber);
        System.out.println("Your Account balance is: ZMK." + balance);

        Scanner in = new Scanner(System.in);
        System.out.println("Proceeding to ATM, Press any key to continue");
        String number = in.next();


        authentication();
    }

    public static void authentication (){

        int pin;
        int count =3;
        Scanner input = new Scanner(System.in);
        while ((count>=3) || (count!=0)){
            count--;
            System.out.print("Enter your PIN to proceed: ");
            pin = input.nextInt();

            if (setPin == pin) {
                option();
                break;
            }
            else {
                System.out.println("PIN not correct;" +count+ " attempt(s) remaining");
            }
        }
        if (count==0){
            System.out.println("You entered 3 wrong PINs in a row,\nYour Account is locked for the next 24 Hours");
        }

    }

    public static void deposit(){

        Scanner depositMoney = new Scanner(System.in);
        System.out.print("Enter Amount to Deposit: ZMK.");
        deposit = depositMoney.nextFloat();
        System.out.println("You are depositing ZMK."+deposit+ " into your account.");
        Scanner in = new Scanner(System.in);
        System.out.println("Press any key to continue");
        String number = in.next();
        balance = balance + deposit;
        System.out.println("Deposit was successful!!\nYou deposited ZMK." + deposit);
        System.out.println("Your new balance is: ZMK." + balance);
        option();
    }

    public static void withDraw(){
        Scanner withDrawMoney = new Scanner(System.in);
        System.out.print("Enter Amount to Withdraw: ZMK.");
        withdraw = withDrawMoney.nextFloat();
        System.out.println("You are withdrawing ZMK."+withdraw+ " from your account.");
        Scanner in = new Scanner(System.in);
        System.out.println("Press any key to continue");
        String number = in.next();
        if (balance>=withdraw){
            balance = balance - withdraw;
            System.out.println("You have withdrawn ZMK." + withdraw + " successfully!!");
            System.out.println("Your new balance is: ZMK." + balance);
            option();
        }
        else
            System.out.println("You do not have enough funds to make this withdraw!");
        option();
    }

    public  static  void  transfer(){
        Scanner sendAccountTransfer = new Scanner(System.in);
        System.out.print("Enter Account No. to transfer funds to:");
        sendAccount = sendAccountTransfer.next();

        Scanner transferMoney = new Scanner(System.in);
        System.out.print("Enter Amount to Transfer: ZMK.");
        transfer = transferMoney.nextFloat();
        System.out.println("You are tranfering ZMK." + transfer + " to Account No. " + sendAccount);
        Scanner in = new Scanner(System.in);
        System.out.println("Press any key to continue");
        String number = in.next();

        if (balance>=transfer){
            balance = balance - transfer;
            System.out.println("You have transferred ZMK." + transfer + " to Account No. " + sendAccount + " successfully!!");
            System.out.println("Your new balance is: ZMK." + balance);
            option();
        }
        else
            System.out.println("You do not have enough funds to make this transfer!\nPerform another transaction");
        option();
    }

    public static void statement(){
        System.out.println("______________");
        System.out.println("Your name: " +name.toUpperCase());
        System.out.println("Account No.: " + accountNumber);
        System.out.println("Your PIN: **");
        System.out.println("Your deposit was: ZMK." + deposit);
        System.out.println("Your Withdraw was: ZMK." + withdraw);
        System.out.println("Transferred ZMK." + transfer + " to Account No. " + sendAccount);
        System.out.println("Your balance is: ZMK." + balance);
        option();
    }
    public static void option(){
        System.out.println("______________");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer Funds");
        System.out.println("4. Print Statement");
        System.out.println("5. Exit");
        System.out.print("Select choice to perform:");

        Scanner option = new Scanner(System.in);
        int select = option.nextInt();

        switch (select){
            case 1:
                deposit();
                break;
            case 2:
                withDraw();
                break;
            case 3:
                transfer();
                break;
            case  4:
                statement();
                break;
            case 5:
                System.out.println("__________________");
                System.out.println("Thank you for banking with us!\nPlease, call again.");
                System.out.println("__________________");
                System.exit(0);
            default:
                System.out.println("Invalid input\nPlease enter a valid selection!");
                option();
        }
    }
}