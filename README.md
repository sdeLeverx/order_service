# Order Service

Order Service is an application implemented using SAP CAP, SAP HANA integrating with Java/Spring Boot.

## Running project loccally

Use the package manager [maven](https://maven.apache.org/) to to run locally.

```bash
# maven
mvn clean install
mvn spring-boot:run
```

## SAP HANA

After providing SAP HANA Cloud instance, configured the file .cdsrc.json in the root folder.

```bash
{
  "hana" : {
    "deploy-format": "hdbtable"
  }
}
```

Implicitly pushed all artifacts to the database.

```bash
cds deploy --to hana:bookstore-hana --store-credentials
```

## Deploying it to CF

To deploy project into Cloud Foundry created a application manifest and enabled application for Cloud Foundry.

```bash
mvn clean install

cf push

cf apps
```

## XSUAA 

While enabling application for Cloud Foundry by adding the cds-starter-cloudfoundry dependency it enabled CAP Java’s secure-by-default behaviour based on Spring Security. Now we should add some custom mock users to the application via adding the security section to the application.yaml file.

```bash
  security:
    mock:
      users:
        - name: admin
          password: admin
          roles:
            - admin
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change, suppose new custom handlers or entities.

Please make sure to update tests as appropriate.

## Cloud Foundry

[Project link on CF](https://order-service-delightful-camel-ju.cfapps.us10-001.hana.ondemand.com)
