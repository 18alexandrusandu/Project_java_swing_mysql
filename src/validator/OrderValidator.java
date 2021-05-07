package validator;
import dao.*;
import modele.*;
public class OrderValidator {
public static boolean validateOrder(Orders order)
{
	ProductDao pd=new ProductDao();
	ClientDao cd=new ClientDao();

    Produs produs=pd.findById(order.getIdProdus());
    Client client=cd.findById(order.getIdClient());
    
    
    
    
    if(produs==null || client==null)
    return false;
    
    
   if( produs.getQuantity()< order.getQuantity())
	return false;
   
	return true;
}
}
