package se.kth.iv1350.sagah.model;
import java.time.LocalDateTime;
import java.util.List;
import se.kth.iv1350.sagah.util.DateHandler;

/**
 * Represents the receipt for the sale
 * @author sagah
 */
public class Receipt {
    private LocalDateTime saleTime;
    private String storeName;
    private String storeAddress;
    private List<AddedItem> itemList;
    private double totalPrice;
    private double VAT;
    private double amountPaid;
    private double change;
    
    /**
     * Creates a new instance with the sale information
     * @param itemList List of items being sold
     * @param total Price information
     */
    public Receipt(List<AddedItem> itemList, SalePriceDTO total, PaymentDTO payment){
        saleTime = LocalDateTime.now();
        storeName = "Hopes&Dreams";
        storeAddress = "Abby road";
        this.itemList = itemList;
        totalPrice = total.getTotal();
        VAT = total.getVatPrice();
        amountPaid = payment.getAmountPaid();
        change = payment.getChange();
    }
    /**
     * Creates a formatted string with the receipt information
     * @return The receipt as a string
     */
    public String receiptToString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Receipt\n");
        builder.append(new DateHandler().createTime());
        builder.append("Store name: " + storeName + "\n");
        builder.append("Store address: " + storeAddress + "\n");
        for (AddedItem item:itemList){
            builder.append(item.getAmount() + " ");
            builder.append(item.getItemDTO().getName() + " ");
            builder.append(item.getItemDTO().getPrice() + " SEK\n");
        }
        builder.append(String.format("Total price: %.2f SEK\n", totalPrice));
        builder.append(String.format("VAT for entire sale: %.2f SEK\n", VAT));
        builder.append(String.format("Amount paid: %.2f SEK\n", amountPaid));
        builder.append("Change: " + change + " SEK\n");
        return builder.toString();
    }
    private String formatSaleTime(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Sale date: %d-%02d-%02d\n", saleTime.getYear(), saleTime.getMonthValue(), saleTime.getDayOfMonth()));
        builder.append(String.format("Sale time: %02d:%02d\n" , saleTime.getHour(), saleTime.getMinute()));
        return builder.toString();
    }
}