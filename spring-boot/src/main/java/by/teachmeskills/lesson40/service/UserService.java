package by.teachmeskills.lesson40.service;

import by.teachmeskills.lesson40.dto.UserDto;
import by.teachmeskills.lesson40.repository.UserRepository;
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
    public List<UserRepository> getAll() {
        return jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<>(UserRepository.class));
    }
    public UserRepository getOne(String email) {
        return jdbcTemplate.query("select * from users where email = ?",
                new BeanPropertyRowMapper<>(UserRepository.class)).stream().findAny().orElse(null);
    }
    public void add(@Valid UserDto userDto) {
        jdbcTemplate.update("select * from users", userDto.getName(), userDto.getPassword(), userDto.getEmail());
    }
}
