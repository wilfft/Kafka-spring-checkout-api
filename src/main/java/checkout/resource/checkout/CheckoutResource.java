package checkout.resource.checkout;


import checkout.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutResource {

     private final CheckoutService checkoutService;

    @PostMapping("/")
    //response entity é classe do spring
    public ResponseEntity<Void> create(CheckoutRequest checkoutRequest)  { //vai receber a request
        checkoutService.create(checkoutRequest);
    return ResponseEntity.ok().build(); //vai retornar uma resposta 200 pra quem consumiu

    }

}
