package com.dbCodingTest.tradeStorage.schedulingTasks;

import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.dbCodingTest.tradeStorage.TradeStorageCodingTestApplication;
import com.dbCodingTest.tradeStorage.scheduling.TradeScheduledTask;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringJUnitConfig(TradeStorageCodingTestApplication.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TradeScheduledTasksTest {

	@SpyBean
    private TradeScheduledTask TradeScheduledTasks;

    @Test
    public void whenWaitOneSecond_thenScheduledIsCalledAtLeastTenTimes() {
    	
    	 await()
         .atMost(Duration.ONE_MINUTE)
         .untilAsserted(() -> verify(TradeScheduledTasks,atLeast(2)).reportCurrentTime());

    	
              
    
    }
	
}
