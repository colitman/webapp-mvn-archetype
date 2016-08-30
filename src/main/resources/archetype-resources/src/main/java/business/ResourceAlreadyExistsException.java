#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business;

public class ResourceAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ResourceAlreadyExistsException(String message) {
		super(message);
	}
}
