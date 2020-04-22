function validate(frm) {
	frm.vflag.value="yes";
	 
	//setting style to error message
	document.getElementById("subjectIDErr").innerHTML="";
	document.getElementById("subjectErr").innerHTML="";
	document.getElementById("branchErr").innerHTML="";
	document.getElementById("shortNameErr").innerHTML="";
	
	//read form data
	var subjectID=frm.subjectID.value;
	var subject=frm.subject.value;
	var branch=frm.branch.value;
	var shortName=frm.shortName.value;
	
	//performing validation
	if(subjectID==""){
		document.getElementById("subjectIDErr").innerHTML="SubjectID is Mandatory";
		frm.subjectID.focus();
		return false;
	}
	if(subject==""){
		document.getElementById("subjectErr").innerHTML="Subject is Mandatory";
		frm.subject.focus();
		return false;
	}
	if(branch==""){
		document.getElementById("branchErr").innerHTML="Branch is Mandatory";
		frm.branch.focus();
		return false;
	}
	if(shortName==""){
		document.getElementById("shortNameErr").innerHTML="ShortName is Mandatory";
		frm.shortName.focus();
		return false;
	}
	return true;
}