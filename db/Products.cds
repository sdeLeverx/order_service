namespace com.sap.cap.orderservice;

using {com.sap.cap.orderservice as orderservice} from './index';
using { Currency, cuid, managed } from '@sap/cds/common';

entity Products : cuid, managed {
    title          : String(111);
    description    : String(1111);
    stock          : Integer;
    price          : Decimal(9,2);
    currency       : Currency;
}