wave = {

	state: {

		stateCallback: function() {},

		map: {},

		get: function(key) {
			return this.map[key];
		},

		submitValue: function(key, value) {
			this.map[key] = value;
			this.stateCallback();
		}

	},

	getState: function() {
		return this.state;
	},

	isInWaveContainer: function() {
		return true;
	},

	setStateCallback: function(stateCallback) {
		this.getState().stateCallback = stateCallback;
	}

}

gadgets = {

	util: {

		registerOnLoadHandler: function(onLoadHandler) {
			window.onload = onLoadHandler;
		}

	}

}