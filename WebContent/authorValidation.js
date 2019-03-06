const MAX_TEXT_LENGTH = 25;

function validateAuthor(){
	
	var validAuthor = true;
	
	if(!validateFirstName()){
		validAuthor = false;
	}
	
	if(!validateLastName()){
		validAuthor = false;
	}
	
	return validAuthor;
}

function validateFirstName(){
	
	var validFirstName = true;
	
	var firstName = document.getElementById("firstName").value;
	var firstNameErrorBox = document.getElementById("firstNameError");
	
	if(isEmptyString(firstName)){
		validFirstName = false;
		firstNameErrorBox.innerHTML = "First name cannot be blank.";
	} else if(firstName.length > MAX_TEXT_LENGTH){
		validFirstName = false;
		firstNameErrorBox.innerHTML = "First name cannot be more than 25 characters.";
	}else {
		firstNameErrorBox.innerHTML = "";
	}
	
	return validFirstName;
	
}

function validateLastName(){
	
	var validLastName = true;
	
	var lastName = document.getElementById("lastName").value;
	var lastNameErrorBox = document.getElementById("lastNameError");
	
	if(isEmptyString(lastName)){
		validLastName = false;
		lastNameErrorBox.innerHTML = "Last name cannot be blank.";
	} else if(lastName.length > MAX_TEXT_LENGTH){
		validLastName = false;
		lastNameErrorBox.innerHTML = "Last name cannot be more than 25 characters.";
	} else {
		lastNameErrorBox.innerHTML = "";
	}
	
	return validLastName;
}

function isEmptyString(entry){
	return entry.trim() === "";
}