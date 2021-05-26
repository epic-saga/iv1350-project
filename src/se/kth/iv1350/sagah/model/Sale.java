package se.kth.iv1350.sagah.model;

import java.util.List;
import se.kth.iv1350.sagah.integration.InvalidItemException;
import se.kth.iv1350.sagah.integration.IntegrationHandler;
import se.kth.iv1350.sagah.integration.ItemDTO;

/**
 * Represents a sale
 * @author sagah
 */
public class Sale {
        private final IntegrationHandler integr;
        private final SalePrice salePrice;
        private final SaleLog saleLog;

        /**
         * Creates a new instance, representing the current sale
         * @param integr A reference to the integration handler
         */
	public Sale(IntegrationHandler integr){
		this.integr = integr;
                salePrice = new SalePrice();
                saleLog = new SaleLog(salePrice);
	}
        /**
         * Adds an item to the sale
         * @param itemIdentifier The item identifier
         * @param amount The amount of items
         * @return Information about the item added
         * @throws InvalidItemException if the item identifier is invalid
         * @throws ExternalSystemException if database could not be reached
         */
        public CurrentItem addItem(int itemIdentifier, int amount) throws InvalidItemException{
            CurrentItem currentItem;
            ItemDTO newItem;
            if (saleLog.itemAlreadyAdded(itemIdentifier))
                currentItem = saleLog.increaseAmount(itemIdentifier, amount);
            else {
                newItem = integr.getItem(itemIdentifier);
                currentItem = saleLog.addItem(newItem, amount);
            }
            return currentItem;
        }
        /**
         * Signals that no more items are to be added
         * @return The final price
         */
        public SalePriceDTO endSale(){
            return salePrice.getTotal();
        }
        /**
         * Signals that a payment has been added and that the sale can therefore be completed
         * @param amountPaid The amount paid by the customer
         * @return How much change should be returned to the customer
         */
        public PaymentDTO completeSale(double amountPaid){
            PaymentDTO payment = salePrice.addPayment(amountPaid);
            SalePriceDTO total = salePrice.getTotal();
            List<AddedItem> itemList = saleLog.getItemList();
            Receipt receipt = new Receipt(itemList, total, payment);
            integr.completedSale(receipt);
            
            return payment;
        }

}