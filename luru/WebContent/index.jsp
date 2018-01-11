<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>麓创 文档自动生成系统</title>
  	<meta http-equiv="pragma" content="no-cache">
  	<meta http-equiv="cache-control" content="no-cache">
  	<meta http-equiv="expires" content="0">
  	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  	<meta http-equiv="description" content="This is my page">
    <style media="screen">
      label{
        font-size: 23px;
        display:inline-block;
        margin-bottom: 2px;
        height:40px;
      }
      input{
        font-size: 23px;
        height:40px;
        margin-bottom: 2px;
      }
      .input-group{
        margin-bottom:2px;
      }
      .panel{
        margin-bottom:0px;
      }
      .form-group{
        position:relative;
        display: inline-block;
        width: 230px;
        margin-right: 55px;
      }
      .his{
        display:none;
      }
    </style>
    <link rel="stylesheet" href="css/bootstrap.css">
  </head>

  <body style="margin:0;">
    <div class="" style="width:100%;">
      <div class="top" style="height:200px;width:100%;position:relative;">
        <img src="img/1-02.jpg" style="width:1920px;height:200px;">
          <h1 style="position:absolute;top:70px;left:20px;">中山市麓创建设机械安全检测有限公司 <small>文档自动生成系统</small></h1>
      </div>
      <div class="" style="">
        <div class="" style="margin:10px auto 5px;width:80%;">
          <a href="ku.jsp" target="_blank" style="margin-left:50px;">服务器里面的文档</a>
        </div>
        <div class="" style="width:1800px;margin:0 auto;">
          <div class="panel panel-info" style="width:100%;">
            <div style="margin:0 auto;width:1700px;">
              <form action="add_luru" method="post" enctype="multipart/form-data" style="margin:42px auto 0;width:1442px;">
                <div class="form-group">
                    <label>种类</label>
                    <select name="mtype" class="form-control">
                    	<option value="-1" selected>请选择种类</option>
                      <option value="物料提升机">物料提升机</option>
                      <option value="塔机">塔机</option>
                      <option value="施工升降机">施工升降机</option>
                      <option value="防坠器">防坠器</option>
                      <option value="钢管、脚手架扣件">钢管、脚手架扣件</option>
                      <option value="安全建材">安全建材</option>
                    </select>
                </div>
                <div class="form-group" style="position:relative;">
                  <label>文件名</label>
                  <input type="type" class="form-control" name="filename">
                </div>
                <div class="form-group">
                  <label>编号</label>
                  <input type="type" class="form-control" name="wl.bh">
                </div>

                <div class="form-group">
                  <label>委托单位</label>
                  <input type="type" class="form-control" name="wl.wtdw">
                </div>
                <div class="form-group">
                  <label>联系人</label>
                  <input type="type" class="form-control" name="wl.name">
                </div>
                <div class="form-group">
                  <label>电话</label>
                  <input type="type" class="form-control" name="wl.phone">
                </div>
                <div class="form-group">
                  <label>安装单位</label>
                  <input type="type" class="form-control" name="wl.azdw">
                </div>
                <div class="form-group">
                  <label>使用单位</label>
                  <input type="type" class="form-control" name="wl.sydw">
                </div>
                <div class="form-group">
                  <label>工程名称</label>
                  <input type="type" class="form-control" name="wl.gcmc">
                </div>
                <div class="form-group">
                  <label>工程地址</label>
                  <input type="type" class="form-control" name="wl.gcdz">
                </div>
                <div class="form-group">
                  <label>设备型号</label>
                  <input type="type" class="form-control" name="wl.sbxh">
                </div>
                <div class="form-group">
                  <label>备案编号</label>
                  <input type="type" class="form-control" name="wl.babh">
                </div>
                <div class="form-group">
                  <label>生产厂家</label>
                  <input type="type" class="form-control" name="wl.sccj">
                </div>
                <div class="form-group">
                  <label>出厂编号</label>
                  <input type="type" class="form-control" name="wl.ccbh">
                </div>
                <div class="form-group">
                  <label>生厂日期</label>
                  <input type="type" class="form-control" placeholder="生产日期(格式 20171228)" name="wl.ccri">
                </div>
                <button type="button" class="btn btn-default test" style="margin: 50px 150px 0px 580px;font-size: 23px;padding: 7px 20px;">提交</button>
                <button type="button" class="btn btn-default clean" style="margin: 50px 0px 0px;font-size: 23px;padding: 7px 20px;">清空</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>





	   <script src="js/jquery-1.11.3.js"></script>
     <script src="js/bootstrap.js"></script>

     <script>
       //清空输入框里面的内容
       $(".clean").click(function(){
         $("input").val("");
       })



   		$(".test").click(function(){
         if($($("select")[0]).val()=="-1"){
           alert("请选择种类");
           return;
         }
         if($("input[name='wl.bh']").val().length != 14){
           alert("编号要等于14位");
           return;
         }
         $("form").submit();
   		})

   	</script>
  </body>
</html>
