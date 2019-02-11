package Utils;

public class Validate {

	private String success;
	private boolean ok;
	/**
	 * @return the success
	 */
	public String getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(String success) {
		this.success = success;
	}
	/**
	 * @return the ok
	 */
	public boolean isOk() {
		return ok;
	}
	/**
	 * @param ok the ok to set
	 */
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
	public  String validarNombre(String nombre){
		if(nombre.length() >= 50){
			return "OK";
		}else{
			return"KO";
		}
	}
}
