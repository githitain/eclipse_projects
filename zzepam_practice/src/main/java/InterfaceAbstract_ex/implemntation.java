package InterfaceAbstract_ex;

public class implemntation extends absctract1 implements interface1 
{

	@Override
	public void print() 
	{
		System.out.println("Intraface method 1");
		
	}

	@Override
	public void Write() 
	{
		System.out.println("Intraface method 2");
		
	}

	@Override
	void run() {
		System.out.println("absctract1 method 1");
		
	}

	@Override
	void Sleep() 
	{
		System.out.println("absctract1 method 2");
		
	}
	
	@Override
	void Stand() 
	{
		// TODO Auto-generated method stub
		super.Stand();
	}

}
