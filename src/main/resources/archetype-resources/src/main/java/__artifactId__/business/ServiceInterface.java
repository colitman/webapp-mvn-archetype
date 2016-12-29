#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ${package}.${artifactId}.business;

import ${package}.${artifactId}.domain.EntityInterface;
import ${package}.${artifactId}.domain.IdentifiedEntityInterface;

import java.util.List;

/**
 * Interface for entity service
 */
public interface ServiceInterface {

	/**
	 * Checks whether the entity with provided key exists
	 *
	 * @param key key to check
	 * @return true is entity with provided key exists; false otherwise
	 */
	boolean exists(Long key);

	/**
	 * Gets an entity by key
	 *
	 * @param key key to search
	 *
	 * @return Entity with provided ID
	 *
	 * @throws ResourceNotFoundException if entity with provided ID does not exist
	 */
	IdentifiedEntityInterface get(Long key) throws ResourceNotFoundException;

	/**
	 * Gets all entities
	 *
	 * @return a list of all entities or empty list if there no such entities
	 */
	List<IdentifiedEntityInterface> list();

	/**
	 * Adds a new entry in the datastorage with data from provided entity
	 *
	 * @param entity entity information to save
	 *
	 * @return ID of the newly created entity
	 */
	Long add(IdentifiedEntityInterface entity);

	/**
	 * Updates entry information in datastorage by ID of the provided entity.
	 * @param entity entity information to update datastorage with.
	 *
	 * @return true if entity was updated; false otherwise
	 *
	 * @throws ResourceNotFoundException if ID of the provided entity is NULL or there is no saved entry
	 * for entity with ID, equal to ID of the provided entity.
	 */
	boolean update(IdentifiedEntityInterface entity) throws ResourceNotFoundException;

	/**
	 * Deletes an entity with provided ID
	 * @param id ID of an entity to delete
	 * @return true if entity was deleted; false otherwise
     */
	boolean delete(Long id);
}