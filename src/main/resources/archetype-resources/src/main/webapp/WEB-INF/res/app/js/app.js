"use strict";

(function(window, undefined){
	
	var appRoot = $('meta[name="contextPath"]').attr('content');
	
	var app = {
	
		VM:{},
		APP_ROOT: appRoot,
		WEB_API_ROOT: appRoot + '/api/web',
		PAGES : {
			login: {url: appRoot + '/login', name: 'Log In'},
			signup: {url: appRoot + '/register', name: 'Sign Up'}
		},
		
		markRequiredFields: function(){
			$('form').each(function(index, form) {
				$('[required="required"]', form).each(function(index, control) {
					var controlId = $(control).attr('id');
					var label = $('label[for="' + controlId + '"]', form);
					var labelText = $(label).text();
					$(label).html(labelText + ' <span class="c-asterisk-required">*</span>');
				});
			});
		},
		
		generateBreadcrumbs: function(currentCrumbText) {
			var crumbsContainer = $('#c-js-crumbs');
			var operatedCrumbs = $('li:not(.active,.c-js-home-crumb)', crumbsContainer);
			
			$(operatedCrumbs).each(function(index, crumbItem) {
				var pageCode = $(crumbItem).text();
				
				var crumbTemplate = app.PAGES[pageCode];
				
				if(crumbTemplate !== undefined) {
					var crumbURL = app.PAGES[pageCode].url;
					var crumbName = app.PAGES[pageCode].name;
				
					var crumbLink = $(document.createElement('a'));
					crumbLink.attr('href', crumbURL);
					crumbLink.text(crumbName);
					
					$(crumbItem).html(crumbLink);
				}
			});
			
			var currentCrumb = $('.active', crumbsContainer).filter(':last');
			currentCrumb.text(currentCrumbText);
		}
	
	}
	
	window.app = window.$APP = app;
	$APP.markRequiredFields();
	
	$('#c-delete-failure-alert button.close').click(function(event) {
		event.preventDefault();
		$('#c-delete-failure-alert').addClass('hidden');
	});
	
	$('#c-delete-confirmation-modal').on('hidden.bs.modal', function (event) {
		$('#c-delete-failure-alert').addClass('hidden');
	})
	
})(window);