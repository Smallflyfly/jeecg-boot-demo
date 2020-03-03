<template>
  <a-drawer
    :title="title"
    :width="width"
    placement="right"
    :closable="false"
    @close="close"
    :visible="visible">
  
    <a-spin :spinning="confirmLoading">
      <a-form :form="form">

        <a-form-item label="名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'name', validatorRules.name]" placeholder="请输入名称"></a-input>
        </a-form-item>
        <a-form-item label="简称" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'shortName', validatorRules.shortName]" placeholder="请输入简称"></a-input>
        </a-form-item>
        <a-form-item label="logo" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-upload v-decorator="['logo', validatorRules.logo]" :trigger-change="true"></j-upload>
        </a-form-item>
        <a-form-item label="公司类型" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-dict-select-tag type="list" v-decorator="['type', validatorRules.type]" :trigger-change="true" dictCode="enterprise_type" placeholder="请选择公司类型"/>
        </a-form-item>
        <a-form-item label="所属行业" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'industry', validatorRules.industry]" placeholder="请输入所属行业"></a-input>
        </a-form-item>
        <a-form-item label="所属行政区域全名" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'regionFullName', validatorRules.regionFullName]" placeholder="请输入所属行政区域全名"></a-input>
        </a-form-item>
        <a-form-item label="主页简介" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'homePageTitle', validatorRules.homePageTitle]" placeholder="请输入主页简介"></a-input>
        </a-form-item>
        <a-form-item label="主页正文" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'homePageText', validatorRules.homePageText]" placeholder="请输入主页正文"></a-input>
        </a-form-item>
        <a-form-item label="联系人" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'contact', validatorRules.contact]" placeholder="请输入联系人"></a-input>
        </a-form-item>
        <a-form-item label="联系电话" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'contactPhone', validatorRules.contactPhone]" placeholder="请输入联系电话"></a-input>
        </a-form-item>
        <a-form-item label="公司照片" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-upload v-decorator="['pictures', validatorRules.pictures]" :trigger-change="true"></j-upload>
        </a-form-item>
        
      </a-form>
    </a-spin>
    <a-button type="primary" @click="handleOk">确定</a-button>
    <a-button type="primary" @click="handleCancel">取消</a-button>
  </a-drawer>
</template>

<script>

  import { httpAction } from '@/api/manage'
  import pick from 'lodash.pick'
  import { validateDuplicateValue } from '@/utils/util'
  import JUpload from '@/components/jeecg/JUpload'
  import JDictSelectTag from "@/components/dict/JDictSelectTag"
  
  export default {
    name: "EnterpriseModal",
    components: { 
      JUpload,
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
            name: {rules: [
            ]},
            shortName: {rules: [
            ]},
            logo: {rules: [
            ]},
            type: {rules: [
            ]},
            industry: {rules: [
            ]},
            regionFullName: {rules: [
            ]},
            homePageTitle: {rules: [
            ]},
            homePageText: {rules: [
            ]},
            contact: {rules: [
            ]},
            contactPhone: {rules: [
            ]},
            pictures: {rules: [
            ]},
},
        url: {
          add: "/api/enterprise/add",
          edit: "/api/enterprise/edit",
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
          this.form.setFieldsValue(pick(this.model,'name','shortName','logo','type','industry','regionFullName','enable','homePageTitle','homePageText','contact','contactPhone','pictures'))
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
        this.form.setFieldsValue(pick(row,'name','shortName','logo','type','industry','regionFullName','enable','homePageTitle','homePageText','contact','contactPhone','pictures'))
      }
      
    }
  }
</script>

<style lang="less" scoped>
/** Button按钮间距 */
  .ant-btn {
    margin-left: 30px;
    margin-bottom: 30px;
    float: right;
  }
</style>