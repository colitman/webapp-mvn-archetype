#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ${package}.${artifactId}.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ${package}.${artifactId}.domain.EntityInterface;
import ${package}.${artifactId}.domain.IdentifiedEntityInterface;
import ${package}.${artifactId}.data.DefaultDAO;
import ${package}.${artifactId}.data.ObjectNotExistsException;
import ${package}.${artifactId}.domain.UniqueNamedEntityInterface;

import java.util.List;

/**
 * Default entity service implementation
 */
@Service
public class DefaultService implements DefaultServiceInterface {
	
	@Autowired
	private DefaultDAO dao;
	
	protected DefaultDAO getDAO() {
		return dao;
	}
	
	@Override
	@Transactional
	public <ENTITY extends IdentifiedEntityInterface> boolean exists(Class<ENTITY> clazz, Long key) {
		return getDAO().exists(clazz, key);
	}
	
	@Override
	@Transactional
	public <ENTITY extends IdentifiedEntityInterface> ENTITY get(Class<ENTITY> clazz, Long key) throws ResourceNotFoundException {
		ENTITY entity = null;
		try {
			entity = getDAO().getByKey(clazz, key);
		} catch (ObjectNotExistsException one) {
			throw new ResourceNotFoundException(one.getMessage(), one);
		}
		
		return entity;
	}

	@Override
	@Transactional
	public <ENTITY extends EntityInterface> List<ENTITY> list(Class<ENTITY> clazz) {
		return getDAO().getAll(clazz);
	}
	
	@Override
	@Transactional
	public <ENTITY extends EntityInterface> Long add(ENTITY entity) throws ResourceAlreadyExistsException {
		
		if(entity instanceof UniqueNamedEntityInterface) {
			UniqueNamedEntityInterface unei = (UniqueNamedEntityInterface) entity;
			try {
				getDAO().getKeyByName(unei.getClass(), unei.getName());
			} catch (ObjectNotExistsException e) {
				return getDAO().create(entity);
			}
			
			throw new ResourceAlreadyExistsException(entity.getClass().getSimpleName() + " entity with provided name already exists: " + unei.getName());
		}
		
		return getDAO().create(entity);
	}
	
	@Override
	@Transactional
	public <ENTITY extends IdentifiedEntityInterface> boolean update(ENTITY entity) throws ResourceNotFoundException {
		try {
			return getDAO().update(entity);
		} catch (ObjectNotExistsException e) {
			throw new ResourceNotFoundException(e.getMessage(), e);
		}
	}
}
