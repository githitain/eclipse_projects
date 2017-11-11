package test.data;

public class Patron 
{
	    private String name;
	    private String barcode;
	    private String pin;
	    private String email;
	    private String address;
	    private String city;
	    private String state;
	    private String zipCode;
	
	    public Patron setName(String name) {
	        this.name = name;
	        return this;
	    }
	
	    public Patron setBarcode(String barcode) {
	        this.barcode = barcode;
	        return this;
	    }
	
	    public Patron setPin(String pin) {
	        this.pin = pin;
	        return this;
	    }
	
	    public Patron setEmail(String email) {
	        this.email = email;
	        return this;
	    }
	
	    public Patron setAddress(String address) {
	        this.address = address;
	        return this;
	    }
	
	    public Patron setCity(String city) {
	        this.city = city;
	        return this;
	    }
	
	    public Patron setState(String state) {
	        this.state = state;
	        return this;
	    }
	
	    public Patron setZipCode(String zipCode) {
	        this.zipCode = zipCode;
	        return this;
	    }
	
	    public String getName() {
	        return name;
	    }
	
	    public String getBarcode() {
	        return barcode;
	    }
	
	    public String getPin() {
	        return pin;
	    }
	
	    public String getEmail() {
	        return email;
	    }
	
	    public String getAddress() {
	        return address;
	    }
	
	    public String getCity() {
	        return city;
	    }
	
	    public String getState() {
	        return state;
	    }
	
	    public String getZipCode() {
	        return zipCode;
	    }
}