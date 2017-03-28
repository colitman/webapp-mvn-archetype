#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ${package}.${artifactId}.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import ${package}.${artifactId}.domain.IdentifiedEntityInterface;
import ${package}.${artifactId}.data.DefaultDAO;

/**
 * Abstract entity service implementation
 */
public abstract class AbstractService {
	
	@Autowired
	private DefaultDAO dao;

	private @Value("${symbol_dollar}{app.softDeleteEnabled}") boolean softDelete;

	protected abstract Class<? extends IdentifiedEntityInterface> getEntityClass();
	
	protected DefaultDAO getDAO() {
		return dao;
	}

	@Transactional
	public boolean delete(Long id) {
		if(id == null) {
			throw new IllegalArgumentException("Provided ID is NULL");
		}
		
		if(softDelete) {
			final boolean[] isDeleted = {false};
			getDAO().getAll(getEntityClass()).stream()
					.filter(e -> e.getId().equals(id))
					.findFirst()
					.ifPresent(s -> {
						s.setDeleted(true);
						isDeleted[0] = true;
					});
			return isDeleted[0];
		} else {
			return getDAO().delete(getEntityClass(), id);
		}
	}

}
