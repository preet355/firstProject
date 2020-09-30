
			jQuery(function($) {

				$('[data-rel=tooltip]').tooltip();

				$('.select2').css('width','200px').select2({allowClear:true})
				.on('change', function(){
					$(this).closest('form').validate().element($(this));
				});


				var $validation = false;
				$('#fuelux-wizard-container')
				.ace_wizard({
					//step: 2 //optional argument. wizard will jump to step "2" at first
					//buttons: '.wizard-actions:eq(0)'
				})
				.on('actionclicked.fu.wizard' , function(e, info){
					if(info.step == 1 && $validation) {
						if(!$('#validation-form').valid()) e.preventDefault();
					}
				})
				//.on('changed.fu.wizard', function() {
				//})
				.on('finished.fu.wizard', function(e) {
					bootbox.dialog({
						message: "Nothing Else To Show!",
						buttons: {
							"success" : {
								"label" : "OK",
								"className" : "btn-sm btn-primary"
							}
						}
					});
				}).on('stepclick.fu.wizard', function(e){
					//e.preventDefault();//this will prevent clicking and selecting steps
				});


				//jump to a step
				/**
				var wizard = $('#fuelux-wizard-container').data('fu.wizard')
				wizard.currentStep = 3;
				wizard.setState();
				*/

				//determine selected step
				//wizard.selectedItem().step



				//hide or show the other form which requires validation
				//this is for demo only, you usullay want just one form in your application
				$('#skip-validation').removeAttr('checked').on('click', function(){
					$validation = this.checked;
					if(this.checked) {
						$('#sample-form').hide();
						$('#validation-form').removeClass('hide');
					}
					else {
						$('#validation-form').addClass('hide');
						$('#sample-form').show();
					}
				})



				//documentation : http://docs.jquery.com/Plugins/Validation/validate


				$.mask.definitions['~']='[+-]';
				$('#phone').mask('(999) 999-9999');

				jQuery.validator.addMethod("phone", function (value, element) {
					return this.optional(element) || /^\(\d{3}\) \d{3}\-\d{4}( x\d{1,6})?$/.test(value);
				}, "Enter a valid phone number.");

				$('#validation-form').validate({
					errorElement: 'div',
					errorClass: 'help-block',
					focusInvalid: false,
					ignore: "",
					rules: {
						email: {
							required: true,
							email:true
						},
						password: {
							required: true, 
							minlength: 5
						},
						password2: {
							required: true,
							minlength: 5,
							equalTo: "#password"
						},
						name: {
							required: true
						},
						phone: {
							required: true,
							phone: 'required'
						},
						url: {
							required: true,
							url: true
						},
						comment: {
							required: true
						},
						state: {
							required: true
						},
						platform: {
							required: true
						},
						subscription: {
							required: true
						},
						gender: {
							required: true,
						},
						agree: {
							required: true,
						}
					},

					messages: {
						email: {
							required: "Please provide a valid email.",
							email: "Please provide a valid email."
						},
						password: {
							required: "Please specify a password.",
							minlength: "Please specify a secure password."
						},
						state: "Please choose state",
						subscription: "Please choose at least one option",
						gender: "Please choose gender",
						agree: "Please accept our policy"
					},


					highlight: function (e) {
						$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
					},

					success: function (e) {
						$(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
						$(e).remove();
					},

					errorPlacement: function (error, element) {
						if(element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
							var controls = element.closest('div[class*="col-"]');
							if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
							else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
						}
						else if(element.is('.select2')) {
							error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
						}
						else if(element.is('.chosen-select')) {
							error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
						}
						else error.insertAfter(element.parent());
					},

					submitHandler: function (form) {
					},
					invalidHandler: function (form) {
					}
				});




				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				})
				
				//show datepicker when clicking on the icon
				.next().on(ace.click_event, function(){
					$(this).prev().focus();
				});
//				$('#id-date-picker-1').attr('readonly','readonly');
				$('.input-daterange').datepicker({autoclose:true});
				
				
				
				       
							 $(document).one('ajaxloadstart.page', function(e) {
									$('[class*=select2]').remove();
									$('select[name="duallistbox_demo1[]"]').bootstrapDualListbox('destroy');
									$('.rating').raty('destroy');
									$('.multiselect').multiselect('destroy');
								});
							 
									$('#id-input-file-2').ace_file_input({
										no_file:'No File ...',
										btn_choose:'Choose',
										btn_change:'Change',
										droppable:false,
										onchange:null,
										thumbnail:false
										
									});
									$(document).ready(function() {
										var data = document.getElementById(selectClass);
										   $("#selectClass").select2({
											   allowClear: true,
												  data: data,
												  placeholderOption: function () { return 'Please select...';}
												});
										});
									$(document).ready(function() {
										var data = document.getElementById(desigDropDown);
										   $("#desigDropDown").select2({
											   allowClear: true,
												  data: data,
												  placeholderOption: function () { return 'Please select...';}
												});
										});
									
									
									
			}) 

