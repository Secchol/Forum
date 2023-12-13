package com.ontotext.forum.mappers;

import com.ontotext.forum.dtos.PostDto;
import com.ontotext.forum.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Defines a mapper for the Post entity and Post DTO.
 */
@Mapper
public interface PostMapper {
    @Mapping(source = "createDate", target = "postCreateDate", qualifiedByName = "toLocalDate")
    @Mapping(source = "modifyDate", target = "postModifyDate", qualifiedByName = "toLocalDate")
    PostDto toPostDto(Post post);
    Post toPost(PostDto postDto);
    default LocalDateTime toLocalDate(Date sourceDate) {
        return sourceDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
