using {com.sap.cap.orderservice as orderservice} from '../db/products';

@path : 'browse'
service ProductService {
  entity Products as projection on orderservice.Products
}