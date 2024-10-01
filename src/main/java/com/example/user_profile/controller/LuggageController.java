package com.example.user_profile.controller;

import com.example.user_profile.dto.LuggageDto;

import com.example.user_profile.service.LuggageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/luggages")
@AllArgsConstructor
public class LuggageController {

    private LuggageService luggageService;

    @PostMapping
    public ResponseEntity<LuggageDto> addLuggage(@RequestBody LuggageDto luggageDto) {
        LuggageDto savedLuggage = luggageService.addLuggage(luggageDto);

        return new ResponseEntity<>(savedLuggage, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<LuggageDto> getLuggageById(@PathVariable long id) {
        LuggageDto luggageDto = luggageService.getLuggageById(id);
        return new ResponseEntity<>(luggageDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LuggageDto>> getAllLuggages() {
        List<LuggageDto> luggageDto = luggageService.getAllLuggages();

        return ResponseEntity.ok(luggageDto);
    }
}
