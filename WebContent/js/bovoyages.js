function cloneDatesVoyage(){
	let nbDates = document.getElementById("nbDates").dataset.nbDates;
	nbDates++;
	document.getElementById("nbDates").dataset.nbDates = nbDates;
	
	let node = document.getElementById("toClone");
	let container = document.getElementById("containerDates");
	let newNode = node.childNodes[1].cloneNode(true);
	
	let it = document.createNodeIterator(newNode,NodeFilter.SHOW_ELEMENT,function(node){
		return node.nodeName.toLowerCase() === 'input' ? NodeFilter.FILTER_ACCEPT : NodeFilter.FILTER_REJECT;
	});
	
	let current;
	while(current = it.nextNode()){
		current.name = current.name+nbDates;
	}
	container.appendChild(newNode);
}