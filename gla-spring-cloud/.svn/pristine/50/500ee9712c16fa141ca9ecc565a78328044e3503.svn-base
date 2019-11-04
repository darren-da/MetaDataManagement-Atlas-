package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.MessageComment;
import com.gla.datacenter.domain.MessageCommentExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MessageCommentMapper {
    int countByExample(MessageCommentExample example);

    int deleteByExample(MessageCommentExample example);

    int insert(MessageComment record);

    int insertSelective(MessageComment record);

    List<MessageComment> selectByExampleWithBLOBs(MessageCommentExample example);

    List<MessageComment> selectByExample(MessageCommentExample example);

    int updateByExampleSelective(@Param("record") MessageComment record, @Param("example") MessageCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") MessageComment record, @Param("example") MessageCommentExample example);

    int updateByExample(@Param("record") MessageComment record, @Param("example") MessageCommentExample example);

    MessageComment getApiAudithistory(Map<String, Object> params);
}