var phone          = { len:11,message: vue.$t('phone') };
var length64       = { max:64, message:vue.$t("length32"), trigger:'blur' };
var length32       = { max:32, message:vue.$t("length64"), trigger:'blur' };
var length128      = { max:128, message:vue.$t("length128"), trigger:'blur' };
var length256      = { max:256, message:vue.$t("length256"), trigger:'blur' };
var arrayRequired  = { required:true,trigger:'change',type:'array',message: vue.$t("requiredBlur")}
var requiredBlur   = { required:true,trigger:'blur',message: vue.$t("requiredBlur") };
var requiredChange = { required:true,trigger:'change',message: vue.$t("requiredBlur") };
var number = {
    required:true,validator:(rule,value,callback)=>{
        if(/^[0-9]+$/.test(value) == false){
            callback(new Error(vue.$t('number')));
        }else{
            callback();
        }
    }, trigger:'blur'
}
var numAndEn = {
    validator:(rule,value,callback)=>{
        if(/^[0-9a-zA-Z]+$/.test(value) == false){
            callback(new Error(vue.$t('numAndEn')));
        }else{
            callback();
        }
    }, trigger:'blur'
}
var version = {
    required:true,validator:(rule,value,callback)=>{
        if(/^\d+\.\d+\.\d+$/.test(value) == false){
            callback(new Error(vue.$t('versionRules')));
        }else{
            callback();
        }
    }, trigger:'blur'
}

export const pwdRules = {
    oldPwd: [ requiredBlur ],
    newPwd: [ requiredBlur ],
    confirmPassword : [ requiredBlur ]
}

export const opertorRules = {
    opUsername:[ requiredBlur,length64 ],
    opRealname:[ requiredBlur,length32 ],
    opTel:[  phone,number ],
    roleId:[ requiredChange ],
    opRemark:[ length256 ],
    orgName:[ requiredBlur ]
}

export const roleRules = {
    roleName:[ requiredBlur ]
}

export const orgRules = {
    orgName: [ requiredBlur, length64 ],
    orgId : [ number ],
    orgLinkman : [ length64,requiredBlur ],
    orgTel : [ phone,number ],
    orgType : [ requiredChange ],
    orgAddress : [ requiredBlur, length256 ]
}

export const brandRules = {
    brandName : [ requiredBlur, length64 ],
    brandLinkman : [ requiredBlur, length32 ],
    brandTel : [ phone,number ]
}

export const modelRules = {
    brandId : [ requiredChange ],
    modelTypeId:[ requiredChange ],
    modelName : [ requiredBlur,length64 ]
}

export const keyRules = {
    description:[numAndEn],
    tmsCode:[numAndEn],
    tmk:[requiredBlur,numAndEn],
    tak:[numAndEn],
    tmkReferenceNo:[numAndEn],
    checksum:[numAndEn],
    filler:[numAndEn],
}

export const devGroupRules={
    groupName: [ requiredBlur, length32 ],
    modelArray :[ arrayRequired ]
}

export const deviceRules = {
    deviceSn : [ number, length64 ],
    deviceHwVersion: [ requiredBlur, length64 ],
    deviceSwVersion: [ requiredBlur, length64 ],
    modelArray :[ arrayRequired ]
}

export const appRules = {
    appName : [ requiredBlur, length32 ],
    appContact : [ requiredBlur, length32 ],
    addfileName: [ requiredBlur ],
    appDesc : [ length256 ],
    modelData : [ arrayRequired ],
    appPkgVer : [ requiredBlur ],
    orgName:[requiredBlur]
}

export const firmWareRules = {
    firmName : [ requiredBlur, length32 ],
    fileName : [ requiredBlur ],
    firmVer  : [ version ]
}
export const documentRules = {
    
}

export const merchantRules = {
    orgName:[ requiredBlur ],
    mchntId:[ requiredBlur, length32 ],
    mchntName:[ requiredBlur, length64 ],
    mchntAbbr:[ requiredBlur, length256 ],
    commAddr:[ requiredBlur, length256 ],
    mobileNo:[ phone,number ],
    artifNm:[ requiredBlur, length64 ],
    artifCertifId:[ number, length32 ],
    regAddr:[ requiredBlur, length128 ],
    deviceIds:[ arrayRequired ]
}

export const parameterRules = {
    deviceSn:[ requiredBlur ],
    paraVer:[ requiredBlur ],
    serverPara:[ requiredBlur ],
    serverParaBak1:[ requiredBlur ],
    serverParaBak2:[ requiredBlur ],
    code:[requiredBlur],
    val:[requiredBlur]
}

export const mchntFormRules = {
    paraId:[ requiredBlur ],
    type:[ requiredBlur ],
    currency:[ requiredBlur ],
    mid:[ requiredBlur ],
    tid:[ requiredBlur ],
    trans:[ requiredBlur ],
    mchntName:[ requiredBlur ]
}

export const pospRules = {
    paramType:[ requiredBlur ],
    paramNo:[ requiredBlur ],
    paramVer:[ requiredBlur ],
    paramVal:[ requiredBlur ]
}
// this.$refs.addForm.validate((valid)=>{
//   if(valid){

//   }
// })