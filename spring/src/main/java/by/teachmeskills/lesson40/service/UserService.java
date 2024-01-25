package by.teachmeskills.lesson40.service;

import by.teachmeskills.lesson40.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;

@Component
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<UserDto> getAll() {
        return jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<>(UserDto.class));
    }
    public UserDto getOne(String email) {
        return jdbcTemplate.query("select * from users where email = ?",
                new BeanPropertyRowMapper<>(UserDto.class)).stream().findAny().orElse(null);
    }
    public void add(@Valid UserDto userDto) {
        jdbcTemplate.update("select * from users", userDto.getName(), userDto.getPassword(), userDto.getEmail());
    }
}
