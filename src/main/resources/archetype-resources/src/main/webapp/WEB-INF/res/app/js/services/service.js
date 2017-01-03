"use strict";

(function(aScope, undefined){
	
	
	
	var service = {
		
		list: function() {
			return $.ajax({
				url     : $APP.WEB_API_ROOT + '/resources',
				method  : 'GET',
				dataType: 'json'
			});
		},
		
		getById: function(id) {
			return $.ajax({
				url     : $APP.WEB_API_ROOT + '/resources/' + id,
				method  : 'GET',
				dataType: 'json'
			});
		},
		
		delete: function(id) {
			return $.ajax({
				url   : $APP.WEB_API_ROOT + '/resources/' + id,
				method: 'DELETE'
			});
		},
		
		create: function(resourceData) {
			return $.ajax({
				url     : $APP.WEB_API_ROOT + '/resources',
				method  : 'POST',
				data    : resourceData,
				dataType: 'json'
			});
		},
		
		update: function(resourceData) {
			return $.ajax({
				url   : $APP.WEB_API_ROOT + '/resources/' + resourceData.id,
				method: 'PUT',
				data  : resourceData
			});
		},
		
		custom: function(id) {
			return $.ajax({
				url   : $APP.WEB_API_ROOT + '/resources/' + id + '/custom',
				method: 'PUT'
			});
		}
	}
	
	aScope.service = service;
	
})($APP);
