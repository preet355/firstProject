<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select name="postmasterId" class="formControl" id="ajaxDesigDropDown" style="width:200px;"  data-placeholder="Search Designation...">
				<option value="0">Search Designation...</option>
				<c:forEach items="${desigList}" var="tag3" varStatus="loop">
						 	<option  value="${tag3.postmasterId}" >${tag3.postName}</option>
						 
						 </c:forEach>
				</select>	
<script>
$(document).ready(function() {
	var data = document.getElementById(ajaxDesigDropDown);
	   $("#ajaxDesigDropDown").select2({
		   allowClear: true,
			  data: data,
			  placeholderOption: function () { return 'Please select...';}
			});
	});
</script>				