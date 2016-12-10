package it.peruvianit.scheduler;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import it.peruvianit.metrics.ExecuteQueuSingleton;
import it.peruvianit.utils.FirebaseUtil;

public class FirebaseScheduler {
	final static Logger logger = LoggerFactory.getLogger(FirebaseScheduler.class);
	
	@Value( "${firebase.database.elapsedTimeRequest}" )
	private String url;
	
	@Value( "${firebase.path.key.security}" )
	private String pathKeySecurity;
	
	@Scheduled(fixedDelay =30000)
	public void syncronizedExecuteTime(){
		ExecuteQueuSingleton executeQueuSingleton = ExecuteQueuSingleton.getInstance();
		FirebaseUtil firebaseUtil = null;
		try {
			firebaseUtil = FirebaseUtil.getInstance(url,pathKeySecurity);
			while(!executeQueuSingleton.isEmpty()){
				firebaseUtil.addRow("elapsedTimeRequest", executeQueuSingleton.poll());
			}
		} catch (FileNotFoundException e) {
			logger.error("Controllare se existe il file di key ssh per Firebase");
		}
	}
}
