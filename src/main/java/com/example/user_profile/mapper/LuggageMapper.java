package com.example.user_profile.mapper;

import com.example.user_profile.dto.LuggageDto;
import com.example.user_profile.entity.Luggage;

public class LuggageMapper {

    public static LuggageDto mapToLuggageDto(Luggage luggage) {

        return new LuggageDto(
                luggage.getId(),
                luggage.getType(),
                luggage.getWeight(),
                null
        );
    }

    public static Luggage mapToLuggage(LuggageDto luggageDto) {

        return new Luggage(
                luggageDto.getId(),
                luggageDto.getType(),
                luggageDto.getWeight(),
                luggageDto.getTicket() != null ? TicketMapper.mapToTicket(luggageDto.getTicket()) : null
        );
    }

}
