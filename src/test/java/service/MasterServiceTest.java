package service;

import SpringBootProject.anformatic.AnformaticApplication;
import SpringBootProject.anformatic.model.Master;
import SpringBootProject.anformatic.repository.MasterRepository;
import SpringBootProject.anformatic.service.MasterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

public class MasterServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(AnformaticApplication.class);
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
        logger.info("TestCreateMaster passed.");

    }

    @Test
    public void testMasterById(){
        Long masterId=20L;
        String masterName="zahra ahmadi";
        Master master=new Master();
        master.setId(masterId);
        master.setName(masterName);
        Mockito.when(masterRepository.findById(masterId)).thenReturn(Optional.of(master));
        Master retrieveMaster=masterService.getMasterById(masterId);
        Assertions.assertEquals(masterId,retrieveMaster.getId());
        logger.info("TestMasterById passed.");
    }
}
