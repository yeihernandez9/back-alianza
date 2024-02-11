package api.alianza.service.implement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import api.alianza.domain.models.entity.ProccessClient;
import api.alianza.domain.repositories.ProccessClientRepository;
import api.alianza.exception.ApplicationException;
import api.alianza.exception.Errors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

class ProccessClientImplTest {

    @Mock
    private ProccessClientRepository proccessClientRepository;

    @InjectMocks
    private ProccessClientImpl proccessClientService;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        proccessClientService = new ProccessClientImpl();
        // Set the mocked repository into the service
        proccessClientService.setProccessClientRepository(proccessClientRepository);
    }

    @Test
    void findAll_shouldReturnPageOfProccessClients() {
        // Arrange
        Page<ProccessClient> expectedPage = mock(Page.class);
        when(proccessClientRepository.findAll(any(Pageable.class))).thenReturn(expectedPage);

        // Act
        Page<ProccessClient> result = proccessClientService.findAll(mock(Pageable.class));

        // Assert
        assertEquals(expectedPage, result);
    }

    @Test
    void findById_whenProccessClientExists_shouldReturnProccessClient() {
        // Arrange
        ProccessClient expectedProccessClient = new ProccessClient();
        when(proccessClientRepository.findById(anyInt())).thenReturn(Optional.of(expectedProccessClient));

        // Act
        ProccessClient result = proccessClientService.findById(1);

        // Assert
        assertEquals(expectedProccessClient, result);
    }

    @Test
    void findById_whenProccessClientDoesNotExist_shouldThrowApplicationException() {
        // Arrange
        when(proccessClientRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ApplicationException.class, () -> proccessClientService.findById(1));
    }

    @Test
    void save_shouldReturnSavedProccessClient() {
        // Arrange
        ProccessClient inputProccessClient = new ProccessClient();
        ProccessClient expectedSavedProccessClient = mock(ProccessClient.class);
        when(proccessClientRepository.save(eq(inputProccessClient))).thenReturn(expectedSavedProccessClient);

        // Act
        ProccessClient result = proccessClientService.save(inputProccessClient);

        // Assert
        assertEquals(expectedSavedProccessClient, result);
    }
}
