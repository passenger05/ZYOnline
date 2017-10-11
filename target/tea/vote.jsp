<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>茶叶管理系统</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">茶叶品级管理系统</a>
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">添加</a></li>
                <li><a href="statistics.jsp">统计</a></li>
                <li class="active"><a href="vote.jsp">投票</a></li>
                <li><a href="score.jsp">作业要求</a></li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-md-7">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">群众最喜欢的茶叶</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row" id="brand">
                        
                        
                            <div class="col-md-3">
                                <div style="background-color:burlywood; padding:10px;margin-top:5px">
                                    <img src="img/ahhc.gif" class="img-thumbnail">
                                    <button class="btn btn-default" type="button" onclick="loadVote()" style="width:100%; margin-top:10px;">投票(10000)</button>
                                </div>
                            </div>
                            
                            
                          
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-5">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">排行榜 
                        <span id="time"></span>
                        </h3>
                    </div>
                    <div class="panel-body">

                        <!-- 图表要绘制到这里，设定宽度和高度 -->
                        <div id="chart1" style="height:370px;">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="loginModalLabel">登录</h4>
                </div>
                
                <div class="modal-body">
                    <div class="form-group">
                      <input type="text" class="form-control" id="phone" placeholder="请输入手机号">
                    </div>
                </div>
                
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary" onclick="telephone()">登录</button>
                </div>
                
                
              </div>
            </div>
          </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

    <!-- 图表 js 库 -->
    <script src="js/echarts.min.js"></script>

    <script type="text/javascript">
        // 设置图表为全局变量
        var chart1 = null;

        $(document).ready(function () {

            // 基于准备好的 dom，初始化echarts实例，并设置全局变量 chart1
            chart1 = echarts.init(document.getElementById('chart1'));

            // 加载完毕页面就加载排行榜
            loadRank();
            
            loadBrand();

            // 然后每两秒更新一次排行榜，自己修改为 30 s
            setInterval('loadRank()', 2000);
        })
        
        
        function loadBrand() {
        	
        	$.ajax({

                type : 'POST',
                url : 'http://47.95.200.255:8080/tea/brand/listBrand',
                async : true,
                
                contentType:'application/json;charset=utf-8',
                  
                dataType:'json',
                  
                success:function(data){
                	
                	$("#brand").empty("");
                    $.each(data, function(index, obj) {
                        
                    	$("#brand").append(
                    			"<div class='col-md-3'>" +
                    			
                                "<div style='background-color:burlywood; padding:10px;margin-top:5px'>" +
                                    "<img src='img/"+ obj.image +"' class='img-thumbnail'>" +
                                    "<button class='btn btn-default' type='button' onclick='loadVote(" + obj.id + ")' style='width:100%; margin-top:10px;'>投票("+ obj.number +")</button>" +
                                "</div>"+
                                "</div>");
                    
                    });
                  },
                  
                  error:function(message) {
                      alert(JSON.stringify(message));
                  }
               });
        }
        
        
        
        
        var brandId = 0;

        // 投票
        function loadVote(id) {
        	
        	brandId = id;
        	
        	
        	$.ajax({

                type : 'POST',
                url : 'http://47.95.200.255:8080/tea/brand/vote',
                async : true,
                
                contentType:'application/json;charset=utf-8',
                  
                data : JSON.stringify({
                    "id" : id
                }),
                
                dataType:'json',
                  
                success:function(data){
                	
                	if (data.errorCode == -1000) {
                		// 未登陆
                		$('#loginModal').modal();
                		
                    } else {
                    	
                    	loadBrand();
                    }
                  },
                  
                  error:function(message) {
                      alert(JSON.stringify(message));
                  }
               });
        }
        
        function telephone() {
        	
        	var phone = $("#phone").val();
        	
        	var flag = isPhoneNo(phone);
        	
        	if(flag){
        		
        		$("#loginModal").modal('hide');
        		
        		vote(phone);
        		 
        	}else{
        		alert("不是正确的手机号格式!");
        	}
        	
		}
        
        function vote(phone){
        	
        	$.ajax({

                type : 'POST',
                url : 'http://47.95.200.255:8080/tea/brand/login',
                async : true,
                
                contentType:'application/json;charset=utf-8',
                  
                data : JSON.stringify({
                    "telephone" : phone
                }),
                
                dataType:'json',
                  
                success:function(data){
                    
                    loadVote(brandId);
                  },
                  
                  error:function(message) {
                      alert(JSON.stringify(message));
                  }
               });
        }
        
        
        
        
        function isPhoneNo(phone) { 
        	
            var pattern = /^1[34578]\d{9}$/; 
            return pattern.test(phone); 
        }
        
        
        var numbers = new Array();
        var names = new Array();

        // 获取排行榜
        function loadRank() {
        	
        	
        	$.ajax({

                type : 'POST',
                url : 'http://47.95.200.255:8080/tea/brand/listBrandByNumber',
                async : true,
                
                contentType:'application/json;charset=utf-8',
                  
                dataType:'json',
                  
                success:function(data){
                	$("#time").html(data.nowTime);
                	
                	numbers = data.numbers;
                	names= data.names;
                	
                	loadRank2();
                  
                  },
                  
                  error:function(message) {
                      alert(JSON.stringify(message));
                  }
               });
           
        }
        
        function loadRank2() {
			
        	 // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '得票数'
                },
                tooltip: {// 鼠标放上展示的提示信息格式
                    trigger: 'item',
                    formatter: "{b}<br/>得票数 : {c}" // 设置茶叶名称
                   
                },
                grid:{
                	x:80,
                	x2:10,
                	y2:20
                },
                
                xAxis: {
                    type: 'value',
                },
                yAxis: {
                    type: 'category',
                    data: [names[7], names[6], names[5], names[4], names[3], names[2], names[1], names[0]]
                },
                series: [{
                    type: 'bar',//==============使用得票数填充 data
                    data: [numbers[7], numbers[6], numbers[5], numbers[4], numbers[3], numbers[2], numbers[1], numbers[0]],
                    itemStyle: {
                        normal: {
                            color: function (param) {
                                var colorList = [
                                    '#C1232B', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                                    '#FE8463', '#9BCA63'
                                ];
                                return colorList[param.dataIndex]
                            }
                        }
                    }
                }]
            };

            // 使用指定的配置项和数据显示图表。
            chart1.setOption(option);
		}
    </script>
</body>

</html>