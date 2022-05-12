package kr.or.soo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Tx1Mapper {
	
	@Insert("insert into tx1 values(#{name})")
	public int insTx1(String name);
}
