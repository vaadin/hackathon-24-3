# V24.3 Hackathon by Herberts
Repository for the 24.3 hackathon worked on by Herberts

## rules - to remove
Hackathon Rules

1. Versions: Use Platform `24.3.0.beta1` and/or Hilla `2.4.0`
2. Choose your project: You can work on an app, fixes, migrations, new features, docs, addons, DS, or just reporting issues.
3. Deadline: Upload your work to the [GitHub Repository](https://github.com/vaadin/hackathon-24-3) by Monday, the 4th at noon.
4. Contribution options: If you don’t have any code to show, please add a README or screenshots demoing your work.
5. Rewards: Everyone gets a gift, and there are prizes for the top three winners.
6. Communication: Use Slack channel #hackathon-24-3 for discussions.
7. Documentation: Refer to vaadin.com/docs/latest for help and information.

# Worked on
* Using the new Started as a base. 
* Rerouting to custom page after access-denied. Ran into setup issues.
* 

# Issues created
* Starter should offer export with Security enabled. [Issue] (https://github.com/vaadin/start/issues/2915)
* Missing documentation for new rerouteToError in annotation. [Issue](https://github.com/vaadin/docs/issues/3013)



## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to import Vaadin projects to different IDEs](https://vaadin.com/docs/latest/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans, and VS Code).

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/herberts-1.0-SNAPSHOT.jar`

## Project structure

- `MainLayout.java` in `src/main/java` contains the navigation setup (i.e., the
  side/top bar and the main menu). This setup uses
  [App Layout](https://vaadin.com/docs/components/app-layout).
- `views` package in `src/main/java` contains the server-side Java views of your application.
- `views` folder in `frontend/` contains the client-side JavaScript views of your application.
- `themes` folder in `frontend/` contains the custom CSS styles.

## Useful links

- Read the documentation at [vaadin.com/docs](https://vaadin.com/docs).
- Follow the tutorial at [vaadin.com/docs/latest/tutorial/overview](https://vaadin.com/docs/latest/tutorial/overview).
- Create new projects at [start.vaadin.com](https://start.vaadin.com/).
- Search UI components and their usage examples at [vaadin.com/docs/latest/components](https://vaadin.com/docs/latest/components).
- View use case applications that demonstrate Vaadin capabilities at [vaadin.com/examples-and-demos](https://vaadin.com/examples-and-demos).
- Build any UI without custom CSS by discovering Vaadin's set of [CSS utility classes](https://vaadin.com/docs/styling/lumo/utility-classes).
- Find a collection of solutions to common use cases at [cookbook.vaadin.com](https://cookbook.vaadin.com/).
- Find add-ons at [vaadin.com/directory](https://vaadin.com/directory).
- Ask questions on [Stack Overflow](https://stackoverflow.com/questions/tagged/vaadin) or join our [Discord channel](https://discord.gg/MYFq5RTbBn).
- Report issues, create pull requests in [GitHub](https://github.com/vaadin).
