<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">
  <title></title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <link rel="stylesheet" href="css/bootstrap.css">

    <style media="screen">
      .input-group{
        margin-bottom:2px;
      }
      .panel{
        margin-bottom:0px;
      }
      .form-group{
        position:relative;
      }
      .his{
        display:none;
      }
    </style>
  </head>
  <body>
    <div class="panel panel-info" style="width:100%;">
      <div style="margin:0 auto;width:600px;">
        <form action="add_luru" method="post" enctype="multipart/form-data" style="margin-top:42px;">
          <div class="form-group">
              <label>种类</label>
              <select name="mtype" class="form-control">
              	<option value="-1" selected>请选择种类</option>
                <option value="物料提升机">物料提升机</option>
                <option value="塔机">塔机</option>
                <option value="施工升降机">施工升降机</option>
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
            <label>生厂厂家</label>
            <input type="type" class="form-control" name="wl.sccj">
          </div>
          <div class="form-group">
            <label>出产编号</label>
            <input type="type" class="form-control" name="wl.ccbh">
          </div>
          <div class="form-group">
            <label>生产日期</label>
            <input type="type" class="form-control" placeholder="生产日期(格式 20171228)" name="wl.ccri">
          </div>
          <button type="button" class="btn btn-default test">提交</button>
          <button type="button" class="btn btn-default clean">清空</button>
        </form>
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
          alert("请选择种类")
          return;
        }
        $.each($("input"),function(index){
          if($(this).val().trim()==''){
            alert("所有信息不能为空")
            return ;
          }
        })
        $("form").submit();
  		})

  	</script>

  </body>
</html>
