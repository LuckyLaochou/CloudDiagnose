package cn.laochou.diagnose.pojo;

import lombok.Data;

/**
 * 用户
 */
@Data
public class User {

    // 用户ID
    private int id;
    // 用户姓名
    private String name;
    // 用户身份证
    private String idCard;
    // 用户邮箱
    private String mail;
    // 用户密码
    private String password;
    private String phone;
    // 用户性别
    private int sex;
    // 用户角色
    private int role;
    // 用户科系
    private String department;
    // 创建时间
    private String createTime;
    // 修改时间
    private String updateTime;


}
