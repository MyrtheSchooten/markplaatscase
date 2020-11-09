package dao;

import domain.Gebruiker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GebruikerDaoTest {
    @Mock
    private EntityManager emMock;
    @InjectMocks
    private GebruikerDao target;
    @Mock
    private EntityTransaction transactionMock;
    @Mock
    private Gebruiker gebruikerMock;

    @Test
    void save() {
        when(emMock.getTransaction()).thenReturn(transactionMock);

        target.save(gebruikerMock);

        verify(transactionMock).begin();
        verify(emMock).persist(eq(gebruikerMock));
        verify(transactionMock).commit();
    }


    @Test
    void get() {
        long id = 3675234L;
        when(emMock.find(eq(Gebruiker.class), eq(id))).thenReturn(gebruikerMock);

        Gebruiker gebruiker = target.get(id);

        verify(emMock).find(eq(Gebruiker.class), eq(id));
        assertEquals(gebruiker, gebruikerMock);
    }

    @Test
    void remove() {
        when(emMock.getTransaction()).thenReturn(transactionMock);

        target.remove(gebruikerMock);

        verify(transactionMock).begin();
        verify(emMock).remove(eq(gebruikerMock));
        verify(transactionMock).commit();
    }

    @Test
    void update() {
        when(emMock.getTransaction()).thenReturn(transactionMock);

        target.update(gebruikerMock);

        verify(transactionMock).begin();
        verify(emMock).merge(gebruikerMock);
        verify(transactionMock).commit();
    }

}