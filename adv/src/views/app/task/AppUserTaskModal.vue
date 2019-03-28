<template>
  <a-modal
    :title="title"
    :width="800"
    :visible="visible"
    :confirmLoading="confirmLoading"
    @ok="handleOk"
    @cancel="handleCancel"
    cancelText="关闭">
    
    <a-spin :spinning="confirmLoading">
      <a-form :form="form">
      
        <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="关联任务ID">
          
          
          <a-input placeholder="请输入关联任务ID" v-decorator="['taskId',  {}]" />
        </a-form-item>
      
        <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="关联用户ID">
          
          
          <a-input placeholder="请输入关联用户ID" v-decorator="['userId',  {}]" />
        </a-form-item>
      
        <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="应用版本">
          
          
          <a-input placeholder="请输入应用版本" v-decorator="['appVersion',  {}]" />
        </a-form-item>

      
        <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="领取时间">
          
          
          <a-date-picker showTime format='YYYY-MM-DD HH:mm:ss' v-decorator="[ 'receiveTime', {}]" />
          <a-input placeholder="请输入None" v-decorator="['receiveTime',  {}]" />
        </a-form-item>
      
        <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="完成时间">
          
          
          <a-date-picker showTime format='YYYY-MM-DD HH:mm:ss' v-decorator="[ 'completeTime', {}]" />
          <a-input placeholder="请输入None" v-decorator="['completeTime',  {}]" />
        </a-form-item>
      
        <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="奖励（分）">
          
          
           
          <a-input-number v-decorator="[ 'bonus', {}]" />
        </a-form-item>
      
      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>
  import { httpAction } from '@/api/manage'
  import pick from 'lodash.pick'
  import moment from "moment"

  export default {
    name: "AppUserTaskModal",
    data () {
      return {
        title:"操作",
        visible: false,
        model: {},
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
        confirmLoading: false,
        form: this.$form.createForm(this),
        validatorRules:{ 
        },
        url: {
          add: "/app/appUserTask/add",
          edit: "/app/appUserTask/edit",
        },
      }
    },
    created () {
    },
    methods: {
      add () {
        this.edit({});
      },
      edit (record) {
        this.form.resetFields();
        this.model = Object.assign({}, record);
        this.visible = true;
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model,'taskId','userId','appVersion','taskStatus','receiveTime','completeTime','bonus'))
          
        });

      },
      close () {
        this.$emit('close');
        this.visible = false;
      },
      handleOk () {
        const that = this;
        // 触发表单验证
        this.form.validateFields((err, values) => {
          if (!err) {
            that.confirmLoading = true;
            let httpurl = '';
            let method = '';
            if(!this.model.id){
              httpurl+=this.url.add;
              method = 'post';
            }else{
              httpurl+=this.url.edit;
               method = 'put';
            }
            let formData = Object.assign(this.model, values);
            
            formData.receiveTime = formData.receiveTime?formData.receiveTime.format('YYYY-MM-DD HH:mm:ss'):null;
            formData.completeTime = formData.completeTime?formData.completeTime.format('YYYY-MM-DD HH:mm:ss'):null;
            
            console.log(formData)
            httpAction(httpurl,formData,method).then((res)=>{
              if(res.success){
                that.$message.success(res.message);
                that.$emit('ok');
              }else{
                that.$message.warning(res.message);
              }
            }).finally(() => {
              that.confirmLoading = false;
              that.close();
            })



          }
        })
      },
      handleCancel () {
        this.close()
      },


    }
  }
</script>

<style scoped>

</style>