using { com.sap.cap.orderservice as orderservice } from '../db/index';

annotate orderservice.Products with {
  price @title : 'Price';
  stock @title : 'Stock';
  description @title : 'Description';
  currency @UI.Hidden;
}