package org.adv.modules.app.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Title: AppUser entity
 * @Description: {'text': '应用用户'}
 * @author： codesmith
 * @date：   2019-03-06 19:13
 * @version： v1.0
 */
@Data
@TableName("app_user")
public class AppUser implements Serializable {
    private static final long serialVersionUID = 1L;

    
    @TableId(type = IdType.UUID)
    private String id; //用户手机号
    
    
    private String pwd; //密码
    
    
    private Byte status; //状态 1＝有效用户 －1＝作弊用户
    
}