function showBackReferredForm(idRequisition){
	   document.getElementById('idRequisition').value=idRequisition;
	   document.getElementById('requisitionForm').action="backReferred";
	   document.getElementById('requisitionForm').submit();
   }			
			
function saveRequisitionForm(onlyPwdFlag,pwdFlag){
	   var designation=document.registerRequisitionForm.postmasterId.value;
	   var noOfPost=document.registerRequisitionForm.numberOfPostToBeFilled.value;
	   var classOfPost=document.registerRequisitionForm.classAndServiceOfPost.value;
	   var anyPublishedRulesForService=document.registerRequisitionForm.anyPublishedRulesForService.value;
	   var isPostPermanentOrTemporary=document.registerRequisitionForm.isPostPermanentOrTemporary.value;
	   var scaleOfPayForDirectRecruits=document.registerRequisitionForm.scaleOfPayForDirectRecruits.value;
	   var anySpecialConcessionsForNonAsiaticDomicile=document.registerRequisitionForm.anySpecialConcessionsForNonAsiaticDomicile.value;
	   var scaleOfPayForPersonsAlreadyInGovernmentService=document.registerRequisitionForm.scaleOfPayForPersonsAlreadyInGovernmentService.value;
	   var higherInitialPayBeGranted=document.registerRequisitionForm.higherInitialPayBeGranted.value;
	   var academicQualifications=document.registerRequisitionForm.academicQualifications.value;
	   var training=document.registerRequisitionForm.training.value;
	   var hindiQualification=document.registerRequisitionForm.hindiQualification.value;
	   var experience=document.registerRequisitionForm.experience.value;
	   var isExperienceTakenIntoConsidration=document.registerRequisitionForm.isExperienceTakenIntoConsidration.value;
	   var equivalentQualifications=document.registerRequisitionForm.equivalentQualifications.value;
	   var anyOtherQualifications=document.registerRequisitionForm.anyOtherQualifications.value;
	   var requirementsStrictlyAthered=document.registerRequisitionForm.requirementsStrictlyAthered.value;
	   var lowerAgeLimit=document.registerRequisitionForm.lowerAgeLimit.value;
	   var upperAgeLimit=document.registerRequisitionForm.upperAgeLimit.value;
	   var areGovServantsEligible=document.registerRequisitionForm.areGovServantsEligible.value;
	   var anyRelaxationForGovServents=document.registerRequisitionForm.anyRelaxationForGovServents.value;
	   var anyRelaxationForSutaibleCandidates=document.registerRequisitionForm.anyRelaxationForSutaibleCandidates.value;
	   var nameOfOfficerForAdvisoryCapacity=document.registerRequisitionForm.nameOfOfficerForAdvisoryCapacity.value;
	   var nameOfNodalOfficer=document.registerRequisitionForm.nameOfNodalOfficer.value;
	   var phoneNumberOfNodelOfficer=document.registerRequisitionForm.phoneNumberOfNodelOfficer.value;
	   var conditionOrQualificationNotCoveredAbove=document.registerRequisitionForm.conditionOrQualificationNotCoveredAbove.value;
	   var linkForServiceRules=document.registerRequisitionForm.linkForServiceRules.value;
	   
	   var fileUpload= document.getElementById("id-input-file-2");
		  
	   if(fileUpload.value=='' && linkForServiceRules==''){
		   document.getElementById("Error").innerHTML = "Either Upload the signed PDF or mention the link for service rules in General Section";
			  return false;
		  }
	      
		  else if(designation=="" || designation==0){
	    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in General Section";
	    	designation.focus();
	   	     return false;
	     }
	     else if(noOfPost==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory.  Make sure no field left blank in General Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(classOfPost==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory.  Make sure no field left blank in General Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(anyPublishedRulesForService==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory.  Make sure no field left blank in General Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(isPostPermanentOrTemporary==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory.  Make sure no field left blank in General Section";
		    	designation.focus();
		   	     return false;
		     }
	     
	     else if(scaleOfPayForDirectRecruits==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Scale Of Pay Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(anySpecialConcessionsForNonAsiaticDomicile==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Scale Of Pay Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(scaleOfPayForPersonsAlreadyInGovernmentService==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Scale Of Pay Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(higherInitialPayBeGranted==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Scale Of Pay Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(academicQualifications==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Qualification Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(training==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Qualification Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(hindiQualification==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Qualification Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(experience==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Qualification Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(isExperienceTakenIntoConsidration==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Qualification Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(equivalentQualifications==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Qualification Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(anyOtherQualifications==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Qualification Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(requirementsStrictlyAthered==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Qualification Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(lowerAgeLimit==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Age-Limit Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(upperAgeLimit==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Age-Limit Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(areGovServantsEligible==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Age-Limit Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(anyRelaxationForGovServents==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Age-Limit Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(anyRelaxationForSutaibleCandidates==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Age-Limit Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(nameOfOfficerForAdvisoryCapacity==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Total Vacancies Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(nameOfNodalOfficer==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Total Vacancies Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(phoneNumberOfNodelOfficer==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Total Vacancies Section";
		    	designation.focus();
		   	     return false;
		     }
	     else if(conditionOrQualificationNotCoveredAbove==""){
		    	document.getElementById("Error").innerHTML = "All * mark Feilds are mandatory. Make sure no field left blank in Total Vacancies Section";
		    	designation.focus();
		   	     return false;
		     }
	    else{  
	    	   if(onlyPwdFlag!="true"){	
	    		  if(pwdFlag!="false") {
					var totalFilled = Number(document.getElementsByName('pwd1')[0].value) + 
					  Number(document.getElementsByName('pwd2')[0].value) +
					  Number(document.getElementsByName('pwd3')[0].value) +
					  Number(document.getElementsByName('pwd4')[0].value);
	
	               var noOfPost=document.getElementById("noOfPostForBifurcation").value;
	               var totalPwd = Math.trunc((noOfPost*4)/100);
	
					if(totalFilled != totalPwd){
						var r=confirm("Entered Seats are not as per the 4% reservation criteria. Are you sure you want to submit ?");
						if(r==true){
							document.getElementById("totalFilled").value=totalFilled;
		                    document.getElementById('requisitionForm').action='saveRequisitionForm';
							document.getElementById('requisitionForm').submit();
						}else{
							document.getElementsByName('pwd1')[0].value= 0;
							document.getElementsByName('pwd2')[0].value= 0;
							document.getElementsByName('pwd3')[0].value= 0;
							document.getElementsByName('pwd4')[0].value= 0;
							return false;	
						}
						
					} 
	    	}
				var totalFilled = 0;
//				var espPost=document.getElementById("totalesp").value;
				
//				if(espPost!=''){
//					totalFilled=Number(totalFilled)+Number(espPost);
//				}
				
					for(var i =0; i <5 ; i++){
						document.getElementsByName('bifurcationList['+i+'].totalCount')[0].value = 
							Number(document.getElementsByName('bifurcationList['+i+'].esmCount')[0].value) + 
							Number(document.getElementsByName('bifurcationList['+i+'].espCount')[0].value) + 
									Number(document.getElementsByName('bifurcationList['+i+'].nonEsmEspCount')[0].value) ;
						totalFilled = Number(totalFilled) + Number(document.getElementsByName('bifurcationList['+i+'].totalCount')[0].value);
					}
					if(totalFilled != document.getElementById('noOfPostForBifurcation').value){
						alert("Please enter valid values in the seat allocation");
					}
                else{
					document.getElementById("totalFilled").value=totalFilled;
                    document.getElementById('requisitionForm').action='saveRequisitionForm';
					document.getElementById('requisitionForm').submit();					
				}
	    	 }
	    	   else{
	    	   document.getElementById('requisitionForm').action='saveRequisitionForm';
			   document.getElementById('requisitionForm').submit();	
	    	 }
	    }	
}


function pwdTotal(){
                var noOfPost=document.getElementById("noOfPostForBifurcation").value;
				
				var totalPwd = Math.trunc((noOfPost*4)/100);
				
				document.getElementById('totalPwd').value = totalPwd;
			   }
/*function espCalculate(){
	 
	var noOfPosts=document.getElementById("noOfPostForBifurcation").value;
	var group=document.getElementById("selectClass").value;
	
	if(group=='Group-C'){
		var totalesp = Math.trunc((noOfPosts*3)/100);
	}else if(group=='Group-D'){
		var totalesp = Math.trunc((noOfPosts*10)/100);
	}
	
	document.getElementById('totalesp').value = totalesp;
}*/
			
				
		/*	function validateTotalPWD(obj){
				var noOfPost=document.getElementById("noOfPostForBifurcation").value;
				
				var totalPwd = Math.trunc((noOfPost*4)/100);
				
				var totalFilled = Number(document.getElementsByName('pwd1')[0].value) + 
								  Number(document.getElementsByName('pwd2')[0].value) +
								  Number(document.getElementsByName('pwd3')[0].value) +
								  Number(document.getElementsByName('pwd4')[0].value);
				if(totalFilled > totalPwd){
					alert("Please enter valid bifurcation for PWD seats");
					obj.value=0;
				}
			} */
			
			function validateTotal(obj){
				var totalFilled = 0;
				
				var noOfPost=document.getElementById("noOfPostForBifurcation").value;
//				var espPost=document.getElementById("totalesp").value;
				if(noOfPost==''){
					alert("Please enter no. of Posts before bifurcation");
					obj.value='';
					return false;
					
				}
				
//				if(!espPost==''){
//					totalFilled=Number(totalFilled)+Number(espPost);
//				}
				
				for(var i =0; i <5 ; i++){
					document.getElementsByName('bifurcationList['+i+'].totalCount')[0].value = 
						Number(document.getElementsByName('bifurcationList['+i+'].esmCount')[0].value) + 
						Number(document.getElementsByName('bifurcationList['+i+'].espCount')[0].value) + 
								Number(document.getElementsByName('bifurcationList['+i+'].nonEsmEspCount')[0].value) ;
					totalFilled = Number(totalFilled)+ Number(document.getElementsByName('bifurcationList['+i+'].totalCount')[0].value);
					document.getElementsByName('totalSeatsFilled')[0].value = totalFilled;
					if(totalFilled > document.getElementById('noOfPostForBifurcation').value){
						alert("Total bifurcated seats should not be greater than total no. of posts.");
						document.getElementsByName('totalSeatsFilled')[0].value=totalFilled;
						obj.value=0;
						return false;
						/*for(var i =0; i <6 ; i++){
							document.getElementsByName('bifurcationList['+i+'].esmCount')[0].value = 0;
							document.getElementsByName('bifurcationList['+i+'].espCount')[0].value = 0;
							document.getElementsByName('bifurcationList['+i+'].nonEsmEspCount')[0].value = 0;
							
						}*/
				}else{
					document.getElementsByName('totalSeatsFilled')[0].value = totalFilled;
				}
			   }
			}
			
			function validateMonths(obj){
				var months=document.getElementsByName('experienceInMonths')[0].value;
				
				if(months>12){
					document.getElementById("Error7").innerHTML = "Months value should not be greater than 12";
					document.getElementsByName('experienceInMonths')[0].value=0
					return false;
				}
			}
			
			function validateCount(){
				document.getElementById('requisitionForm').target='Validate Requisitions';	
				document.getElementById('requisitionForm').onsubmit = window.open("about:blank","Validate Requisitions", "width=1000,height=600");
				document.getElementById('requisitionForm').action = "readOnlyReq";
				document.getElementById('requisitionForm').submit();
				}
			
			function SelectChanged(obj,desig){
				var cmb = document.getElementById(obj.id).value;
				document.getElementById("idSpinner").style.display = "inline-block";
				var postGroupId=null;
				   if(cmb=='Group-B'){
					   postGroupId=2;
					   /*document.getElementById("exceptGB").style.display = "none";
					   document.getElementById("bifurcationExceptGB").style.display = "none";
					   document.getElementById("GB").style.display = "table-row";
					   document.getElementById("bifurcationGB").style.display = "table-row";*/
				   }else if(cmb=='Group-C'){
					   postGroupId=3;
					   /*document.getElementById("exceptGB").style.display = "table-row";
					   document.getElementById("bifurcationExceptGB").style.display = "table-row";
					   document.getElementById("GB").style.display = "none";
					   document.getElementById("bifurcationGB").style.display = "none";*/
				   }else if(cmb=='Group-D'){
					   postGroupId=4;
					   /*document.getElementById("exceptGB").style.display = "table-row";
					   document.getElementById("bifurcationExceptGB").style.display = "table-row";
					   document.getElementById("GB").style.display = "none";
					   document.getElementById("bifurcationGB").style.display = "none";*/
				   }
				
				 $.ajax({
						type: "GET",
						url: "fetchAllPosts",
						data: { postGroupId: postGroupId},
						async: false,
						success: function(response){
							document.getElementById("idSpinner").style.display = "none";
							/*var options="";
							 for(i=0;i<response.length;i++){
			                    options += '<option value="' + response[i].postmasterId + '">' + response[i].postName + '</option>';
								 $("#"+desig).html(options);
						}*/
							$('#postMasterAjaxList').html(response);	
							

						}
				});
			}
 /*function validateESP(){
	 var esp=document.getElementById('totalesp').value;
	 
	 var noOfPosts=document.getElementById("noOfPostForBifurcation").value;
	 
	 var group=document.getElementById("selectClass").value;
		
		if(group=='Group-C'){
			var totalesp = Math.trunc((noOfPosts*3)/100);
		}else if(group=='Group-D'){
			var totalesp = Math.trunc((noOfPosts*10)/100);
		}
		
		if(esp!=totalesp){
			var r=confirm("Entered seats are not as per ESP bifurcation criteria. Do you wish to proceed");
			if(r==true){
				return true;
			}else{
				espCalculate();	
			}
		}
 }*/
 
 function showPHBifurcation(){
	 var blnum=document.getElementById("blVision").value;
	 var hhnum=document.getElementById("hhVision").value;
	 var ohnum=document.getElementById("ohVision").value;
	 if(blnum!=" "){
		 document.getElementById("vh").style.display = "table-row";
	 }
	 if(hhnum!=" "){
		 document.getElementById("hh").style.display = "table-row";
	 }
	 if(ohnum!=" "){
		 document.getElementById("orthoHed").style.display =  "table-row";
		 document.getElementById("oh").style.display =  "table-row";
		 document.getElementById("oh1").style.display = "table-row";
		 document.getElementById("oh2").style.display = "table-row";
	 }
 }
 
 
 function showPHBifurcation1(){
	 var bl1num=document.getElementById("bl1Vision").value;
	 var hh1num=document.getElementById("hh1Vision").value;
	 var oh1num=document.getElementById("oh1Vision").value;
	 if(bl1num!=" "){
		 document.getElementById("vh1").style.display = "table-row";
	 }
	 if(hh1num!=" "){
		 document.getElementById("hh1").style.display = "table-row";
	 }
	 if(oh1num!=" "){
		 document.getElementById("orthoHed1").style.display =  "table-row";
		 document.getElementById("oh0").style.display =  "table-row";
		 document.getElementById("oh11").style.display = "table-row";
		 document.getElementById("oh21").style.display = "table-row";
	 }
 }
 
 
