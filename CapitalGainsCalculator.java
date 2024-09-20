/* PROGRAM: CapitalGainsCalculator
 @Author  caitlin.meinecke
 This program calculates the tax rate of an asset and
 calculates the total capital gains of the asset after
 the tax has been deducted.
*/


import java.util.Scanner;

public class CapitalGainsCalculator
{
    public static void main(String[] args)
    {
        //Declare variables

        String asset;           //hold asset name
        int months;             //holds number of months
        double shares;          //holds number of shares
        double assetPrice;       //holds asset price

        //add scanner keyboard for user input
        Scanner keyboard = new Scanner(System.in);

        //ask user for name of asset and apply to asset variable
        System.out.println("Which stock, index bond, or 401k would you like to purchase?");
        asset = keyboard.nextLine();

        //ask  user for number of months and apply to months variable
        System.out.println("How many months will you hold this asset?");
        months = keyboard.nextInt();

        //ask user for number of share and apply to shares variable
        System.out.println("How many shares are you going to purchase?");
        shares = keyboard.nextDouble();

        //ask user for asset price and apply to assetPrice variable
        System.out.println("What is the current asset price?");
        assetPrice = keyboard.nextDouble();

        //returns value from getTaxAmount method to the tax variable
        double tax = getTaxAmount(months);

        //returns value from calculateAssetTotal method to the assetTotal variable
        double assetTotal = calculateAssetTotal(shares, assetPrice);

        //calculates total tax of the asset
        double taxTotal = assetTotal * tax / 100;

        //calculates the total capital gains after tax is deducted
        double capitalGains = assetTotal - taxTotal;

        //add line between user input and program output
        System.out.println("--------------------------------------------------");

        //displays asset input by user
        System.out.println("The asset you've selected is: " + asset);

        //displays amount of months input by user
        System.out.println("You will hold this asset for " + months + " month(s).");

        //displays number of shares input by the user
        System.out.println("You are going to invest in " + shares + " share(s) of this asset.");

        //displays the current price of the asset input by user
        System.out.println("The current price for the asset is $" + assetPrice);

        //displays the tax rate for the asset
        System.out.println("Your tax rate for this transaction will be " + tax + "%");

        //displays the total capital gains with tax deducted and rounds decimal to hundredth place
        System.out.printf("You are estimated to gain $%2.2f", capitalGains);

        //Close the scanner keyboard
        keyboard.close();
    }

    /*creates method to calculate and apply correct tax rate to asset by passing argument
 using the months variable*/
    public static double getTaxAmount(int months)
    {
        if (months >= 12)
        {
            return 12.0; // returns 12% tax rate for investment periods 12 months or more
        } else {
            return 20.0; // returns 20% tax rate for investment periods less than 12 months
        }
    }

    /*creates method to calculate the total amount spent on the asset by passing arguments using
    shares and assetPrice171.2 variables
     */
    public static double calculateAssetTotal(double shares, double assetPrice)
    {
        return shares * assetPrice;  //returns calculation of shares multiplied by assetPrice
    }
}
