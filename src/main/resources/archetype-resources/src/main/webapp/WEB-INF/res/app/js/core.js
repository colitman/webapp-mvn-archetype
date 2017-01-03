"use strict";

/**
 * Observer object base implementation
 */
function Observer() {
	var observer = {
		
		/**
		 * Method doing nothing and intended to be overriden in subclasses.
		 * @param {*} [subject=undefined] - any data that related to change event
		 * @param {string} [message=undefined] - optional message that may be provided with a notification
		 */
		update: function(subject, message) {
			
		}
	}
	
	return observer;
}

/**
 * Observable object base implementation
 */
function Observable() {
	
	var observable = {
		
		/**
		 * Registers an object, provided as argument as an observer for current object's state
		 * @param {Observer} observer - object that will receive notifications about current object change events
		 */
		subscribe: function(observer) {
			observers.push(observer);
		},
		
		/**
		 * Sets the current object as one that had been changed
		 */
		setChanged: function() {
			changed = true;
		},
		
		/**
		 * Sends notifications about current object change event to all observers and clears the changed status for current object afterwards
		 * @param {*} [subject=undefined] - any data that related to change event
		 * @param {string} [message=undefined] - optional message that may be provided with a notification
		 */
		notifyObservers: function(subject, message) {
			
			if(!isChanged()) {
				return;
			}
			
			for(var i = 0; i < observers.length; i++) {
				var observer = observers[i];
				observer.update(subject, message);
			}
			
			clearChanged();
		},
		
		/**
		 * Unsubscribes all observers from the current object
		 */
		deleteObservers: function() {
			observers.length = 0;
		}
	};
	
	/* Private fields */
	var observers = [];
	var changed = false;
	var _this = this;
	
	/* Private methods */
	
	/**
	 * Counts how many observers are registered for the current object
	 * @returns {number} amount of registered observers
	 */
	var countObservers = function() {
		return observers.length;
	};
	
	/**
	 * Returns the "changed" flag for current object
	 * @returns {boolean} true if object is in changed state. False otherwise.
	 */
	var isChanged = function() {
		return changed;
	};
	
	/**
	 * Sets the "changed" flag to false for current object
	 */
	var clearChanged = function() {
		changed = false;
	};
	
	return observable;
}

function  Stringifier() {
	var model = {
		
		/**
		 * Converts the provided data to string value, using the provided pattern
		 * @param {Array} data - array of data to convert to one string
		 * @param {string} pattern - pattern to use. Indexes of data array are used for parts placing, prepended with '%'
		 * @example
		 * // will produce - 'first second (last) - 30%'
		 * .stringify(['last', 'first', 30, 'second'], '%1 %3 (%0) - %2%%')
		 * @returns {string} resulting string
		 */
		stringify: function(data, pattern) {
			var result = '';
			
			for(var i = 0; i < pattern.length; i++) {
				var character = pattern[i];
				
				if('%' === character) {
					if('%' === pattern[i-1]) {
						result += character;
						continue;
					} else {
						continue;
					}
				}
				
				if(isNaN(character) || character.trim().length === 0) {
					result += character;
				} else {
					if('%' === pattern[i-1] && '%' !== pattern[i-2]) {
						result += data[character];
					} else {
						result += character;
					}
					
				}
			}
			
			return result;
		}
	}
	
	Object.seal(model);
	return model;
}

function jsMap() {
	
	var size = 0;
	
	var data = {};
	
	var map = {
		put: function(key, value) {
			if(this.hasKey(key)) {
				var prevValue = this.get(key);
				data[key] = value;
				return prevValue;
			} else {
				data[key] = value;
				size++;
				return null;
			}
		},
		
		get: function(key) {
			if(this.hasKey(key)) {
				return data[key];
			} else {
				return null;
			}
		},
		
		remove: function(key) {
			if(this.hasKey(key)) {
				var prevValue = this.get(key);
				delete data[key];
				size--;
				return prevValue;
			} else {
				return null;
			}
		},
		
		hasKey: function(key) {
			if(this.isEmpty()) return false;
			return key in data;
		},
		
		size: function() {
			return size;
		},
		
		isEmpty: function() {
			return this.size() === 0;
		}
	};
	
	Object.seal(map);
	return map;
}