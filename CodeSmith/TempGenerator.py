# _*_ coding:utf-8 _*_

#通过配置生成代码
from jinja2 import Template
from cfg import config as cfg
import os
import ReverseEng as re
import MyFilter
import time

def gen(config=cfg):
    models = re.getTableDesc()
    now = time.strftime('%Y-%m-%d %H:%M',time.localtime(time.time()))
    common = {'now':now} #通用参数，可根据需要扩展
 
    for m in models:
        if 'models' in config.keys() and config['models'] is not None and m['name'] not in config['models'] : continue
        parm = {'m':m,'cfg':cfg.config,'common':common} #供模板调用，其中m表示数据库反射信息，cfg表示模板配置信息
        for tmp in config['temp_arr']:
            tp = tmp.split(':')
            file_type = config['file_type'] if len(tp)<=2 else (tp[2] if not tp[2]=='' else config['file_type'])
            prefix = '' if len(tp)<=3 else tp[3]
            tmp_path = '{0}/{1}.tmp'.format(config['temp_dir'],tp[0])
            #out_path = config['output'] + '/' + m['table'] + tp[1] + '.java'
            out_path = '{0}/{1}/'.format(config['output'],tp[0]) 
            file_name = '{3}{0}{1}.{2}'.format(m['name'],tp[1],file_type,prefix)
            file_path = '{0}{1}'.format(out_path,file_name)
            
            parm['tp'] = tp #传入部分可自定义参数以便模板扩展
            
            
            print(out_path)
            print(file_path)
            
            if not os.path.exists(out_path):
                os.makedirs(out_path) #os.system(r"cd.>{}".format(file_path)) #调用系统命令行来创建文件,linux使用touch 
            
            try:
                #加载模板内容
                temp_cont = open(tmp_path,encoding='utf-8').read()
                t = Template(temp_cont)
                #生成输出文件 
                fo = open(file_path, "w+",encoding='utf-8')
                fo.write(t.render(parm))

                if config['echo'] : print('生成文件：',file_path)
            except Exception as err:
                print('gen error:',err)
            
    if config['echo'] : print('生成完毕！')
