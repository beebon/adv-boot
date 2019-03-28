
#模板生成配置项
config = {
    'echo':True
    ,'author':'codesmith'
    ,'version':'v1.0'
    ,'package':'com.mycompany.myapp'
    ,'file_type' : 'java'
    ,'temp_dir':'temp/adv'
    ,'temp_arr': #模板组：模板名:后缀:文件类型:前缀:扩展参数
        ['entity:','controller:Controller','service:Service::I','serviceImpl:ServiceImpl','mapper:Mapper','mapperXml:Mapper:xml','vueList:List:vue','vueModal:Modal:vue']
    ,'output' : 'output/example'
    
}