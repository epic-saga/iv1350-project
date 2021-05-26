package se.kth.iv1350.sagah.view;

import java.io.IOException;
import se.kth.iv1350.sagah.controller.Controller;
import se.kth.iv1350.sagah.controller.OperationFailedException;
import se.kth.iv1350.sagah.model.CurrentItem;
import se.kth.iv1350.sagah.model.PaymentDTO;
import se.kth.iv1350.sagah.util.FileLogger;

public class View {
	private Controller contr;
        private FileLogger revenueLog;

	public View(Controller contr) throws IOException{
		this.contr = contr; 
                revenueLog = new FileLogger("revenue-log.txt");
                
	}
        private void printCurrentItem(CurrentItem currentItem){
            System.out.println(currentItem.getName() + ": " + currentItem.getDescription());
            System.out.println("Price: " + currentItem.getPrice() + " SEK\nRunning total: " + currentItem.getRunningTotal() + " SEK\n");                
        }
        /**
         * Simulates a user scenario
         */
        public void exampleRun(){
            try{
                contr.startSale();
                int [] listOfItemIdentifiers = new int[]{1, 2, 11, 4, 13};
                for(int i = 0; i < listOfItemIdentifiers.length; i++){
                    try{
                        printCurrentItem(contr.enterItem(listOfItemIdentifiers[i], 1));
                    }catch(OperationFailedException e){
                        System.out.println("ERROR: " + e.getMessage() + "\n");
                    }
                }
                double totalAmount = contr.endSale().getTotal();
                System.out.println("Total amount: " + totalAmount+ " SEK\n");
                PaymentDTO change = contr.addPayment(Math.round(((totalAmount+5)/10.0))*10);
                System.out.println("The change is " + change.getChange() + " SEK"); 
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
}