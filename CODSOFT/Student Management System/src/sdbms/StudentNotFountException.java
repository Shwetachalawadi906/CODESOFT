package sdbms;

public class StudentNotFountException  extends RuntimeException
{
  private String message;
  
  public  StudentNotFountException (String message)
  {
	  this.message=message;
  } 
  @Override
  public String getMessage()
  {
	  return message;
  }
}
