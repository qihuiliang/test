/*员工管理页面的json数据*/
/*
$(function(){
	var list = '[{"员工编号":7369, "员工姓名":"SMITH", "工作":"CLERK", "经理":7902, "雇佣日期":"1980-12-17","薪水":800.10, "津贴":0.00, "部门":"RESEARCH"},'
				+'{"员工编号":7499, "员工姓名":"ALLEN","工作":"SALESMAN", "经理":7698, "雇佣日期":"1981-02-20", "薪水":1600.00, "津贴":300.00, "部门":"SALES"},'
				+'{"员工编号":7521, "员工姓名":"SALESMAN", "工作":"SALESMAN", "经理":7698, "雇佣日期":"1981-02-22", "薪水":1250.00, "津贴":500.00, "部门":"SALES"}]';
		var info = JSON.parse(list);
		for (var i = 0; i < info.length; i++) {
			$('tbody').append('<tr>')
			.append('<td>'+info[i].员工编号+'</td>')
                .append('<td>'+info[i].员工姓名+'</td>')
                .append('<td>'+info[i].工作+'</td>')
                .append('<td>'+info[i].经理+'</td>')
                .append('<td>'+info[i].雇佣日期+'</td>')
                .append('<td>'+info[i].薪水+'</td>')
                .append('<td>'+info[i].津贴+'</td>')
                .append('<td>'+info[i].部门+'</td>')
                .append('<img src="../image/u53.png" href="empno'+emp.+'">'
                    +'<img src="../image/u54.png" href="empno'+emp.empno+'">')
                .append('</tr>');
		}
});*/


$(function(){
	$.ajax({
		url:"servlet/SelectAllEmp",
		dataType:"json",
		method: "get",
		success:function(response){
			$.each(response,function(index,emp){
				var $tr = $("<tr></tr>");
				$("tbody").append($tr);
				$.each(emp,function(key,value){
					$tr.append("<td>"+ value+ "</td>");
				});
				$tr.append('<td><a  href="/servlet/DeleteEmp?empno='+emp.empno+'"><img src="../image/u53.png"/></a></td>')
					.append('<td><a href="update.html?empno='+emp.empno+'"><img src="../image/u54.png"></a></td>')
			});
		}
	});
});

