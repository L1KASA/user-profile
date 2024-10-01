package com.example.user_profile.service;

import com.example.user_profile.dto.LuggageDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LuggageService {
    LuggageDto addLuggage(LuggageDto luggageDto);

    LuggageDto getLuggageById(long id);

    List<LuggageDto> getAllLuggages();
}
