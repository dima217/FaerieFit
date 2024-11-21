package org.faeriefit.microusers.convertor;

import lombok.RequiredArgsConstructor;
import org.faeriefit.microentity.entity.user.ProfileImage;
import org.faeriefit.microusers.dto.ProfileImageDTO;
import org.faeriefit.microutility.service.ConvertorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class ProfileImageDTOConvertor implements ConvertorDTO<ProfileImageDTO, ProfileImage> {
    private final ModelMapper modelMapper;


    @Override
    public ProfileImageDTO convertEntityToDTO(ProfileImage profileImage) {
        return modelMapper.map(profileImage, ProfileImageDTO.class);
    }

    @Override
    public ProfileImage convertDTOToEntity(ProfileImageDTO profileImageDTO) {
        return modelMapper.map(profileImageDTO, ProfileImage.class);
    }
}
