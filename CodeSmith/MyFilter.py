# _*_ coding:utf-8 _*_

import jinja2
import re

#jinja自定义方法
def smallCamel(value): #小驼峰
    result = (value.title()[0].lower()+value.title()[1:]).replace('_','').replace('-','')
    return result

def bigCamel(value): #大驼峰
    result = value.title().replace('_','').replace('-','')
    return result

def getFieldType(value):
    value = re.sub(re.compile(r'\(.*\)'),'',str(value))
    return str(value);

def getFieldMapType(value): #获取字段数据库类型与java数据类型映射
    value = re.sub(re.compile(r'\(.*\)'),'',str(value))
    return {
            'BIGINT': 'java.lang.Integer',
            'INTEGER': 'java.lang.Long',
            'DECIMAL': 'java.lang.Double',
            'TINYINT': 'java.lang.Byte',
            'DATE':'java.util.Date',
            'DATETIME':'java.util.Date',
            'VARCHAR': 'java.lang.String'
    }.get(value,'java.lang.String') 

def importName(v): #获取引入字段类型名称
    return str(v).split(' ')[0].split("(")[0]

def getType(v):
    return str(v).split(' ')[0]

#注册filter(******切记定义完要在此注册，否则将不生效*******)
jinja2.filters.FILTERS['smallCamel'] = smallCamel
jinja2.filters.FILTERS['bigCamel'] = bigCamel
jinja2.filters.FILTERS['getFieldType'] = getFieldType
jinja2.filters.FILTERS['getFieldMapType'] = getFieldMapType
jinja2.filters.FILTERS['importName'] = importName
jinja2.filters.FILTERS['getType'] = getType
