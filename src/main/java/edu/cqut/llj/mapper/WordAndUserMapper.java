package edu.cqut.llj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.cqut.llj.pojo.WordAndUser;
import edu.cqut.llj.utils.MyMapper;
import edu.cqut.llj.vo.Rank;

public interface WordAndUserMapper extends MyMapper<WordAndUser> {

	List<Rank> getRank(@Param("limit0") Integer limit0,@Param("limit1") Integer limit1);

	Integer getRankSize();
}