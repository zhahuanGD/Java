package cn.itcast.dao;

import cn.itcast.pojo.Member;

public interface MemberMapper {
    /*
    根据会员号,查询会员信息
     */
    public Member findMemberById(String id) throws Exception;
}
