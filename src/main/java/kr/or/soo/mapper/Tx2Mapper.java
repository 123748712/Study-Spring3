package kr.or.soo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Tx2Mapper {
	
	@Insert("insert into tx2 values(#{name})")
	public int insTx2(String name);
}
