package com.example.user_profile.service.impl;

import com.example.user_profile.dto.LuggageDto;
import com.example.user_profile.entity.Luggage;
import com.example.user_profile.exception.ResourceNotFoundException;
import com.example.user_profile.mapper.LuggageMapper;
import com.example.user_profile.repository.LuggageRepository;
import com.example.user_profile.service.LuggageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LuggageServiceImpl implements LuggageService {

    private LuggageRepository luggageRepository;

    @Override
    public LuggageDto addLuggage(LuggageDto luggageDto) {

        Luggage luggage = LuggageMapper.mapToLuggage(luggageDto);

        luggageRepository.save(luggage);

        return LuggageMapper.mapToLuggageDto(luggage);
    }

    @Override
    public LuggageDto getLuggageById(long id) {

        Luggage luggage = luggageRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Luggage with id " + id + " not found!")
        );

        return LuggageMapper.mapToLuggageDto(luggage);
    }

    @Override
    public List<LuggageDto> getAllLuggages() {

        List<Luggage> luggages = luggageRepository.findAll();

        return luggages.stream().map(LuggageMapper::mapToLuggageDto).collect(Collectors.toList());

    }
}
