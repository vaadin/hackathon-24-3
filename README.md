# hackathon-24-3 Marco

Repository for the 24.3 hackathon

* Fixed a potential breaking change introduce by Navigation Access Control
  https://github.com/vaadin/flow/pull/18176
  Credits goes to @SebastianKuehnau that opened the Pandora Box
* Tested the AutoCrud feature in a Hilla application running on Quarkus
  The application is in this repo and can be run using `./mvnw quarkus:dev`
  It uses [quarkus-hilla-react](https://github.com/mcollovati/quarkus-hilla/) extension and it has been developed
  following the [quick started guide](https://github.com/mcollovati/quarkus-hilla/wiki/QuickStart-react), but using AutoCrud features.
* Proposed [PR](https://github.com/vaadin/hilla/pull/1845) to implement https://github.com/vaadin/hilla/issues/1749  

## rules
Hackathon Rules

1. Versions: Use Platform `24.3.0.beta1` and/or Hilla `2.4.0`
2. Choose your project: You can work on an app, fixes, migrations, new features, docs, addons, DS, or just reporting issues.
3. Deadline: Upload your work to the [GitHub Repository](https://github.com/vaadin/hackathon-24-3) by Monday, the 4th at noon.
4. Contribution options: If you don’t have any code to show, please add a README or screenshots demoing your work.
5. Rewards: Everyone gets a gift, and there are prizes for the top three winners.
6. Communication: Use Slack channel #hackathon-24-3 for discussions.
7. Documentation: Refer to vaadin.com/docs/latest for help and information.



# getting-started

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

