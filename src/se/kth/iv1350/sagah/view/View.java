package se.kth.iv1350.sagah.view;

import se.kth.iv1350.sagah.controller.Controller;
import se.kth.iv1350.sagah.model.CurrentItem;
import se.kth.iv1350.sagah.model.PaymentDTO;

public class View {
	private Controller contr;

	public View(Controller contr){
		this.contr = contr; 
                exampleRun();
	}
        private void printCurrentItem(CurrentItem currentItem){
            System.out.println(currentItem.getName() + ": " + currentItem.getDescription());
            System.out.println("Price: " + currentItem.getPrice() + " SEK\nRunning total: " + currentItem.getRunningTotal() + " SEK\n");                
        }
        private void exampleRun(){
                contr.startSale();
                for(int i = 1; i < 4; i++){
                    printCurrentItem(contr.enterItem(i, 1));
                }
                printCurrentItem(contr.enterItem(1, 3));
                double totalAmount = contr.endSale().getTotal();
                System.out.println("Total amount: " + totalAmount+ " SEK\n");
                PaymentDTO change = contr.addPayment(Math.round(((totalAmount+5)/10.0))*10);
                System.out.println("The change is " + change.getChange() + " SEK");            
        }
        
}