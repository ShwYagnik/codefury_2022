package in.co.teams.org.exceptions;

public class ContactNotExistException extends Exception{
	
	public void showMessage() {
		System.out.println("This contact does not exist");
	}

}
