"use strict";

(function(aScope, undefined) {
	var model = aScope.mainNavModel;
	var view = aScope.mainNavView;
	
	model.subscribe(view);
	model.updateData();
	
	/* Event listeners */
	$(view)
		.on('subject:action', function(event, modal, button) {
						
			model.getResources()
				.done(function(resourcesData) {
					doSmth(resourcesData);
					modal.modal('show');
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					new Alert('danger', 'Oops!', 'Failed to get resources.').show();
					console.log(jqXHR.responseText);
				});
		});
	
	/* Private methods */
	var doSmth = function(resourcesData) {
		
	};
})($APP);