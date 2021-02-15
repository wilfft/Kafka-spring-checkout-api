package checkout.service;

import checkout.entity.CheckoutEntity;
import checkout.repository.CheckoutRepository;
import checkout.resource.checkout.CheckoutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImp implements CheckoutService {

 // @Autowired //Nao é boa pratica pois inviabiliza testes unitarios
private  final CheckoutRepository checkoutRepository;

 /* public CheckoutServiceImp(CheckoutRepository checkoutRepository){
   this.checkoutRepository = checkoutRepository;
       }*/

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
        .code(UUID.randomUUID().toString())
        .status(CheckoutEntity.Status.CREATED)
        .build();

        return Optional.of(checkoutRepository.save(checkoutEntity));
    }

}
