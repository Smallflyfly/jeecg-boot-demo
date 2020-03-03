<template>
  <a-modal
    :title="title"
    :width="width"
    :visible="visible"
    :confirmLoading="confirmLoading"
    @ok="handleOk"
    @cancel="handleCancel"
    cancelText="关闭">
    <a-spin :spinning="confirmLoading">
      <a-form :form="form">

        <a-form-item label="公司名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'enterpriseName', validatorRules.enterpriseName]" placeholder="请输入公司名称"></a-input>
        </a-form-item>
        <a-form-item label="职位名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'position', validatorRules.position]" placeholder="请输入职位名称"></a-input>
        </a-form-item>
        <a-form-item label="经验要求" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-dict-select-tag type="list" v-decorator="['experience', validatorRules.experience]" :trigger-change="true" dictCode="experience" placeholder="请选择经验要求"/>
        </a-form-item>
        <a-form-item label="学历要求" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-dict-select-tag type="list" v-decorator="['education', validatorRules.education]" :trigger-change="true" dictCode="education" placeholder="请选择学历要求"/>
        </a-form-item>
        <a-form-item label="薪资范围下限" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input-number v-decorator="[ 'salaryLower', validatorRules.salaryLower]" placeholder="请输入薪资范围下限" style="width: 100%"/>
        </a-form-item>
        <a-form-item label="薪资范围上限" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input-number v-decorator="[ 'salaryUpper', validatorRules.salaryUpper]" placeholder="请输入薪资范围上限" style="width: 100%"/>
        </a-form-item>
        <a-form-item label="职位关键词" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'positionKey', validatorRules.positionKey]" placeholder="请输入职位关键词"></a-input>
        </a-form-item>
        <a-form-item label="岗位描述小标题" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'positionTitle', validatorRules.positionTitle]" placeholder="请输入岗位描述小标题"></a-input>
        </a-form-item>
        <a-form-item label="岗位描述正文内容" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'positionContent', validatorRules.positionContent]" placeholder="请输入岗位描述正文内容"></a-input>
        </a-form-item>
        <a-form-item label="工作城市行政区域编码" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'regionId', validatorRules.regionId]" placeholder="请输入工作城市行政区域编码"></a-input>
        </a-form-item>
        <a-form-item label="招聘人数" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input-number v-decorator="[ 'hireNumber', validatorRules.hireNumber]" placeholder="请输入招聘人数" style="width: 100%"/>
        </a-form-item>
        <a-form-item label="工作地址" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'workAddress', validatorRules.workAddress]" placeholder="请输入工作地址"></a-input>
        </a-form-item>
        <a-form-item label="联系方式" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'phone', validatorRules.phone]" placeholder="请输入联系方式"></a-input>
        </a-form-item>

      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>

  import { httpAction } from '@/api/manage'
  import pick from 'lodash.pick'
  import { validateDuplicateValue } from '@/utils/util'
  import JDictSelectTag from "@/components/dict/JDictSelectTag"

  export default {
    name: "EnterprisePositionModal",
    components: { 
      JDictSelectTag,
    },
    data () {
      return {
        form: this.$form.createForm(this),
        title:"操作",
        width:800,
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
        validatorRules: {
          enterpriseName: {rules: [
            {required: true, message: '请输入公司名称!'},
          ]},
          position: {rules: [
            {required: true, message: '请输入职位名称!'},
          ]},
          experience: {rules: [
          ]},
          education: {rules: [
          ]},
          salaryLower: {rules: [
          ]},
          salaryUpper: {rules: [
          ]},
          positionKey: {rules: [
          ]},
          positionTitle: {rules: [
          ]},
          positionContent: {rules: [
          ]},
          regionId: {rules: [
            {required: true, message: '请输入工作城市行政区域编码!'},
          ]},
          hireNumber: {rules: [
          ]},
          workAddress: {rules: [
          ]},
          phone: {rules: [
            {required: true, message: '请输入联系方式!'},
          ]},
        },
        url: {
          add: "/codegenerate/enterprisePosition/add",
          edit: "/codegenerate/enterprisePosition/edit",
        }
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
          this.form.setFieldsValue(pick(this.model,'enterpriseName','position','experience','education','salaryLower','salaryUpper','positionKey','positionTitle','positionContent','regionId','hireNumber','workAddress','phone','releaseTime','status'))
        })
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
            console.log("表单提交数据",formData)
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
      popupCallback(row){
        this.form.setFieldsValue(pick(row,'enterpriseName','position','experience','education','salaryLower','salaryUpper','positionKey','positionTitle','positionContent','regionId','hireNumber','workAddress','phone','releaseTime','status'))
      },

      
    }
  }
</script>