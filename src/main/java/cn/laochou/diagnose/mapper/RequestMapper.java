package cn.laochou.diagnose.mapper;

import cn.laochou.diagnose.pojo.Request;
import cn.laochou.diagnose.search.RequestSearchCondition;
import cn.laochou.diagnose.vo.RequestDetailVO;
import cn.laochou.diagnose.vo.RequestVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RequestMapper {

    int insertRequest(Request request);

    List<RequestVO> getRequestByDepartment(String department);

    RequestDetailVO getRequestDetailById(int id);

    List<RequestDetailVO> getRequestDetailByUserId(int id);

    Boolean updateRequestByDiagnose(int id);

    void updateRequestByPreDiagnose(int id);

    List<Request> selectAllRequest();

    void updateRequest(Request request);

    void delRequestById(int id);

    List<Request> selectRequestByCondition(RequestSearchCondition condition);
}
