package com.geekbrains.knigopoisk.dto.mappers;

import com.geekbrains.knigopoisk.dto.RoleDto;
import com.geekbrains.knigopoisk.entities.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-22T16:17:21+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.7 (Ubuntu)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role getRoleFromRoleDto(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setName( roleDto.getName() );

        return role;
    }

    @Override
    public RoleDto getRoleDtoFromRole(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setName( role.getName() );

        return roleDto;
    }

    @Override
    public List<Role> getRoleListFromRoleDtoList(List<RoleDto> roleDtoList) {
        if ( roleDtoList == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( roleDtoList.size() );
        for ( RoleDto roleDto : roleDtoList ) {
            list.add( getRoleFromRoleDto( roleDto ) );
        }

        return list;
    }

    @Override
    public List<RoleDto> getRoleDtoListFromRoleList(List<Role> roleList) {
        if ( roleList == null ) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>( roleList.size() );
        for ( Role role : roleList ) {
            list.add( getRoleDtoFromRole( role ) );
        }

        return list;
    }
}
