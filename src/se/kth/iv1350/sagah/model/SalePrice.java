package se.kth.iv1350.sagah.model;

import se.kth.iv1350.sagah.integration.ItemDTO;

class SalePrice {
    private double total;
    private double itemPrice;
    private double vatPrice;
    private SalePriceDTO priceData;
    SalePrice(){}
    SalePriceDTO updatePrice(ItemDTO item, int amount){
        double price = item.getPrice() * amount;
        double vat = item.getVAT() * price;
        itemPrice = itemPrice + price;
        vatPrice = vatPrice + vat;
        total = itemPrice + vatPrice;
        priceData = new SalePriceDTO(itemPrice, vatPrice);
        return priceData;
    }
    SalePriceDTO getTotal(){
        return priceData;
    }
    PaymentDTO addPayment(double amountPaid){
        return new PaymentDTO(amountPaid, total);
    }
}
