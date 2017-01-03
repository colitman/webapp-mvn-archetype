"use strict";

(function(aScope, undefined){
	
	var observer = new Observer();
	
	var mainNavView = {
		__proto__: observer,
		
		/**
		 * This method is called by observed model when it is changed.
		 *
		 * @param {*} subject - reference to VM object in global application scope with model data
		 * @param {string} [message=undefined] - additional message that model may send
		 */
		update: function(subject, message) {
			resetForms();
			hideModals();
		}
		
	};
	
	aScope.mainNavView = mainNavView;
	
	/* Private fields */
	var button = $('#c-js-button');
	var modal = $('#c-js-modal');
	
	/* View events triggers */
	button.click(function(event) {
		event.preventDefault();
		$(mainNavView).trigger('subject:action', [modal]);
	});
	
	/* Private methods */
	var resetForms = function() {
		
	};
	
	var hideModals = function() {
		$(modal).modal('hide');
	};
	
})($APP);
