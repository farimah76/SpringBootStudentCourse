package service;

import aSpringBootProject.anformatic.model.Master;
import aSpringBootProject.anformatic.repository.MasterRepository;
import aSpringBootProject.anformatic.repository.StudentRepository;
import aSpringBootProject.anformatic.service.MasterService;
import aSpringBootProject.anformatic.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;

public class MasterServiceTest {
    @Mock
    MasterRepository masterRepository;
    @InjectMocks
    MasterService masterService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testCreateMaster(){
        String masterName="reza";
        Master master=new Master();
        master.setName(masterName);
        Mockito.when(masterRepository.save(any())).thenReturn(master);
        Master createMaster=masterService.createMaster(masterName);
        Assertions.assertNotNull(createMaster);
        Assertions.assertEquals(masterName,createMaster.getName());
        Mockito.verify(masterRepository, Mockito.times(1)).save(Mockito.any());
        Mockito.verifyNoMoreInteractions(masterRepository);

    }
}
