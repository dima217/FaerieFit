package org.faeriefit.microusers.convertor;

import lombok.RequiredArgsConstructor;
import org.faeriefit.microentity.entity.user.User;
import org.faeriefit.microusers.dto.UserDTO;
import org.faeriefit.microutility.service.ConvertorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class UserDTOConvertor implements ConvertorDTO<UserDTO, User> {
    private final ModelMapper modelMapper;

    @Override
    public UserDTO convertEntityToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public User convertDTOToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
