package bookshop.util.request;

/**
 * 
 * @author antonTkachenko
 *
 */

public class ServiceRequest {

	private boolean result;
	private String message;

	public ServiceRequest(boolean result, String message) {
		this.result = result;
		this.message = message;
	}

	public boolean getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

	public void setResult(boolean result) {
		this.result = result;

	}

	public void setMessage(String message) {
		this.message = message;

	}

}
