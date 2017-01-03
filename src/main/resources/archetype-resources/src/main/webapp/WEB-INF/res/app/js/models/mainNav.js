"use strict";

(function(aScope, undefined){
	
	var observable = new Observable();
	
	var mainNavModel = {
		__proto__: observable,
		
		updateData: function() {
			var _this = this;
			
			_this.setChanged();
			_this.notifyObservers(aScope.VM, 'misc:mainNavDataUpdated');
		},
		
		action: function(resourceData) {
			var _this = this;
			return aScope.service.create(resourceData)
				.done(function(data) {
					_this.updateData();
				});
		},
		
		getResources: function() {
			var _this = this;
			return aScope.service.list();
		}
	
	};
	
	
	aScope.mainNavModel = mainNavModel;
	
})($APP);
