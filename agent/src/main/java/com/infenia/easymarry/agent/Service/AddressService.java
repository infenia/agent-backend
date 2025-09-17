package com.infenia.easymarry.agent.Service;
import com.infenia.easymarry.agent.Entity.AddressEntity;
import com.infenia.easymarry.agent.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    /**
     * Retrieves the address details for a specific user.
     *
     * @param userId The ID of the user whose address details are to be fetched.
     * @return A Mono emitting the AddressEntity if found, or an empty Mono otherwise.
     */
    public Mono<AddressEntity> getAddressByUserId(@PathVariable Long userId) {
        return addressRepository.findById(userId)
                .doOnNext(address -> System.out.println("Address found for user: " + userId))
                .doOnError(e -> System.err.println("Error fetching address for user " + userId + ": " + e.getMessage()))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Address not found for user ID: " + userId)));
    }
}

