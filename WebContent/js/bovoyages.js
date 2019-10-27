function cloneDatesVoyage(){
	let nbDates = document.getElementById("nbDates").dataset.nbDates;
	nbDates++;
	document.getElementById("nbDates").dataset.nbDates = nbDates;
	
	let node = document.getElementById("toClone");
	let container = document.getElementById("containerDates");
	let newNode = node.childNodes[1].cloneNode(true);
	
	let it = document.createNodeIterator(newNode,NodeFilter.SHOW_ELEMENT,function(node){
		let name = node.nodeName.toLowerCase();
		if(name == 'input'){
			return NodeFilter.FILTER_ACCEPT
		}
		if(name == 'span'){
			return NodeFilter.FILTER_ACCEPT
		}
		return NodeFilter.FILTER_REJECT;
	});
	
	let current;
	while(current = it.nextNode()){
		if(current.nodeName.toLowerCase() == 'input')
			current.name = current.name+nbDates;
		if(current.nodeName.toLowerCase() == 'span')
			current.id = current.id + nbDates;
	}
	container.appendChild(newNode);
}

function initInputEvents(inputs){
	for(let i=0 ; i<inputs.length ; i++){
		inputs[i].addEventListener("blur",checkInput);
	}
	
}

function checkDescription(event){
	
}

function checkInput(event){
	let elt = event.target;
	let error = document.getElementById('error_'+elt.name);
	error.className = 'invisible';
	if(elt.trim().length == 0){
		error.innerText = ""
	}
}

document.addEventListener("DOMContentLoaded",function(){
//	let inputs = document.getElementsByTagName('input');
//	initInputEvents(inputs);
//	document.getElementById("description",checkDescription);
});