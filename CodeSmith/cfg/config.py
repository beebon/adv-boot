
#模板生成配置项
config = {
    'echo':True
    ,'author':'codesmith'
    ,'version':'v1.0'
    ,'package':'com.mycompany.myapp' #命名空间
    ,'file_type' : 'java' #默认文件类型（当不指定生成规则的文件类型时默认使用）
    ,'temp_dir':'temp/adv' #模板目录，若需自定义模板，可复制该目录模板自行修改
    ,'temp_arr': #模板生成规则：包名:后缀:文件类型:前缀:扩展参数
        ['entity:','controller:Controller','service:Service::I','serviceImpl:ServiceImpl','mapper:Mapper','mapperXml:Mapper:xml','vueList:List:vue','vueModal:Modal:vue']
    #,'models':['Notify'] #可以仅指定需要生成的模块,不设置则默认数据库所有表都生成
    ,'output' : 'output/example'
}
