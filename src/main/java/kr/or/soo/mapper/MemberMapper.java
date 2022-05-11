package kr.or.soo.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.soo.domain.MemberVO;

@Mapper
public interface MemberMapper {

	public MemberVO read(String userid);
}