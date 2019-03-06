const MAX_TITLE_LENGTH = 35;

function validateBook(){
	var validBook = true;
	
	if(!validateTitle()){
		validBook = false;
	}
	
	return validBook;
}

function validateTitle(){
	validTitle = true;
	
	var title = document.getElementById("title").value;
	var titleErrorBox = document.getElementById("titleError");
	
	if(isEmptyString(title)){
		validTitle = false;
		titleErrorBox.innerHTML = "Title cannot be blank.";
	} else if(title.length > MAX_TITLE_LENGTH){
		validTitle = false;
		titleErrorBox.innerHTML = "Title cannot be more than 35 characters."
	} else {
		titleErrorBox.innerHTML = "";
	}
	
	return validTitle;
}

function isEmptyString(entry){
	return entry.trim() === "";
}