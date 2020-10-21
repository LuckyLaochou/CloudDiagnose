package cn.laochou.diagnose.mapper;

import cn.laochou.diagnose.pojo.Request;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RequestMapper {

    int insertRequest(Request request);

}
