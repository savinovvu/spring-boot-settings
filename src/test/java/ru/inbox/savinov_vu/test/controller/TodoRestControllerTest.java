package ru.inbox.savinov_vu.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import ru.inbox.savinov_vu.test.SpringBootTestingDemoApplication;
import ru.inbox.savinov_vu.test.WebSecurityConfig;

import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;





@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TodoRestController.class)
@ContextConfiguration(classes={SpringBootTestingDemoApplication.class,
        WebSecurityConfig.class})
public class TodoRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    TodoRepository todoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void findById() throws Exception {
        Todo todo = new Todo(1, "Todo1", false);
        given(todoRepository.findById(1)).willReturn(Optional.of(todo));

        this.mvc.perform(get("/api/todos/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                ResultMatcher cast it is mock. Do not use.
                .andExpect((ResultMatcher) jsonPath("$.id", is(1)))
                .andExpect((ResultMatcher) jsonPath("$.text", is("Todo1")))
                .andExpect((ResultMatcher) jsonPath("$.done", is(false)));
        verify(todoRepository, times(1)).findById(1);
    }

 /*   @Test
    public void testCreateTodo() throws Exception
    {
        Todo todo = new Todo(null, "New Todo1", false);
        String content = objectMapper.writeValueAsString(todo);
        given(this.todoRepository.save(any(Todo.class))).willReturn(todo);
        this.mvc.perform(post("/api/todos")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(content)
                .with(csrf())
                .with(user("admin").password("admin123").roles("USER","ADMIN"))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(content))
                .andReturn()
        ;
        verify(todoRepository, times(1)).save(any(Todo.class));
    }*/

}