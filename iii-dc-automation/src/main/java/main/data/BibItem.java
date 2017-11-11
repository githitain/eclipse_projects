package main.data;

/**
 * The class for Bib Item objects
 */
public class BibItem 
{
    private String location;
    private String callNo;
    private ItemStatus status;
    private String barcode;

    public String getLocation() {
        return location;
    }

    public String getCallNo() {
        return callNo;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public String getBarcode() {
        return barcode;
    }

    public BibItem setLocation(String location) {
        this.location = location;
        return this;
    }

    public BibItem setCallNo(String callNo) {
        this.callNo = callNo;
        return this;
    }

    public BibItem setStatus(ItemStatus status) {
        this.status = status;
        return this;
    }

    public BibItem setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }
}
