package ejbs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@ApplicationPath("/api")
public class App extends Application {
	public static void main(String[] args) {
		
		Service service = new Service();

	    Calculation calculation = new Calculation();
	    calculation.setNumber1(10);
	    calculation.setNumber2(5);
	    calculation.setOperation("/");

	    Response response = service.performCalculation(calculation);

	    // Handle response
	    if (response.getStatus() == Response.Status.OK.getStatusCode()) {
	      Result result = (Result) response.getEntity();
	      System.out.println("Result: " + result.getResult());
	    } else {
	      System.out.println("Error: " + response.getStatusInfo().getReasonPhrase());
	    }
	  }
}