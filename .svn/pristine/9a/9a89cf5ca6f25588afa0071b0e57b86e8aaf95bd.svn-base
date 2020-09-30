function saveDetails(dEpartmentId){
	    var selectedValue=selectDepart.value;
	    var postName=document.postForm.nAmeOfPost;
	    var advtNo=document.postForm.aDvtNo;
	    var catNo=document.postForm.cAtNo;
	     if(selectedValue==""){
	    	  document.getElementById("Error").innerHTML = "Please select the department";
	    	  selectDepart.focus();
	          return false;
	     }
	     else if(postName.value==""){
	    	  document.getElementById("Error1").innerHTML = "Please Enter the post name";
	    	  postName.focus();
	    	  return false;
	     }
	     else if(advtNo.value==""){
	    	 document.getElementById("Error2").innerHTML = "Please Enter the Advertisement number";
	    	 advtNo.focus();
	    	 return false;
	     }
	     else if(catNo.value==""){
	    	 document.getElementById("Error3").innerHTML = "Please Enter the category number";
	    	 advtNo.focus();
	    	 return false;
	     }
	    else{
	   document.getElementById('dEpartmentId').value=selectedValue;
	   document.getElementById('postDetailsForm').action="updatePostDetails";
	   document.getElementById('postDetailsForm').submit();
	    }
}
function isNumberKey(evt,msg,errId){
    var charCode = (evt.which) ? evt.which : event.keyCode
    var id=errId;
    if (charCode > 31 && (charCode< 48 || charCode>57)){
    	 document.getElementById(errId).innerHTML = msg;
        return false;
        }
    else{
    	document.getElementById(errId).innerHTML = "";
         return true;
    
    }
    
}
function isDatekey(evt,msg,errId,aTag){
	document.getElementById(errId).innerHTML = msg;
	document.getElementById('nExtStepvalue').value=msg;
	document.getElementById(aTag).style.pointerEvents="auto";
    document.getElementById(aTag).style.cursor="pointer";      
     return true;
   }

