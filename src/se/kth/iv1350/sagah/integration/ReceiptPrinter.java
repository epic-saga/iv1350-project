package se.kth.iv1350.sagah.integration;

import se.kth.iv1350.sagah.model.Receipt;

class ReceiptPrinter {
    ReceiptPrinter(){}
    void printReceipt(Receipt receipt){
        System.out.println(receipt.receiptToString());
    }
}
