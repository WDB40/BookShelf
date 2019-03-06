const MAX_NAME_LENGTH = 25;
const MAX_DESC_LENGTH = 100;

function validateGenre(){
	var validGenre = true;
	
	if(!validateName()){
		validGenre = false;
	}
	
	if(!validateDesc()){
		validGenre = false;
	}
	
	return validGenre;
}


function validateName(){
	var validName = true;
	
	var name = document.getElementById("name").value;
	var nameErrorBox = document.getElementById("nameError");
	
	if(isEmptyString(name)){
		validName = false;
		nameErrorBox.innerHTML = "Name cannot be blank.";
	} else if(name.length > MAX_NAME_LENGTH){
		validName = false;
		nameErrorBox.innerHTML = "Name cannot be more than 25 characters.";
	} else {
		nameErrorBox.innerHTML = "";
	}
	
	return validName;
}

function validateDesc(){
	var validDesc = true;
	
	var desc = document.getElementById("desc").value;
	
	var descErrorBox = document.getElementById("descError");
	
	if(desc.length > MAX_DESC_LENGTH){
		validDesc = false;
		descErrorBox.innerHTML = "Description cannot be more than 100 characters."
	} else {
		descErrorBox.innerHTML = "";
	}
	
	return validDesc;
}

function isEmptyString(entry){
	return entry.trim() === "";
}