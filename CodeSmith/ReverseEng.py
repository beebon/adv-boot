# _*_ coding:utf-8 _*_

#逆向工程
from sqlalchemy import create_engine
from sqlalchemy.engine import reflection
from cfg import dbconfig as c


def getEngs():
    dbs = []
    for db in c.cfg['dbs']:
        eng = create_engine(db['url'], echo=db['echo'],encoding='utf-8',convert_unicode=True)
        dbs.append(eng)
        if c.cfg['echo'] : print('get engine for',db['name'])
    return dbs

#获取表结构描述信息
def getTableDesc():
    engs = getEngs()
    desc = []
    for e in engs:
        insp = reflection.Inspector.from_engine(e)
        for t in insp.get_table_names():
            desc.append({'table':t,'comment':insp.get_table_comment(t),'name':t.title().replace('_','').replace('-',''),'pk':insp.get_primary_keys(t) if hasattr(insp,'get_primary_keys') else '','fk':insp.get_foreign_keys(t) if hasattr(insp,'get_foreign_keys') else '','cols':insp.get_columns(t),'type':'table'})
            if c.cfg['echo'] : print('get tables for',t)
        for t in insp.get_view_names():
            desc.append({'table':t,'comment':insp.get_table_comment(t),'name':t.title().replace('_','').replace('-',''),'pk':insp.get_primary_keys(t) if hasattr(insp,'get_primary_keys') else '','fk':insp.get_foreign_keys(t) if hasattr(insp,'get_foreign_keys') else '','cols':insp.get_columns(t),'type':'view'})
            if c.cfg['echo'] : print('get views for',t)
    return desc
