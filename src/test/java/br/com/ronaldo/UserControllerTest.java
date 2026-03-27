package br.com.ronaldo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ronaldo.api.request.UserRequestDTO;
import br.com.ronaldo.api.response.UserResponseDTO;
import br.com.ronaldo.business.UserService;

@SpringBootTest
class UserControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testCreateUser() throws Exception {
        // Arrange
        UserRequestDTO requestDTO = new UserRequestDTO("test@example.com", "Test User");
        UserResponseDTO responseDTO = new UserResponseDTO("test@example.com", "Test User");
        when(userService.saveUsers(any(UserRequestDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.email").value("test@example.com"))
                .andExpect(jsonPath("$.name").value("Test User"));

        verify(userService).saveUsers(any(UserRequestDTO.class));
    }

    @Test
    void testGetUserByEmail() throws Exception {
        // Arrange
        String email = "test@example.com";
        UserResponseDTO responseDTO = new UserResponseDTO(email, "Test User");
        when(userService.searchUserByEmail(eq(email))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(get("/user")
                .param("email", email))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.email").value(email))
                .andExpect(jsonPath("$.name").value("Test User"));

        verify(userService).searchUserByEmail(eq(email));
    }

    @Test
    void testDeleteUser() throws Exception {
        // Arrange
        String email = "test@example.com";
        doNothing().when(userService).deleteUser(eq(email));

        // Act & Assert
        mockMvc.perform(delete("/user")
                .param("email", email))
                .andExpect(status().isAccepted());

        verify(userService).deleteUser(eq(email));
    }
}
