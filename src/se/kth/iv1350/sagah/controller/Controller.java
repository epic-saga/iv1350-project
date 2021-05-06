package se.kth.iv1350.sagah.controller;

import se.kth.iv1350.sagah.integration.IntegrationHandler;
import se.kth.iv1350.sagah.integration.CashRegister;
import se.kth.iv1350.sagah.model.CurrentItem;
import se.kth.iv1350.sagah.model.PaymentDTO;
import se.kth.iv1350.sagah.model.Sale;
import se.kth.iv1350.sagah.model.SalePriceDTO;

/**
 * Represents the controller layer
 * @author sagah
 */
public class Controller {
	private final IntegrationHandler integr;
        private final CashRegister cashRegister;
        private Sale sale;
        
        /**
        * Creates a new instance
        * @param integr A reference to the integration handler
        */
	public Controller(IntegrationHandler integr){
		this.integr = integr;
                cashRegister = new CashRegister();
	}
        /** 
        * Creates a new Sale instance
        */
	public void startSale(){
		sale = new Sale(integr);
	}
         /**
         * Adds item to ongoing sale
         * @param identifier Represents the item identifier
         * @param amount Represents the amount of items entered
         * @return Information about the current state of the sale
         */
        public CurrentItem enterItem(int identifier, int amount){
            return sale.addItem(identifier, amount);
        }
        /**
        * Signals that no more items are to be added
        * @return Total price of the sale
        */
        public SalePriceDTO endSale(){
            return sale.endSale();
        }
        /**
        * Signals that payment to complete the sale has been added
        * @param amountPaid The amount paid by the customer
        * @return How much change should be returned to the customer
        */
        public PaymentDTO addPayment(double amountPaid){
            cashRegister.updateCashRegister(amountPaid);
            return sale.completeSale(amountPaid);
        }        
}
