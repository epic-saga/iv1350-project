package se.kth.iv1350.sagah.view;

import java.io.IOException;
import se.kth.iv1350.sagah.controller.Controller;
import se.kth.iv1350.sagah.controller.OperationFailedException;
import se.kth.iv1350.sagah.model.CurrentItem;
import se.kth.iv1350.sagah.model.PaymentDTO;
import se.kth.iv1350.sagah.util.TotalRevenueFileOutput;

public class View {
	private Controller contr;

	public View(Controller contr) throws IOException{
		this.contr = contr; 
                
	}
        private void printCurrentItem(CurrentItem currentItem){
            System.out.println(currentItem.getName() + ": " + currentItem.getDescription());
            System.out.println(String.format("Price: %.2f SEK\nRunning total: %.2f SEK\n", currentItem.getPrice(),currentItem.getRunningTotal()));                
        }
        private void saleProcess(int [] listOfItems){
                int [] listOfItemIdentifiers = listOfItems;
                contr.startSale();
                for(int i = 0; i < listOfItemIdentifiers.length; i++){
                    try{
                        printCurrentItem(contr.enterItem(listOfItemIdentifiers[i], 1));
                    }catch(OperationFailedException e){
                        System.out.println("ERROR: " + e.getMessage() + "\n");
                    }
                }
                double totalAmount = contr.endSale().getTotal();
                System.out.println(String.format("Total amount: %.2f SEK\n", totalAmount));
                PaymentDTO change = contr.addPayment(Math.round(((totalAmount+5)/10.0))*10);
                System.out.println(String.format("The change is %.2f SEK\n", change.getChange())); 
        }
        /**
         * Simulates a user scenario
         */
        public void exampleRun(){
            try{
                contr.addSaleObserver(new TotalRevenueFileOutput());
                contr.addSaleObserver(new TotalRevenueView());
                saleProcess(new int[]{1,2,3,4});
                saleProcess(new int[]{5,5,6});
                saleProcess(new int[]{8,9,10,11,13});

            }catch(Exception e){
                System.out.println(e);
            }
        }
        
}