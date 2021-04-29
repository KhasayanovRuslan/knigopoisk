package com.geekbrains.knigopoisk.dto.mappers;

import com.geekbrains.knigopoisk.dto.RoleDto;
import com.geekbrains.knigopoisk.dto.UserDetailsDto;
import com.geekbrains.knigopoisk.dto.UserForAdminsEditDto;
import com.geekbrains.knigopoisk.dto.UserRegistrationDto;
import com.geekbrains.knigopoisk.entities.Role;
import com.geekbrains.knigopoisk.entities.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-22T16:17:22+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.7 (Ubuntu)"
)
@Component
@Qualifier("delegate")
public class UserMapperImpl_ implements UserMapper {

    @Override
    public User getUserFromUserRegistrationDto(UserRegistrationDto userRegistrationDto) {
        if ( userRegistrationDto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userRegistrationDto.getUserName() );
        if ( userRegistrationDto.getBirthDay() != null ) {
            user.setBirthDay( LocalDate.parse( userRegistrationDto.getBirthDay() ) );
        }
        user.setEmail( userRegistrationDto.getEmail() );
        user.setFirstName( userRegistrationDto.getFirstName() );
        user.setLastName( userRegistrationDto.getLastName() );

        return user;
    }

    @Override
    public UserForAdminsEditDto getUserForAdminsEditDtoFromUser(User userForAdminsEditDto) {
        if ( userForAdminsEditDto == null ) {
            return null;
        }

        UserForAdminsEditDto userForAdminsEditDto1 = new UserForAdminsEditDto();

        userForAdminsEditDto1.setUserName( userForAdminsEditDto.getUsername() );
        userForAdminsEditDto1.setId( userForAdminsEditDto.getId() );
        userForAdminsEditDto1.setFirstName( userForAdminsEditDto.getFirstName() );
        userForAdminsEditDto1.setLastName( userForAdminsEditDto.getLastName() );
        userForAdminsEditDto1.setEmail( userForAdminsEditDto.getEmail() );
        userForAdminsEditDto1.setBirthDay( userForAdminsEditDto.getBirthDay() );
        userForAdminsEditDto1.setEnabled( userForAdminsEditDto.isEnabled() );
        userForAdminsEditDto1.setAccountNotExpired( userForAdminsEditDto.isAccountNotExpired() );
        userForAdminsEditDto1.setCredentialsNotExpired( userForAdminsEditDto.isCredentialsNotExpired() );
        userForAdminsEditDto1.setAccountNotLocked( userForAdminsEditDto.isAccountNotLocked() );
        userForAdminsEditDto1.setRoles( roleCollectionToRoleDtoCollection( userForAdminsEditDto.getRoles() ) );

        return userForAdminsEditDto1;
    }

    @Override
    public void updateUserFromUserDetailsDto(UserDetailsDto userDetailsDto, User user) {
        if ( userDetailsDto == null ) {
            return;
        }

        if ( userDetailsDto.getId() != null ) {
            user.setId( userDetailsDto.getId() );
        }
        if ( userDetailsDto.getBirthDay() != null ) {
            user.setBirthDay( LocalDate.parse( userDetailsDto.getBirthDay() ) );
        }
        if ( userDetailsDto.getEmail() != null ) {
            user.setEmail( userDetailsDto.getEmail() );
        }
        if ( userDetailsDto.getFirstName() != null ) {
            user.setFirstName( userDetailsDto.getFirstName() );
        }
        if ( userDetailsDto.getLastName() != null ) {
            user.setLastName( userDetailsDto.getLastName() );
        }
    }

    @Override
    public UserDetailsDto getUserDetailsDtoFromUser(User user) {
        if ( user == null ) {
            return null;
        }

        UserDetailsDto userDetailsDto = new UserDetailsDto();

        userDetailsDto.setUserName( user.getUsername() );
        userDetailsDto.setId( user.getId() );
        userDetailsDto.setFirstName( user.getFirstName() );
        userDetailsDto.setLastName( user.getLastName() );
        userDetailsDto.setEmail( user.getEmail() );
        if ( user.getBirthDay() != null ) {
            userDetailsDto.setBirthDay( DateTimeFormatter.ISO_LOCAL_DATE.format( user.getBirthDay() ) );
        }

        return userDetailsDto;
    }

    @Override
    public List<UserDetailsDto> getUserDetailsDtoListFromUserList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDetailsDto> list = new ArrayList<UserDetailsDto>( users.size() );
        for ( User user : users ) {
            list.add( getUserDetailsDtoFromUser( user ) );
        }

        return list;
    }

    protected RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setName( role.getName() );

        return roleDto;
    }

    protected Collection<RoleDto> roleCollectionToRoleDtoCollection(Collection<Role> collection) {
        if ( collection == null ) {
            return null;
        }

        Collection<RoleDto> collection1 = new ArrayList<RoleDto>( collection.size() );
        for ( Role role : collection ) {
            collection1.add( roleToRoleDto( role ) );
        }

        return collection1;
    }
}
