using ProductService from '../../srv/service';

annotate ProductService.Products with @(UI : {
  HeaderInfo  : {
      TypeName : 'Product',
      TypeNamePlural : 'Products',
  },
  LineItem : [
        {
            Value: title,
            Label: 'Title'
        },
        { Value: stock },
        { Value: price },
        {
            Value: description,
            Label: 'Description'
        },
        {
            Value: id,
            ![@UI.Hidden]
        },
        {
            Value : currency_code,
            ![@UI.Hidden]
        },
  ],
  SelectionFields : [
      price,
      stock
    ],
  PresentationVariant : {
      Text           : 'Default',
      SortOrder      : [{Property : title}],
      Visualizations : ['@UI.LineItem']
  }
}) {
      @Measures.ISOCurrency : currency.code
      price
};