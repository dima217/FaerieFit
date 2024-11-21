package org.faeriefit.microusers.convertor;

import lombok.RequiredArgsConstructor;
import org.faeriefit.microentity.entity.user.Profile;
import org.faeriefit.microusers.dto.ProfileDTO;
import org.faeriefit.microutility.service.ConvertorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class ProfileDTOConvertor implements ConvertorDTO<ProfileDTO, Profile> {
    private final ModelMapper modelMapper;

    @Override
    public ProfileDTO convertEntityToDTO(Profile profile) {
        return modelMapper.map(profile,ProfileDTO.class);
    }

    @Override
    public Profile convertDTOToEntity(ProfileDTO profileDTO) {
        return modelMapper.map(profileDTO,Profile.class);
    }
}
