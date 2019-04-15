package bookmyshow.api.services;
import com.hazelcast.core.HazelcastInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Service
public class HazzleCastService {

    private final Logger logger = LoggerFactory.getLogger(HazzleCastService.class);
    private final HazelcastInstance hazelcastInstance;

    @Autowired
    HazzleCastService(@Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    public String writeDataToHazelcast(String key,String value) {
        Map<String, String> hazelcastMap = hazelcastInstance.getMap("my-map");
        hazelcastMap.put(key, value);
        return "Data is stored.";
    }

    public String readDataFromHazelcast(@RequestParam String key) {
        Map<String, String> hazelcastMap = hazelcastInstance.getMap("my-map");
        return hazelcastMap.get(key);
    }

    public Map<String, String> readAllDataFromHazelcast() {
        Map<String, String> hazelcastMap = hazelcastInstance.getMap("my-map");
        return hazelcastInstance.getMap("my-map");
    }

}

