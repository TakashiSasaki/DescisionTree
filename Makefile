.PHONY: prepare test-entropy test-iris

test-entropy: entropy.js
	@NODE_PATH=MyAssert node $<

test-iris: Iris.js
	@NODE_PATH=/usr/local/lib/node_modules:MyAssert node $<


prepare:
	sudo apt-get update ;\
	sudo apt-get upgrade -y ;\
	sudo n stable ;\
	sudo npm install -g npm ;\
	sudo npm update -g ;\
	sudo npm install -g csv ;\
	sudo npm install -g csv-parse


