package com.mysite.netflixProject.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestBody;


@Mapper
public interface MemberMapper {
	@Select("select count(*) from member where member_id=#{member_id} and pw=#{member_pw}")
	public int login(MemberVO member);
	
	@Insert("insert into member (member_id, member_pw, member_name, member_tel, member_addr, pw_question, pw_answer) "
			+ "values (#{member_id}, #{member_pw}, #{member_name}, #{member_tel}, #{member_addr}, #{pw_question}, #{pw_answer})")
	public int insertMember(MemberVO member);
	
	@Select("select count(*) from member where member_id=#{member_id} and pw_question=#{pw_question} and pw_answer=#{pw_answer}")
	public int passwordSearch(MemberVO member);
	
	@Update("update member set member_pw=#{member_pw} where member_id=#{member_id}")
	public int passwordUpdate(MemberVO vo);
}