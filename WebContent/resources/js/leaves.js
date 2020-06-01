
function appliedLeave()
{
	
var empId   = document.getElementById("empId").value;
var company = document.getElementById("company").value;
$('#example').DataTable({
    "serverSide": true,
    "processing": true,
    "paging": true,
    "searching": { "regex": true },
    "lengthMenu": [ [1,5,10,20] ],
    "pageLength": 1,
    columns: [
        { title: "S.No" },
        { title: "Name" },
        { title: "Appliedon" },
        { title: "Status" },
        { title: "Leave Type" },
        { title: "Approved by" }
    ],
    "ajax": {
        "type": "POST",
        "url": "/appliedLeaves.obj?empId="+empId+"&company="+company,
        "dataType": "json",
        "contentType": 'application/json; charset=utf-8',
    	type:"POST",
        "data": function (response) {
            // Grab form values containing user options
            var form = {};
            $.each($("form").serializeArray(), function (i, field) {
                form[field.name] = field.value || "";
            });
            // Add options used by Datatables
            var info = { "start": 0, "length": 1, "draw": 1 };
            $.extend(form, info);
            return JSON.stringify(form);
        },
        "complete": function(response) {
            console.log(response);
       }
    }
});


$.ajax({
	url:"appliedLeaves.obj",
	type:"POST",
	data:{
		"empId":empId,
		"company":company
	},
	success:function(response)
	{
		console.log(response);
		var content = JSON.parse(response);
		var value = content.leaves;
		var dataset = new Array();
		
		for (var i = 0; i < value.length; i++) {
		  var array = new Array();
		  array.push(i);
		  array.push(value[i].applied_by);
		  array.push(value[i].appliedon);
		  array.push(value[i].status);
		  array.push(value[i].type);
		  array.push(value[i].approved_by);
		  dataset.push(array);
			console.log(value[i].applied_by);
			
		}
		console.log(dataset);
		
		$('#example').DataTable( {
	        data: dataset,
	        serverSide: true,
	        ordering: false,
	        searching: false,
	        columns: [
	            { title: "S.No" },
	            { title: "Name" },
	            { title: "Appliedon" },
	            { title: "Status" },
	            { title: "Leave Type" },
	            { title: "Approved by" }
	        ]
	    });
	
		
	}
	
});


}





