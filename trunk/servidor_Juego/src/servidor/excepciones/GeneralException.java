package servidor.excepciones;


public class GeneralException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;	
	
	public GeneralException(){}
	
	public GeneralException(String message)
	{
		this.message = message;
	}	
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public String getMensaje()
	{ 
		return this.message;
	}
}