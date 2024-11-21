package org.faeriefit.microusers.convertor;

import lombok.RequiredArgsConstructor;
import org.faeriefit.microentity.entity.user.Role;
import org.faeriefit.microusers.dto.RoleDTO;
import org.faeriefit.microutility.service.ConvertorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class RoleDTOConvertor implements ConvertorDTO<RoleDTO, Role> {
    private final ModelMapper modelMapper;

    @Override
    public RoleDTO convertEntityToDTO(Role role) {
        return modelMapper.map(role, RoleDTO.class);
    }

    @Override
    public Role convertDTOToEntity(RoleDTO roleDTO) {
        return modelMapper.map(roleDTO, Role.class);
    }
}
