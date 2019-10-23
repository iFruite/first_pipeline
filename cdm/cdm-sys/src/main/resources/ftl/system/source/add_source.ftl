<#--Created by IntelliJ IDEA.
User: Administrator
Date: 2017/12/27
Time: 12:40
To change this template use File | Settings | File Templates.-->

<!DOCTYPE html>
<html>

  <head>
    <meta charset="UTF-8">
    <title>商机管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
    <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js" charset="utf-8"></script>
  </head>

  <body>
    <div class="x-body">
      <form class="layui-form layui-form-pane" style="margin-left: 20px;">
        <div style="width:100%; height:500px; overflow: auto;">
          <div class="layui-form-item">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
              <legend style="font-size:16px;">基础信息</legend>
            </fieldset>
          </div>
          <div style="margin-left:25%">
            <div class="layui-form-item">
              <label for="sourceType" class="layui-form-label">
                  <span class="x-red">*</span>商机类型
              </label>
              <div class="layui-input-block" style="width:190px;">
                <select name="sourceType" id="sourceType" lay-verify="sourceType"  lay-filter="sourceType">
                  <option value=""></option>
                  <option value="0">前程无忧</option>
                  <option value="1">智联招聘</option>
                  <option value="2">中华英才</option>
                  <option value="3">大街招聘</option>
                  <option value="4">人才热线</option>
                  <option value="5">自主添加</option>
                </select>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="name" class="layui-form-label">
                <span class="x-red">*</span>名称
              </label>
              <div class="layui-input-inline">
                <input type="text"  id="name" name="name"  lay-verify="name"
                      autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="mobile" class="layui-form-label">
                手机
              </label>
              <div class="layui-input-inline">
                <input type="text" id="mobile" name="mobile" lay-verify="mobile"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="age" class="layui-form-label">
                年龄
              </label>
              <div class="layui-input-inline">
                <input type="text" id="age" name="age" lay-verify="age"  autocomplete="off" class="layui-input">
              </div>
            </div>
            <div class="layui-form-item">
              <label for="gender" class="layui-form-label">
                性别
              </label>
              <div class="layui-input-inline">
                <input type="text" id="gender" name="gender" lay-verify="gender"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="degree" class="layui-form-label">
                学历
              </label>
              <div class="layui-input-inline">
                <input type="text" id="degree" name="degree" lay-verify="degree"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="school" class="layui-form-label">
                院校
              </label>
              <div class="layui-input-inline">
                <input type="text" id="school" name="school" lay-verify="school"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="hukou" class="layui-form-label">
                户口
              </label>
              <div class="layui-input-inline">
                <input type="text" id="hukou" name="hukou" lay-verify="hukou"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="location" class="layui-form-label">
                地址
              </label>
              <div class="layui-input-inline">
                <input type="text" id="location" name="location" lay-verify="location"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="email" class="layui-form-label">
                邮件
              </label>
              <div class="layui-input-inline">
                <input type="text" id="email" name="email" lay-verify="email"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="education" class="layui-form-label">
                教育
              </label>
              <div class="layui-input-inline">
                <input type="text" id="education" name="education" lay-verify="education"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="career" class="layui-form-label">
                工作
              </label>
              <div class="layui-input-inline">
                <input type="text" id="career" name="career" lay-verify="career"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="project" class="layui-form-label">
                项目
              </label>
              <div class="layui-input-inline">
                <input type="text" id="project" name="project" lay-verify="project"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="skills" class="layui-form-label">
                技能
              </label>
              <div class="layui-input-inline">
                <input type="text" id="skills" name="skills" lay-verify="skills"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="position" class="layui-form-label">
                职位
              </label>
              <div class="layui-input-inline">
                <input type="text" id="position" name="position" lay-verify="edupositioncation"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="remark" class="layui-form-label">
                备注
              </label>
              <div class="layui-input-inline">
                <input type="text" id="remark" name="remark" lay-verify="remark"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
          </div>
        </div>
        <div style="height: 60px"></div>
        <div style="width: 100%;height: 55px;background-color: white;border-top:1px solid #e6e6e6;
        position: fixed;bottom: 1px;margin-left:-20px;">
          <div class="layui-form-item" style=" float: right;margin-right: 30px;margin-top: 8px">
            <button  class="layui-btn layui-btn-normal" lay-filter="add" lay-submit="">
              增加
            </button>
            <button  class="layui-btn layui-btn-primary" id="close">
              取消
            </button>
          </div>
        </div>
      </form>
    </div>
    <script>
      layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;

        $('#select_icon').click(function(){
          parent.layer.open({
            id:'icon',
            type: 2,
            area: ['800px','600px'],
            shade: 0.4,
            zIndex: layer.zIndex,
            title: '图标',
            content: '/plugin/html/icon.html'
          });
        });
        //自定义验证规则
        var type=$('#sourceType');
        form.verify({
          sourceType:function(v){
            console.info(v=='')
            if(v==''){
                return '类型 不能为空';
            }
          }
          ,name:function(v){
            if(v.trim()==''){
                return '名称不能为空';
            }
          }
          ,mobile:function(v){
            if(type.val()=='1'){
                $('#mobile').val('');
            }
            if(type.val()=='0'&&v.trim()==''){
                return 'mobile 不能为空';
            }
          }
          ,email:function(v){
            if(type.val()=='1'){
                $('#email').val('');
            }
            if(type.val()=='0'&&v.trim()==''){
                return 'email 不能为空';
            }
          }
          
        });

      
        /**
        * id :元素id
        * flag true:禁止输入，false 允许输入
        */
        function dOs(id,flag){
          var $id= $("#"+id);
          if(flag){
              $id.val('');
              $id.attr('disabled','disabled').css('background','#e6e6e6');
          }
          else
              $id.removeAttr('disabled').css('background','white')
        }

        $('#close').click(function(){
          var index = parent.layer.getFrameIndex(window.name);
          parent.layer.close(index);
        });

        //监听提交
        form.on('submit(add)', function(data){
          data.field['icon']=$('#icon').text();
          $.ajax({
            url:'addSource',
            type:'post',
            data:data.field,
            async:false, dataType: "json", traditional: true,
            success:function(data){
              console.info(data.msg);
              var index = parent.layer.getFrameIndex(window.name);
              window.top.layer.msg(data.msg,{icon:6,offset: 'rb',area:['120px','80px'],anim:2});
              parent.layer.close(index);
              parent.location.replace(parent.location.href);
            },error:function(){
                var index = parent.layer.getFrameIndex(window.name);
              window.top.layer.msg('请求失败',{icon:5,offset: 'rb',area:['120px','80px'],anim:2});
              parent.layer.close(index);
            }
          });
          return false;
        });
        form.render();
      });

      
    </script>
  </body>

</html>
