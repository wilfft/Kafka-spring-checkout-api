package checkout.resource.checkout;


import checkout.entity.CheckoutEntity;
import checkout.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutResource {

     private final CheckoutService checkoutService;


     @GetMapping("/")
     public String   get(String msgm){
         return "ACESSADO GET";
    }
    @PostMapping("/")
    //response entity é classe do spring
    public ResponseEntity<CheckoutResponse> create(@RequestBody CheckoutRequest checkoutRequest)  {
        System.out.println("OLA");//vai receber a request
       final CheckoutEntity checkoutEntity=  checkoutService.create(checkoutRequest).orElseThrow();

       final CheckoutResponse checkoutResponse = CheckoutResponse.builder()
               .code(checkoutEntity.getCode())
               .build();
    return ResponseEntity.status(HttpStatus.CREATED).body(checkoutResponse); //vai retornar uma resposta 200 pra quem consumiu
//estou retornando o response para nao expor todos os dados

    }
    //vai receber a request

}
