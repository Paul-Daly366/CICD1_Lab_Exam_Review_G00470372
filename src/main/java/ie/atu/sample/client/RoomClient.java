package ie.atu.sample.client;

import ie.atu.sample.client.dto.RoomRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RoomService", url="localhost:8082")
public interface RoomClient {

    @GetMapping("/api/rooms/{id}")
    RoomRequest getRoomById(@PathVariable Long id);
}
