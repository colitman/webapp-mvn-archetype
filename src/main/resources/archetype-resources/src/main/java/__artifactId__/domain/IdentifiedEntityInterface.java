#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ${package}.${artifactId}.domain;

/**
 * Designates a persistent entity that has a unique numeric ID
 */
public interface IdentifiedEntityInterface extends EntityInterface {
	/**
	 * Gets the unique numeric ID of the entity
	 * @return the entity numeric ID
     */
	Long getId();

	/**
	 * <p>Sets the numeric ID for an entity.</p>
	 *
	 * <p>ID should be unique within a datastorage</p>
	 * @param id ID to set
     */
	void setId(Long id);
}
