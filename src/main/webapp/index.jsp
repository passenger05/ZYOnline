<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                <li class="active"><a href="index.jsp">添加</a></li>
                <li><a href="statistics.jsp">统计</a></li>
                <li><a href="vote.jsp">投票</a></li>               
                <li><a href="score.jsp">作业要求</a></li>                                                                
            </ul>
        </div>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-md-6">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">添加茶叶</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="input1" class="col-sm-2 control-label">形状</label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control" id="input1" max="1" min="0" step="0.1" placeholder="形状">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="input2" class="col-sm-2 control-label">色泽</label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control" id="input2" max="1" min="0" step="0.1" placeholder="色泽">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="input3" class="col-sm-2 control-label">净度</label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control" id="input3" max="1" min="0" step="0.1" placeholder="净度">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="input4" class="col-sm-2 control-label">汤色</label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control" id="input4" max="1" min="0" step="0.1" placeholder="汤色">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="input5" class="col-sm-2 control-label">香气</label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control" id="input5" max="1" min="0" step="0.1" placeholder="香气">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="input6" class="col-sm-2 control-label">滋味</label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control" id="input6" max="1" min="0" step="0.1" placeholder="滋味">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="input7" class="col-sm-2 control-label">叶底</label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control" id="input7" max="1" min="0" step="0.1" placeholder="叶底">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="button" class="btn btn-default" onclick="loadRate()">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">茶叶品级相似度</h3>
                    </div>
                    <div class="panel-body">

                        <!-- 图表要绘制到这里，设定宽度和高度 -->
                        <div id="chart1" style="height:392px;">

                        </div>
                    </div>
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
        })

        // 提交评分
            
        var similarity = null;
        var rank = null;
        
        function loadRate() {
        	
        	var shape = $("#input1").val();
        	var color = $("#input2").val();
        	var purity = $("#input3").val();
        	var liquorColor = $("#input4").val();
        	var aroma = $("#input5").val();
        	var taste = $("#input6").val();
        	var leaf = $("#input7").val();
        	
        	if(shape == "" || color == "" || purity == "" || liquorColor == "" || aroma == "" || taste == "" || leaf == ""){
        		
        		alert("请添加全部内容");
        		
        	}else{
        		
        		$.ajax({

                    type : 'POST',
                    url : 'http://47.95.200.255:8080/tea/tea/addTea',
                    async : true,

                    contentType : 'application/json;charset=utf-8',
                    data : JSON.stringify({

                        "shape" : $("#input1").val(),
                        "color" : $("#input2").val(),
                        "purity" : $("#input3").val(),
                        "liquorColor" : $("#input4").val(),
                        "aroma" : $("#input5").val(),
                        "taste" : $("#input6").val(),
                        "leaf" : $("#input7").val(),

                    }),

                    dataType : 'json',

                    success : function(data) {
                        
                        similarity = data.data;
                        rank = data.message;
                        
                        load();

                    },
                    error : function(msg) {

                        alert(msg);
                    }
                });
                
        	}
        	
        }
        
        function load() {
        	 // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '该茶叶属于 ' + rank
                },
                tooltip: {},
                legend: {
                    data: ['相似度']
                },
                xAxis: {
                    data: ["特一级", "特二级", "特三级", "一级", "二级", "三级", "四级"]
                },
                yAxis: {},
             
                series: [{
                    type: 'bar',// ==========请求成功，替换 data 中的数字
                    data: similarity,
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