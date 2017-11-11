package mock_stocks;

public class Stock 
{
	   private String stockId;
	   private String name;	
	   private int quantity;

	   public Stock(String stockId, String name, int quantity)
	   {
	      this.stockId = stockId;
	      this.name = name;		
	      this.quantity = quantity;		
	   }

	   public String getStockId() 
	   {
	      return stockId;
	   }

	   public void setStockId(String stockId) 
	   {
	      this.stockId = stockId;
	   }

	   public int getQuantity() 
	   {
	      return quantity;
	   }

	   public String getTicker() 
	   {
	      return name;
	   }
	   
	   
/*	   public static void main (String args[])
	   {
		   Stock s1= new Stock("AB", "Engergy", 4);
		   System.out.println(s1.getStockId());
		   //s1.setStockId("AB2");
		   System.out.println(s1.getStockId());
		   
		   System.out.println(s1.getQuantity());
		  // System.out.println(s1.getQuantity());
	   }
	   */
}