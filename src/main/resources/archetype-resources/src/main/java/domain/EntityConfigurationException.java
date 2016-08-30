#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ${package}.domain;

/**
 * Exception means that domain entity class is not configured and/or annotated properly
 */
public class EntityConfigurationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message - exception message
	 */
	public EntityConfigurationException(String message) {
		super(message);
	}
}
