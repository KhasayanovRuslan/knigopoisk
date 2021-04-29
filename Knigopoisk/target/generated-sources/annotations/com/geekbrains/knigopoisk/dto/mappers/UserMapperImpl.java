package com.geekbrains.knigopoisk.dto.mappers;

import com.geekbrains.knigopoisk.dto.UserDetailsDto;
import com.geekbrains.knigopoisk.dto.UserForAdminsEditDto;
import com.geekbrains.knigopoisk.entities.User;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-22T16:17:22+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.7 (Ubuntu)"
)
@Component
@Primary
public class UserMapperImpl extends UserMapperDecorator implements UserMapper {

    @Autowired
    @Qualifier("delegate")
    private UserMapper delegate;

    @Override
    public UserForAdminsEditDto getUserForAdminsEditDtoFromUser(User userForAdminsEditDto)  {
        return delegate.getUserForAdminsEditDtoFromUser( userForAdminsEditDto );
    }

    @Override
    public void updateUserFromUserDetailsDto(UserDetailsDto userDetailsDto, User user)  {
        delegate.updateUserFromUserDetailsDto( userDetailsDto, user );
    }

    @Override
    public UserDetailsDto getUserDetailsDtoFromUser(User user)  {
        return delegate.getUserDetailsDtoFromUser( user );
    }

    @Override
    public List<UserDetailsDto> getUserDetailsDtoListFromUserList(List<User> users)  {
        return delegate.getUserDetailsDtoListFromUserList( users );
    }
}
