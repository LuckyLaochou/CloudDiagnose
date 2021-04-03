package cn.laochou.diagnose.service;

import cn.laochou.diagnose.pojo.Request;
import cn.laochou.diagnose.search.RequestSearchCondition;
import cn.laochou.diagnose.vo.RequestDetailVO;
import cn.laochou.diagnose.vo.RequestVO;

import java.util.List;

public interface RequestService {

    boolean insertRequest(Request request);

    List<RequestVO> getRequestByDepartment(String department);

    RequestDetailVO getRequestDetailById(int id);

    List<RequestDetailVO> getRequestDetailByUserId(int id);

    Boolean updateRequestByDiagnose(int id);

    void updateRequestByPreDiagnose(int id);

    List<Request> selectAllRequest();

    void updateRequest(Request request);

    void delRequestById(int id);

    List<Request> searchRequestByCondition(RequestSearchCondition condition);
}
