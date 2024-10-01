package com.example.user_profile.controller;

import com.example.user_profile.dto.UserDto;
import com.example.user_profile.entity.Name;
import com.example.user_profile.entity.User;
import com.example.user_profile.mapper.UserMapper;
import com.example.user_profile.repository.UserRepository;
import com.example.user_profile.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Autowired
    private UserRepository userRepository;  // Внедряем репозиторий

    @BeforeEach
    void setUp() {
        try (AutoCloseable mocks = MockitoAnnotations.openMocks(this)) {
            // Тестовый код, моки инициализированы
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testAddUser() {
        UserDto userDto = new UserDto();
        Name name = new Name();
        name.setFirstName("John");
        name.setLastName("Doe");
        name.setMiddleName("Middle");
        name.setSurName("Surname");

        userDto.setName(name);

        // Мокирование поведения сервиса
        when(userService.addUser(any(UserDto.class))).thenAnswer(invocation -> {
            User user = UserMapper.mapToUser(invocation.getArgument(0)); // Преобразуем UserDto в User
            user.setId(1L); // Устанавливаем идентификатор для мокируемого объекта
            return UserMapper.mapToUserDto(userRepository.save(user)); // Сохраняем пользователя в базе и преобразуем его обратно в UserDto
        });

        // Вызов контроллера
        ResponseEntity<UserDto> response = userController.addUser(userDto);

        // Проверки
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("John", response.getBody().getName().getFirstName());

        // Проверка добавления пользователя в базу данных
        User addedUser = userRepository.findById(response.getBody().getId()).orElse(null);
        assertNotNull(addedUser);  // Проверяем, что пользователь найден
        System.out.println("Пользователь добавлен: " + addedUser.getName().getFirstName() + " " + addedUser.getName().getLastName());
    }

    @Test
    void testGetUserById() {
        UserDto userDto = new UserDto();
        Name name = new Name();
        name.setFirstName("John");
        name.setLastName("Doe");
        name.setMiddleName("Middle");
        name.setSurName("Surname");

        userDto.setName(name);

        // Мокирование поведения сервиса
        when(userService.getUserById(anyLong())).thenReturn(userDto);

        ResponseEntity<UserDto> response = userController.getUserById(1L);

        // Проверки
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("John", response.getBody().getName().getFirstName());

        // Вывод сообщения в консоль
        System.out.println("Получен пользователь: " + response.getBody().getName().getFirstName() + " " + response.getBody().getName().getLastName());
    }

    @Test
    void testGetAllUsers() {
        Name name1 = new Name();
        name1.setFirstName("User 1");
        name1.setLastName("LastName 1");

        Name name2 = new Name();
        name2.setFirstName("User 2");
        name2.setLastName("LastName 2");

        UserDto user1 = new UserDto();
        user1.setName(name1);

        UserDto user2 = new UserDto();
        user2.setName(name2);

        List<UserDto> users = Arrays.asList(user1, user2);

        // Мокирование поведения сервиса
        when(userService.getAllUsers()).thenReturn(users);

        // Вызов контроллера
        ResponseEntity<List<UserDto>> response = userController.getAllUsers();

        // Проверки
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals("User 1", response.getBody().get(0).getName().getFirstName());
        assertEquals("User 2", response.getBody().get(1).getName().getFirstName());

        // Вывод сообщения в консоль
        System.out.println("Получено " + response.getBody().size() + " пользователей.");
    }

    @Test
    void testUpdateUser() {
        Name updatedName = new Name();
        updatedName.setFirstName("Updated");
        updatedName.setLastName("User");

        UserDto updatedUser = new UserDto();
        updatedUser.setName(updatedName);

        // Мокирование поведения сервиса
        when(userService.updateUser(anyLong(), any(UserDto.class))).thenReturn(updatedUser);

        // Вызов контроллера
        ResponseEntity<UserDto> response = userController.updateUser(1L, updatedUser);

        // Проверки
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated", response.getBody().getName().getFirstName());
        assertEquals("User", response.getBody().getName().getLastName());

        // Вывод сообщения в консоль
        System.out.println("Пользователь обновлён: " + response.getBody().getName().getFirstName() + " " + response.getBody().getName().getLastName());
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userService).deleteUser(anyLong());

        // Вызываем метод контроллера
        ResponseEntity<String> response = userController.deleteUser(1L);

        // Проверки
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User deleted successfully.", response.getBody());

        // Вывод сообщения в консоль
        System.out.println("Пользователь удалён.");
    }

    /*
    @Test
    void testGetUserById_NotFound() {
        // Мокируем поведение сервиса: если ID не найден, возвращаем null
        when(userService.getUserById(anyLong())).thenReturn(null);

        // Вызываем метод контроллера
        ResponseEntity<UserDto> response = userController.getUserById(999L);

        // Проверки
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    } */

}
