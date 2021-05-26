package se.kth.iv1350.sagah.controller;

import java.io.IOException;
import se.kth.iv1350.sagah.integration.IntegrationHandler;
import se.kth.iv1350.sagah.integration.CashRegister;
import se.kth.iv1350.sagah.integration.ExternalSystemException;
import se.kth.iv1350.sagah.integration.InvalidItemException;
import se.kth.iv1350.sagah.model.CurrentItem;
import se.kth.iv1350.sagah.model.PaymentDTO;
import se.kth.iv1350.sagah.model.Sale;
import se.kth.iv1350.sagah.model.SalePriceDTO;
import se.kth.iv1350.sagah.util.FileLogger;

/**
 * Represents the controller layer
 * @author sagah
 */
public class Controller {
	private final IntegrationHandler integr;
        private final CashRegister cashRegister;
        private FileLogger errorLog;
        private Sale sale;
        
        /**
        * Creates a new instance
        * @param integr A reference to the integration handler
        */
	public Controller(IntegrationHandler integr) throws IOException{
		this.integr = integr;
                cashRegister = new CashRegister();
                errorLog = new FileLogger("error-log.txt");
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
         * @throws OperationFailedException if the item could not be added
         */
        public CurrentItem enterItem(int identifier, int amount) throws OperationFailedException{
            try{
                return sale.addItem(identifier, amount);
            }catch(InvalidItemException e){
                throw new OperationFailedException("Could not enter item. " + e.getMessage(), e);
            }catch(ExternalSystemException e){
                errorLog.logException(e);
                throw new OperationFailedException("Could not enter item. Please try again.", e);
            }
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
