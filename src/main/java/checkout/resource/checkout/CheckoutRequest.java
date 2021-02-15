package checkout.resource.checkout;


import lombok.Data;

import java.io.Serializable;

@Data
public class CheckoutRequest implements Serializable {

    private String firstName;
    private String address;
    private Boolean saveInfo;

}
