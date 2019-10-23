<#--Created by IntelliJ IDEA.
User: Administrator
Date: 2018/3/5
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
        <div style="width:100%;height:500px;overflow: auto;">
          <div class="layui-form-item">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
              <legend style="font-size:16px;">基础信息</legend>
            </fieldset>
          </div>
          <div style="margin-left:25%">
            <div class="layui-form-item">
              <label for="sourceType" class="layui-form-label">
                <span class="x-red">*</span>类型
              </label>
              <div class="layui-input-block" style="width:190px;">
                <select  disabled id="sourceType" lay-verify="sourceType"  lay-filter="sourceType">
                  <option value=""></option>
                  <option <#if sysSource.sourceType=='0'>selected</#if> value="0">前程无忧</option>
                  <option <#if sysSource.sourceType=='1'>selected</#if> value="1">智联招聘</option>
                  <option <#if sysSource.sourceType=='2'>selected</#if> value="2">中华英才</option>
                  <option <#if sysSource.sourceType=='3'>selected</#if> value="3">大姐招聘</option>
                  <option <#if sysSource.sourceType=='4'>selected</#if> value="4">人才热线</option>
                  <option <#if sysSource.sourceType=='5'>selected</#if> value="5">自主添加</option>
                </select>
              </div>
            </div>
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
                  <option value="3">大姐招聘</option>
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
                <input type="text" value="${sysSource.name}" id="name" name="name"  lay-verify="name"
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
                <input type="text" value="${sysSource.mobile}" id="mobile" name="mobile" lay-verify="mobile"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="age" class="layui-form-label">
                age
              </label>
              <div class="layui-input-inline">
                <input type="text" value="${sysSource.age}" id="age" name="age" lay-verify="age"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="gender" class="layui-form-label">
                gender
              </label>
              <div class="layui-input-inline">
                <input type="text" value="${sysSource.gender}" id="gender" name="gender" lay-verify="gender"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="degree" class="layui-form-label">
                degree
              </label>
              <div class="layui-input-inline">
                <input type="text" value="${sysSource.degree}" id="degree" name="degree" lay-verify="degree"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="school" class="layui-form-label">
                school
              </label>
              <div class="layui-input-inline">
                <input type="text" value="${sysSource.school}" id="school" name="school" lay-verify="school"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="hukou" class="layui-form-label">
                hukou
              </label>
              <div class="layui-input-inline">
                <input type="text" value="${sysSource.hukou}" id="hukou" name="hukou" lay-verify="hukou"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="location" class="layui-form-label">
                location
              </label>
              <div class="layui-input-inline">
                <input type="text" value="${sysSource.location}" id="location" name="location" lay-verify="location"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="email" class="layui-form-label">
                email
              </label>
              <div class="layui-input-inline">
                <input type="text" value="${sysSource.email}" id="email" name="email" lay-verify="email"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="education" class="layui-form-label">
                education
              </label>
              <div class="layui-input-inline">
                <input type="text" value="${sysSource.education}" id="education" name="education" lay-verify="education"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="career" class="layui-form-label">
                career
              </label>
              <div class="layui-input-inline">
                <input type="text" value="${sysSource.career}" id="career" name="career" lay-verify="career"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="project" class="layui-form-label">
                project
              </label>
              <div class="layui-input-inline">
                <input type="text" value="${sysSource.project}" id="project" name="project" lay-verify="project"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="skills" class="layui-form-label">
                skills
              </label>
              <div class="layui-input-inline">
                <input type="text" value="${sysSource.skills}" id="skills" name="skills" lay-verify="skills"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="position" class="layui-form-label">
                position
              </label>
              <div class="layui-input-inline">
                <input type="text" value="${sysSource.position}" id="position" name="position" lay-verify="edupositioncation"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="remark" class="layui-form-label">
                remark
              </label>
              <div class="layui-input-inline">
                <input type="text" value="${sysSource.remark}" id="remark" name="remark" lay-verify="remark"  autocomplete="off" class="layui-input">
              </div>
              <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">必须填写</span>
              </div>
            </div>
            <div class="layui-form-item">
              <label for="permission" class="layui-form-label">
                <span class="x-red">*</span>权限
              </label>
              <div class="layui-input-inline">
                <input type="text"  value="${sysSource.permission}" id="permission" name="permission"  lay-verify="permission"
                  autocomplete="off" class="layui-input">
              </div>
            </div>
            <div class="layui-form-item">
              <label for="icon" class="layui-form-label">
                <span class="x-red">*</span>图标
              </label>
              <div class="layui-input-inline">
                <div style="margin-left: 20px;margin-top:5px">
                  <ul>
                    <li style="display: inline-block;width: 50px;" id="source-icon">
                      <i class="layui-icon" id="icon"  style="font-size: 25px;">${sysSource.icon}</i>
                    </li>
                    <li style="display: inline-block;">
                      <i class="layui-btn layui-btn-primary layui-btn-sm" id="select_icon">选择图标</i>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
            <div style="height: 60px"></div>
          </div>
        </div>
        <div style="width: 100%;height: 55px;background-color: white;border-top:1px solid #e6e6e6;
    position: fixed;bottom: 1px;margin-left:-20px;">
          <div class="layui-form-item" style=" float: right;margin-right: 30px;margin-top: 8px">
            <button  class="layui-btn layui-btn-normal" lay-filter="add" lay-submit="">
              更新
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
        layui.tree({
            elem:'#tree',
            nodes:${sources}
        });
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
                return '类型不能为空';
            }
        }
        
        ,name:function(v){
          if(v.trim()==''){
              return '名称不能为空';
          }
        }
        ,email:function(v){
          if(v.trim()==''){
            return '名称不能为空';
          }
        }
        ,permission:function(v){
          if((type.val()=='1'||type.val()=='0')&&v.trim()==''){
            return '权限不能为空';
          }
        }
      });

      $('#close').click(function(){
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
      });
      //监听提交
      form.on('submit(add)', function(data){
        data.field['icon']=$('#icon').text();
        data.field['id']='${sysSource.id}';
        $.ajax({
          url:'updateSource',
          type:'post',
          data:data.field,
          async:false, dataType: "json", traditional: true,
          success:function(data){
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
