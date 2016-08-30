#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ${package}.business;

import ${package}.domain.EntityInterface;
import ${package}.domain.IdentifiedEntityInterface;

import java.util.List;

/**
 * Interface for default entity service
 */
public interface DefaultServiceInterface {

	/**
	 * Checks whether the entity with provided key exists
	 *
	 * @param clazz entity class
	 * @param key key to check
	 * @return true is entity of the provided class with provided key exists; false otherwise
	 */
	<ENTITY extends IdentifiedEntityInterface> boolean exists(Class<ENTITY> clazz, Long key);

	/**
	 * Gets an entity by key
	 *
	 * @param clazz entity class
	 * @param key key to search
	 *
	 * @return Entity of the provided class with provided ID
	 *
	 * @throws ResourceNotFoundException if entity of provided class with provided ID does not exist
	 */
	<ENTITY extends IdentifiedEntityInterface> ENTITY get(Class<ENTITY> clazz, Long key) throws ResourceNotFoundException;

	/**
	 * Gets all entities of the provided class
	 * @param clazz entity class
	 *
	 * @return a list of all entities of provided class or empty list if there no such entities
	 */
	<ENTITY extends EntityInterface> List<ENTITY> list(Class<ENTITY> clazz);

	/**
	 * Adds a new entry in the datastorage with data from provided entity
	 *
	 * @param entity entity information to save
	 *
	 * @return ID of the newly created entity
	 */
	<ENTITY extends EntityInterface> Long add(ENTITY entity) throws ResourceAlreadyExistsException;

	/**
	 * Updates entry information in datastorage by ID of the provided entity.
	 * @param entity entity information to update datastorage with.
	 *
	 * @return true if entity was updated; false otherwise
	 *
	 * @throws ResourceNotFoundException if ID of the provided entity is NULL or there is no saved entry
	 * for entity with ID, equal to ID of the provided entity.
	 */
	<ENTITY extends IdentifiedEntityInterface> boolean update(ENTITY entity) throws ResourceNotFoundException;

}